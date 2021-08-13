package com.dksh.qrcoderedemption.repository;

import com.dksh.qrcoderedemption.domain.TempCustTriggerQueue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface TempCustTriggerQueueRepository extends JpaRepository<TempCustTriggerQueue, String> {

    @Query(value = "insert into TempCustTriggerQueue\n" +
            "(\n" +
            "TRIGGERTIME,\n" +
            "CARDTYPE,\n" +
            "CARDID,\n" +
            "CURRENTTEMPCUSTTIME,\n" +
            "NEWTEMPCUSTTIME,\n" +
            "DEVICEID,\n" +
            "FACILITYKEY,\n" +
            ")\n" +
            "values(\n" +
            ":TRIGGERTIME,\n" +
            ":CARDTYPE,\n" +
            ":CARDID,\n" +
            ":CURRENTTEMPCUSTTIME,\n" +
            ":NEWTEMPCUSTTIME,\n" +
            ":DEVICEID,\n" +
            ":FACILITYKEY" +
            ")", nativeQuery = true)
    void InsertTempCustTriggerQueue(
            @Param(value = "TRIGGERTIME") Date TRIGGERTIME,
            @Param(value = "CARDTYPE") long CARDTYPE,
            @Param(value = "CARDID") String CARDID,
            @Param(value = "CURRENTTEMPCUSTTIME") Date CURRENTTEMPCUSTTIME,
            @Param(value = "NEWTEMPCUSTTIME") Date NEWTEMPCUSTTIME,
            @Param(value = "DEVICEID") long DEVICEID,
            @Param(value = "FACILITYKEY") long FACILITYKEY
            );

}
