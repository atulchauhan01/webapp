/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelman.action.device;

/**
 *
 * @author techno life
 */
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.action.LoginAction;
import com.travelman.business.service.device.DeviceBusinesService;
import com.travelman.domain.*;
import java.util.*;
import org.apache.log4j.Logger;

public class SelectDeviceForEdit extends ActionSupport{
    private Logger log=Logger.getLogger(SelectDeviceForEdit.class);

    private long deviceid;
    private String currentUserName;
    private Device device = new Device();

    public String execute()
    {
        String actionResult = "";
        try{

        Map<String, Object> session = ActionContext.getContext().getSession();
        User user = (User) session.get("USER");

        DeviceBusinesService deviceBusinessService = new DeviceBusinesService();
        log.info(deviceid+"=deviceId********SelectDeviceForEdit");
        String str = deviceBusinessService.selectDeviceForEdit(deviceid, device);

        if(str.equals("ok"))
        {
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
				}else{
                                  actionResult = "input";
                                }
			}
		}
        }else{
          actionResult = str;
        }

        log.info("Going with "+actionResult);
       }catch(Exception e){
         log.info("Ye bat hai "+e);
       }
        return actionResult;
    }

    public long getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(long deviceid) {
        this.deviceid = deviceid;
    }

    public String getCurrentUserName() {
        return currentUserName;
    }

    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

}
