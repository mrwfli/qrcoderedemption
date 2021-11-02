package com.dksh.qrcoderedemption.controller;

import com.dksh.qrcoderedemption.constant.ResponseHtml;
import com.dksh.qrcoderedemption.domain.CardInPark;
import com.dksh.qrcoderedemption.model.QRCodeResposeModel;
import com.dksh.qrcoderedemption.model.VerifyResponseModel;
import com.dksh.qrcoderedemption.service.CSVService;
import com.dksh.qrcoderedemption.service.CarParkService;
import com.dksh.qrcoderedemption.service.QRCodeRedemptionValidation;
import com.dksh.qrcoderedemption.service.RedemptionService;
import org.apache.http.HttpException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class QRCodeRedemptionController  {

    private final Logger LOGGER = LoggerFactory.getLogger(QRCodeRedemptionController.class);

    @Autowired
    QRCodeRedemptionValidation qrCodeRedemptionValidation;

    @Autowired
    RedemptionService redemptionService;

    @Autowired
    CarParkService carParkService;

    public QRCodeRedemptionController() {
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "Verify", method = RequestMethod.GET)
    @ResponseBody
    public String Verify(@RequestParam(name = "qrcode") String qrcode,
                         @RequestParam(name = "cardId") String cardId,
                         @RequestParam(name = "cardtype") long cardtype,
                         @RequestParam(name = "deviceId") long deviceId
                        ) {
        try{

            String result = "";

            String[] arrStr = qrcode.split("\\|\\|");
            qrcode = arrStr[1];

            List<Long> cardtypels = new ArrayList<>();

            if(cardId.length() < 11){
                cardtypels.add(540L);
            }else{
                cardtypels.add(257L);
                cardtypels.add(259L);
                cardtypels.add(577L);
            }

            CardInPark cardinpark = carParkService.GetCardInPark(cardId, cardtypels); //cardInParkRepository.findByCARDIDAndCARDTYPEIn(cardId,cardtypels);

            if(cardinpark == null) {
                return ResponseHtml.record_not_found;
            }

            //verify the qrcode
            VerifyResponseModel verify_result = redemptionService.Verify(qrcode);

            result = qrCodeRedemptionValidation.VerifyValidate(verify_result, cardId, (long)cardinpark.getHOURLYCOUPON(), cardtype);

           if(!result.equals("")) return  result;

            //redeem the qrcode
            QRCodeResposeModel redemption_result = redemptionService.Redemption(qrcode);

            //redeem success
            if(redemption_result != null){
                result = qrCodeRedemptionValidation.RedemptionValidate(redemption_result);
                if(!result.equals("")) return result;
            }
            else {
                //redeem failed
                LOGGER.info("cannot call redemption api");
                redemption_result = new QRCodeResposeModel();
                redemption_result.setMessage("cannot call redemption api");
                redemption_result.setStatus(-1);
            }

            try {
                qrCodeRedemptionValidation.UpdateDatabase(verify_result, redemption_result.getMessage(), qrcode, redemption_result.getStatus(), cardinpark, deviceId, (long)cardinpark.getHOURLYCOUPON());
            }
            catch (Exception ex){
                LOGGER.error(ex.getMessage());
                System.out.println(ex);
            }

            result = qrCodeRedemptionValidation.CompletedProcess(cardinpark);

            return result;
        }
        catch (ArrayIndexOutOfBoundsException ex){
            LOGGER.error(ex.getMessage());
            LOGGER.error("QRCode:"+ qrcode);
            System.out.println(ex);
            return ResponseHtml.invalid_coupon;
        }
        catch (HttpException ex){
            LOGGER.error(ex.getMessage());
            LOGGER.error("QRCode:"+ qrcode);
            return ResponseHtml.connect_server_failed;
        }
        catch (Exception ex){
            LOGGER.error(ex.getMessage());
            LOGGER.error("QRCode:"+ qrcode);
            System.out.println(ex);
            return ResponseHtml.operation_failed;
        }
    }
}
