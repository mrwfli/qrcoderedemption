package com.dksh.qrcoderedemption.model;

public class RedemptionData
{
    private long redemption_status;
    private String redemption_id;
    private String gift_code;

    public RedemptionData() {
    }

    public RedemptionData(long redemption_status, String redemption_id, String gift_code) {
        this.redemption_status = redemption_status;
        this.redemption_id = redemption_id;
        this.gift_code = gift_code;
    }

    public long getRedemption_status() {
        return redemption_status;
    }

    public void setRedemption_status(long redemption_status) {
        this.redemption_status = redemption_status;
    }

    public String getRedemption_id() {
        return redemption_id;
    }

    public void setRedemption_id(String redemption_id) {
        this.redemption_id = redemption_id;
    }

    public String getGift_code() {
        return gift_code;
    }

    public void setGift_code(String gift_code) {
        this.gift_code = gift_code;
    }
}