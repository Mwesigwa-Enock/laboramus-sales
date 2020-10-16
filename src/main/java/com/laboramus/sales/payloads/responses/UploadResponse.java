package com.laboramus.sales.payloads.responses;

import java.io.Serializable;

public class UploadResponse implements Serializable {

    private String reponseCode, responseMessage;
    private boolean responseStatus;

    public String getReponseCode() {
        return reponseCode;
    }

    public void setReponseCode(String reponseCode) {
        this.reponseCode = reponseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public boolean isResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(boolean responseStatus) {
        this.responseStatus = responseStatus;
    }

    @Override
    public String toString() {
        return "UploadResponse{" +
                "reponseCode='" + reponseCode + '\'' +
                ", responseMessage='" + responseMessage + '\'' +
                ", responseStatus=" + responseStatus +
                '}';
    }
}
