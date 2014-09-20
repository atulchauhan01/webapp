
package com.travelman.action.billing;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.action.LoginAction;
import com.travelman.business.service.billing.BillBusinesService;
import com.travelman.domain.Bill;
import com.travelman.domain.Payment;
import com.travelman.domain.Plan;
import com.travelman.domain.SmsPlan;
import com.travelman.domain.User;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

 
public class GenerateBillAction extends ActionSupport{
    private Logger log=Logger.getLogger(GenerateBillAction.class);
        
    private String currentUserName;
    private  List<Long> list_DeviceId;

   
    private Plan plan;
    private Bill bill;
    private SmsPlan smsPlan;
    private Payment payment;
    private String planname;
    private float rental;
    
    
    
    
    private BillBusinesService billBusinessService;
    @Override
    public String execute(){
    
        String actionResult="";
        Map<String,Object> session =ActionContext.getContext().getSession();
        User user=(User)session.get("USER");
        setCurrentUserName(user.getFname()+" "+user.getLname());
        
        billBusinessService=new BillBusinesService();
        
         list_DeviceId=billBusinessService.getDeviceIdList();
         
        for(long deviceid : getList_DeviceId()){
          log.info("Action Device ID: "+deviceid); 
          
          //getting plan information to calculate current bill amount
           plan=new Plan();
          plan=billBusinessService.getPlanInfo(deviceid);
          planname=plan.getPlanname();
          rental=plan.getRental();
            //log.info("planname--->"+planname);
            //log.info("rental--->"+rental);    
          
          //getting previous month bill amount
          bill=new Bill();
          bill=billBusinessService.getPreviousBillInfo(deviceid);
            log.info("amount befort due date"+bill.getAmtBeforeDueDate());
            
            //geeting sms Charges
            smsPlan=new SmsPlan();
            smsPlan=billBusinessService.getSmsPlanInfo(deviceid);
            log.info("Sms Plan Amount--->"+smsPlan.getSmsAmount());
            
            //getrting payment Info
            payment=new Payment();
            payment=billBusinessService.getPaymentInfo(deviceid);
            log.info("Payment Received--->"+payment.getReceivedAmt());
            log.info("Payment Discount--->"+payment.getDiscount());
            log.info("Payment Discount--->"+payment.getCouponDiscount());
            
                    
          
          
        }
        
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

    public List<Long> getList_DeviceId() {
        return list_DeviceId;
    }

    public void setList_DeviceId(List<Long> list_DeviceId) {
        this.setList_DeviceId(list_DeviceId);
    }

    public Plan plan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public String getPlanname() {
        return planname;
    }

    public void setPlanname(String planname) {
        this.planname = planname;
    }

    public float getRental() {
        return rental;
    }

    public void setRental(float rental) {
        this.rental = rental;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    
    
    
}
