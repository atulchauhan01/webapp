package com.travelman.domain;

import java.util.Date;

public class Device {
	
	private long deviceId;
	private String dtype;
	private String dprotocol;
	private String diemi;
	//private String dreg_date;
        private Date dreg_date;
	private String dsim_num;
	private int userid;
	private int vehicleid;
        private int active;
	
	/**
	 * 
	 */
	private String deviceCurrentLocation;
	 /**
	 * 
	 */
	private String deviceSimNum;
	/**
	  * 
	  */
	private String deviceCurrentLon;
	 /**
	  * 
	  */
	private String deviceCurrentLat;

	private TrackData trackdata;
	/**
	 * @return the deviceId
	 */
	
	public Device()
	{
		trackdata = new TrackData();
	}
	
	public long getDeviceId() {
		return deviceId;
	}

	/**
	 * @param deviceId the deviceId to set
	 */
	public void setDeviceId(long deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * @return the deviceSimNum
	 */
	public String getDeviceSimNum() {
		return deviceSimNum;
	}

	/**
	 * @param deviceSimNum the deviceSimNum to set
	 */
	public void setDeviceSimNum(String deviceSimNum) {
		this.deviceSimNum = deviceSimNum;
	}

	/**
	 * @return the deviceCurrentLocation
	 */
	public String getDeviceCurrentLocation() {
		return deviceCurrentLocation;
	}

	/**
	 * @param deviceCurrentLocation the deviceCurrentLocation to set
	 */
	public void setDeviceCurrentLocation(String deviceCurrentLocation) {
		this.deviceCurrentLocation = deviceCurrentLocation;
	}

	/**
	 * @return the deviceCurrentLon
	 */
	public String getDeviceCurrentLon() {
		return deviceCurrentLon;
	}

	/**
	 * @param deviceCurrentLon the deviceCurrentLon to set
	 */
	public void setDeviceCurrentLon(String deviceCurrentLon) {
		this.deviceCurrentLon = deviceCurrentLon;
	}

	/**
	 * @return the deviceCurrentLat
	 */
	public String getDeviceCurrentLat() {
		return deviceCurrentLat;
	}

	/**
	 * @param deviceCurrentLat the deviceCurrentLat to set
	 */
	public void setDeviceCurrentLat(String deviceCurrentLat) {
		this.deviceCurrentLat = deviceCurrentLat;
	}

	/**
	 * @return the trackdata
	 */
	public TrackData getTrackdata() {
		return trackdata;
	}

	/**
	 * @param trackdata the trackdata to set
	 */
	public void setTrackdata(TrackData trackdata) {
		this.trackdata = trackdata;
	}

	/**
	 * @return the dtype
	 */
	public String getDtype() {
		return dtype;
	}

	/**
	 * @param dtype the dtype to set
	 */
	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	/**
	 * @return the dprotocol
	 */
	public String getDprotocol() {
		return dprotocol;
	}

	/**
	 * @param dprotocol the dprotocol to set
	 */
	public void setDprotocol(String dprotocol) {
		this.dprotocol = dprotocol;
	}

	/**
	 * @return the diemi
	 */
	public String getDiemi() {
		return diemi;
	}

	/**
	 * @param diemi the diemi to set
	 */
	public void setDiemi(String diemi) {
		this.diemi = diemi;
	}

	

	/**
	 * @return the dsim_num
	 */
	public String getDsim_num() {
		return dsim_num;
	}

	/**
	 * @param dsimNum the dsim_num to set
	 */
	public void setDsim_num(String dsimNum) {
		dsim_num = dsimNum;
	}

	/**
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}

	/**
	 * @return the vehicleid
	 */
	public int getVehicleid() {
		return vehicleid;
	}

	/**
	 * @param vehicleid the vehicleid to set
	 */
	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}



    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Date getDreg_date() {
        return dreg_date;
    }

    public void setDreg_date(Date dreg_date) {
        this.dreg_date = dreg_date;
    }

}
