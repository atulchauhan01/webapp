package com.travelman.action.vehicle;
import java.util.List;
import java.util.Map;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.action.LoginAction;
import com.travelman.business.service.vehicle.VehicleBusinesService;
import com.travelman.domain.User;
import com.travelman.domain.Vehicle;
import org.apache.log4j.Logger;

public class ListVehicleAction extends ActionSupport {
    private Logger log=Logger.getLogger(ListVehicleAction.class);

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
                
                
                log.info(user.getUserId()+">>>>>>>>>>>>>>>>>>>userId");
		for (Vehicle vehicle : list) {
			log.info(vehicle.getVn());
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

