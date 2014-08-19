/**
 * 
 */
package com.travelman.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author ssingh
 *
 */
public class FormDataEntryAction extends ActionSupport {
	
	private String fname ;
	
	private String lname;
	
	@Override
	public String execute() throws Exception {
		
		if(getFname().equals("") ||getFname() == null || getLname().equals("") ||getLname() == null )
		{
			return ERROR;
		}else {
			
			return SUCCESS;
		}
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
