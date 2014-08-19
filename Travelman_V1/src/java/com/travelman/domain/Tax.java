
package com.travelman.domain;


public class Tax 
{
    private float serviceTax;
    private float educationCess;
    private float sheCess;
    private float otherTax;

    public float getEducationCess() {
        return educationCess;
    }

    public void setEducationCess(float educationCess) {
        this.educationCess = educationCess;
    }

    public float getOtherTax() {
        return otherTax;
    }

    public void setOtherTax(float otherTax) {
        this.otherTax = otherTax;
    }

    public float getServiceTax() {
        return serviceTax;
    }

    public void setServiceTax(float serviceTax) {
        this.serviceTax = serviceTax;
    }

    public float getSheCess() {
        return sheCess;
    }

    public void setSheCess(float sheCess) {
        this.sheCess = sheCess;
    }
     
}
