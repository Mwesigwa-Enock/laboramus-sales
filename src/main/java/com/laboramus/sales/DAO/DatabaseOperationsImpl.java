package com.laboramus.sales.DAO;

import com.laboramus.sales.Objects.AnalyticsObj;
import com.laboramus.sales.Objects.ItemsObj;
import com.laboramus.sales.Objects.SalesObj;
import com.laboramus.sales.configs.BigdecimalOperations;
import com.laboramus.sales.payloads.requests.SalesRequest;
import com.laboramus.sales.payloads.responses.AnalyticsResponse;
import com.laboramus.sales.payloads.responses.MessageResponse;
import com.laboramus.sales.payloads.responses.SalesResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Service
public class DatabaseOperationsImpl implements DatabaseOperations {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseOperationsImpl.class);

    @Autowired
    private JdbcTemplate jdbctemplate;

    public DatabaseOperationsImpl(JdbcTemplate jdbctemplate) {
        this.jdbctemplate = jdbctemplate;
    }

    @Transactional
    @Override
    public int[] batchInsertSales(List<SalesObj> salesObjList) {
        return this.jdbctemplate.batchUpdate("INSERT INTO sales (region, country, item_type, sales_channel, order_priority," +
                        " order_date, order_id, ship_date, units_sold, unit_price, unit_cost, total_revenue, total_cost, total_profit) " +
                        " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setString(1, salesObjList.get(i).getRegion());
                        ps.setString(2, salesObjList.get(i).getCountry());
                        ps.setString(3, salesObjList.get(i).getItem_type());
                        ps.setString(4, salesObjList.get(i).getSales_Channel());
                        ps.setString(5, salesObjList.get(i).getOrder_Priority());
                        ps.setString(6, salesObjList.get(i).getOrder_Date());
                        ps.setString(7, salesObjList.get(i).getOrder_ID());
                        ps.setString(8, salesObjList.get(i).getShip_Date());
                        ps.setInt(9, salesObjList.get(i).getUnits_Sold());
                        ps.setBigDecimal(10, salesObjList.get(i).getUnit_Price());
                        ps.setBigDecimal(11, salesObjList.get(i).getUnit_Cost());
                        ps.setBigDecimal(12, salesObjList.get(i).getTotal_Revenue());
                        ps.setBigDecimal(13, salesObjList.get(i).getTotal_Cost());
                        ps.setBigDecimal(14, salesObjList.get(i).getTotal_Profit());
                    }

                    @Override
                    public int getBatchSize() {
                        return salesObjList.size();
                    }
                }
        );

    }


    @Override
    public SalesResponse fetchSales(SalesRequest salesRequest) {
        SalesResponse salesResponse = new SalesResponse();
        MessageResponse messageResponse = new MessageResponse();
        BigDecimal total_profit = null;
        try {
            //select total profit
            String itemsQuery = "select distinct item_type, sum(total_profit) as totalProfits from sales " +
                    "where order_date >= ? and order_date <= ? " +
                    "group by item_type order by totalProfits desc limit 5";
            List<ItemsObj> transList = jdbctemplate.query
                    (itemsQuery, new BeanPropertyRowMapper<>(ItemsObj.class), salesRequest.getStartDate(), salesRequest.getEndDate());
            if (!transList.isEmpty()) {

                for (ItemsObj obj : transList) {
                    total_profit = BigdecimalOperations.addAmount(total_profit, obj.getTotalProfits());
                }

                messageResponse.setResponseCode("00");
                messageResponse.setSuccess(true);
                messageResponse.setMessage("Success");
                salesResponse.setTotalProfit(total_profit);
                salesResponse.setMessageResponse(messageResponse);
                salesResponse.setItemsObjs(transList);
            } else {
                messageResponse.setResponseCode("00");
                messageResponse.setSuccess(true);
                messageResponse.setMessage("No Records Founds");
                salesResponse.setMessageResponse(messageResponse);
                salesResponse.setItemsObjs(transList);
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
            messageResponse.setMessage(e.toString());
            messageResponse.setResponseCode("201");
            messageResponse.setSuccess(false);
            salesResponse.setMessageResponse(messageResponse);
            salesResponse.setItemsObjs(null);
            salesResponse.setTotalProfit(null);
        }
        return salesResponse;
    }

    @Override
    public AnalyticsResponse getTotals() {
        AnalyticsResponse analyticsResponse = new AnalyticsResponse();
        MessageResponse messageResponse = new MessageResponse();
        try {
            String analyticsQuery = "select * from V_ANALYTICS";

            AnalyticsObj analyticsObj = jdbctemplate.queryForObject(analyticsQuery, new Object[]{},
                    new BeanPropertyRowMapper<>(AnalyticsObj.class));

            messageResponse.setResponseCode("00");
            messageResponse.setSuccess(true);
            messageResponse.setMessage("Success");
            analyticsResponse.setMessageResponse(messageResponse);
            analyticsResponse.setAnalyticsObj(analyticsObj);

        } catch (Exception ex) {
            logger.error(ex.getMessage());
            messageResponse.setResponseCode("101");
            messageResponse.setSuccess(false);
            messageResponse.setMessage("Error! Try Again!");
            analyticsResponse.setMessageResponse(messageResponse);
            analyticsResponse.setAnalyticsObj(null);

        }

        return analyticsResponse;
    }
}
