/**
 * 
 */
package com.travelman.action;

import com.opensymphony.xwork2.ActionSupport;
import com.travelman.data.service.DataService;
import com.travelman.domain.User;

/**
 * @author ssingh
 *
 */
public class WelcomeAction extends ActionSupport {

	private String userid;
	private String password;
	
	public String execute() throws Exception {
		
		DataService dataService = new DataService();
		return SUCCESS;//DataService.getUserInfo(userid,password);
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}