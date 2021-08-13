package com.dksh.qrcoderedemption.repository;

import com.dksh.qrcoderedemption.domain.CardInPark;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CardInParkRepository extends JpaRepository<CardInPark, String> {
    CardInPark findByCARDIDAndCARDTYPEIn(String CARDID, List<Long> CARDTYPE);
}


