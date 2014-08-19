package com.travelman.business.service.report;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import com.travelman.data.service.DataService;
import com.travelman.domain.Report;
import com.travelman.domain.User;

public class ReportBusinesService {
	
	private DataService dataService = new DataService();

	public List<String> getVehicleList(User user) {
		return dataService.getVehicleList(user);
		
	}

	public List<Report> createTrip(User user, String startDate,
			 String endDate,String vregistration_num) {
		return dataService.createTrip(user,startDate,endDate,vregistration_num);
		
	}

	public List<Report> createStoppage(User user, String startDate , String endDate,
			String vregistration_num) {
		
		return dataService.createStoppage(user,startDate,endDate,vregistration_num);
	}

	public List<Report> createIdealTime(User user, String startDate,
		 String endDate,
			String vregistration_num) {
		
		return dataService.createIdealTime(user,startDate,endDate,vregistration_num);
	}

	public List<Report> createHistory(User user, String startDate,
			String endDate,
			String vregistration_num) {
		
		return dataService.createHistory(user,startDate,endDate,vregistration_num);
	}

        public List<Report> createOverSpeed(User user, String startDate, String endDate, String vregistration_num, int overSpeed) {
        return dataService.createOverSpeed(user, startDate, endDate, vregistration_num, overSpeed);
        }
	
}
