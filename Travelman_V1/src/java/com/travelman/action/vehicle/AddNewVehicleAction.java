package com.travelman.action.vehicle;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.vehicle.VehicleBusinesService;
import com.travelman.domain.User;

import java.util.*;

public class AddNewVehicleAction extends ActionSupport {

    private String currentUserName;
    private long userid;
    private List<Long> list;
	
    private VehicleBusinesService vehicleBusinessService = new VehicleBusinesService();

    public String execute() {
        String actionResult = "";
        Map<String, Object> session = ActionContext.getContext().getSession();
        User user = (User) session.get("USER");
        
        userid=user.getUserId();
        
        setList(vehicleBusinessService.getDeviceId(userid,user.getUprofile()));      
        
        
        
        if (user != null) {
            setCurrentUserName(user.getFname() + " " + user.getLname() + " [G]");
            if (user.getUprofile() == 1) {
                actionResult = "individual";
                setCurrentUserName(getCurrentUserName() + " [I]");

            } else {
                if (user.getUprofile() == 2) {
                    actionResult = "group";
                    setCurrentUserName(getCurrentUserName() + " [G]");
                } else {
                    if (user.getUprofile() == 3) {
                        actionResult = "admin";
                        setCurrentUserName(getCurrentUserName() + " [A]");
                    }
                }
            }
        } else {
            actionResult = "input";
        }
        return actionResult;
    }

    public String getCurrentUserName() {
        return currentUserName;
    }

    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }

    /**
     * @return the userid
     */
    public long getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(long userid) {
        this.userid = userid;
    }

    public List<Long> getList() {
        return list;
    }

    public void setList(List<Long> list) {
        this.list = list;
    }
}
