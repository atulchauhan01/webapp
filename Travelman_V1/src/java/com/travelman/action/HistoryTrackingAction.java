package com.travelman.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.data.service.DataService;
import com.travelman.domain.TrackData;
import com.travelman.domain.User;

public class HistoryTrackingAction extends ActionSupport {

    private User user;
    private Map<String, Object> session;
    private String currentUserName;
    private List<TrackData> list;
    private String vregisteration_num;
    private String startDate;
    private String endDate;
    private String latitude = "";
    private String longitude = "";
    private String location = "";
    private String dummyLat = "";
    private String dummyLong = "";

    public String execute() {
        String actionResult = "";
        session = ActionContext.getContext().getSession();
        user = (User) session.get("USER");
        list = (new DataService()).getHistoryLocations(startDate, endDate, vregisteration_num);
        if (list != null) {

            // latitude = TrackData.getLatitudeList();
            //  longitude = TrackData.getLongitudeList();

            for (int i = 0; i < list.size(); i++) {
                if (getDummyLat().equalsIgnoreCase("")) {
                    setDummyLat(list.get(i).getLatitudeList());
                } else {
                    setDummyLat(getDummyLat() + ',' + list.get(i).getLatitudeList());
                }
                if (dummyLong.equalsIgnoreCase("")) {
                    dummyLong = list.get(i).getLongitudeList();
                } else {
                    dummyLong = dummyLong + ',' + list.get(i).getLongitudeList();
                }
                
                 if (location.equalsIgnoreCase("")) {
                    location = list.get(i).getLocation();
                } else {
                    location =location+'^'+list.get(i).getLocation();
                }

            }
            setLatitude(dummyLat);
            setLongitude(dummyLong);

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
        } else {
            actionResult = "error";
        }
        return actionResult;
    }

    public String getCurrentUserName() {
        return currentUserName;
    }

    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }

    /**
     * @return the list
     */
    public List<TrackData> getList() {
        return list;
    }

    /**
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @return the longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the vregisteration_num
     */
    public String getVregisteration_num() {
        return vregisteration_num;
    }

    /**
     * @param vregisteration_num the vregisteration_num to set
     */
    public void setVregisteration_num(String vregisteration_num) {
        this.vregisteration_num = vregisteration_num;
    }

    public String getDummyLat() {
        return dummyLat;
    }

    public void setDummyLat(String dummyLat) {
        this.dummyLat = dummyLat;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
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
