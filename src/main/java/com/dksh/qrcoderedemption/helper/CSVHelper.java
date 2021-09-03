package com.dksh.qrcoderedemption.helper;

import com.dksh.qrcoderedemption.domain.QRCODE_REDEMPTION_LOG;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVHelper {


public static ByteArrayInputStream QRCodeRedemptionLogToCSV(List<QRCODE_REDEMPTION_LOG> logs)  throws IOException {

    List<String> header = new ArrayList<>();
    header.add("REDEMPTIONID");
    header.add("CREATEDATE");

    final CSVFormat format = CSVFormat
                            .DEFAULT
                            .withHeader(header.toArray(new String[0]))
                            .withQuoteMode(QuoteMode.MINIMAL);

    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
         CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {

        for (QRCODE_REDEMPTION_LOG log : logs) {
            List<String> data = Arrays.asList(
                                String.valueOf(log.getREDEMPTIONID()),
                                String.valueOf(log.getCREATEDATE())
            );

            csvPrinter.printRecord(data);
        }
        csvPrinter.flush();
        return new ByteArrayInputStream(out.toByteArray());
    } catch (IOException e) {
        throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
    }
}

}
