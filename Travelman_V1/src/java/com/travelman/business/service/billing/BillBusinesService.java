
package com.travelman.business.service.billing;

import com.travelman.data.service.DataService;
import com.travelman.domain.Bill;
import com.travelman.domain.Coupon;
import com.travelman.domain.Device;
import com.travelman.domain.Offer;
import com.travelman.domain.Payment;
import com.travelman.domain.Plan;
import com.travelman.domain.SmsPlan;
import com.travelman.domain.Tax;
import java.util.List;

/**
 *
 * @author Techno Life
 */
public class BillBusinesService {
    
     private DataService dataService = new DataService();

    public List<Integer> getUserIdPlan(int userId) {
       List<Integer> list = null;
		list=dataService.getUserIdPlan(userId);
		return list;
    }      
    
      public List<String> getUserId(int userId) {
       List<String> list = null;
		list=dataService.getUserId(userId,2);
		return list;
    }
      
    public List<Integer> getDeviceListPayment(int accNo) {
       List<Integer> list=null;
		list=dataService.getDeviceListPayment(accNo);
		return list;
    }

    public void savePayment(Payment payment) {
       dataService.savePayment(payment);
    }
    
    public List<Long> getDeviceIdList(){       
       return dataService.getDeviceIdList();
    }
   
        public List<Long> getUserId() {
       List<Long> list = null;
		list=dataService.getUserIdList();
		return list;
    }    
    
    public void SaveOffer(Offer ofr)
    {
        dataService.saveOffer(ofr);
    }
    
    public List<Offer> listOffer(long userid,long uprofile) 
    {
       List<Offer> list = null;
		list=dataService.listOffer(userid,uprofile);
		return list;
    } 
    
    public void SaveCoupons(Coupon coupon,String str)
    {
        dataService.saveCoupons(coupon,str);
    }

    public void preAssignedCoupon() 
    {
     dataService.preAssignedCoupon();
    }
public void createPlan(Plan plan)
   {
       dataService.createPlan(plan);
   }
   public List<Plan> listPlan(int userID,int uprofile)
   {
       List<Plan> list=null;
       list = dataService.listPlans(userID, uprofile);
       return list;
       
   }
   public void createTax(Tax tax)
   {
       dataService.createTax(tax);
       
   }
   public List<Tax> getListTax()
   {
      List<Tax> lists=null;
      lists=dataService.updateTax();
      return lists;
       
   }
   public void updateTax(Tax tax)
   {
       dataService.editTax(tax);
   }
   public List<Long> getDeviceI(int userID,int uprofile)
           
   {
       List<Long> lists=null;
      lists = dataService.getDeviceId(userID,uprofile);
       return lists;
   }
   
   public List<String> getPlanName(int userID,int uprofile)
           
   {
       List<String> list=null;
       list=dataService.getPlanName(userID,uprofile);
       return list;
   }
   public List<String> getSmsPlan()
           
   {
       List<String> listes=null;
       listes=dataService.getSmsPlan();
       return listes;
   }
   public void assignPlan(long deviceId,String plan,String smsPlan)
   {
       dataService.assignPlan(deviceId, plan, smsPlan);
       
   }

      public Plan getPlanInfo(long deviceid) {
        return dataService.getPlanInfo(deviceid);
   
      }

    public Bill getPreviousBillInfo(long deviceid) {
       return dataService.getPreviousBillInfo(deviceid);
    }

    public SmsPlan getSmsPlanInfo(long deviceid) {
        return dataService.getSmsPlanInfo(deviceid);
    }

    public Payment getPaymentInfo(long deviceid) {
        return dataService.getPaymentInfo(deviceid);
    }
   
}
