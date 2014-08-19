package com.travelman.action.vehicle;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import com.travelman.business.service.vehicle.VehicleBusinesService;
import com.travelman.domain.User;
import com.travelman.domain.Vehicle;
import java.util.Map;


public class EditVehicleDataAction extends ActionSupport implements ModelDriven<Vehicle> {
   private static final long serialVersionUID = 1L;
            
        private long vehicleId;	
	private String vn;
	private String registration_date;
	private String vmake;
	private String vmodel;
	private String vfuel_type;
	private long fleet;
	private long userid;
	private long deviceid;
        private int active;
        private String currentUserName;
   
        private Vehicle vehicle;
        // Business Service
	private VehicleBusinesService vehicleBusinesService = new VehicleBusinesService();      
	
	@Override
	public String execute()  {
		String actionResult = "";
		Map<String, Object> session=ActionContext.getContext().getSession();
		User userObj=(User)session.get("USER");		
                
		setCurrentUserName(userObj.getFname()+" "+userObj.getLname());		                
                                
		vehicle=vehicleBusinesService.getVehicle(vehicleId);
                
			if (userObj.getUprofile() == 2) {
				actionResult = "group";
				setCurrentUserName(getCurrentUserName()+" [G]");
			} else {
				if (userObj.getUprofile() == 3) {
					actionResult = "admin";
					setCurrentUserName(getCurrentUserName()+" [A]");
				}
			}
		
	
		return actionResult;
	
	}
        @Override
         public Vehicle getModel(){
        
            return getVehicle();
        }
        
    public String getCurrentUserName() {
        return currentUserName;
    }

    /**
     * @param currentUserName the currentUserName to set
     */
    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }

    /**
     * @return the vehicle
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * @param vehicle the vehicle to set
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * @return the vehicleId
     */
    public long getVehicleId() {
        return vehicleId;
    }

    /**
     * @param vehicleId the vehicleId to set
     */
    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVn() {
        return vn;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }

    public String getVmake() {
        return vmake;
    }

    public void setVmake(String vmake) {
        this.vmake = vmake;
    }

    public String getVmodel() {
        return vmodel;
    }

    public void setVmodel(String vmodel) {
        this.vmodel = vmodel;
    }

    public String getVfuel_type() {
        return vfuel_type;
    }

    public void setVfuel_type(String vfuel_type) {
        this.vfuel_type = vfuel_type;
    }

    public long getFleet() {
        return fleet;
    }

    public void setFleet(long fleet) {
        this.fleet = fleet;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public long getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(long deviceid) {
        this.deviceid = deviceid;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    
}
