package com.travelman.domain;

public class Profile {
	

	
	private long profileId;
	
	/**
	 * 
	 */
	
	private String pname;
	/**
	 * 
	 */
	private String pdiscription;
	/**
	 * 
	 */
	public long getProfileId() {
		return profileId;
	}

	public void setProfileId(long profileId) {
		this.profileId = profileId;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPdiscription() {
		return pdiscription;
	}

	public void setPdiscription(String pdiscription) {
		this.pdiscription = pdiscription;
	}
	
	
}