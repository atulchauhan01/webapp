package com.travelman.action.billing;
 import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.billing.BillBusinesService;
import com.travelman.domain.Plan;
import com.travelman.domain.User;
import com.travelman.domain.Tax;
import java.util.List;
import java.util.Map;

public class CreateTaxAction extends ActionSupport
{
    private float serviceTax;
    private float educationCess;
    private float sheCess;
    private float otherTax;
    
    private BillBusinesService billBusinesService = null;

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

    public void setSheCess(float shCess) {
        this.sheCess = shCess;
    }
    
    
    @Override
    public String execute()throws Exception
    {
        billBusinesService = new BillBusinesService();
        Tax tax = new Tax();
        
        tax.setServiceTax(serviceTax);
        tax.setEducationCess(educationCess);
        tax.setSheCess(sheCess);
        tax.setOtherTax(otherTax);
        billBusinesService.createTax(tax);
        return SUCCESS;
    }
    
}
