package com.laboramus.sales.payloads.responses;

import com.laboramus.sales.Objects.AnalyticsObj;

import java.io.Serializable;

public class AnalyticsResponse implements Serializable {
    MessageResponse messageResponse;
    AnalyticsObj analyticsObj;

    public MessageResponse getMessageResponse() {
        return messageResponse;
    }

    public void setMessageResponse(MessageResponse messageResponse) {
        this.messageResponse = messageResponse;
    }

    public AnalyticsObj getAnalyticsObj() {
        return analyticsObj;
    }

    public void setAnalyticsObj(AnalyticsObj analyticsObj) {
        this.analyticsObj = analyticsObj;
    }

    @Override
    public String toString() {
        return "AnalyticsResponse{" +
                "messageResponse=" + messageResponse +
                ", analyticsObj=" + analyticsObj +
                '}';
    }
}
