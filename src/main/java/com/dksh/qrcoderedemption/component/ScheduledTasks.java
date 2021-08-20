package com.dksh.qrcoderedemption.component;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.dksh.qrcoderedemption.model.VerifyResponseModel;
import com.dksh.qrcoderedemption.service.RedemptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private RedemptionService redemptionService;

    //@Value("${ScheduledTasks.Cron}")
    private static final String cron = "";

    @Scheduled(fixedRate = 50000)
    public void UploadQRCodeRedemption() {
      //  log.info("The time is now {}", dateFormat.format(new Date()));

      //  VerifyResponseModel data = redemptionService.Verify("12344");

      //  log.info("Status {}", data.getStatus());
    }
}
