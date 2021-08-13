package com.dksh.qrcoderedemption.service;

import com.dksh.qrcoderedemption.component.RestTemplateHelper;
import com.dksh.qrcoderedemption.model.QRCodeResposeModel;
import com.dksh.qrcoderedemption.model.VerifyResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.IOException;

@Service
public class RedemptionService {

    @Value("${QRCode.Verfy}")
    String verify_url;

    @Value("${QRCode.Redemption}")
    String redemption_url;

    private static final Logger LOGGER = LoggerFactory.getLogger(RedemptionService.class);

    @Autowired
    private RestTemplateHelper restTemplateHelper;

    public VerifyResponseModel Verify(String qrocde) {

        try{

            MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            map.add("qrcode", qrocde);
            VerifyResponseModel response = restTemplateHelper.postForEntity(VerifyResponseModel.class, verify_url, map);
            return response;
        } catch (Exception e){
            System.out.println(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    public QRCodeResposeModel Redemption(String qrcode) {

        try{
            MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            map.add("qrcode", qrcode);
            QRCodeResposeModel result = restTemplateHelper.postForEntity(QRCodeResposeModel.class, redemption_url, map);

            return result;
        }catch (Exception e){
            LOGGER.error(e.getMessage());
            System.out.println(e);
        }
        return null;
    }
}
