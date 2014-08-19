package com.travelman.action.device;

import java.util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.data.service.DataService;
import com.travelman.domain.User;


public class AddDevProfileAction  extends ActionSupport {

	private String currentUserName;
        
        //private List<String> list_of_users;
        
        private List<Integer> list;

	@Override
	public String execute()
        {
		String actionResult = "";
		
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("USER");
		setCurrentUserName(user.getFname()+" "+user.getLname());
                
                list = new DataService().getUseSubUserList(user.getUserId(),user.getUprofile());
                
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

    /**
     * @return the list_of_users
     */
    public List<Integer> getList() {
        return list;
    }

    /**
     * @param list_of_users the list_of_users to set
     */
    public void setList(List<Integer> list) {
        this.list = list;
    }
    
    public String getCurrentUserName() {
		return currentUserName;
	}


	public void setCurrentUserName(String currentUserName) {
		this.currentUserName = currentUserName;
	}

    
}
