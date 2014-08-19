
package com.travelman.action.billing;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.billing.BillBusinesService;
import com.travelman.domain.User;
import com.travelman.domain.Device;
import com.travelman.domain.Plan;
import com.travelman.domain.Sms;
import com.travelman.domain.SmsPlan;
import java.util.List;
import java.util.Map;

public class AssignPlanSave extends ActionSupport
{
     private String currentUserName;
    private  List<Integer> list;
    private BillBusinesService billBusinessService;
    
    
    private long deviceId;
    private String planName;
    private String smsPlan;
    
    //Device device = new Device();
    //Plan plan = new Plan();
    //SmsPlan smsPlans = new SmsPlan();
    
    
    @Override
    public String execute()
    {
    
        String actionResult="";
        Map<String,Object> session =ActionContext.getContext().getSession();
        User user=(User)session.get("USER");
        setCurrentUserName(user.getFname()+" "+user.getLname());
        
        billBusinessService=new BillBusinesService();
        //list=billBusinessService.getUserId(user.getUserId());
        
        if (user.getUprofile() == 1) {
			actionResult = "individual";
			setCurrentUserName(getCurrentUserName()+" [I]");
		} else 
        {
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
        
       // device.setDeviceId(deviceId);
        //plan.setPlanname(planName);
        //smsPlans.setSmsPlan(smsPlan);
        
        billBusinessService.assignPlan(deviceId, planName, smsPlan);       
        
        
		return actionResult;       
    }

    public String getCurrentUserName() {
        return currentUserName;
    }

    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getSmsPlan() {
        return smsPlan;
    }

    public void setSmsPlan(String smsPlan) {
        this.smsPlan = smsPlan;
    }
    
    
    
}
