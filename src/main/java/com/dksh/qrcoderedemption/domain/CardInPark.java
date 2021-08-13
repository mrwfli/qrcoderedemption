package com.dksh.qrcoderedemption.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CARDINPARK")
@IdClass(CardInParkId.class)
public class CardInPark  implements Serializable  {

    @Id
    @Column(name = "CARDID", nullable = true)
    private String CARDID;

    @Id
    @Column(name = "CARDTYPE", nullable = true)
    private long CARDTYPE;

    @Column(name = "ENTRYTIME", nullable = true)
    private Date ENTRYTIME;

    @Column(name = "ENTRYDATE", nullable = true)
    private String  ENTRYDATE;

    @Column(name = "HOURLYCOUPON")
    private double  HOURLYCOUPON;

    @Column(name = "CASHCOUPON")
    private double CASHCOUPON	;

    @Column(name = "TRANAMOUNT")
    private double TRANAMOUNT;

    @Column(name = "ISPAID")
    private int ISPAID;

    @Column(name = "PAYTIME", nullable = true)
    private Date  PAYTIME;

    @Column(name = "FREETILLTIME", nullable = true)
    private Date  FREETILLTIME;

    @Column(name = "GRACEPERIODGRANTED", nullable = true)
    private int  GRACEPERIODGRANTED;

    @Column(name = "DEVICEID", nullable = true)
    private int  DEVICEID	;

    @Column(name = "FACILITYKEY")
    private int FACILITYKEY;

    @Column(name = "RESERVED1")
    private int RESERVED1;

    @Column(name = "RESERVED2")
    private int RESERVED2;

    public CardInPark() {
    }

    public CardInPark(String CARDID, long CARDTYPE, Date ENTRYTIME, String ENTRYDATE, double HOURLYCOUPON, double CASHCOUPON, double TRANAMOUNT, int ISPAID, Date PAYTIME, Date FREETILLTIME, int GRACEPERIODGRANTED, int DEVICEID, int FACILITYKEY, int RESERVED1, int RESERVED2) {
        this.CARDID = CARDID;
        this.CARDTYPE = CARDTYPE;
        this.ENTRYTIME = ENTRYTIME;
        this.ENTRYDATE = ENTRYDATE;
        this.HOURLYCOUPON = HOURLYCOUPON;
        this.CASHCOUPON = CASHCOUPON;
        this.TRANAMOUNT = TRANAMOUNT;
        this.ISPAID = ISPAID;
        this.PAYTIME = PAYTIME;
        this.FREETILLTIME = FREETILLTIME;
        this.GRACEPERIODGRANTED = GRACEPERIODGRANTED;
        this.DEVICEID = DEVICEID;
        this.FACILITYKEY = FACILITYKEY;
        this.RESERVED1 = RESERVED1;
        this.RESERVED2 = RESERVED2;
    }

    public String getCARDID() {
        return CARDID;
    }

    public void setCARDID(String CARDID) {
        this.CARDID = CARDID;
    }

    public long getCARDTYPE() {
        return CARDTYPE;
    }

    public void setCARDTYPE(int CARDTYPE) {
        this.CARDTYPE = CARDTYPE;
    }

    public Date getENTRYTIME() {
        return ENTRYTIME;
    }

    public void setENTRYTIME(Date ENTRYTIME) {
        this.ENTRYTIME = ENTRYTIME;
    }

    public String getENTRYDATE() {
        return ENTRYDATE;
    }

    public void setENTRYDATE(String ENTRYDATE) {
        this.ENTRYDATE = ENTRYDATE;
    }

    public double getHOURLYCOUPON() {
        return HOURLYCOUPON;
    }

    public void setHOURLYCOUPON(double HOURLYCOUPON) {
        this.HOURLYCOUPON = HOURLYCOUPON;
    }

    public double getCASHCOUPON() {
        return CASHCOUPON;
    }

    public void setCASHCOUPON(double CASHCOUPON) {
        this.CASHCOUPON = CASHCOUPON;
    }

    public double getTRANAMOUNT() {
        return TRANAMOUNT;
    }

    public void setTRANAMOUNT(double TRANAMOUNT) {
        this.TRANAMOUNT = TRANAMOUNT;
    }

    public Number getISPAID() {
        return ISPAID;
    }

    public void setISPAID(int ISPAID) {
        this.ISPAID = ISPAID;
    }

    public Date getPAYTIME() {
        return PAYTIME;
    }

    public void setPAYTIME(Date PAYTIME) {
        this.PAYTIME = PAYTIME;
    }

    public Date getFREETILLTIME() {
        return FREETILLTIME;
    }

    public void setFREETILLTIME(Date FREETILLTIME) {
        this.FREETILLTIME = FREETILLTIME;
    }

    public int getGRACEPERIODGRANTED() {
        return GRACEPERIODGRANTED;
    }

    public void setGRACEPERIODGRANTED(int GRACEPERIODGRANTED) {
        this.GRACEPERIODGRANTED = GRACEPERIODGRANTED;
    }

    public int getDEVICEID() {
        return DEVICEID;
    }

    public void setDEVICEID(int DEVICEID) {
        this.DEVICEID = DEVICEID;
    }

    public int getFACILITYKEY() {
        return FACILITYKEY;
    }

    public void setFACILITYKEY(int FACILITYKEY) {
        this.FACILITYKEY = FACILITYKEY;
    }

    public int getRESERVED1() {
        return RESERVED1;
    }

    public void setRESERVED1(int RESERVED1) {
        this.RESERVED1 = RESERVED1;
    }

    public int getRESERVED2() {
        return RESERVED2;
    }

    public void setRESERVED2(int RESERVED2) {
        this.RESERVED2 = RESERVED2;
    }

}
