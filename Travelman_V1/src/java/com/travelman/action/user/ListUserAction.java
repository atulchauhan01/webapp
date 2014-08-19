
package com.travelman.action.user;

import com.opensymphony.xwork2.ActionContext;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.user.UserBusinesService;
import com.travelman.domain.User;
import java.util.Map;


public class ListUserAction extends ActionSupport {

	
	private List<User>  list;
	
         public List<User> getList() {
		return list;
            }
		
		public void setList(List<User> list) {
			this.list = list;
		}
	private static final long serialVersionUID = 1L;
        
        private int userId;
        
	private String fname;
	/**
	 * 
	 */
	private String lname;
	/**
	 * 
	 */
	private String uemail;
	/**
	 * 
	 */
	private String umobile;
	/**
	 * 
	 */
	private String haddress;
	/**
	 * 
	 */
	private String baddress;
	/**
	 * 
	 */
	private String utype;
        
        private int active;
        
        private String currentUserName;

	// Business Service
	private UserBusinesService userBusinesService;

	
	@Override
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User userObj = (User) session.get("USER");
                
                
                userBusinesService = new UserBusinesService();
		
                list=userBusinesService.listViewUser(userObj.getUprofile(),userObj.getUserId());
                
                String actionResult = "";
		if (list == null) {
			actionResult = "null";
		} else {
			setCurrentUserName(userObj.getFname() + " " + userObj.getLname());
			if (userObj.getUprofile() == 2) {
					actionResult = "group";
					setCurrentUserName(getCurrentUserName() + " [G]");
				} else {
					if (userObj.getUprofile() == 3) {
						actionResult = "admin";
						setCurrentUserName(getCurrentUserName() + " [A]");
					}
				}
			}
		
		return actionResult;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUmobile() {
		return umobile;
	}

	public void setUmobile(String umobile) {
		this.umobile = umobile;
	}

	public String getHaddress() {
		return haddress;
	}

	public void setHaddress(String haddress) {
		this.haddress = haddress;
	}

	public String getBaddress() {
		return baddress;
	}

	public void setBaddress(String baddress) {
		this.baddress = baddress;
	}

	public String getUtype() {
		return utype;
	}

	public void setUtype(String utype) {
		this.utype = utype;
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

    /**
     * @return the currentUserName
     */
    public String getCurrentUserName() {
        return currentUserName;
    }

    /**
     * @param currentUserName the currentUserName to set
     */
    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
