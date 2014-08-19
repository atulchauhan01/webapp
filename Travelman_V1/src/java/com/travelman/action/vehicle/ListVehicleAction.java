package com.travelman.action.vehicle;
import java.util.List;
import java.util.Map;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.vehicle.VehicleBusinesService;
import com.travelman.domain.User;
import com.travelman.domain.Vehicle;

public class ListVehicleAction extends ActionSupport {

	private List<Vehicle> list;
	private String currentUserName;
        
        
	

	// Business Service
	private VehicleBusinesService vehicleBusinesService = new VehicleBusinesService();

	@Override
	public String execute()
	{
		Map<String,Object> session = ActionContext.getContext().getSession();
		User  user = (User)session.get("USER");
		list = vehicleBusinesService.listVehicle(user.getUserId(),user.getUprofile());
                
                
                System.out.println(user.getUserId()+">>>>>>>>>>>>>>>>>>>userId");
		for (Vehicle vehicle : list) {
			System.out.println(vehicle.getVn());
		}
		currentUserName=user.getFname()+" "+user.getLname()+" [G]";
		return "group";
	}

	public List<Vehicle> getList() {
		return list;
	}

	public String getCurrentUserName() {
		return currentUserName;
	}

    /**
     * @param list the list to set
     */
    public void setList(List<Vehicle> list) {
        this.list = list;
    }

 
}

