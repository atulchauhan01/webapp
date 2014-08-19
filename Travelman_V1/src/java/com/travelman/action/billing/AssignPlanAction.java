
package com.travelman.action.billing;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.billing.BillBusinesService;
import com.travelman.domain.Plan;
import com.travelman.domain.User;
import com.travelman.domain.SmsPlan;
import com.travelman.domain.Device;
import java.util.List;
import java.util.Map;

public class AssignPlanAction extends ActionSupport
{
    private String currentUserName;
    
    private long deviceId;
    private  List<Integer> list;
    private BillBusinesService billBusinessService;
    
     

    private List<Long>deviceIdd;
    private List<String> planName;
    private List<String> smsPlans;
    
    @Override
    public String execute(){
    
        String actionResult="";
        Map<String,Object> session =ActionContext.getContext().getSession();
        User user=(User)session.get("USER");
        setCurrentUserName(user.getFname()+" "+user.getLname());
        
       
        billBusinessService=new BillBusinesService();
        deviceIdd=billBusinessService.getDeviceI(user.getUserId(),user.getUprofile() );
        //deviceIdd=billBusinessService.getDeviceI();
        planName = billBusinessService.getPlanName(user.getUserId(),user.getUprofile());
        smsPlans = billBusinessService.getSmsPlan();
       
      
      
        
        
        if (user.getUprofile() == 1) 
        {
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

   

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    

    public List<String> getPlanName() {
        return planName;
    }

    public void setPlanName(List<String> planName) {
        this.planName = planName;
    }

    public List<String> getSmsPlans() {
        return smsPlans;
    }

    public void setSmsPlans(List<String> smsPlans) {
        this.smsPlans = smsPlans;
    }

    public List<Long> getDeviceIdd() 
    {
        return deviceIdd;
    }

    public void setDeviceIdd(List<Long> deviceIdd) 
    {
        this.setDeviceIdd(deviceIdd);
    }

  
    
}
