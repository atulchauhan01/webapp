package com.travelman.business.service.device;

import java.util.List;

import com.travelman.data.service.DataService;
import com.travelman.domain.Device;
import com.travelman.domain.User;

public class DeviceBusinesService {

    private DataService dataService = new DataService();

    public int getMaxIdVehicle() {
        return dataService.getMaxIdVehicle();
    }

    public String selectDeviceForEdit(long deviceid, Device device) {
        return dataService.selectDeviceForEdit(deviceid, device);
    }

  // public String getDeviceIDList(User user) {

    //    return dataService.getDeviceIDList(user);
    //}

    public String createDevice(Device device) {

        return dataService.createDevice(device);
    }

    public String validateDevice(String dsim_num, long deviceid, int userid, User user) {
        return dataService.validateDevice(dsim_num, deviceid, userid, user);
    }

    public int getMaxIdDevice() {
        int id = 0;
        id = dataService.getMaxIdDevice();
        return id;
    }

    public String updateDevice(Device device) {
        
       return  dataService.updateDevice(device);
       
    }

    public String removeDevice(long deviceid) {
       return dataService.removeDevice(deviceid);
    }

    public void editDevice(Device device) {
        dataService.editDevice(device);
    }

    public List<Device> listDevice(int userid,int uprofile) {
        List<Device> list = null;
        list = dataService.listDevice(userid,uprofile);
        return list;
    }

    public List<Device> detailDeleteDevice(long deviceId) {
         List<Device> list = null;
        list = dataService.detailDeleteDevice(deviceId);
        return list;
    }
}
