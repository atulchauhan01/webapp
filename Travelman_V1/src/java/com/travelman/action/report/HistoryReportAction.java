package com.travelman.action.report;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.report.ReportBusinesService;
import com.travelman.domain.Report;
import com.travelman.domain.User;

public class HistoryReportAction extends ActionSupport {

    private static long serialVersionUID = 1L;
    private String vregistration_num;
    private String startDate;
    private String endDate;
    private String currentUserName;
    private List<Report> list;
    // Business Service
    private ReportBusinesService reportBusinesService;
    private String latitude;
    private String longitude;
    private String dummyLat = "";
    private String dummyLong = "";

    public String execute() {

        Map<String, Object> session = ActionContext.getContext().getSession();
        User user = (User) session.get("USER");

        setList(null);

        String actionResult = "";

        reportBusinesService = new ReportBusinesService();
        setList(reportBusinesService.createHistory(user, getStartDate(), getEndDate(), getVregistration_num()));
        if (getList() != null) {
            // latitude = Report.getLatitudeList();
            // longitude = Report.getLongitudeList();
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
            actionResult = "input";
        }


        return actionResult;

    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    /**
     * @return the vregistration_num
     */
    public String getVregistration_num() {
        return vregistration_num;
    }

    /**
     * @param vregistration_num the vregistration_num to set
     */
    public void setVregistration_num(String vregistration_num) {
        this.vregistration_num = vregistration_num;
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
     * @return the list
     */
    public List<Report> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Report> list) {
        this.list = list;
    }

    /**
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    
}
