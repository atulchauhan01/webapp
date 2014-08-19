/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelman.action.billing;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.billing.BillBusinesService;
import com.travelman.domain.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Techno Life
 */
public class PaymentAction extends ActionSupport{
    
    private String currentUserName;
    private int accNo;
    private long deviceId;
    private  List<Integer> list;
    private BillBusinesService billBusinessService;
    @Override
    public String execute(){
    
        String actionResult="";
        Map<String,Object> session =ActionContext.getContext().getSession();
        User user=(User)session.get("USER");
        setCurrentUserName(user.getFname()+" "+user.getLname());
        
        billBusinessService=new BillBusinesService();
        setList(billBusinessService.getDeviceListPayment(accNo));
        
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

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}