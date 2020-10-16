package com.laboramus.sales.DAO;

import com.laboramus.sales.Objects.SalesObj;
import com.laboramus.sales.payloads.responses.MessageResponse;

import java.util.List;

public interface DatabaseOperations {
    int[] batchInsertSales(List<SalesObj> salesObjList);

}
