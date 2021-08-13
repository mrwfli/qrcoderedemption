package com.dksh.qrcoderedemption.domain;

import java.io.Serializable;
import java.util.Date;

public class CardTransactionId  implements Serializable {

    private Date TRANTIME;

    private String CARDID;

    public CardTransactionId() {

    }

    public CardTransactionId(Date TRANTIME, String CARDID) {
        this.TRANTIME = TRANTIME;
        this.CARDID = CARDID;
    }
}