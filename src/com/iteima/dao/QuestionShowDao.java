package com.iteima.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.iteima.domain.Question;
import com.iteima.utils.JdbcUtil;

public class QuestionShowDao {
	
	public List<Question> Questionshow(String category) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="select * from all_question where category=?";
  	   List<Question> allquestion=null;
  	   try {
  		 allquestion=qr.query(sql, new BeanListHandler<Question>(Question.class));
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	   return allquestion;
	}

}
