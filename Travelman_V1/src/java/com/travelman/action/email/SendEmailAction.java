package com.travelman.action.email;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.email.EmailBusinesService;

import com.travelman.domain.Email;
import com.travelman.domain.User;


public class SendEmailAction  extends ActionSupport {



	private static final long serialVersionUID = 1L;

	private String rtype;
	
	private String send_interval;
	
	private String report_for_days;
	
	private String rec_email;
	
	private String send_time;
    
	private int vehicleid;
	private String currentUserName;

	public String getCurrentUserName() {
		return currentUserName;
	}

	public void setCurrentUserName(String currentUserName) {
		this.currentUserName = currentUserName;
	}
 // Business Service
	EmailBusinesService emailBusinesService = new EmailBusinesService();

	

	public String execute()
	{
		String actionResult="";
		Email email = new Email();		
		
		email.setRtype(rtype);
		email.setSend_interval(send_interval);
		email.setReport_for_days(report_for_days);
		email.setRec_email(rec_email);
		email.setSend_time(send_time);
		email.setVehicleid(vehicleid);
		
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
		
		emailBusinesService.sendEmail(email);
		
		return actionResult;
	}

	public String getRtype() {
		return rtype;
	}

	public void setRtype(String rtype) {
		this.rtype = rtype;
	}

	public String getSend_interval() {
		return send_interval;
	}

	public void setSend_interval(String send_interval) {
		this.send_interval = send_interval;
	}

	public String getReport_for_days() {
		return report_for_days;
	}

	public void setReport_for_days(String report_for_days) {
		this.report_for_days = report_for_days;
	}

	public String getRec_email() {
		return rec_email;
	}

	public void setRec_email(String rec_email) {
		this.rec_email = rec_email;
	}

	public String getSend_time() {
		return send_time;
	}

	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}

	public int getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}

	

}
