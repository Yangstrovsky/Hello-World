package com.dao.user;

/**
 * DAO工厂类，生成DAO代理实例，以供调用
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
