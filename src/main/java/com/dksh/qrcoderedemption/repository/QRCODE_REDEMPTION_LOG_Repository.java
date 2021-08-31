package com.dksh.qrcoderedemption.repository;

import com.dksh.qrcoderedemption.domain.QRCODE_REDEMPTION_LOG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QRCODE_REDEMPTION_LOG_Repository extends JpaRepository<QRCODE_REDEMPTION_LOG, Number> {

    @Query(value = "select * from QRCODE_REDEMPTION_LOG where ROWNUM = 1 and REDEMPTIONID=:REDEMPTIONID and TO_CHAR(CREATEDATE,'yyyy-MM-dd') = :DATE", nativeQuery = true)
    QRCODE_REDEMPTION_LOG findByREDEMPTIONIDAndCREATEDATE(String REDEMPTIONID, String DATE);

    @Query(value = "select * from QRCODE_REDEMPTION_LOG where TO_CHAR(CREATEDATE,'yyyy-MM-dd') = :DATE ", nativeQuery = true)
    List<QRCODE_REDEMPTION_LOG> findByCREATEDATE(String DATE);

}
