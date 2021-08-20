package com.dksh.qrcoderedemption.controller;

import com.dksh.qrcoderedemption.domain.CardInPark;
import com.dksh.qrcoderedemption.model.QRCodeResposeModel;
import com.dksh.qrcoderedemption.model.VerifyResponseModel;
import com.dksh.qrcoderedemption.repository.CardInParkRepository;
import com.dksh.qrcoderedemption.service.QRCodeRedemptionValidation;
import com.dksh.qrcoderedemption.service.RedemptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QRCodeRedemptionController  {

    private static final Logger LOGGER = LoggerFactory.getLogger(QRCodeRedemptionController.class);

    @Autowired
    QRCodeRedemptionValidation qrCodeRedemptionValidation;

    @Autowired
    RedemptionService redemptionService;

    @Autowired
    CardInParkRepository cardInParkRepository;

    public QRCodeRedemptionController() {
    }

    @RequestMapping(value = "Verify", method = RequestMethod.GET)
    @ResponseBody
    public String Verify(@RequestParam(name = "qrcode") String qrcode,
                         @RequestParam(name = "cardId") String cardId,
                         @RequestParam(name = "cardtype") long cardtype,
                         @RequestParam(name = "deviceId") long deviceId
                        ) {
        try{
            LOGGER.info("Sleeping---------begin-----------------");
            Thread.sleep(100000);
            LOGGER.info("Sleeping---------end-----------------");
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

            CardInPark cardinpark = cardInParkRepository.findByCARDIDAndCARDTYPEIn(cardId,cardtypels);

            if(cardinpark == null) {
                return "<img src=\"\\images\\record_not_found.jpg\">\n" +
                        "<div class=right_button>\n" +
                        "\t<img src=\"\\images\\return_small.png\" onmousedown=backToQueryRecord()>\n" +
                        "</div>\n";
            }

            VerifyResponseModel verify_result = redemptionService.Verify(qrcode);

            result = qrCodeRedemptionValidation.VerifyValidate(verify_result,cardId,(long)cardinpark.getHOURLYCOUPON(),cardtype);

           if(!result.equals("")) return  result;

            QRCodeResposeModel redemption_result = redemptionService.Redemption(qrcode);

            result = qrCodeRedemptionValidation.RedemptionValidate(redemption_result);

            if(!result.equals("")) return result;

            try {
                qrCodeRedemptionValidation.UpdateDatabase(verify_result,redemption_result.getMessage(),qrcode,redemption_result.getStatus(), cardinpark,deviceId);
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
            return "<img src=\"\\images\\cp02-invalid_coupon.png\">\n" +
                    "<div class=right_button>\n" +
                    "\t<img src=\"\\images\\cp01-quit.png\" onmousedown=backToHome()>\n" +
                    "</div>";
        }
        catch (Exception ex){
            LOGGER.error(ex.getMessage());
            LOGGER.error("QRCode:"+ qrcode);
            System.out.println(ex);
            return "<img src=\"\\images\\cp03-operation_failed.png\">\n" +
                    "<div class=right_button>\n" +
                    "\t<img src=\"\\images\\cp01-quit.png\" onmousedown=backToHome()>\n" +
                    "</div>";
        }
    }

//    @RequestMapping(value = "Redemption", method = RequestMethod.GET)
//    @ResponseBody
//    public String Redemption(@RequestParam(defaultValue = "", name = "qrcode") String qrcode) throws IOException {
//
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        // service.Verify(qrcode);
//
//        System.out.println("Redemption:" + qrcode);
//        // RedemptionResposeModel result = service.Redemption(qrcode);
//        return "";
//    }
}
