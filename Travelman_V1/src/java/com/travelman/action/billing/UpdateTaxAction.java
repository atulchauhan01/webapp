package com.travelman.action.billing;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.billing.BillBusinesService;
import com.travelman.domain.User;
import com.travelman.domain.Tax;
import java.util.List;
import java.util.Map;

public class UpdateTaxAction extends ActionSupport
{
    private List<Tax> list;
    
    private BillBusinesService billBusinessService;
    
    
    
    @Override
    public String execute()throws Exception
    {
        billBusinessService = new BillBusinesService();

        
       
        
        list = billBusinessService.getListTax();
        
        
        return SUCCESS;
        
    }

    public List<Tax> getList() {
        return list;
    }

    public void setList(List<Tax> list) {
        this.list = list;
    }
    
}
