package com.dksh.qrcoderedemption.domain;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "QRCODE_REDEMPTION_LOG")
public class QRCODE_REDEMPTION_LOG {

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "ID_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "ID")
    private Integer ID;

    private String CARDID;
    private long CARDTYPE;
    private String QRCODE;
    private String REDEMPTIONID;
    private String MESSAGE;
    private long DEVICEID;
    private Date CREATEDATE;
    private String STATUS;

    public QRCODE_REDEMPTION_LOG() {
    }

    public QRCODE_REDEMPTION_LOG(String CARDID, long CARDTYPE, String QRCODE, String REDEMPTIONID, String MESSAGE, long DEVICEID, Date CREATEDATE, String STATUS) {
      //  this.ID = 0;
        this.CARDID = CARDID;
        this.CARDTYPE = CARDTYPE;
        this.QRCODE = QRCODE;
        this.REDEMPTIONID = REDEMPTIONID;
        this.MESSAGE = MESSAGE;
        this.DEVICEID = DEVICEID;
        this.CREATEDATE = CREATEDATE;
        this.STATUS = STATUS;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
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

    public void setCARDTYPE(long CARDTYPE) {
        this.CARDTYPE = CARDTYPE;
    }

    public String getQRCODE() {
        return QRCODE;
    }

    public void setQRCODE(String QRCODE) {
        this.QRCODE = QRCODE;
    }

    public String getREDEMPTIONID() {
        return REDEMPTIONID;
    }

    public void setREDEMPTIONID(String REDEMPTIONID) {
        this.REDEMPTIONID = REDEMPTIONID;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public long getDEVICEID() {
        return DEVICEID;
    }

    public void setDEVICEID(long DEVICEID) {
        this.DEVICEID = DEVICEID;
    }

    public Date getCREATEDATE() {
        return CREATEDATE;
    }

    public void setCREATEDATE(Date CREATEDATE) {
        this.CREATEDATE = CREATEDATE;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }
}
