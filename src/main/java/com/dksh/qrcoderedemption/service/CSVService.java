package com.dksh.qrcoderedemption.service;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.dksh.qrcoderedemption.domain.QRCODE_REDEMPTION_LOG;
import com.dksh.qrcoderedemption.helper.CSVHelper;
import com.dksh.qrcoderedemption.repository.QRCODE_REDEMPTION_LOG_Repository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CSVService {

    @Autowired
    QRCODE_REDEMPTION_LOG_Repository qrcode_redemption_log_repository;

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public ByteArrayInputStream GenerateCSV() throws IOException {

        Date date = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000); // yesterday
        String yesterday = dateFormat.format(date);

        List<QRCODE_REDEMPTION_LOG> logs = qrcode_redemption_log_repository.findByCREATEDATE(yesterday);

        ByteArrayInputStream stream = CSVHelper.tutorialsToCSV(logs);

        return stream;
    }

}
