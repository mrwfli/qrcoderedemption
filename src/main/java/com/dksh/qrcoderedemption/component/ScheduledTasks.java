package com.dksh.qrcoderedemption.component;

import java.io.ByteArrayInputStream;
import com.dksh.qrcoderedemption.helper.CommonInputStreamResource;
import com.dksh.qrcoderedemption.model.CSVResponseModel;
import com.dksh.qrcoderedemption.service.CSVService;
import com.dksh.qrcoderedemption.service.RedemptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    private final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    CSVService csvService;

    @Autowired
    private RedemptionService redemptionService;

    @Scheduled(cron ="${ScheduledTasks.Cron}")
    public void UploadQRCodeRedemption() throws Exception {
        log.info("Start Scheduled");
        log.info("generating csv");
        ByteArrayInputStream csv =  csvService.GenerateCSV();
        Resource resource = new CommonInputStreamResource(csv); //generate the resource for upload to api
        log.info("uploading csv");
        CSVResponseModel result = redemptionService.UploadCSV(resource);
        log.info("Scheduled finished");
    }
}
