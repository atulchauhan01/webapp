/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelman.business.service.tracking;
import com.travelman.data.service.DataService;
import com.travelman.domain.User;
import java.util.List;

/**
 *
 * @author Techno Life
 */
public class TrackingBusinessService {
    
private DataService dataService = new DataService();

	public List<String> getVehicleList(User user) {
		return dataService.getVehicleList(user);
		
	}

    
}
