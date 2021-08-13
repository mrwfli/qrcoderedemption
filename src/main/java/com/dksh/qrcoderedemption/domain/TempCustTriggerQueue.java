package com.dksh.qrcoderedemption.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "TEMPCUSTTRIGGERQUEUE")
public class TempCustTriggerQueue {

    @Id
    Date TRIGGERTIME;
    long  CARDTYPE;
    String CARDID;
    Date CURRENTTEMPCUSTTIME;
    Date NEWTEMPCUSTTIME;
    long DEVICEID;
    long FACILITYKEY;
    int  PROCESSLEVEL;

    public TempCustTriggerQueue() {
    }

    public TempCustTriggerQueue(Date TRIGGERTIME, long CARDTYPE, String CARDID, Date CURRENTTEMPCUSTTIME, Date NEWTEMPCUSTTIME, long DEVICEID, long FACILITYKEY, int PROCESSLEVEL) {
        this.TRIGGERTIME = TRIGGERTIME;
        this.CARDTYPE = CARDTYPE;
        this.CARDID = CARDID;
        this.CURRENTTEMPCUSTTIME = CURRENTTEMPCUSTTIME;
        this.NEWTEMPCUSTTIME = NEWTEMPCUSTTIME;
        this.DEVICEID = DEVICEID;
        this.FACILITYKEY = FACILITYKEY;
        this.PROCESSLEVEL = PROCESSLEVEL;
    }

    public Date getTRIGGERTIME() {
        return TRIGGERTIME;
    }

    public void setTRIGGERTIME(Date TRIGGERTIME) {
        this.TRIGGERTIME = TRIGGERTIME;
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

    public Date getCURRENTTEMPCUSTTIME() {
        return CURRENTTEMPCUSTTIME;
    }

    public void setCURRENTTEMPCUSTTIME(Date CURRENTTEMPCUSTTIME) {
        this.CURRENTTEMPCUSTTIME = CURRENTTEMPCUSTTIME;
    }

    public Date getNEWTEMPCUSTTIME() {
        return NEWTEMPCUSTTIME;
    }

    public void setNEWTEMPCUSTTIME(Date NEWTEMPCUSTTIME) {
        this.NEWTEMPCUSTTIME = NEWTEMPCUSTTIME;
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

    public int getPROCESSLEVEL() {
        return PROCESSLEVEL;
    }

    public void setPROCESSLEVEL(int PROCESSLEVEL) {
        this.PROCESSLEVEL = PROCESSLEVEL;
    }
}
