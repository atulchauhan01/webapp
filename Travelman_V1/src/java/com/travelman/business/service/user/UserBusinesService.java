/**
 * 
 */
package com.travelman.business.service.user;

import java.util.List;

import com.travelman.data.service.DataService;
import com.travelman.domain.User;

/**
 * @author Armaan
 * 
 */
public class UserBusinesService {

		
 private DataService dataService = new DataService();
	/**
	 * 
	 */
	public void createUser(User user) {

		dataService.createUser(user);
	}


	/**
	 * 
	 */
	public void removeUser(User user) {
		dataService.removeUser(user);
	}

	public List<User> listViewUser(int uprofile,int userId ) {
				List<User> list=null;
			list=dataService.listViewUser(uprofile,userId);
			return list;
		}

	public int getMaxUserId() {
		int id=0;
		id = dataService.getMaxUserId();
		return id;
	}

    public List<String> getUserId(int userId,int uprofile) {
       List<String> list = null;
		list=dataService.getUserId(userId,uprofile);
		return list;
    }

    public User getUser(String uemail,int userId_Owner) {
        User user;
        user=dataService.getUser(uemail,userId_Owner);
        
        return user;
    }

    public void updateUser(User user, int userId_Owner) {
       dataService.updateUser(user,userId_Owner);
    }

    public String updatePassword(int userId, String password, String newPassword) {
        return dataService.updatePassword(userId,password,newPassword);
    }


   
	}


