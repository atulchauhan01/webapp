package com.travelman.domain;


public class Plan 
{
  
    private String planname;
    private float rental;
    private String billingcycle;
    private float discount;
    private float tatalrental;
    private String facilities;
    private int assignto;

    public int getAssignto() {
        return assignto;
    }

    public void setAssignto(int assignto) {
        this.assignto = assignto;
    }
    
    
   
    public String getBillingcycle()
    {
        return billingcycle;
    }

    public void setBillingcycle(String billingcycle)
    {
        this.billingcycle = billingcycle;
    }

    public float getDiscount() 
    {
        return discount;
    }

    public void setDiscount(float discount) 
    {
        this.discount = discount;
    }

    public String getFacilities() 
    {
        return facilities;
    }

    public void setFacilities(String facilities)
    {
        this.facilities = facilities;
    }

    public String getPlanname()
    {
        return planname;
    }

    public void setPlanname(String planname)
    {
        this.planname = planname;
    }

    public float getRental() 
    {
        return rental;
    }

    public void setRental(float rental)
    {
        this.rental = rental;
    }

    public float getTatalrental() 
    {
        return tatalrental;
    }

    public void setTatalrental(float tatalrental)
    {
        this.tatalrental = tatalrental;
    }
    
}
