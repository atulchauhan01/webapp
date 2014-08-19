
package com.travelman.action.billing;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.domain.User;
import java.io.IOException;
import java.util.Map;


public class CouponAction extends ActionSupport
{
     private String currentUserName;

    public String getCurrentUserName() {
        return currentUserName;
    }

    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }
     
    public String execute() throws IOException
    {
        
     Map<String,Object> session = ActionContext.getContext().getSession();
     User user = (User)session.get("USER");
		setCurrentUserName(user.getFname()+" "+user.getLname());
		
                
				if (user.getUprofile() == 3) {
					
					setCurrentUserName(getCurrentUserName()+" [A]");
				}
			
		
		return SUCCESS;
        
    }
    
}
