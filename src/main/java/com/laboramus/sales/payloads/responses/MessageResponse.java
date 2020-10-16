package com.laboramus.sales.payloads.responses;

import java.io.Serializable;

public class MessageResponse implements Serializable {
    private String message;
    private boolean success;
    private String responseCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    @Override
    public String toString() {
        return "MessageResponse{" +
                "message='" + message + '\'' +
                ", success=" + success +
                ", responseCode='" + responseCode + '\'' +
                '}';
    }
}
