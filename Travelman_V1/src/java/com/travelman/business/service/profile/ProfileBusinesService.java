package com.travelman.business.service.profile;

import java.util.List;

import com.travelman.data.service.DataService;
import com.travelman.domain.Profile;


public class ProfileBusinesService {
	
	private DataService dataService; 

	/**
	 * @return the dataService
	 */
	public DataService getDataService() {
		return dataService;
	}

	/**
	 * @param dataService the dataService to set
	 */
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
	
	/**
	 *  1- check if similar user doesn't exist
	 *  2- create new userid unique
	 *  3- create user profile also
	 *  4- send sms after creation
	 *  5- check if user has rights to create user
	 */
	public void createProfile(Profile profile){
		
		dataService.createProfile(profile);
		
	}
	public long getMaxId(){
		long id=0;
		id=dataService.getMaxId();
		return id;
	}
	
	public List<Profile> listProfile(Profile profile) {
		List<Profile> list=null;
		list=dataService.listProfile(profile);
		return list;
	}

}
