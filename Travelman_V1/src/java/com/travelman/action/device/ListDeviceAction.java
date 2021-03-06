package com.travelman.action.device;

import java.util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.device.DeviceBusinesService;
import com.travelman.domain.Device;
import com.travelman.domain.User;

public class ListDeviceAction extends ActionSupport {

	private List<Device> list;

	public List<Device> getList() {
		return list;
	}

	public void setList(List<Device> list) {
		this.list = list;
	}

	private long deviceId;

	private String dtype;

	private String dreg_date;

	private String dprotocol;

	private String diemi;

	private String dsim_num;
	private int userid;
	private int vehicleid;

	private String currentUserName;

	/*
	 * private String downer;
	 * 
	 * private String dfleet_id;
	 * 
	 * private String duser_id;
	 */
	// Business Service
	private DeviceBusinesService deviceBusinesService;

	@Override
	public String execute() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("USER");
		deviceBusinesService = new DeviceBusinesService();

		list = deviceBusinesService.listDevice(user.getUserId(),user.getUprofile());
		String actionResult = "";
		if (list == null) {
			actionResult = "null";
		} else {
			setCurrentUserName(user.getFname() + " " + user.getLname());
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
		}
		return actionResult;

	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public long getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}

	

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public String getDreg_date() {
		return dreg_date;
	}

	public void setDreg_date(String dreg_date) {
		this.dreg_date = dreg_date;
	}

	public String getDprotocol() {
		return dprotocol;
	}

	public void setDprotocol(String dprotocol) {
		this.dprotocol = dprotocol;
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

    /**
     * @return the deviceId
     */
    public long getDeviceId() {
        return deviceId;
    }

    /**
     * @param deviceId the deviceId to set
     */
    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

}
