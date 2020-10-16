package com.laboramus.sales.services;

import com.laboramus.sales.Objects.SalesObj;
import com.laboramus.sales.payloads.responses.MessageResponse;

import java.util.List;

public interface Sales {
    int[] batchInsertSales(List<SalesObj> salesObjList);
}
