package com.travelman.action.device;

import java.util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.device.DeviceBusinesService;
import com.travelman.data.service.DataService;
import com.travelman.domain.User;
import com.travelman.domain.Device;


public class EditDeviceAction extends ActionSupport{
	 
    private long deviceid;
    private int userid;
    private String dtype;
    private String diemi;
    private String dsim_num;
    private String currentUserName;
    
    private List<Integer> list;
  

    @Override
    public String execute(){
        String actionResult = "";
       try{ 

        Map<String, Object> session = ActionContext.getContext().getSession();
        User user = (User) session.get("USER");

        

        DeviceBusinesService deviceBusinessService = new DeviceBusinesService();
//        String str = deviceBusinessService.validateDevice(dsim_num, deviceid, userid, user);
//           System.out.println("going with validation"+str);
//        if(str.equals("sim"))
//        {
//           addFieldError("dsim_num", "SIM already in used.");
//           actionResult = "input"; 
//        }else{
//               if(str.equals("ok")){
                 // Now , insert.
                 String str="";
                   Device device = new Device();
                   
                   device.setUserid(userid);
                   device.setDeviceId(deviceid);
                   device.setDtype(dtype);
                   device.setDiemi(diemi);
                   device.setDsim_num(dsim_num);
                   str = deviceBusinessService.updateDevice(device);
                   if(str.equals("success")){
                      //addFieldError("deviceid", "Successfully Added");
                      actionResult = "success";
                   }else{
                     if(str.equals("SQLException")){
                       actionResult ="SQLException";
                     }
                   }
     //  }
      //     }
        
        System.out.println("Going with ......... "+actionResult);
       }catch(Exception e){
         System.out.println("Ye bat hai "+e);
       }
        return actionResult;
    }

    public long getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(long deviceid) {
        this.deviceid = deviceid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public String getDiemi() {
        return diemi;
    }

    public void setDiemi(String diemi) {
        this.diemi = diemi;
    }

    public String getDsim_num() {
        return dsim_num;
    }

    public void setDsim_num(String dsim_num) {
        this.dsim_num = dsim_num;
    }

    public String getCurrentUserName() {
        return currentUserName;
    }

    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}