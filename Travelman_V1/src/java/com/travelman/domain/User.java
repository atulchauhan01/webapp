package com.travelman.domain;

import java.util.*;

public class User {
	

	
	
	private int userId;
	private int admin_id;
	
	/**
	 * 
	 */
	private String fname;
	/**
	 * 
	 */
	private String lname;
	/**
	 * 
	 */
	private String baddress;
	/**
	 * 
	 */
	private String haddress;
	/**
	 * 
	 */
	private String utype;
	/**
	 * 
	 */
	private String umobile;
	/**
	 * 
	 */
	private String uemail;
	
	/**
	 * 
	 */
	

	/**
	 * 
	 */
	private String password;
	private int uprofile;
	private int ownerid;
	
	private List<TrackData> track_data_list;
	private List<User> user_list; 
	private List<Vehicle> vehicle_list; 
	
	private int active;


	public User()
	{
		vehicle_list = new ArrayList<Vehicle>();
		user_list = new ArrayList<User>();
		track_data_list = new ArrayList<TrackData>();
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getBaddress() {
		return baddress;
	}
	public void setBaddress(String baddress) {
		this.baddress = baddress;
	}
	public String getHaddress() {
		return haddress;
	}
	public void setHaddress(String haddress) {
		this.haddress = haddress;
	}
	public String getUtype() {
		return utype;
	}
	public void setUtype(String utype) {
		this.utype = utype;
	}
	public String getUmobile() {
		return umobile;
	}
	public void setUmobile(String umobile) {
		this.umobile = umobile;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public int getUprofile() {
		return uprofile;
	}
	public void setUprofile(int uprofile) {
		this.uprofile = uprofile;
	}
	public int getOwnerid() {
		return ownerid;
	}
	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}

	/**
	 * @return the vehicle_list
	 */
	public List<Vehicle> getVehicle_list() {
		return vehicle_list;
	}

	/**
	 * @param vehicle_list the vehicle_list to set
	 */
	public void setVehicle_list(List<Vehicle> vehicle_list) {
		this.vehicle_list = vehicle_list;
	}

	/**
	 * @return the user_list
	 */
	public List<User> getUser_list() {
		return user_list;
	}

	/**
	 * @param user_list the user_list to set
	 */
	public void setUser_list(List<User> user_list) {
		this.user_list = user_list;
	}

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public List<TrackData> getTrack_data_list() {
		return track_data_list;
	}

	public void setTrack_data_list(List<TrackData> track_data_list) {
		this.track_data_list = track_data_list;
	}
}
