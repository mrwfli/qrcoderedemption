package com.dksh.qrcoderedemption.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CARDTRANSACTION")
@IdClass(CardTransactionId.class)
public class CardTransaction  implements Serializable {


    @Id
    Date TRANTIME;
    String TRANDATE	;
    int TRANTYPE	;
    long CARDTYPE;

    @Id
    String CARDID	;
    long PAYCARDTYPE	;
    String PAYCARDID	;
    double TRANAMOUNT;
    long SBARTICLEID	;
    long READERID	;
    long DEVICEID	;
    long FACILITYKEY	;
    long ZSETTLMNTID	;
    int PROCESSLEVEL	;
    int RESERVED1	;
    int RESERVED2	;

    public CardTransaction() {
    }

    public CardTransaction(Date TRANTIME, String TRANDATE, int TRANTYPE, long CARDTYPE, String CARDID, long PAYCARDTYPE, String PAYCARDID, double TRANAMOUNT, long SBARTICLEID, long READERID, long DEVICEID, long FACILITYKEY, long ZSETTLMNTID, int PROCESSLEVEL, int RESERVED1, int RESERVED2) {
        this.TRANTIME = TRANTIME;
        this.TRANDATE = TRANDATE;
        this.TRANTYPE = TRANTYPE;
        this.CARDTYPE = CARDTYPE;
        this.CARDID = CARDID;
        this.PAYCARDTYPE = PAYCARDTYPE;
        this.PAYCARDID = PAYCARDID;
        this.TRANAMOUNT = TRANAMOUNT;
        this.SBARTICLEID = SBARTICLEID;
        this.READERID = READERID;
        this.DEVICEID = DEVICEID;
        this.FACILITYKEY = FACILITYKEY;
        this.ZSETTLMNTID = ZSETTLMNTID;
        this.PROCESSLEVEL = PROCESSLEVEL;
        this.RESERVED1 = RESERVED1;
        this.RESERVED2 = RESERVED2;
    }

    public Date getTRANTIME() {
        return TRANTIME;
    }

    public void setTRANTIME(Date TRANTIME) {
        this.TRANTIME = TRANTIME;
    }

    public String getTRANDATE() {
        return TRANDATE;
    }

    public void setTRANDATE(String TRANDATE) {
        this.TRANDATE = TRANDATE;
    }

    public int getTRANTYPE() {
        return TRANTYPE;
    }

    public void setTRANTYPE(int TRANTYPE) {
        this.TRANTYPE = TRANTYPE;
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

    public long getPAYCARDTYPE() {
        return PAYCARDTYPE;
    }

    public void setPAYCARDTYPE(long PAYCARDTYPE) {
        this.PAYCARDTYPE = PAYCARDTYPE;
    }

    public String getPAYCARDID() {
        return PAYCARDID;
    }

    public void setPAYCARDID(String PAYCARDID) {
        this.PAYCARDID = PAYCARDID;
    }

    public double getTRANAMOUNT() {
        return TRANAMOUNT;
    }

    public void setTRANAMOUNT(double TRANAMOUNT) {
        this.TRANAMOUNT = TRANAMOUNT;
    }

    public long getSBARTICLEID() {
        return SBARTICLEID;
    }

    public void setSBARTICLEID(long SBARTICLEID) {
        this.SBARTICLEID = SBARTICLEID;
    }

    public long getREADERID() {
        return READERID;
    }

    public void setREADERID(long READERID) {
        this.READERID = READERID;
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

    public long getZSETTLMNTID() {
        return ZSETTLMNTID;
    }

    public void setZSETTLMNTID(long ZSETTLMNTID) {
        this.ZSETTLMNTID = ZSETTLMNTID;
    }

    public int getPROCESSLEVEL() {
        return PROCESSLEVEL;
    }

    public void setPROCESSLEVEL(int PROCESSLEVEL) {
        this.PROCESSLEVEL = PROCESSLEVEL;
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
