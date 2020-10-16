package com.laboramus.sales.services;

import com.laboramus.sales.DAO.DatabaseOperationsImpl;
import com.laboramus.sales.Objects.SalesObj;
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
}
