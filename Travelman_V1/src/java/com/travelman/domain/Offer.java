
package com.travelman.domain;


public class Offer 
{
   
    String offerName;
    float offerAmount;
    String billingCycle;
    Long assignTo;
    
    public Offer()
    {
        
    }
    
    public Offer(String offerName,float offerAmount,String billingCycle,Long assignTo)
    {
        this.offerName=offerName;
        this.offerAmount=offerAmount;
        this.billingCycle=billingCycle;
        this.assignTo=assignTo;
    }

    public Long getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(Long assignTo) {
        this.assignTo = assignTo;
    }

    public String getBillingCycle() {
        return billingCycle;
    }

    public void setBillingCycle(String billingCycle) {
        this.billingCycle = billingCycle;
    }

    public float getOfferAmount() {
        return offerAmount;
    }

    public void setOfferAmount(float offerAmount) {
        this.offerAmount = offerAmount;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }
    
    
   
}
