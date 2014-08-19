package com.travelman.business.service.sms;



import com.travelman.data.service.DataService;
import com.travelman.domain.Sms;


public class SmsBusinesService {
	
	private DataService dataService=new DataService();; 

	
	


	public void sendSms(Sms sms){
	
		dataService.sendSms(sms);
		
	}
	
	


}
