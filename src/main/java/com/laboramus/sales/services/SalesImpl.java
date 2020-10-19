package com.laboramus.sales.services;

import com.laboramus.sales.DAO.DatabaseOperationsImpl;
import com.laboramus.sales.Objects.SalesObj;
import com.laboramus.sales.payloads.requests.SalesRequest;
import com.laboramus.sales.payloads.responses.AnalyticsResponse;
import com.laboramus.sales.payloads.responses.RecordsResponse;
import com.laboramus.sales.payloads.responses.SalesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesImpl implements Sales {

    @Autowired
    DatabaseOperationsImpl databaseOperations;

    @Override
    public int[] batchInsertSales(List<SalesObj> salesObjList) {
        return databaseOperations.batchInsertSales(salesObjList);
    }

    @Override
    public SalesResponse fetchSales(SalesRequest salesRequest) {
        return databaseOperations.fetchSales(salesRequest);
    }

    @Override
    public AnalyticsResponse getTotals() {
        return databaseOperations.getTotals();
    }

    @Override
    public List<RecordsResponse> getSales() {
        return databaseOperations.getSales();
    }


}
