package com.dksh.qrcoderedemption.domain;

import java.io.Serializable;
import java.util.Objects;

public class CardInParkId implements Serializable {

    private String CARDID;

    private long CARDTYPE;

    public CardInParkId(String CARDID, long CARDTYPE) {
        this.CARDID = CARDID;
        this.CARDTYPE = CARDTYPE;
    }

    public CardInParkId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardInParkId that = (CardInParkId) o;
        return CARDTYPE == that.CARDTYPE && Objects.equals(CARDID, that.CARDID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CARDID, CARDTYPE);
    }
}
