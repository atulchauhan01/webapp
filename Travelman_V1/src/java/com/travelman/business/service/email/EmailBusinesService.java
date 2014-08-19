package com.travelman.business.service.email;

import java.util.ArrayList;
import java.util.List;

import com.travelman.data.service.DataService;
import com.travelman.domain.Email;
import com.travelman.domain.Vehicle;

public class EmailBusinesService {
	
	private DataService dataService; 

	
	

	public void sendEmail(Email email){
		dataService =new DataService();
		dataService.sendEmail(email);
		
	}



	public List<Integer> getVehicleId() {
                dataService =new DataService();
		List<Integer> list = null;
		list=dataService.getVehicleId();
		return list;
	}






}
