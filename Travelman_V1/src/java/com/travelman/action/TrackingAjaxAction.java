package com.travelman.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.data.service.DataService;
import com.travelman.domain.TrackData;
import com.travelman.domain.User;
import javax.servlet.http.HttpServletResponse;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.pojoxml.core.PojoXml;
import org.pojoxml.core.PojoXmlFactory;

public class TrackingAjaxAction extends ActionSupport implements ServletResponseAware  {
    private Logger log=Logger.getLogger(TrackingAjaxAction.class);

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

    HttpServletResponse response;
    
    public String getLatestVehicleData() {
        
        log.info("========In getLatestVehicleData()===========");
        String actionResult = "";
        setSession(ActionContext.getContext().getSession());
        setUser((User) getSession().get("USER"));
        DataService dataService = new DataService();
        setList(dataService.getLiveLocation(getUser()));
        if (getList() != null) {

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
        
        PojoXml pojoXml = PojoXmlFactory.createPojoXml();
        StringBuilder builder = new StringBuilder();
        
        builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        builder.append("<Data>");
        for (TrackData trackData : list) {
        builder.append(pojoXml.getXml(trackData).replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", ""));    
        }
        builder.append("</Data>");
        log.info(builder);
        response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");
        try {
            response.getWriter().write(builder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
         
        return null;

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
    
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
}
