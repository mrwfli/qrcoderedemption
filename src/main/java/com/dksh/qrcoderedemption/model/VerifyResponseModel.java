package com.dksh.qrcoderedemption.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VerifyResponseModel extends QRCodeResposeModel {

    private  RedemptionData data ;

    public VerifyResponseModel(RedemptionData data) {
        this.data = data;
    }

    public VerifyResponseModel(int status, int code, String message, String exetime, String description, ErrorModel errors, RedemptionData data) {
        super(status, code, message, exetime, description, errors);
        this.data = data;
    }

    @JsonProperty("data")
    public RedemptionData getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(RedemptionData data) {
        this.data = data;
    }

    @Override
    public String toString() {

        return super.toString() + " VerifyResponseModel{" +
                "data=" + data +
                '}';
    }
}

