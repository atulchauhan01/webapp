package com.travelman.action.sms;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.sms.SmsBusinesService;

import com.travelman.domain.Sms;
import com.travelman.domain.User;


public class SendSmsAction  extends ActionSupport {



	private static final long serialVersionUID = 1L;

	private String mobileno;
    
    private String time;
    
    private String currentUserName;
    
    
 // Business Service
	private SmsBusinesService smsBusinesService;

	

	public String execute(){
		smsBusinesService =new SmsBusinesService();
		Sms sms = new Sms();
		String actionResult = "";
		
		sms.setMobileno(mobileno);
		sms.setTime(time);
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("USER");
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
		smsBusinesService.sendSms(sms);
		return actionResult;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCurrentUserName() {
		return currentUserName;
	}

	public void setCurrentUserName(String currentUserName) {
		this.currentUserName = currentUserName;
	}

}
