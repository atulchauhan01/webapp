/**
 *
 */
package com.travelman.action;

import java.util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.travelman.data.connection.DBConnection;
import com.travelman.data.service.DataService;
import com.travelman.domain.TrackData;
import com.travelman.domain.User;
import org.apache.log4j.Logger;

/**
 * @author ssingh
 *
 */
public class LoginAction extends ActionSupport implements ModelDriven {
    private Logger log=Logger.getLogger(LoginAction.class);

    private String uemail;
    private String password;
    private User user;
    private String currentUserName;
    private List<TrackData> list;
    private String latitude = "";
    private String longitude = "";

    public String execute() {
        String actionResult = "";

        try {
            DataService dataService = new DataService();

            Map param = ActionContext.getContext().getParameters();
            if (!param.isEmpty()) {
                String[] paramValueArray = null;
                paramValueArray = (String[]) param.get("password");
                password = paramValueArray[0];
                paramValueArray = (String[]) param.get("uemail");
                uemail = paramValueArray[0];
                log.info("In LoginAction : " + uemail + "   " + password);
            }            
            
            // User user = dataService.getUserInfo(getUserId());
            User user = dataService.authenticateUser(uemail, password);
            log.info("user object  ::: "+user);
            //Put User to session.
            Map<String, Object> session = ActionContext.getContext().getSession();
            session.put("USER", user);
            if (user != null) {
                if (user.getActive() != 1) {
                    addFieldError("uemail", "You has been deactivated by your Admin.");
                    actionResult = "incative";
                } else {

                    if (user.getUemail().equalsIgnoreCase(uemail) && user.getPassword().equals(password)) {
                        //valid user.
                        log.info("user profile in Login action -->" + user.getUprofile());
                        setList(dataService.getLiveLocation(user));
                        // setLatitude(TrackData.getLatitudeList());
                        // setLongitude(TrackData.getLongitudeList());

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
                        //actionResult = SUCCESS;
                    } else {
                        log.info("invalid user.");
                        actionResult = INPUT;
                        addFieldError("uemail", "Invalid email ID or password");
                    }
                }
            } else {

                actionResult = INPUT;
                addFieldError("uemail", "Invalid email ID or password");
                log.info("Invalid email ID or password");
            }
        } catch (Exception e) {
            log.info("Exception ::::::::  "+e);
        }
        return actionResult;

    }

    public Object getModel() {

        return new User();
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
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

    public List<TrackData> getList() {
        return list;
    }

    public void setList(List<TrackData> list) {
        this.list = list;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}