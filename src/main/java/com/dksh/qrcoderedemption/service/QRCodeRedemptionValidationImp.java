package com.dksh.qrcoderedemption.service;

import com.dksh.qrcoderedemption.constant.ResponseHtml;
import com.dksh.qrcoderedemption.domain.*;
import com.dksh.qrcoderedemption.model.QRCodeResposeModel;
import com.dksh.qrcoderedemption.model.VerifyResponseModel;
import com.dksh.qrcoderedemption.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class QRCodeRedemptionValidationImp implements  QRCodeRedemptionValidation{

    @Autowired
    private CarParkService carParkService;

    @Value("${Redemption.PaidGraceMinutes}")
    int PaidGraceMinutes;

    @Value("${Redemption.MaxFreeHours}")
    int MaxFreeHours;

    private  SimpleDateFormat formatter;

    @Override
    public String VerifyValidate(VerifyResponseModel data,String cardId,long hourlycoupon, long cardtype){

        if(data == null){
            return ResponseHtml.operation_failed;
        }

        if(data.getStatus() == -1){
            return ResponseHtml.invalid_coupon;
        }

        long redemption_status = data.getData().getRedemption_status();
        String redemption_id =  data.getData().getRedemption_id();
        String gift_code = data.getData().getGift_code();

        if(redemption_status >= 2){
            return  ResponseHtml.invalid_coupon;
        }

        Date date = new Date(System.currentTimeMillis());
        formatter= new SimpleDateFormat("yyyy-MM-dd");
        String now = formatter.format(date);

        QRCODE_REDEMPTION_LOG log = carParkService.GetRedemptionLogByIdAndCreateDate(redemption_id,now); //qrcode_redemption_log_repository.findByREDEMPTIONIDAndCREATEDATE(redemption_id,now);

        if(log != null){
            return ResponseHtml.invalid_coupon;
        }

        long qrcode_hour = Long.parseLong(gift_code.split("-")[1]);

        long remaind_hour = MaxFreeHours - hourlycoupon;

        if(remaind_hour < qrcode_hour) {
            return ResponseHtml.over_hour_limit;
        }

        return "";
    }

    @Override
    public String RedemptionValidate(QRCodeResposeModel data) {

        if(data.getStatus() == -1){
            return ResponseHtml.invalid_coupon;
        }

        return  "";
    }

    @Override
    public void UpdateDatabase(VerifyResponseModel verify_result,String msg,String Qrcode,int status, CardInPark cardinpark, long DeviceId) {
        Date date = new Date(System.currentTimeMillis());

        String gift_code = verify_result.getData().getGift_code();
        long qrcode_hour = Long.parseLong(gift_code.split("-")[1]);

        long entrytime  = cardinpark.getENTRYTIME().getTime();

        double h = cardinpark.getHOURLYCOUPON() + qrcode_hour +  PaidGraceMinutes / 60;

        Date freetiltime = new Date(entrytime + ((int)h * 60 * 60 * 1000));
        cardinpark.setFREETILLTIME(freetiltime);
        cardinpark.setGRACEPERIODGRANTED(PaidGraceMinutes);
        cardinpark.setISPAID(1);
        cardinpark.setPAYTIME(date);
        cardinpark.setHOURLYCOUPON(cardinpark.getHOURLYCOUPON() + qrcode_hour);

        //cardInParkRepository.save(cardinpark);
        carParkService.SaveCarInPark(cardinpark);

        CARDEVENTLOG log = new CARDEVENTLOG(date,
                cardinpark.getCARDTYPE(),
                cardinpark.getCARDID(),
                6,
                "Insert coupon" + verify_result.getData().getRedemption_id(),
                DeviceId,
                cardinpark.getFACILITYKEY());

        // cardEventLogRepository.save(log);
        carParkService.SaveCardEventLog(log);

        formatter= new SimpleDateFormat("yyyy-MM-dd");
        CardTransaction tran = new CardTransaction(date,
                formatter.format(date),
                5,
                cardinpark.getCARDTYPE(),
                cardinpark.getCARDID(),
                6,
                verify_result.getData().getRedemption_id(),
                qrcode_hour,
                0,
                DeviceId,
                0,
                cardinpark.getFACILITYKEY(),
                0,0,0,0);

       // cardTransactionRepository.save(tran);
        carParkService.SaveCardTransaction(tran);

        QRCODE_REDEMPTION_LOG redemption_log = new QRCODE_REDEMPTION_LOG(
                cardinpark.getCARDID(),
                cardinpark.getCARDTYPE(),
                Qrcode,
                verify_result.getData().getRedemption_id(),
                msg,
                DeviceId,
                date,
                status == 1 ? "Completed" : "Open");

        // qrcode_redemption_log_repository.save(redemption_log);
        carParkService.SaveQrcode_redemption_log(redemption_log);

        TempCustTriggerQueue queue = new TempCustTriggerQueue(
                date, //Date
                cardinpark.getCARDTYPE(),//long
                cardinpark.getCARDID(),//String
                cardinpark.getENTRYTIME(),//Date
                cardinpark.getFREETILLTIME(),//Date
                DeviceId,//long
                cardinpark.getFACILITYKEY(),//int
                0);

       // tempCustTriggerQueueRepository.save(queue);
        carParkService.SaveTempCustTriggerQueue(queue);
    }

    @Override
    public String CompletedProcess(CardInPark cardinpark) {

        formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date freetiltime = new Date(cardinpark.getFREETILLTIME().getTime() - (PaidGraceMinutes * 60 * 1000));

        String result = "<img src=\"\\images\\cp01-record.png\" style=\"position: relative; top: 0; left: 0;\" />\n";

        if( ((double)MaxFreeHours - cardinpark.getHOURLYCOUPON()) > 0){
            result += "<div class=recordcouponeng>PLEASE SCAN QR CODE / INSERT PARKING COUPON ONE BY ONE</div>\n" +
                    "<div class=recordcouponchn>請掃瞄二維碼 / 逐一放入泊車券</div>\n" +
                    "<div id=maskcardbox class=box>"+ cardinpark.getCARDID() +"</div>\n" +
                    "<div id=entrytimebox class=box>"+formatter.format(cardinpark.getENTRYTIME())+"</div>\n" +
                    "<div id=freeuntilbox class=box>"+formatter.format(freetiltime) +"</div>\n" +
                    "<div id=maxcouponbox class=box>"+ ((double)MaxFreeHours - cardinpark.getHOURLYCOUPON()) + "</div>\n" +
                    "<div id=maxcouponunitbox class=box>Hour(s)</div>\n" +
                    "\n" +
                    "<div style=\"color:white;\">\n" +
                    "    <b>Entry Card :</b>\n" +
                    "    <div id=cardbox>"+cardinpark.getCARDID()+"</div>\n" +
                    "    <b>Entry Card Type :</b>\n" +
                    "    <div id=cardtypebox>"+cardinpark.getCARDTYPE()+"</div>\n" +
                    "    <b>Discounted :</b>\n" +
                    "    <div id=discountedbox>"+cardinpark.getHOURLYCOUPON()+"</div>\n" +
                    "    <b>Coupon Fac Code :</b>\n" +
                    "    <div id=faccodebox>"+cardinpark.getFACILITYKEY()+"</div>\n" +
                    "</div>\n" +
                    "<div class=vertfloating id=insertcoupon style=\"visibility:hidden;\">\n" +
                    "    <img src=\"\\images\\cp01-coupon.png\">\n" +
                    "</div>\n" +
                    "\n" +
                    "<div class=left_button id=receiptbutton style=\"visibility:hidden;\">\n" +
                    "    <img src=\"\\images\\cp01-receipt.png\" onmousedown=redemptionReceipt()>\n" +
                    "</div>\n" +
                    "<div class=right_button>\n" +
                    "    <img src=\"\\images\\cp01-quit.png\" onmousedown=backToHome()>\n" +
                    "</div>";
        }
        else{

            result += "<div id=maskcardbox class=box>"+ cardinpark.getCARDID() +"</div>\n" +
                    "<div id=entrytimebox class=box>"+formatter.format(cardinpark.getENTRYTIME())+"</div>\n" +
                    "<div id=freeuntilbox class=box>"+formatter.format(freetiltime) +"</div>\n" +
                    "<div id=maxcouponbox class=box>"+ ((double)MaxFreeHours - cardinpark.getHOURLYCOUPON()) + "</div>\n" +
                    "<div id=maxcouponunitbox class=box>Hour(s)</div>\n" +
                    "\n" +
                    "<div style=\"color:white;\">\n" +
                    "    <b>Entry Card :</b>\n" +
                    "    <div id=cardbox>"+cardinpark.getCARDID()+"</div>\n" +
                    "    <b>Entry Card Type :</b>\n" +
                    "    <div id=cardtypebox>"+cardinpark.getCARDTYPE()+"</div>\n" +
                    "    <b>Discounted :</b>\n" +
                    "    <div id=discountedbox>"+cardinpark.getHOURLYCOUPON()+"</div>\n" +
                    "    <b>Coupon Fac Code :</b>\n" +
                    "    <div id=faccodebox>"+cardinpark.getFACILITYKEY()+"</div>\n" +
                    "</div>\n" +
                    "<div class=vertfloating id=insertcoupon style=\"visibility:hidden;\">\n" +
                    "    <img src=\"\\images\\cp01-coupon.png\">\n" +
                    "</div>\n" +
                    "\n" +
                    "<div class=left_button id=receiptbutton style=\"visibility:hidden;\">\n" +
                    "    <img src=\"\\images\\cp01-receipt.png\" onmousedown=redemptionReceipt()>\n" +
                    "</div>\n" +
                    "<div class=right_button>\n" +
                    "    <img src=\"\\images\\cp01-quit.png\" onmousedown=backToHome()>\n" +
                    "</div>";
        }

        return result;
    }

}
