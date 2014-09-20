package com.travelman.action.user;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.travelman.action.LoginAction;
import com.travelman.business.service.user.UserBusinesService;
import com.travelman.domain.User;
import java.util.Map;
import org.apache.log4j.Logger;

public class EditUserProfileAction extends ActionSupport implements ModelDriven<User> {
    private Logger log=Logger.getLogger(EditUserProfileAction.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
        private int userId;
        
        private String fname;
	/**
	 * 
	 */
	private String lname;
	
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
        /**
	 * 
	 */
	private String umobile;
	/**
	 * 
	 */
	private String uemail;
	
	/**
	 * 
	 */
	private String password;
        
	private int uprofile;
        
	private int active;
	
        private String currentUserName;
        // Business Service
	private UserBusinesService userBusinesService;
        
        private User user;
	
	@Override
	public String execute() {
		String actionResult = "";
		Map<String, Object> session=ActionContext.getContext().getSession();
		User userObj=(User)session.get("USER");
		
		userBusinesService = new UserBusinesService();
                
		setCurrentUserName(userObj.getFname()+" "+userObj.getLname());
		
                int userId_Owner = userObj.getUserId();
		log.info(userId_Owner+"Owner***************");
		
                log.info(getUserId()+"User@@@@@@@@@@@@@@@");
                
		setUser(userBusinesService.getUser(uemail,userId_Owner));
	
			if (userObj.getUprofile() == 2) {
				actionResult = "group";
				setCurrentUserName(getCurrentUserName()+" [G]");
			} else {
				if (userObj.getUprofile() == 3) {
					actionResult = "admin";
					setCurrentUserName(getCurrentUserName()+" [A]");
				}
			}
		
	
		return actionResult;
	
	}
        
        public User getModel(){
        
            return getUser();
        }
    /**
         * 
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * @return the haddress
     */
    public String getHaddress() {
        return haddress;
    }

    /**
     * @param haddress the haddress to set
     */
    public void setHaddress(String haddress) {
        this.haddress = haddress;
    }

    /**
     * @return the baddress
     */
    public String getBaddress() {
        return baddress;
    }

    /**
     * @param baddress the baddress to set
     */
    public void setBaddress(String baddress) {
        this.baddress = baddress;
    }

    /**
     * @return the utype
     */
    public String getUtype() {
        return utype;
    }

    /**
     * @param utype the utype to set
     */
    public void setUtype(String utype) {
        this.utype = utype;
    }

    /**
     * @return the umobile
     */
    public String getUmobile() {
        return umobile;
    }

    /**
     * @param umobile the umobile to set
     */
    public void setUmobile(String umobile) {
        this.umobile = umobile;
    }

    /**
     * @return the uemail
     */
    public String getUemail() {
        return uemail;
    }

    /**
     * @param uemail the uemail to set
     */
    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the uprofile
     */
    public int getUprofile() {
        return uprofile;
    }

    /**
     * @param uprofile the uprofile to set
     */
    public void setUprofile(int uprofile) {
        this.uprofile = uprofile;
    }

    /**
     * @return the active
     */
    public int getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(int active) {
        this.active = active;
    }

    /**
     * @return the userBusinesService
     */
    public UserBusinesService getUserBusinesService() {
        return userBusinesService;
    }

    /**
     * @param userBusinesService the userBusinesService to set
     */
    public void setUserBusinesService(UserBusinesService userBusinesService) {
        this.userBusinesService = userBusinesService;
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
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

 

}


