package com.dao.user;

public class UserDaoFactory {

	
	public static UserImpProxy getUserDaoInstance(){
		return new UserImpProxy();
		
	}
}
