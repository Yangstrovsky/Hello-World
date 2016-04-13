package com.dao.user;

import java.util.List;
import com.object.User;


/**
 * DAO接口，定义SQL操作方法
 * @author Yang
 *
 */

public interface UserDao {

	public boolean findbyID (String id, List<User> list) throws Exception;
	public List<String> findbyName() throws Exception;
	public boolean insertUser(User user) throws Exception;
	public boolean  insertUpdateUser(User user) throws Exception;

}
