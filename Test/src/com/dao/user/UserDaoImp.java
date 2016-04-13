package com.dao.user;

import java.util.Iterator;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.object.User;
/**
 * DAO实现类，实现SQL操作方法
 * 
 * @author Yang
 *
 */
public class UserDaoImp implements UserDao {
	private Connection connection;
	private PreparedStatement pst = null;
	// 有参构造方法，获取数据库连接
	public UserDaoImp(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean findbyID (String id, List<User> list) throws Exception {
		if (id.equals(null)) {
			String sql = "SELECT id, name, phone, address, company FROM yang.user";
			this.pst = this.connection.prepareStatement(sql);
		} else {
			String sql = "SELECT id, name, phone, address, company FROM yang.user WHERE id=?";
			this.pst = this.connection.prepareStatement(sql);
			pst.setString(1, id);
		}
		ResultSet rs = this.pst.executeQuery();
		//注意检测List中对象是否为同一个user
		
		// boolean rs.next() 游标初始位置为首行前，首次调用rs.next()即将首行置为当前行
		// JAVA端trim 也可通过DB2 trim实现
		if (!rs.next()) {
			return false;

		}
		do {
			User user = new User();
			user.setId(Integer.valueOf(rs.getString("id").trim()));
			user.setName(rs.getString("name"));
			user.setPhone(rs.getString("phone"));
			user.setAddress(rs.getString("address"));
			list.add(user);

		} while (rs.next());
		Iterator<User> iter = list.iterator();
		while(iter.hasNext()){
			User user=iter.next();
			System.out.println("user.getId()="+user.getId());
			System.out.println("user.getName()="+user.getName());
			System.out.println("user.getPhone()="+user.getPhone());
			System.out.println("user.getAddress()="+user.getAddress());

			
		}
		return true;

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
