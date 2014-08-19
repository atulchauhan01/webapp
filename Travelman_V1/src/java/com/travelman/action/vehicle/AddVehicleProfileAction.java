package com.travelman.action.vehicle;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.vehicle.VehicleBusinesService;
import com.travelman.domain.User;
import com.travelman.domain.Vehicle;
import java.util.Date;

public class AddVehicleProfileAction extends ActionSupport{
	private long vehicleId;
	private String vn;
	private String registration_date;
	private String vmake;
	private String vmodel;
	private String vfuel_type;
	private long fleet;
	private long userid;
	private long deviceid;
	private String currentUserName;
	
	private VehicleBusinesService vehicleBusinesService = new VehicleBusinesService();

	
	@Override

	public String execute() {
		String actionResult = "";
		  Map<String,Object> session = ActionContext.getContext().getSession();
		  User user = (User)session.get("USER");
		  if(user != null)
		  {
		     setCurrentUserName(user.getFname()+" "+user.getLname()+" [G]");
		     Vehicle vehicle = new Vehicle();
                     int id=0;
                     id=getVehicleBusinesService().getMaxVehicleId();
                     
                          vehicle.setVehicleId(id);                        
			  vehicle.setVn(vn);
			  vehicle.setRegistration_date(new Date().toLocaleString());
			  vehicle.setVmake(getVmake());
			  vehicle.setVmodel(getVmodel());
			  vehicle.setVfuel_type(getVfuel_type());
			  vehicle.setFleet(0);
			  vehicle.setUserid(0);
                          vehicle.setDeviceid(getDeviceid());
                          vehicle.setActive(1);
                          System.out.println(getDeviceid()+"!!!!!!!!!!!!!!!!!!!!!");
                          System.out.println(getVn()+"vvvvvvvvvvv!!!!!!!!!!!!!!!!!!!!!");
			  getVehicleBusinesService().createVehicle(vehicle);
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

    /**
     * @return the vRegistrationNum
     */
    public String getVn() {
        return vn;
    }

    /**
     * @param vRegistrationNum the vRegistrationNum to set
     */
    public void setVn(String vn) {
        this.vn = vn;
    }

    /**
     * @return the registration_date
     */
    public String getRegistration_date() {
        return registration_date;
    }

    /**
     * @param registration_date the registration_date to set
     */
    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }

    /**
     * @return the vmake
     */
    public String getVmake() {
        return vmake;
    }

    /**
     * @param vmake the vmake to set
     */
    public void setVmake(String vmake) {
        this.vmake = vmake;
    }

    /**
     * @return the vmodel
     */
    public String getVmodel() {
        return vmodel;
    }

    /**
     * @param vmodel the vmodel to set
     */
    public void setVmodel(String vmodel) {
        this.vmodel = vmodel;
    }

    /**
     * @return the vfuel_type
     */
    public String getVfuel_type() {
        return vfuel_type;
    }

    /**
     * @param vfuel_type the vfuel_type to set
     */
    public void setVfuel_type(String vfuel_type) {
        this.vfuel_type = vfuel_type;
    }

    /**
     * @return the fleet
     */
    public long getFleet() {
        return fleet;
    }

    /**
     * @param fleet the fleet to set
     */
    public void setFleet(long fleet) {
        this.fleet = fleet;
    }

    /**
     * @return the userid
     */
    public long getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(long userid) {
        this.userid = userid;
    }

    /**
     * @return the deviceid
     */
    public long getDeviceid() {
        return deviceid;
    }

    /**
     * @param deviceid the deviceid to set
     */
    public void setDeviceid(long deviceid) {
        this.deviceid = deviceid;
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

    /**
     * @return the vehicleBusinesService
     */
    public VehicleBusinesService getVehicleBusinesService() {
        return vehicleBusinesService;
    }

    /**
     * @param vehicleBusinesService the vehicleBusinesService to set
     */
    public void setVehicleBusinesService(VehicleBusinesService vehicleBusinesService) {
        this.vehicleBusinesService = vehicleBusinesService;
    }

    
	
}



