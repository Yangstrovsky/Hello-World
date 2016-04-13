package com.dao.user;

import java.awt.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.object.User;

public class UserDaoImp implements UserDao {
	private Connection connection;
	private PreparedStatement pst = null;
	
	public UserDaoImp(Connection connection) {
		this.connection = connection;
	}

	@Override
	public User findbyID(String id) throws Exception {
		String sql="SELECT id, name, phone, address, company FROM yang.user WHERE id=?";
		this.pst=this.connection.prepareStatement(sql);
		pst.setString(1, id);
		ResultSet rs=this.pst.executeQuery();
		User user=new User();
		Exception e= new Exception("No results!");
		if (rs == null ) {
			throw e;
		}
		else{
			
			
			user.setId(Integer.valueOf(rs.getString("id")));
			user.setName(rs.getString("name"));
			user.setPhone(rs.getString("phone"));
			user.setAddress(rs.getString("address"));
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
