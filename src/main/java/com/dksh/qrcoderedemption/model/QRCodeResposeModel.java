package com.dksh.qrcoderedemption.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QRCodeResposeModel {

    private  int status;
    private  int code ;
    private  String message;
    private  String exetime ;
    private ErrorModel errors;
    private String description;

    public QRCodeResposeModel() {
    }

    public QRCodeResposeModel(int status, int code, String message, String exetime, String description, ErrorModel errors) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.exetime = exetime;
        this.description = description;
        this.errors = errors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ErrorModel getErrors() {
        return errors;
    }

    public void setErrors(ErrorModel errors) {
        this.errors = errors;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("exe.time")
    public String getExetime() {
        return exetime;
    }

    @JsonProperty("exe.time")
    public void setExetime(String exetime) {
        this.exetime = exetime;
    }
}
