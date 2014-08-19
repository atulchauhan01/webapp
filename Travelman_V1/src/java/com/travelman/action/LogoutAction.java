/**
 * 
 */
package com.travelman.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author ssingh
 *
 */
public class LogoutAction extends ActionSupport {

	/**
	 *  Invalidate session.
	 */
	public String execute() throws Exception {
		ActionContext.getContext().getSession().clear();
		return SUCCESS;
	}

}