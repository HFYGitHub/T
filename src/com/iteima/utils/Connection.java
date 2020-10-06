package com.iteima.utils;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
public static void mian(String[] args){
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	String url="jdbc:mysql://localhost:3306/ac_circle";
	String user="root";
	String password="123456cj";
	java.sql.Connection conn = DriverManager.getConnection(url,user,password);
		
		System.out.println(conn);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
