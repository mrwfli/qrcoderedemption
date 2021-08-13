package com.dksh.qrcoderedemption.repository;

import com.dksh.qrcoderedemption.domain.CardTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface CardTransactionRepository extends JpaRepository<CardTransaction, String> {

    @Query(value = "insert into CardTransaction (TRANTIME,\n" +
            "TRANDATE,\n" +
            "TRANTYPE,\n" +
            "CARDTYPE,\n" +
            "CARDID,\n" +
            "PAYCARDTYPE,\n" +
            "PAYCARDID,\n" +
            "TRANAMOUNT,\n" +
            "SBARTICLEID,\n" +
            "READERID,\n" +
            "DEVICEID,\n" +
            "FACILITYKEY,\n" +
            "ZSETTLMNTID,\n" +
            "PROCESSLEVEL,\n" +
            "RESERVED1,\n" +
            "RESERVED2) values ( :TRANTIME, " +
            "                    :TRANDATE, " +
            "                    :TRANTYPE, " +
            "                    :CARDTYPE, " +
            "                    :CARDID," +
            "                    :PAYCARDTYPE, " +
            "                    :PAYCARDID," +
            "                    :TRANAMOUNT, " +
            "                    :SBARTICLEID," +
            "                    :READERID," +
            "                    :DEVICEID, " +
            "                    :FACILITYKEY ," +
            "                    :ZSETTLMNTID,", nativeQuery = true)
    void InsertTransaction(@Param("TRANTIME") Date TRANTIME,
                           @Param("TRANDATE") String  TRANDATE,
                           @Param("TRANTYPE") int     TRANTYPE,
                           @Param("CARDTYPE") long    CARDTYPE,
                           @Param("CARDID") String  CARDID,
                           @Param("PAYCARDTYPE") long    PAYCARDTYPE,
                           @Param("PAYCARDID") String  PAYCARDID,
                           @Param("TRANAMOUNT") double  TRANAMOUNT,
                           @Param("SBARTICLEID") long    SBARTICLEID,
                           @Param("DEVICEID") long    DEVICEID,
                           @Param("READERID") long    READERID,
                           @Param("FACILITYKEY") long    FACILITYKEY,
                           @Param("ZSETTLMNTID") long    ZSETTLMNTID);
}
