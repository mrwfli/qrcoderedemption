package com.dksh.qrcoderedemption.service;

import com.dksh.qrcoderedemption.domain.*;
import com.dksh.qrcoderedemption.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarParkService {

    @Autowired
    private CardInParkRepository cardInParkRepository;

    @Autowired
    private QRCODE_REDEMPTION_LOG_Repository qrcode_redemption_log_repository;

    @Autowired
    CardEventLogRepository cardEventLogRepository;

    @Autowired
    CardTransactionRepository cardTransactionRepository;

    @Autowired
    TempCustTriggerQueueRepository tempCustTriggerQueueRepository;

   public CardInPark GetCardInPark(String cardId, List<Long> cardtypels){
       return cardInParkRepository.findByCARDIDAndCARDTYPEIn(cardId,cardtypels);
   }

   public List<QRCODE_REDEMPTION_LOG> GetRedemptionLogByCreateDate(String date){
       return qrcode_redemption_log_repository.findByCREATEDATE(date);
   }

    public List<QRCODE_REDEMPTION_LOG> GetRedemptionLogByStatusAndCreateDate(String status, String date){
        return qrcode_redemption_log_repository.findByStatusAndCREATEDATE(status, date);
    }

   public QRCODE_REDEMPTION_LOG GetRedemptionLogByIdAndCreateDate(String redemption_id, String now) {
     return qrcode_redemption_log_repository.findByREDEMPTIONIDAndCREATEDATE(redemption_id,now);
   }

   public void Update_Redemption_Log_Completed(String redemption_id){
       QRCODE_REDEMPTION_LOG log = this.qrcode_redemption_log_repository.findByREDEMPTIONID(redemption_id);
       if(log != null){
           log.setSTATUS("Completed");
           this.qrcode_redemption_log_repository.save(log);
       }
   }

   public void SaveCarInPark(CardInPark card){
       cardInParkRepository.save(card);
   }

   public void SaveCardEventLog(CARDEVENTLOG log){
       cardEventLogRepository.save(log);
    }

    public void SaveCardTransaction(CardTransaction tran){
        cardTransactionRepository.save(tran);
    }

    public void SaveQrcode_redemption_log(QRCODE_REDEMPTION_LOG log){
        qrcode_redemption_log_repository.save(log);
    }

    public void SaveTempCustTriggerQueue(TempCustTriggerQueue queue){
        tempCustTriggerQueueRepository.save(queue);
    }

}
