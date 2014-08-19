package com.travelman.action.profile;

import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.profile.ProfileBusinesService;
import com.travelman.domain.Profile;

public class AddProfileAction  extends ActionSupport {



    private long profileId;
	
	private String pname;
	
	private String pdiscription;
	
	

	// Business Service
	private ProfileBusinesService profileBusinesService;
	
	
	

	public ProfileBusinesService getProfileBusinesService() {
		return profileBusinesService;
	}

	public void setProfileBusinesService(ProfileBusinesService profileBusinesService) {
		this.profileBusinesService = profileBusinesService;
	}

	@Override
	public String execute() throws Exception {
		Profile profile = new Profile();
		long id=0;
		id=profileBusinesService.getMaxId();
		profile.setProfileId(id);
		profile.setPname(pname);
		profile.setPdiscription(pdiscription);
		
		
		
	profileBusinesService.createProfile(profile);
		
		return SUCCESS;
	}

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
