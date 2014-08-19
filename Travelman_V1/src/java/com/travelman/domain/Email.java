package com.travelman.domain;

public class Email {
	

	
	private String rtype;
	
	private String send_interval;

	private String report_for_days;

	private String rec_email;
	
	private String send_time;
	
	private int vehicleid;
	
	public String getRtype() {
		return rtype;
	}

	public void setRtype(String rtype) {
		this.rtype = rtype;
	}

	public String getSend_interval() {
		return send_interval;
	}

	public void setSend_interval(String send_interval) {
		this.send_interval = send_interval;
	}

	public String getReport_for_days() {
		return report_for_days;
	}

	public void setReport_for_days(String report_for_days) {
		this.report_for_days = report_for_days;
	}

	public String getRec_email() {
		return rec_email;
	}

	public void setRec_email(String rec_email) {
		this.rec_email = rec_email;
	}

	public String getSend_time() {
		return send_time;
	}

	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}

	public int getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}

	
	
	
}