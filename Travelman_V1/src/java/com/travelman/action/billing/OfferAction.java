/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelman.action.billing;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.billing.BillBusinesService;
import com.travelman.data.service.DataService;
import com.travelman.domain.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jaikant Bhagwan Das
 */
public class OfferAction extends ActionSupport {

    private String currentUserName;
    BillBusinesService billBusinesService;

    public List<Long> getUser_id_list() {
        return user_id_list;
    }

    public void setUser_id_list(List<Long> user_id_list) {
        this.user_id_list = user_id_list;
    }
    private List<Long> user_id_list;

    public String getCurrentUserName() {
        return currentUserName;
    }

    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }

    @Override
    public String execute() throws Exception {

        String actionResult = "";
        billBusinesService = new BillBusinesService();
        setUser_id_list(billBusinesService.getUserId());

        Map<String, Object> session = ActionContext.getContext().getSession();
        User user = (User) session.get("USER");
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
        return actionResult;
    }
}
