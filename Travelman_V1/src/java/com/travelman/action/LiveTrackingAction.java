package com.travelman.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.data.service.DataService;
import com.travelman.domain.TrackData;
import com.travelman.domain.User;
import java.util.Iterator;

public class LiveTrackingAction extends ActionSupport {

    private int vehicleid;
    private User user;
    private String currentUserName;
    private Map<String, Object> session;
    private List<TrackData> list;
    private String latitude = "";
    private String longitude = "";
    private String location = "";
    private String dummyLat = "";
    private String dummyLong = "";

    public String execute() {
        String actionResult = "";
        /**
         *   Getting User Object from Session.
         */
        setSession(ActionContext.getContext().getSession());
        setUser((User) getSession().get("USER"));

        DataService dataService = new DataService();
        setList(dataService.getLiveLocation(getUser()));
        if (getList() != null) {
            //   TrackData trackdata = new TrackData();
            //Iterator<TrackData> trackdata = list().iterator();

            for (int i = 0; i < list.size(); i++) {
                if (dummyLat.equalsIgnoreCase("")) {
                    dummyLat = list.get(i).getLatitudeList();
                } else {
                    dummyLat = dummyLat + ',' + list.get(i).getLatitudeList();
                }
                if (dummyLong.equalsIgnoreCase("")) {
                    dummyLong = list.get(i).getLongitudeList();
                } else {
                    dummyLong = dummyLong + ',' + list.get(i).getLongitudeList();
                }
                
                if (location.equalsIgnoreCase("")) {
                    location = list.get(i).getLocation();
                } else {
                    location = location + ',' + list.get(i).getLocation();
                }
                
            }
            setLatitude(dummyLat);
            setLongitude(dummyLong);

            setCurrentUserName(getUser().getFname() + " " + getUser().getLname());
            if (getUser().getUprofile() == 1) {
                actionResult = "individual";
                setCurrentUserName(getCurrentUserName() + " [I]");
            } else {
                if (getUser().getUprofile() == 2) {
                    actionResult = "group";
                    setCurrentUserName(getCurrentUserName() + " [G]");
                } else {
                    if (getUser().getUprofile() == 3) {
                        actionResult = "admin";
                        setCurrentUserName(getCurrentUserName() + " [A]");
                    }
                }
            }
        } else {
            actionResult = "error";
            addFieldError("uemail", "Invalid User");
        }
        return actionResult;

    }

    public int getVehicleid() {
        return vehicleid;
    }

    public void setVehicleid(int vehicleid) {
        this.vehicleid = vehicleid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCurrentUserName() {
        return currentUserName;
    }

    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
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

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }
}
