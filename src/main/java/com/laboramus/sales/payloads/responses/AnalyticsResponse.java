package com.laboramus.sales.payloads.responses;

import com.laboramus.sales.Objects.AnalyticsObj;

import java.io.Serializable;

public class AnalyticsResponse implements Serializable {
    AnalyticsObj analyticsObj;

    public AnalyticsObj getAnalyticsObj() {
        return analyticsObj;
    }

    public void setAnalyticsObj(AnalyticsObj analyticsObj) {
        this.analyticsObj = analyticsObj;
    }

}
