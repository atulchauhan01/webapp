/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelman.action.device;

/**
 *
 * @author techno life
 */

import java.util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.data.service.DataService;
import com.travelman.domain.*;


public class EditMgtDeviceAction extends ActionSupport{
    
    private String currentUserName;
        
        private List<Long> list;

	@Override
	public String execute()
        {
		String actionResult = "";
		
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("USER");
		setCurrentUserName(user.getFname()+" "+user.getLname());
                
                list = new DataService().getDeviceIdForDevice(user.getUserId(),user.getUprofile());
                
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
				}else{
                                  actionResult = "input";
                                }
			}
		}
		return actionResult;
	}

    public String getCurrentUserName() {
        return currentUserName;
    }

    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }

    public List<Long> getList() {
        return list;
    }

    public void setList(List<Long> list) {
        this.list = list;
    }
    
}
