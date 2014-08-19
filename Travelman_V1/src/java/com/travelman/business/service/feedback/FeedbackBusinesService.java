package com.travelman.business.service.feedback;


import com.travelman.data.service.DataService;
import com.travelman.domain.Feedback;


public class FeedbackBusinesService {
	
	
		
		
	
		public void sendFeedback(Feedback feedback) {
			DataService dataService = new DataService();
			dataService.sendFeedback(feedback);
		}

}
