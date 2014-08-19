package com.travelman.action.user;

import java.util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.domain.User;

public class AddUserAction  extends ActionSupport {

	private String currentUserName;
        
        private List<String> user_Type_list;
	  

	public String getCurrentUserName() {
		return currentUserName;
	}


	public void setCurrentUserName(String currentUserName) {
		this.currentUserName = currentUserName;
	}


	@Override
	public String execute() throws Exception {
		String actionResult = "";
		setUser_Type_list(new ArrayList<String>());
                getUser_Type_list().add("Group");
                getUser_Type_list().add("Individual");
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("USER");
		setCurrentUserName(user.getFname()+" "+user.getLname());
		
			if (user.getUprofile() == 2) {
				actionResult = "group";
				setCurrentUserName(getCurrentUserName()+" [G]");
			} else {
				if (user.getUprofile() == 3) {
					actionResult = "admin";
					setCurrentUserName(getCurrentUserName()+" [A]");
				}
			}
		
		return actionResult;
	}

    /**
     * @return the user_Type_list
     */
    public List<String> getUser_Type_list() {
        return user_Type_list;
    }

    /**
     * @param user_Type_list the user_Type_list to set
     */
    public void setUser_Type_list(List<String> user_Type_list) {
        this.user_Type_list = user_Type_list;
    }
}
