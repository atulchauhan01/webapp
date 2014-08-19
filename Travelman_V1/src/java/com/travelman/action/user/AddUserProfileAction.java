package com.travelman.action.user;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.user.UserBusinesService;
import com.travelman.domain.User;

public class AddUserProfileAction extends ActionSupport {

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
	
	private int ownerid;
		
	private int active;

	private int admin_id;

	private String currentUserName;
	// Business Service
	private UserBusinesService userBusinesService;
	
	@Override
	public String execute() {
		String actionResult = "";
		Map<String, Object> session=ActionContext.getContext().getSession();
		User userObj=(User)session.get("USER");
		int id=0;		
		userBusinesService = new UserBusinesService();
		setCurrentUserName(userObj.getFname()+" "+userObj.getLname());
		
		int uprofile = 0;
                if(utype.equals("Group"))
                    uprofile = 2;
                else 
                    if(utype.equals("Individual"))
                        uprofile = 1;
                
		User user = new User();
		id=userBusinesService.getMaxUserId();
		user.setUserId(id);
		user.setFname(fname);
		user.setLname(lname);
		user.setBaddress(baddress);
		user.setHaddress(haddress);
                user.setUtype(utype);
		
		user.setUmobile(umobile);
		user.setUemail(uemail);
		user.setPassword(password);
		user.setUprofile(uprofile);
		user.setOwnerid(userObj.getUserId());
		user.setActive(active);
		user.setAdmin_id(3);
				
		userBusinesService.createUser(user);
	
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

	public int getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getCurrentUserName() {
		return currentUserName;
	}

	public void setCurrentUserName(String currentUserName) {
		this.currentUserName = currentUserName;
	}

}
