package com.dao.user;

import java.awt.List;

import com.object.User;

public interface UserDao {

	public User findbyID(String id) throws Exception;
	public List findbyName() throws Exception;
	public boolean insertUser(User user) throws Exception;
	public boolean  insertUpdateUser(User user) throws Exception;

}
