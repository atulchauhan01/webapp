/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelman.action.billing;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.billing.BillBusinesService;
import com.travelman.domain.Plan;
import com.travelman.domain.User;
import java.util.List;
import java.util.Map;

    
public class PlanAction extends ActionSupport
{
     private String currentUserName;
     private BillBusinesService billBusinessService;
    private  List<Plan> list;

        public List<Plan> getList() {
            return list;
        }

        public void setList(List<Plan> list)
        {
            this.list = list;
        }
    
    
    
   
    public String execute(){
    
        String actionResult="";
        Map<String,Object> session =ActionContext.getContext().getSession();
        User user=(User)session.get("USER");
        setCurrentUserName(user.getUserId()+" "+user.getUprofile());
        
        billBusinessService=new BillBusinesService();
        setList(billBusinessService.listPlan(user.getUserId(),user.getUprofile() ));
        
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

   

}