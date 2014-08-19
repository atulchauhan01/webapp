/**
 * 
 */
package com.travelman.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author ssingh
 *
 */
public class EntryAction extends ActionSupport {
	
	private String fname ;
	
	private String lname;
	
	@Override
	public String execute() throws Exception {
		
		
			
			return SUCCESS;
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

}
