package com.dksh.qrcoderedemption.domain;

import java.io.Serializable;

public class CardInParkId implements Serializable {

    private String CARDID;

    private long CARDTYPE;

    public CardInParkId(String CARDID, long CARDTYPE) {
        this.CARDID = CARDID;
        this.CARDTYPE = CARDTYPE;
    }

    public CardInParkId() {
    }
}
