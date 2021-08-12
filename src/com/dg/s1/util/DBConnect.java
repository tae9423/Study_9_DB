package com.dg.s1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect {
	
	public Connection getConnect() throws SQLException {
		
		//1. 접속 정보 나열
		String user = "user02";
		String password = "user02";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		//Driver 생략
		
		//2. Connection 연결
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("접속 성공");
		
		return con;
	}

	public void disConnect(ResultSet rs, PreparedStatement st, Connection con) {
		try {
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
