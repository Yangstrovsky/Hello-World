package com.dao.user;

/**
 * DAO�����࣬����DAO����ʵ�����Թ�����
 * @author Yang
 *
 */

public class UserDaoFactory {

	
	public static UserImpProxy getUserDaoInstance() throws Exception{
		UserImpProxy usrimpproxy=new UserImpProxy();
		usrimpproxy.userDaoproxy();
		return usrimpproxy;
		
	}
}
