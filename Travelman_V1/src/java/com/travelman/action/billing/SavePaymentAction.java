package com.travelman.action.billing;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.action.LoginAction;
import com.travelman.business.service.billing.BillBusinesService;
import com.travelman.domain.Payment;
import com.travelman.domain.User;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.apache.log4j.Logger;


public class SavePaymentAction extends ActionSupport{
    private Logger log=Logger.getLogger(SavePaymentAction.class);
    private String currentUserName;
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
    
    private BillBusinesService billBusinessService;
    @Override
    public String execute(){
    
        String actionResult="";

        Map<String,Object> session =ActionContext.getContext().getSession();
        User user=(User)session.get("USER");
        setCurrentUserName(user.getFname()+" "+user.getLname());
        log.info("111");
        billBusinessService=new BillBusinesService();
        Payment payment=new Payment();
        payment.setAccNo(accNo);
        payment.setDeviceId(deviceId);
        payment.setNetAmount(netAmount);
        payment.setPaymentMode(paymentMode);
        //SimpleDateFormat df=new SimpleDateFormat("dd-MMM-yyyy");
       // paymentDate=new Date();
        payment.setPaymentDate(paymentDate);
        payment.setReceivedAmt(receivedAmt);
        payment.setChqDdNo(chqDdNo);
        payment.setBankName(bankName);
        payment.setBranchName(branchName);
        payment.setOfferName(offerName);
        payment.setOfferAmt(offerAmt);
        payment.setAdjusment(adjusment);
        payment.setDiscount(discount);
        payment.setCouponNo(couponNo);
        payment.setCouponDiscount(couponDiscount);
        billBusinessService.savePayment(payment);
    
        
        if (user.getUprofile() == 1) {
			actionResult = "individual";
			setCurrentUserName(getCurrentUserName()+" [I]");
		} else {
			if (user.getUprofile() == 2) {
				actionResult = "group";
				setCurrentUserName(getCurrentUserName()+" [G]");
			} else {
				if (user.getUprofile() == 3) {
					actionResult = "admin";
					setCurrentUserName(getCurrentUserName()+" [A]");
				}
			}
		}
		return actionResult;       
    }

    public String getCurrentUserName() {
        return currentUserName;
    }

    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }

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

    public float getOfferAmt() {
        return offerAmt;
    }

    public void setOfferAmt(float offerAmt) {
        this.offerAmt = offerAmt;
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

    public String getCouponNo() {
        return couponNo;
    }

    public void setCouponNo(String couponNo) {
        this.couponNo = couponNo;
    }

    public float getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(float couponDiscount) {
        this.couponDiscount = couponDiscount;
    }
}
