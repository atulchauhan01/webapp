package com.travelman.business.service.vehicle;

/**
 * 
 */

import java.util.Date;
import java.util.List;
import com.travelman.data.service.DataService;
import com.travelman.domain.User;
import com.travelman.domain.Vehicle;

/**
 * @author
 * 
 */
public class VehicleBusinesService {

	/**
	 * 
	 */
	private DataService dataService = new DataService();

	
	public List<Vehicle> listVehicle(int userid,int uprofile) {
		List<Vehicle> list=null;
		list=dataService.listVehicle(userid,uprofile);
		return list;
	}
	
	public List<String> listUsers(int userid)
	{
		return dataService.listUser(userid);
	}
	
	public String addExistingVehicle(long vehicleid, int userid) {
		return dataService.addExistingVehicle(vehicleid ,userid);
	}

    public List<Long> getDeviceId(long userid,int uprofile) {
       List<Long> list=null;
		list=dataService.getDeviceId(userid,uprofile);
		return list;
    }

    public int getMaxVehicleId() {
        int id=dataService.getMaxVehicleId();
        return id;
    }

    public void createVehicle(Vehicle vehicle) {
        dataService.createVehicle(vehicle);
    }

    public List<Integer> getUserIdList(int userId,int uprofile) {
       List<Integer> list=null;
		list=dataService.getUserIdList(userId,uprofile);
		return list;
    }

    public List<Integer> VehicleIdList(int userId,int uprofile) {
        List<Integer> list=null;
		list=dataService.getVehicleIdList(userId,uprofile);
		return list;
    }

    public Vehicle getVehicle(long vehicleId) {
    Vehicle vehicle=dataService.getVehicle(vehicleId);
    return vehicle;
    }

    public String validateDeviceInVehicle(long deviceid, long vehicleId) {
        return dataService.validateDeviceInVehicle(deviceid,vehicleId);
    }
    
    public String updateVehicle(Vehicle vehicle) {
       return dataService.updateVehicle(vehicle);
    }

    public void deleteVehicle(long vehicleId) {
        dataService.deleteVehicle(vehicleId);
    }

    public List<Vehicle> searchVehicle(String vn, int userId) {
        List<Vehicle> list=null;
        list=dataService.searchVehicle(vn,userId);
        return list;
    }

    

    
}