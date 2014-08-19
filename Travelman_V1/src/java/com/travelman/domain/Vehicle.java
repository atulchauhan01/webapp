
package com.travelman.domain;

import java.util.Date;

/**
 * 
 * @author ssingh
 *
 */
public class Vehicle {
	
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
	/**
	 * 
	 */
	private Device device;
	/**
	 * 
	 */
	private String vNumber;
	/**
	 * 
	 */
	private String vEngineNum;
	/**
	 * @return the vehicleId
	 */
	public Vehicle()
	{
		device = new Device();
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
     * @return the active
     */
    public int getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(int active) {
        this.active = active;
    }

    /**
     * @return the device
     */
    public Device getDevice() {
        return device;
    }

    /**
     * @param device the device to set
     */
    public void setDevice(Device device) {
        this.device = device;
    }

    /**
     * @return the vNumber
     */
    public String getvNumber() {
        return vNumber;
    }

    /**
     * @param vNumber the vNumber to set
     */
    public void setvNumber(String vNumber) {
        this.vNumber = vNumber;
    }

    /**
     * @return the vEngineNum
     */
    public String getvEngineNum() {
        return vEngineNum;
    }

    /**
     * @param vEngineNum the vEngineNum to set
     */
    public void setvEngineNum(String vEngineNum) {
        this.vEngineNum = vEngineNum;
    }

    /**
     * @return the vn
     */
    public String getVn() {
        return vn;
    }

    /**
     * @param vn the vn to set
     */
    public void setVn(String vn) {
        this.vn = vn;
    }
	
	
}
