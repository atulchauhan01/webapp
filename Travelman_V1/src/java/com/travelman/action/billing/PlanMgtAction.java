
package com.travelman.action.billing;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.billing.BillBusinesService;
import com.travelman.domain.User;
import com.travelman.domain.Plan;
import com.travelman.domain.SmsPlan;
import com.travelman.domain.Device;
import java.util.List;
import java.util.Map;


public class PlanMgtAction extends ActionSupport{
    
    private String currentUserName;
    private  List<Integer> list;
    private  List<Integer> lists;
    
   
    
    private BillBusinesService billBusinessService;
    @Override
    public String execute(){
    
        String actionResult="";
        Map<String,Object> session =ActionContext.getContext().getSession();
        User user=(User)session.get("USER");
        setCurrentUserName(user.getFname()+" "+user.getLname());
        Plan plan = new Plan();
        
        
        billBusinessService=new BillBusinesService();
        list=billBusinessService.getUserIdPlan(user.getUserId());    
        
       
        
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

    public List<Integer> getList()
    {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public List<Integer> getLists() {
        return lists;
    }

    public void setLists(List<Integer> lists) {
        this.lists = lists;
    }
    
    
}
