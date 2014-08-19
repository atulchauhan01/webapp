/**
 * 
 */
package com.travelman.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.data.service.DataService;
import com.travelman.domain.User;

/**
 * @author ssingh
 *
 */
public class UserManageAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9020661774132490441L;
	
	/**
	 * 
	 */
	private User user = null;
	
	/**
	 * 
	 */
    private String userId = null;
    
    /**
     * 
     * @return
     */
    public User getUser() {
		return user;
	}

    /**
     * 
     * @param user
     */
	public void setUser(User user) {
		this.user = user;
	}

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 */
    private String password = null;
    
	/**
	 * 
	 */
	public String execute() throws Exception {
		
		DataService dataService = new DataService();
		//User user = dataService.getUserInfo(getUserId());
		ActionContext.getContext().getSession().put("User",	user);
		
		
		System.out.println("Travel Man");
		if((user != null && user.getPassword() != null) && user.getPassword().equals(getPassword())){
		
			
			return SUCCESS;
		}else{
			return INPUT;
		}
		
		

	}

}