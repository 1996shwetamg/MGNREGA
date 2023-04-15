package com.masai.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DButils {
	static Connection getConnectiontodatabase() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		ResourceBundle rb=ResourceBundle.getBundle("dbdetails");
		return DriverManager.getConnection(rb.getString("url"),rb.getString("username"),rb.getString("password"));
	}

	static void closeConnection(Connection conn) throws SQLException {
	if(conn!=null)
		conn.close();
	}

	//checking resultset is empty or not
	static boolean isResultSetEmpty(ResultSet rs) throws SQLException {
		if(!rs.isBeforeFirst()&& rs.getRow()==0)
			return true;
		   return false;
	}
	
}




