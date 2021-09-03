package com.dksh.qrcoderedemption.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class CardTransactionId  implements Serializable {

    private Date TRANTIME;

    private String CARDID;

    public CardTransactionId() {

    }

    public CardTransactionId(Date TRANTIME, String CARDID) {
        this.TRANTIME = TRANTIME;
        this.CARDID = CARDID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardTransactionId that = (CardTransactionId) o;
        return Objects.equals(TRANTIME, that.TRANTIME) && Objects.equals(CARDID, that.CARDID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(TRANTIME, CARDID);
    }
}