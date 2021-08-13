package com.dksh.qrcoderedemption.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="CARDEVENTLOG")
public class CARDEVENTLOG {

    @Id
    @Column(name = "LOGTIME",nullable = true)
    Date LOGTIME;

    @Column(name = "CARDTYPE",nullable = true)
    long CARDTYPE;

    @Column(name = "CARDID",nullable = true)
    String CARDID;

    @Column(name = "EVENTCODE",nullable = true)
    long EVENTCODE;

    @Column(name = "EVENTDETAILS",nullable = true)
    String EVENTDETAILS;

    @Column(name = "DEVICEID",nullable = true)
    long DEVICEID;

    @Column(name = "FACILITYKEY")
    long FACILITYKEY;

    public CARDEVENTLOG() {
    }

    public CARDEVENTLOG(Date LOGTIME, long CARDTYPE, String CARDID, long EVENTCODE, String EVENTDETAILS, long DEVICEID, long FACILITYKEY) {
        this.LOGTIME = LOGTIME;
        this.CARDTYPE = CARDTYPE;
        this.CARDID = CARDID;
        this.EVENTCODE = EVENTCODE;
        this.EVENTDETAILS = EVENTDETAILS;
        this.DEVICEID = DEVICEID;
        this.FACILITYKEY = FACILITYKEY;
    }

    public Date getLOGTIME() {
        return LOGTIME;
    }

    public void setLOGTIME(Date LOGTIME) {
        this.LOGTIME = LOGTIME;
    }

    public long getCARDTYPE() {
        return CARDTYPE;
    }

    public void setCARDTYPE(long CARDTYPE) {
        this.CARDTYPE = CARDTYPE;
    }

    public String getCARDID() {
        return CARDID;
    }

    public void setCARDID(String CARDID) {
        this.CARDID = CARDID;
    }

    public long getEVENTCODE() {
        return EVENTCODE;
    }

    public void setEVENTCODE(long EVENTCODE) {
        this.EVENTCODE = EVENTCODE;
    }

    public String getEVENTDETAILS() {
        return EVENTDETAILS;
    }

    public void setEVENTDETAILS(String EVENTDETAILS) {
        this.EVENTDETAILS = EVENTDETAILS;
    }

    public long getDEVICEID() {
        return DEVICEID;
    }

    public void setDEVICEID(long DEVICEID) {
        this.DEVICEID = DEVICEID;
    }

    public long getFACILITYKEY() {
        return FACILITYKEY;
    }

    public void setFACILITYKEY(long FACILITYKEY) {
        this.FACILITYKEY = FACILITYKEY;
    }
}
