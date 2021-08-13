package com.dksh.qrcoderedemption.repository;

import com.dksh.qrcoderedemption.domain.CARDEVENTLOG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface CardEventLogRepository extends JpaRepository<CARDEVENTLOG, String> {

    @Query(value = "\n" +
            "insert into cardeventlog(\n" +
            "LOGTIME,\n" +
            "CARDTYPE,\n" +
            "CARDID,\n" +
            "EVENTCODE,\n" +
            "EVENTDETAILS,\n" +
            "DEVICEID,\n" +
            "FACILITYKEY,\n" +
            ") values \n" +
            "(\n" +
            ":LOGTIME,\n" +
            ":CARDTYPE,\n" +
            ":CARDID,\n" +
            ":EVENTCODE,\n" +
            ":EVENTDETAILS,\n" +
            ":DEVICEID,\n" +
            ":FACILITYKEY)" , nativeQuery = true)
    void InsertCardEventLog(@Param(value = "LOGTIME") Date LOGTIME,
                            @Param(value = "CARDTYPE") long CARDTYPE,
                            @Param(value = "CARDID") String CARDID,
                            @Param(value = "EVENTCODE") int EVENTCODE,
                            @Param(value = "EVENTDETAILS") String EVENTDETAILS,
                            @Param(value = "DEVICEID") long DEVICEID,
                            @Param(value = "FACILITYKEY") long FACILITYKEY);
}
