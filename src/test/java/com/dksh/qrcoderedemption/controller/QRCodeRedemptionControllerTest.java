package com.dksh.qrcoderedemption.controller;

import com.dksh.qrcoderedemption.constant.ResponseHtml;
import com.dksh.qrcoderedemption.service.CarParkService;
import com.dksh.qrcoderedemption.service.QRCodeRedemptionValidation;
import com.dksh.qrcoderedemption.service.RedemptionService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest({QRCodeRedemptionController.class})
class QRCodeRedemptionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    RedemptionService redemptionService;

    @MockBean
    CarParkService carParkService;

    @MockBean
    QRCodeRedemptionValidation qrCodeRedemptionValidation;

    @Test
    public void verfiy_qrcode() throws Exception {

        String qrcode = "FP-01||bska8JtePE2rFiBwLjWHIv2vO6onwnKdYSeNzyFlrGqSnkTuEZxyPBeoYyPeYkPt8ufUmQDNNh0yJD8oskkz3YcfmOS5eJoEpTMwJ+ZfukOO95caQK9MeR/TGwMTdSlaCkEKQ7x0Ha3kpOLmD4BeZPLvl+SgFbabuqUNbfBYY053973ds+FWz1hw0a+UzuwyNuStPO/GdDHZyWkzQ+LbUw2JxU1n8k64pNqvSwJbL2Xx+01EjufmdWPkL7K0pZa99/3Ir+DfP9VpGJ4Bm0QPjtTpmy6UqswONQcEPJhV6mRUnQY/OxTacbQ1pTUCfuWGAp6FJNU46+Zn/8HCW6rqBA==";

        mockMvc.perform(
                MockMvcRequestBuilders.get("/Verify")
                        .param("qrcode",qrcode)
                        .param("cardId","999999999999")
                        .param("cardtype","3")
                        .param("deviceId","709")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(content().string(ResponseHtml.record_not_found));
    }

}