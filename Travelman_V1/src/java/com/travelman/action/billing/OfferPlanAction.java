package com.travelman.action.billing;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.billing.BillBusinesService;
import com.travelman.data.service.DataService;
import com.travelman.domain.Offer;
import com.travelman.domain.Plan;
import com.travelman.domain.User;
import java.util.List;
import java.util.Map;

public class OfferPlanAction extends ActionSupport {
      private String currentUserName;
     String name;
        float amount;
        String cycle;
        Long[] assignTo;
        BillBusinesService billBusinesService;

    public Long[] getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(Long[] assignTo) {
        this.assignTo = assignTo;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrentUserName() {
        return currentUserName;
    }

    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }
    
    
    @Override
    public String execute()
    {
    
        Map<String,Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("USER");
		setCurrentUserName(user.getFname()+" "+user.getLname());
                
                if (user.getUprofile() == 1) {
			
			setCurrentUserName(getCurrentUserName()+" [I]");
		} else {
			if (user.getUprofile() == 2) {
				
				setCurrentUserName(getCurrentUserName()+" [G]");
			} else {
				if (user.getUprofile() == 3) {
					
					setCurrentUserName(getCurrentUserName()+" [A]");
				}
			}
                        for(Long assignTo:this.assignTo)
      {
      Offer ofr=new Offer(name,amount,cycle,assignTo);
     
      billBusinesService=new BillBusinesService();
      billBusinesService.SaveOffer(ofr);
      }
		}
		return SUCCESS;
	}
		
}
