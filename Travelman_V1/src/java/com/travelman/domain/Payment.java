
package com.travelman.domain;

import java.util.Date;

public class Payment {
    
    private int accNo;
    private long deviceId;
    private float netAmount;
    private String paymentMode;
    private Date paymentDate;
    private float receivedAmt;
    private int chqDdNo;
    private String bankName;
    private String branchName;
    private String offerName;
    private float offerAmt;
    private float adjusment;
    private float discount;
    private String couponNo;
    private float couponDiscount;

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public float getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(float netAmount) {
        this.netAmount = netAmount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public float getReceivedAmt() {
        return receivedAmt;
    }

    public void setReceivedAmt(float receivedAmt) {
        this.receivedAmt = receivedAmt;
    }

    public int getChqDdNo() {
        return chqDdNo;
    }

    public void setChqDdNo(int chqDdNo) {
        this.chqDdNo = chqDdNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public float getAdjusment() {
        return adjusment;
    }

    public void setAdjusment(float adjusment) {
        this.adjusment = adjusment;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }    

    public float getOfferAmt() {
        return offerAmt;
    }

    public void setOfferAmt(float offerAmt) {
        this.offerAmt = offerAmt;
    }

    public float getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(float couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public String getCouponNo() {
        return couponNo;
    }

    public void setCouponNo(String couponNo) {
        this.couponNo = couponNo;
    }
}
