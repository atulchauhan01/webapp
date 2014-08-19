
package com.travelman.action.vehicle;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.vehicle.VehicleBusinesService;
import com.travelman.domain.User;
import com.travelman.domain.Vehicle;
import java.util.List;
import java.util.Map;


public class SearchVehicleAction extends ActionSupport{
    
       private String currentUserName;        
        
       private long vehicleId;
       
       	private String vn;
       
       private List<Vehicle> list;
       
       private VehicleBusinesService vehicleBusinessService;
       @Override
    public String execute(){
         String actionResult="";
         Map<String,Object> session =ActionContext.getContext().getSession();
         User user=(User)session.get("USER");
         setCurrentUserName(user.getFname()+" "+user.getLname());
         vehicleBusinessService=new VehicleBusinesService();
         
         setList(vehicleBusinessService.searchVehicle(vn,user.getUserId()));
         
         if (user.getUprofile() == 1) {
			actionResult = "individual";
			setCurrentUserName(getCurrentUserName()+" [I]");
		} else {
			if (user.getUprofile() == 2) {
				actionResult = "group";
				setCurrentUserName(getCurrentUserName()+" [G]");
			} else {
				if (user.getUprofile() == 3) {
					actionResult = "admin";
					setCurrentUserName(getCurrentUserName()+" [A]");
				}
			}
		}
         
           
           
        return actionResult;
    }

    public String getCurrentUserName() {
        return currentUserName;
    }

    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public List<Vehicle> getList() {
        return list;
    }

    public void setList(List<Vehicle> list) {
        this.list = list;
    }

    /**
     * @return the vn
     */
    public String getVn() {
        return vn;
    }

    /**
     * @param vn the vn to set
     */
    public void setVn(String vn) {
        this.vn = vn;
    }

   
}
