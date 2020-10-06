package com.iteima.dao;

import java.math.BigDecimal;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.iteima.utils.JdbcUtil;

public class UserOp {

	public void insertUser(String name,String pwd,String email) {
		QueryRunner runner=new QueryRunner(JdbcUtil.getDataSource());
	     
		String inSql = "insert users (name,password,email,image) values (?, ?, ?,?)";

		Object object=null;
		try {
		 object =  runner.insert(inSql,new ScalarHandler(), name,pwd,email,"oranage.jpg");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//System.out.println("ScalarHandler: " + insertRs); // Print:[ScalarHandler: 3]
		System.out.println(Integer.parseInt(String.valueOf(object )));
		
	}
}
