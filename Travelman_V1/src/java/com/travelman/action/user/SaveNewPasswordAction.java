/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelman.action.user;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.user.UserBusinesService;
import com.travelman.domain.User;
import java.util.Map;

/**
 *
 * @author technolife
 */
public class SaveNewPasswordAction extends ActionSupport {

    private String currentUserName;
    private String password;
    private String newPassword;

    @Override
    public String execute() {
        String actionResult = "";
        Map<String, Object> session = ActionContext.getContext().getSession();
        User user = (User) session.get("USER");
        setCurrentUserName(user.getFname() + " " + user.getLname());

        UserBusinesService userBusinesService = new UserBusinesService();
        actionResult = userBusinesService.updatePassword(user.getUserId(), password, newPassword);

        if (actionResult.equalsIgnoreCase("updated")) {
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
            if(actionResult.equalsIgnoreCase("psdInput"))  {
                System.out.println("ActionResult--->"+actionResult);
                addFieldError("newPassword", "Please insert correct password. ");   
                if(user.getUprofile()==3){
                actionResult="inputAdmin";
                }else{
                if(user.getUprofile()==2){
                    actionResult="inputGroup";
                }else{
                actionResult="inputIndividual";
                }
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

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the newPassword
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * @param newPassword the newPassword to set
     */
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
