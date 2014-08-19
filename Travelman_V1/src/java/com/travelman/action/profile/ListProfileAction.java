package com.travelman.action.profile;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.profile.ProfileBusinesService;
import com.travelman.domain.Profile;

public class ListProfileAction  extends ActionSupport {

	private List<Profile>  list;

    public List<Profile> getList() {
		return list;
	}

	public void setList(List<Profile> list) {
		this.list = list;
	}

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
		
		profile.setProfileId(profileId);
		profile.setPname(pname);
		profile.setPdiscription(pdiscription);
		
		
		
	list=profileBusinesService.listProfile(profile);
		
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
