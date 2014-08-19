/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelman.action.user;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.domain.User;
import java.util.Map;

/**
 *
 * @author technolife
 */
public class ChangePasswordAction extends ActionSupport {

    private String currentUserName;

    @Override
    public String execute() {
        String actionResult = "";
        Map<String, Object> session = ActionContext.getContext().getSession();
        User user = (User) session.get("USER");

        setCurrentUserName(user.getFname() + " " + user.getLname());

        if (user.getUprofile() == 1) {
            actionResult = "individual";
            setCurrentUserName(getCurrentUserName() + " [I]");
        }else{
        if (user.getUprofile() == 2) {
            actionResult = "group";
            setCurrentUserName(getCurrentUserName() + " [G]");
        }
        else {
            if (user.getUprofile() == 3) {
                actionResult = "admin";
                setCurrentUserName(getCurrentUserName() + " [A]");
            }
        }
        }
        return actionResult;
    }

    /**
     * @return the currentUserName
     */
    public String getCurrentUserName() {
        return currentUserName;
    }

    /**
     * @param currentUserName the currentUserName to set
     */
    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }
}
