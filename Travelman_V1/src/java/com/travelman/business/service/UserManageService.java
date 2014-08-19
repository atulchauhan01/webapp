package com.travelman.business.service;

import java.util.ArrayList;

import com.travelman.data.service.DataService;
import com.travelman.domain.User;


public class UserManageService {
	
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
	public void createUser(User user){
		
		dataService.createUser(user);
		
	}
	
	/**
	 * 
	 */
	
	public void updateUser(){
		
	}
	
	
	/**
	 * 
	 */
	
	public void readUser(){
		
	}
	/**
	 * 
	 */
	
	public void deleteUser(){
		
	}
	
	/**
	 * 
	 */
	
	public void readAllUsers(){
		
	}


}
