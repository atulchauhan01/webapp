package com.travelman.action.vehicle;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.vehicle.VehicleBusinesService;
import com.travelman.data.connection.DBConnection;
import com.travelman.domain.User;

public class AddExistingVehicle extends ActionSupport{
        
        private String currentUserName;
	private long deviceid;
	private long vehicleid;
	private int userid;
	
	public String execute()
	{
		String actionResult = "";
                String str = "";
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user =  (User)session.get("USER");
                setCurrentUserName(user.getFname()+" "+user.getLname());
		if(user!=null)
		{
		 	VehicleBusinesService vehicleBusinessService = new VehicleBusinesService();
		 	
                        str = vehicleBusinessService.addExistingVehicle(vehicleid,userid );
                        System.out.println(str);
                        System.err.println(getVehicleid()+"<---vehicleid");
                        System.err.println(getUserid()+"<---userid");
		 	
                        if(actionResult.equals("input"))
		 		addFieldError("userid", "Invalid User or Vehicle");
		}
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

    public long getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(long deviceid) {
        this.deviceid = deviceid;
    }

    public long getVehicleid() {
        return vehicleid;
    }

    public void setVehicleid(long vehicleid) {
        this.vehicleid = vehicleid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getCurrentUserName() {
        return currentUserName;
    }

    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }
}
