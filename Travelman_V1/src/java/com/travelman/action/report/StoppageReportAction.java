package com.travelman.action.report;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.report.ReportBusinesService;
import com.travelman.domain.Report;
import com.travelman.domain.User;

public class StoppageReportAction extends ActionSupport {

    private String vregistration_num;
    private String startDate;
    private String endDate;
    private String currentUserName;
    private List<Report> list;
    private String latitude;
    private String longitude;
    private String dummyLat = "";
    private String dummyLong = "";
    // Business Service
    private ReportBusinesService reportBusinesService;

    public String execute() {

        Map<String, Object> session = ActionContext.getContext().getSession();
        User user = (User) session.get("USER");

        String actionResult = "";

        reportBusinesService = new ReportBusinesService();
        list = reportBusinesService.createStoppage(user, startDate, endDate, vregistration_num);

        if (list != null) {

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

    public String getVregistration_num() {
        return vregistration_num;
    }

    public void setVregistration_num(String vregistration_num) {
        this.vregistration_num = vregistration_num;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCurrentUserName() {
        return currentUserName;
    }

    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }

    public ReportBusinesService getReportBusinesService() {
        return reportBusinesService;
    }

    public void setReportBusinesService(ReportBusinesService reportBusinesService) {
        this.reportBusinesService = reportBusinesService;
    }

    public List<Report> getList() {
        return list;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
