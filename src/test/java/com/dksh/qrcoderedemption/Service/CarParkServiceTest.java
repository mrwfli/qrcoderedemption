package com.dksh.qrcoderedemption.Service;

import com.dksh.qrcoderedemption.domain.*;
import com.dksh.qrcoderedemption.repository.*;
import com.dksh.qrcoderedemption.service.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class CarParkServiceTest {

    @Autowired
    @Mock
    TempCustTriggerQueueRepository tempCustTriggerQueueRepository;

    @Autowired
    @Mock
    CardInParkRepository cardInParkRepository;

    @Autowired
    @Mock
    CardEventLogRepository cardEventLogRepository;

    @Autowired
    @Mock
    CardTransactionRepository cardTransactionRepository;

    @Autowired
    @Mock
    QRCODE_REDEMPTION_LOG_Repository qrcode_redemption_log_repository;


//    CarParkService carParkService;

    private Date date = new Date(System.currentTimeMillis());

//    @BeforeEach
//    void InitUserCase(){
//        carParkService = new CarParkService();
//    }

    @Test
    public void save_TempCustTriggerQueue(){
        TempCustTriggerQueue temp = new TempCustTriggerQueue();
        temp.setCARDID("1111111");
        temp.setCARDTYPE(100);
        temp.setCURRENTTEMPCUSTTIME(date);
        temp.setDEVICEID(11111);
        temp.setTRIGGERTIME(date);
        temp.setFACILITYKEY(111111);
        temp.setPROCESSLEVEL(1);
        temp.setNEWTEMPCUSTTIME(date);
       // carParkService.SaveTempCustTriggerQueue(temp);

        // providing knowledge
        when(tempCustTriggerQueueRepository.save(any(TempCustTriggerQueue.class))).thenReturn(temp);

        TempCustTriggerQueue saveTemp = tempCustTriggerQueueRepository.save(temp);
        assertThat(saveTemp.getCARDID()).isEqualTo("1111111");//.isNotNull();
    }

    @Test
    public void save_CarInPark(){
        CardInPark temp = new CardInPark();
        temp.setCARDID("1111111");
        temp.setCARDTYPE(100);
        temp.setDEVICEID(11111);
        temp.setFACILITYKEY(111111);
        temp.setHOURLYCOUPON(10);
        temp.setENTRYDATE("");
        temp.setFREETILLTIME(date);
        temp.setGRACEPERIODGRANTED(10);
        temp.setISPAID(1);
        temp.setPAYTIME(date);
        temp.setRESERVED1(1);
        temp.setRESERVED2(2);
        temp.setTRANAMOUNT(9999);

        // providing knowledge
        when(cardInParkRepository.save(any(CardInPark.class))).thenReturn(temp);

        CardInPark saveTemp = cardInParkRepository.save(temp);
        assertThat(saveTemp.getCARDID()).isEqualTo("1111111");//.isNotNull();
    }

    @Test
    public void save_CardEventLog(){
        CARDEVENTLOG temp = new CARDEVENTLOG();
        temp.setCARDID("1111111");
        temp.setCARDTYPE(100);
        temp.setDEVICEID(11111);
        temp.setFACILITYKEY(111111);
        temp.setEVENTCODE(11111);
        temp.setLOGTIME(date);

        // providing knowledge
        when(cardEventLogRepository.save(any(CARDEVENTLOG.class))).thenReturn(temp);

        CARDEVENTLOG saveTemp = cardEventLogRepository.save(temp);
        assertThat(saveTemp.getCARDID()).isEqualTo("1111111");//.isNotNull();
    }

    @Test
    public void save_CardTransaction(){
        CardTransaction temp = new CardTransaction();
        temp.setCARDID("1111111");
        temp.setCARDTYPE(100);
        temp.setDEVICEID(11111);
        temp.setFACILITYKEY(111111);
        temp.setRESERVED1(1);
        temp.setRESERVED2(2);
        temp.setTRANAMOUNT(9999);
        temp.setPROCESSLEVEL(999);
        temp.setPAYCARDID("11111");
        temp.setPAYCARDTYPE(1111);
        temp.setREADERID(111);
        temp.setRESERVED1(0);
        temp.setRESERVED2(0);
        temp.setSBARTICLEID(999);
        temp.setTRANDATE("1999-01-01");
        temp.setTRANTIME(date);
        temp.setZSETTLMNTID(999);
        // providing knowledge
        when(cardTransactionRepository.save(any(CardTransaction.class))).thenReturn(temp);

        CardTransaction saveTemp = cardTransactionRepository.save(temp);
        assertThat(saveTemp.getCARDID()).isEqualTo("1111111");//.isNotNull();
    }

//    @Test
//    public void save_QRCODE_REDEMPTION_LOG(){
//        QRCODE_REDEMPTION_LOG temp = new QRCODE_REDEMPTION_LOG();
//        temp.setCARDID("1111111");
//        temp.setCARDTYPE(1111);
//        temp.setDEVICEID(11111);
//        temp.setQRCODE("111111111111111111");
//        temp.setCREATEDATE(date);
//        temp.setMESSAGE("test");
//        temp.setREDEMPTIONID("99999");
//        temp.setSTATUS("Test");
//        // providing knowledge
//        when(qrcode_redemption_log_repository.save(any(QRCODE_REDEMPTION_LOG.class))).thenReturn(temp);
//
//        QRCODE_REDEMPTION_LOG saveTemp = qrcode_redemption_log_repository.save(temp);
//        assertThat(saveTemp.getCARDID()).isEqualTo("1111111");//.isNotNull();
//    }

}
