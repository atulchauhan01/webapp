package com.travelman.domain;


public class Report 
{
        
        private String latitudeList="";
        
        private String longitudeList="";
	
	private String startlocation;
 
	private String endlocation;
	
	private String startDate;
	
	private String endDate;
	
	private String duration;
	
	private String speed;
	
	private String distance;
	
	private String ignition;
	
	private String GPS;
        
        private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


	public String getStartlocation() {
		return startlocation;
	}

	public void setStartlocation(String startlocation) {
		this.startlocation = startlocation;
	}

	public String getEndlocation() {
		return endlocation;
	}

	public void setEndlocation(String endlocation) {
		this.endlocation = endlocation;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getIgnition() {
		return ignition;
	}

	public void setIgnition(String ignition) {
		this.ignition = ignition;
	}

	public String getGPS() {
		return GPS;
	}

	public void setGPS(String gPS) {
		GPS = gPS;
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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
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
	
}
