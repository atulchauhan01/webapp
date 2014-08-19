package com.travelman.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.travelman.domain.User;

public class HomeAction {
	
	private User user;
	private String currentUserName;
	Map<String,Object> session;
	
	public String execute()
	{
		String actionResult = "";
		session = ActionContext.getContext().getSession();
		user = (User)session.get("USER");
		
		if (user != null) {
			// valid User.

			setCurrentUserName(user.getFname()+" "+user.getLname());
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
		} else {
			// invalid User.
			actionResult = "error";
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
