package com.travelman.action.user;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.action.LoginAction;
import com.travelman.business.service.user.UserBusinesService;
import com.travelman.domain.User;
import org.apache.log4j.Logger;

public class SaveEditUserAction extends ActionSupport {
    private Logger log=Logger.getLogger(SaveEditUserAction.class);

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
	private String baddress;
	/**
	 * 
	 */
	private String haddress;
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
		
	private String password;
	
	private int uprofile;
	
	
		
	private int active;

	

	private String currentUserName;
	// Business Service
	private UserBusinesService userBusinesService;
	
	@Override
	public String execute() {
		String actionResult = "";
		Map<String, Object> session=ActionContext.getContext().getSession();
		User userObj=(User)session.get("USER");
		if((utype.trim()).equalsIgnoreCase("ADMIN"))
                    uprofile = 3;
                else
                if((utype.trim()).equalsIgnoreCase("Group"))
                    uprofile = 2;
                else
                    if((utype.trim()).equalsIgnoreCase("Individual"))
                        uprofile = 1;
		userBusinesService = new UserBusinesService();
		setCurrentUserName(userObj.getFname()+" "+userObj.getLname());
		int userId_Owner = userObj.getUserId();
		
		User user = new User();
		
		user.setUserId(userId);
		user.setFname(fname);
		user.setLname(lname);
		user.setBaddress(baddress);
		user.setHaddress(haddress);
		user.setUemail(uemail);
		user.setUmobile(umobile);
		user.setUtype(utype);
		user.setPassword(password);
                user.setUprofile(uprofile);
		user.setActive(getActive());
		
		log.info(userId+"  userId");		
	           userBusinesService.updateUser(user,userId_Owner);
	
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
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getBaddress() {
		return baddress;
	}

	public void setBaddress(String baddress) {
		this.baddress = baddress;
	}

	public String getHaddress() {
		return haddress;
	}

	public void setHaddress(String haddress) {
		this.haddress = haddress;
	}

	public String getUtype() {
		return utype;
	}

	public void setUtype(String utype) {
		this.utype = utype;
	}

	public String getUmobile() {
		return umobile;
	}

	public void setUmobile(String umobile) {
		this.umobile = umobile;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUprofile() {
		return uprofile;
	}

	public void setUprofile(int uprofile) {
		this.uprofile = uprofile;
	}

	

	public String getCurrentUserName() {
		return currentUserName;
	}

	public void setCurrentUserName(String currentUserName) {
		this.currentUserName = currentUserName;
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

}
