package com.laboramus.sales.csvhelper;

import com.laboramus.sales.Objects.SalesObj;
import com.laboramus.sales.payloads.responses.UploadResponse;
import com.laboramus.sales.services.SalesImpl;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FileUploadHelper {
    private static Logger logger = LoggerFactory.getLogger(FileUploadHelper.class);

    @Autowired
    SalesImpl sales;

    public UploadResponse processCsv(MultipartFile file) {
        UploadResponse uploadResponse = new UploadResponse();
        if (file.isEmpty()) {
            uploadResponse.setReponseCode("201");
            uploadResponse.setResponseMessage("Please select a CSV file to upload.");
            uploadResponse.setResponseStatus(false);
        } else {

            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                // Hashmap to map CSV data to
                // Bean attributes.
                Map<String, String> mapping = new
                        HashMap<String, String>();
                mapping.put("Region", "Region");
                mapping.put("Country", "Country");
                mapping.put("Item type", "Item_type");
                mapping.put("Sales Channel", "Sales_Channel");
                mapping.put("Order Priority", "Order_Priority");
                mapping.put("Order Date", "Order_Date");
                mapping.put("Order ID", "Order_ID");
                mapping.put("Ship Date", "Ship_Date");
                mapping.put("Units Sold", "Units_Sold");
                mapping.put("Unit Price", "Unit_Price");
                mapping.put("Unit Cost", "Unit_Cost");
                mapping.put("Total Revenue", "Total_Revenue");
                mapping.put("TotalCost", "Total_Cost");
                mapping.put("Total Profit", "Total_Profit");

                // HeaderColumnNameTranslateMappingStrategy
                HeaderColumnNameTranslateMappingStrategy mappingStrategy =
                        new HeaderColumnNameTranslateMappingStrategy();
                mappingStrategy.setColumnMapping(mapping);
                mappingStrategy.setType(SalesObj.class);

                // create csv bean reader

                CsvToBean<SalesObj> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(SalesObj.class)
                        .withSeparator(',')
                        .withIgnoreLeadingWhiteSpace(true)
                        .withIgnoreEmptyLine(true)
                        .withMappingStrategy(mappingStrategy)
                        .build();
                // convert `CsvToBean` object to list of sales
                List<SalesObj> salesList = csvToBean.parse();
                System.out.println(salesList.get(12));

                //Database Call
                int[] batchInsertSales = sales.batchInsertSales(salesList);
                System.out.println(batchInsertSales);

                uploadResponse.setReponseCode("00");
                uploadResponse.setResponseMessage("Successfully");
                uploadResponse.setResponseStatus(true);

            } catch (Exception ex) {
                logger.info(ex.toString());
                uploadResponse.setReponseCode("201");
                uploadResponse.setResponseMessage("An error occurred while processing the CSV file.");
                uploadResponse.setResponseStatus(false);
            }

        }
        return uploadResponse;

    }
}
