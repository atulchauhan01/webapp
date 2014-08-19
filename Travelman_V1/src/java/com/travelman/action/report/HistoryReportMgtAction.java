package com.travelman.action.report;
import java.util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.report.ReportBusinesService;
import com.travelman.domain.User;

public class HistoryReportMgtAction  extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String currentUserName;
	
	public String getCurrentUserName() {
		return currentUserName;
	}

	public void setCurrentUserName(String currentUserName) {
		this.currentUserName = currentUserName;
	}

	private List<String> list;
	
	@Override
	public String execute()
	{
		
	String actionResult = "";
		
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("USER");
		ReportBusinesService reportBusinessService = new ReportBusinesService();
		list = reportBusinessService.getVehicleList(user);
		
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
			actionResult = "input";
		}
		return actionResult;
	}

	public List<String> getList() {
		return list;
	}
}
