package com.travelman.action.vehicle;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.vehicle.VehicleBusinesService;
import com.travelman.domain.User;
import java.util.List;

public class EditVehicleListAction  extends ActionSupport {


	private String currentUserName;
        
        
        private List<Integer> list_vehicleid;

	public String getCurrentUserName() {
		return currentUserName;
	}

	public void setCurrentUserName(String currentUserName) {
		this.currentUserName = currentUserName;
	}
        private VehicleBusinesService vehicleBusinessService = new VehicleBusinesService();
	@Override
	public String execute() {
String actionResult = "";
		
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("USER");
		setCurrentUserName(user.getFname()+" "+user.getLname());
                
                                            
               list_vehicleid=vehicleBusinessService.VehicleIdList(user.getUserId(),user.getUprofile());
		
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
		return actionResult;
	}

    
    public List<Integer> getList_vehicleid() {
        return list_vehicleid;
    }

   
    public void setList_vehicleid(List<Integer> list_vehicleid) {
        this.list_vehicleid = list_vehicleid;
    }

		
}
