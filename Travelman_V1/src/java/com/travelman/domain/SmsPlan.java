package com.travelman.domain;
public class SmsPlan
{
    private int smsPlanId;
    private String smsPlan;
    private float smsAmount;

    public float getSmsAmount() {
        return smsAmount;
    }

    public void setSmsAmount(float smsAmount) {
        this.smsAmount = smsAmount;
    }

    public String getSmsPlan() {
        return smsPlan;
    }

    public void setSmsPlan(String smsPlan) {
        this.smsPlan = smsPlan;
    }

    public int getSmsPlanId() {
        return smsPlanId;
    }

    public void setSmsPlanId(int smsPlanId) {
        this.smsPlanId = smsPlanId;
    }
    
    
    
}
