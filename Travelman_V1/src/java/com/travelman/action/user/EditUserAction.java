package com.travelman.action.user;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.user.UserBusinesService;
import com.travelman.domain.User;
import java.util.List;

public class EditUserAction  extends ActionSupport {

	private String currentUserName;
	
        private int userId;

	private List<String> list;


	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
        
	@Override
	public String execute() {
		String actionResult = "";
		UserBusinesService userBusinesService = new UserBusinesService();
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("USER");
                
                
		userId = user.getUserId();
                list=userBusinesService.getUserId(userId,user.getUprofile());
                
                
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
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getCurrentUserName() {
		return currentUserName;
	}


	public void setCurrentUserName(String currentUserName) {
		this.currentUserName = currentUserName;
	}

}
