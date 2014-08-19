
package com.travelman.action.billing;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.billing.BillBusinesService;
import com.travelman.domain.User;
import java.util.List;
import java.util.Map;


public class PaymentMgtAction extends ActionSupport{
    
    private String currentUserName;
    private  List<String> list;
    private BillBusinesService billBusinessService;
    @Override
    public String execute(){
    
        String actionResult="";
        Map<String,Object> session =ActionContext.getContext().getSession();
        User user=(User)session.get("USER");
        setCurrentUserName(user.getFname()+" "+user.getLname());
        
        billBusinessService=new BillBusinesService();
        list=billBusinessService.getUserId(user.getUserId());
        
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

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
    
}
