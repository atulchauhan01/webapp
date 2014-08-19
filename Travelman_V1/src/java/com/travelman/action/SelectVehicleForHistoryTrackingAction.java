/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelman.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.tracking.TrackingBusinessService;
import java.util.List;
import java.util.Map;
import com.travelman.domain.User;

/**
 *
 * @author Techno Life
 */
public class SelectVehicleForHistoryTrackingAction extends ActionSupport
{
 
    private List<String> list;
    
    private String startDate;
    
    private String endDate;
    
    private String currentUserName;
    
    public String execute()
	{
		
	String actionResult = "";
		
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("USER");
		TrackingBusinessService trackingBusinessService = new TrackingBusinessService();
		list = trackingBusinessService.getVehicleList(user);
		
		if(list != null)
		{
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
		}
		else
		{
                        addFieldError("uemail","Session Expired");
			actionResult = "input";
		}
		return actionResult;
	}

    /**
     * @return the list
     */
    public List<String> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<String> list) {
        this.list = list;
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
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
    
    
    
}    
