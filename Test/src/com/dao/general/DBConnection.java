package com.dao.general;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnection {
	private static String DBName = "java:comp/env/jdbc/mydb2";
	private Connection connection = null;
	public DBConnection() throws Exception {

		try {

			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup(DBName);
			this.connection = ds.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void close() throws Exception {
		try {
			this.connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		return this.connection;
	}

}
