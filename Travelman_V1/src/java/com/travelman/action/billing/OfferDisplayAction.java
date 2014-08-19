
package com.travelman.action.billing;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.billing.BillBusinesService;
import com.travelman.domain.Offer;
import com.travelman.domain.User;
import java.io.IOException;
import java.util.List;
import java.util.Map;


public class OfferDisplayAction extends ActionSupport
{
   private String currentUserName;
   private List<Offer>  list;
   BillBusinesService billBusinesService;
   
   
   
	public String getCurrentUserName() {
		return currentUserName;
	}


	public void setCurrentUserName(String currentUserName) {
		this.currentUserName = currentUserName;
	}
         public List<Offer> getList() {
		return list;
            }
		
		public void setList(List<Offer> list) {
			this.list = list;
		}
                
                
                public String execute() throws IOException
                        
                {
                      String actionResult = "";
                     
                      billBusinesService=new BillBusinesService();
                     
                      
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("USER");
		setCurrentUserName(user.getFname()+" "+user.getLname());
		
                  setList(billBusinesService.listOffer(user.getUserId(),user.getUprofile()));
                if (user.getUprofile() == 1) {
			actionResult = "individual";
			setCurrentUserName(getCurrentUserName()+" [I]");
		} else {
			if (user.getUprofile() == 2) {
				actionResult = "group";
				setCurrentUserName(getCurrentUserName()+" [G]");
                                
			} else {
				if (user.getUprofile() == 3) {
					actionResult = "admin";
					setCurrentUserName(getCurrentUserName()+" [A]");
				}
			}
		}
		return actionResult;
                }
}
