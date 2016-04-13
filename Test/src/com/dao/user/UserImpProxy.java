package com.dao.user;

import java.util.List;

import com.dao.general.DBConnection;
import com.object.User;
/**
 * DAO代理类，实现连接管理及SQL执行
 * @author Yang
 *
 */
public class UserImpProxy implements UserDao {
	private DBConnection dbconnection;
	private UserDaoImp daoimp;
		 public void userDaoproxy() throws Exception{
			 try {
				this.dbconnection=new DBConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			 try {
				this.daoimp=new UserDaoImp(this.dbconnection.getConnection());
			} catch (Exception e) {
				e.printStackTrace();
			}
			 
		 }
	@Override
	public boolean findbyID (String id, List<User> list) throws Exception {
		
		if (this.daoimp.findbyID(id, list)) {
			
			dbconnection.close();
			return true;
		} else {
			dbconnection.close();
            return false;
		}
		
			
	}

	@Override
	public List<String> findbyName() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertUpdateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
