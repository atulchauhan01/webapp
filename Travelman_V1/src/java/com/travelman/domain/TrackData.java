package com.travelman.domain;

public class TrackData {

    private String vregisteration_num;
    private String deviceid;
    private String date;
    private double speed;
    private String acc_status;
    private String latitudeList = "";
    private String longitudeList = "";
    private String location = "";

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getAcc_status() {
        return acc_status;
    }

    public void setAcc_status(String acc_status) {
        this.acc_status = acc_status;
    }

    public String getLatitudeList() {
        return latitudeList;
    }

    public void setLatitudeList(String aLatitudeList) {
        latitudeList = aLatitudeList;
    }

    public String getLongitudeList() {
        return longitudeList;
    }

    public void setLongitudeList(String aLongitudeList) {
        longitudeList = aLongitudeList;
    }

    public String getVregisteration_num() {
        return vregisteration_num;
    }

    public void setVregisteration_num(String vregisteration_num) {
        this.vregisteration_num = vregisteration_num;
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
