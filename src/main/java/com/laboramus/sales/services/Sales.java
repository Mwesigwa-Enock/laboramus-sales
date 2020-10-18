package com.laboramus.sales.services;

import com.laboramus.sales.Objects.AnalyticsObj;
import com.laboramus.sales.Objects.SalesObj;
import com.laboramus.sales.payloads.requests.SalesRequest;
import com.laboramus.sales.payloads.responses.AnalyticsResponse;
import com.laboramus.sales.payloads.responses.SalesResponse;

import java.util.List;

public interface Sales {
    int[] batchInsertSales(List<SalesObj> salesObjList);

    SalesResponse fetchSales(SalesRequest salesRequest);

    AnalyticsResponse getTotals();
}
