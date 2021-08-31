package com.dksh.qrcoderedemption.model;

import java.util.ArrayList;

public class CSVResponseModel {

    private  int status;
    private ArrayList<String> checked;
    private ArrayList<String> check ;

    public CSVResponseModel() {
    }

    public CSVResponseModel(int status, ArrayList<String> checked, ArrayList<String> check) {
        this.status = status;
        this.checked = checked;
        this.check = check;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<String> getChecked() {
        return checked;
    }

    public void setChecked(ArrayList<String> checked) {
        this.checked = checked;
    }

    public ArrayList<String> getCheck() {
        return check;
    }

    public void setCheck(ArrayList<String> check) {
        this.check = check;
    }

    @Override
    public String toString() {
        return "CSVResponseModel{" +
                "status=" + status +
                ", checked=" + checked +
                ", check=" + check +
                '}';
    }
}
