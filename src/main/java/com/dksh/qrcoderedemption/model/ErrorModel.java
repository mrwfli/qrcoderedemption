package com.dksh.qrcoderedemption.model;

import java.lang.reflect.Array;
import java.util.List;

public class ErrorModel {

    String[] member_token;

    String[] redemption_id;

    public ErrorModel(String[] member_token, String[] redemption_id) {
        this.member_token = member_token;
        this.redemption_id = redemption_id;
    }

    public String[] getMember_token() {
        return member_token;
    }

    public void setMember_token(String[] member_token) {
        this.member_token = member_token;
    }

    public String[] getRedemption_id() {
        return redemption_id;
    }

    public void setRedemption_id(String[] redemption_id) {
        this.redemption_id = redemption_id;
    }
}
