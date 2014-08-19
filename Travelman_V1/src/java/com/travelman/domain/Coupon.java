
package com.travelman.domain;

import java.util.Date;


public class Coupon 
{
    String couponId;
    String couponName;
    int numberOfCoupons;
    float discount;
    //int noOfUses;
    String assign;
    String validTill;
    
    
    
    public Coupon()
    {
       
    }

    public String getAssign() {
        return assign;
    }

    public void setAssign(String assign) {
        this.assign = assign;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

   /* public int getNoOfUses() {
        return noOfUses;
    }

    public void setNoOfUses(int noOfUses) {
        this.noOfUses = noOfUses;
    }*/

    public int getNumberOfCoupons() {
        return numberOfCoupons;
    }

    public void setNumberOfCoupons(int numberOfCoupons) {
        this.numberOfCoupons = numberOfCoupons;
    }

    public String getValidTill() {
        return validTill;
    }

    public void setValidTill(String validTill) {
        this.validTill = validTill;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }
    
    
}
