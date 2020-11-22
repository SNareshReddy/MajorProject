package com.harish.dao;

import java.sql.*;

public class DB {
	
	/*
	public static Connection getCon(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/major_db","username","password");
			
		}catch(Exception e){e.printStackTrace();}
		return con;
	}*/
	public static Connection getCon() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/major_db?useSSL=false","username","password");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
		
	}
}
