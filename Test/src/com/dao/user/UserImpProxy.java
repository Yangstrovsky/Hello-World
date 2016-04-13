package com.dao.user;

import java.awt.List;

import com.dao.general.DBConnection;
import com.object.User;

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
	public User findbyID(String id) throws Exception {
		User user=new User();
		try {
			daoimp.findbyID(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			dbconnection.close();
		}
			return user;
	}

	@Override
	public List findbyName() throws Exception {
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
