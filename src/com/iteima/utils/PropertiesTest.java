package com.iteima.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbutils.QueryRunner;

import com.iteima.domain.User;

public class PropertiesTest {
public static void main(String[] args)  {
//	Properties p=new  Properties();
//	//获取字节码目录
//	
//	String path=User.class.getClassLoader().getResource("db.properties").getPath();
//	System.out.println(path);
//	FileInputStream in;
//	try {
//		in = new FileInputStream(path);
//	
//		p.load(in);
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//    System.out.println(p.getProperty("url"));
//    System.out.println(p.getProperty("username"));
//    System.out.println(p.getProperty("password"));
//    
//    
//    QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
//     
//    	  Connection conn=JdbcUtil.getConn();
//    	  System.out.println(conn);
		
	
	BigDecimal insertRs=new BigDecimal(11);

	System.out.println(insertRs.intValue());
}
}
