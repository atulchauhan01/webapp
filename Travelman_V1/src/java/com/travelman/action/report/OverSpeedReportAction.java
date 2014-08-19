package com.travelman.action.report;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.report.ReportBusinesService;
import com.travelman.domain.Report;
import com.travelman.domain.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Atul
 */
public class OverSpeedReportAction extends ActionSupport {

    private String vregistration_num;
    private String startDate;
    private String endDate;
    private String currentUserName;
    //private String overSpeed;
    private int overSpeed;
    private List<Report> list;

    public String execute() {

        Map<String, Object> session = ActionContext.getContext().getSession();
        User user = (User) session.get("USER");
        String actionResult = "";
        ReportBusinesService reportBusinesService = new ReportBusinesService();
        System.out.println("over speed : " + getOverSpeed());
        list = reportBusinesService.createOverSpeed(user, startDate, endDate, vregistration_num, getOverSpeed());

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

    public List<Report> getList() {
        return list;
    }

    public void setList(List<Report> list) {
        this.list = list;
    }

    public int getOverSpeed() {
        return overSpeed;
    }

    public void setOverSpeed(int overSpeed) {
        this.overSpeed = overSpeed;
    }
}
