package com.travelman.action.billing;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.billing.BillBusinesService;
import com.travelman.business.service.billing.AlphaNumericAutoGenerator;
import com.travelman.domain.Coupon;
import com.travelman.domain.User;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class CouponPlanAction extends ActionSupport {

    private String currentUserName;
    String couponName;
    int numberOfCoupons;
    float discount;
    //int noOfUses = 0;
    String assign;
    String validTill;
    BillBusinesService billBusinesService;

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

    public String getCurrentUserName() {
        return currentUserName;
    }

    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
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

    public String execute() throws IOException {
        Map<String, Object> session = ActionContext.getContext().getSession();
        User user = (User) session.get("USER");
        setCurrentUserName(user.getFname() + " " + user.getLname());

        if (user.getUprofile() == 3) {

            setCurrentUserName(getCurrentUserName() + " [A]");
        }
        
       
        billBusinesService = new BillBusinesService();
        String[] couponsList = AlphaNumericAutoGenerator.autoGenerated(numberOfCoupons, 15);
       String tabName=null;
        if (couponsList != null) 
        {
             if(assign.equals("YES"))
        {
            for (String str : couponsList) {
                Coupon coupon = new Coupon();
                coupon.setCouponId(str);
                coupon.setCouponName(couponName);
                coupon.setDiscount(discount);
               // coupon.setNoOfUses(noOfUses);
                coupon.setNumberOfCoupons(numberOfCoupons);
                coupon.setAssign(assign);
               // System.out.println("here");
                coupon.setValidTill(validTill);
              //  System.out.println("there");
                str="definingpreassigned_coupons";
                billBusinesService.SaveCoupons(coupon,str);

            }
              billBusinesService.preAssignedCoupon();
            
        }
             else
             {
                for (String str : couponsList) {
                Coupon coupon = new Coupon();
                coupon.setCouponId(str);
                coupon.setCouponName(couponName);
                coupon.setDiscount(discount);
               // coupon.setNoOfUses(noOfUses);
                coupon.setNumberOfCoupons(numberOfCoupons);
                coupon.setAssign(assign);
               // System.out.println("here");
                coupon.setValidTill(validTill);
              //  System.out.println("there");
               str="definingpostassigned_coupons";
                billBusinesService.SaveCoupons(coupon,str);

            }  
             }
       
    }
         return SUCCESS;
}
}
