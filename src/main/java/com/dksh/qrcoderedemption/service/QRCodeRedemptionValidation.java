package com.dksh.qrcoderedemption.service;

import com.dksh.qrcoderedemption.domain.CardInPark;
import com.dksh.qrcoderedemption.model.QRCodeResposeModel;
import com.dksh.qrcoderedemption.model.VerifyResponseModel;

public interface QRCodeRedemptionValidation {
    String VerifyValidate(VerifyResponseModel data,String cardId,long HOURLYCOUPON, long cardtype);
    String RedemptionValidate(QRCodeResposeModel data);
    void UpdateDatabase(VerifyResponseModel verify_result,String msg,String Qrcode,int status, CardInPark cardinpark, long DeviceId, long remaining_hour);
    String CompletedProcess(CardInPark cardinpark);
}
