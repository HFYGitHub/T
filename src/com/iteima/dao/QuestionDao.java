package com.iteima.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.iteima.domain.Answer;
import com.iteima.domain.File;
import com.iteima.domain.Question;
import com.iteima.domain.User;
import com.iteima.utils.JdbcUtil;

public class QuestionDao {
	public void insertQues(int id,String category,String title,String content,String release_time) {
			QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
			 String sql="insert into all_question(user_id,category,release_time,content,title,permission) values(?,?,?,?,?,?)  ";
			 Object object=null;
				try {
				 object =  qr.insert(sql,new ScalarHandler(), id,category,release_time,content,title,"0");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  	  
}
	public Question findQuesById(int id,int user_id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
	   	   String sql="select * from all_question where question_id=? and user_id=? ";
	   	Question question=null;
			try {
				question=qr.query(sql, new BeanHandler<Question>(Question.class),id,user_id);
			 
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
	   return question;
	}
	
	public List<Question> findQuesByUserId(int id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
	   	   String sql="select * from all_question where user_id=? ";
	   	List<Question> question=null;
			try {
				question=qr.query(sql, new BeanListHandler<Question>(Question.class),id);
			 
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
	   return question;
	}
	public List<Question> findAllQues() {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
	   	   String sql="select * from all_question  ";
	   	List<Question> question=null;
			try {
				question=qr.query(sql, new BeanListHandler<Question>(Question.class));
			 
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
	   return question;
	}
	public List<Answer> findAnById(int id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
	   	   String sql="select * from all_answer where question_id=?  ";
	   	List<Answer> answer=null;
			try {
				answer= qr.query(sql, new BeanListHandler<Answer>(Answer.class),id);
			 
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
	   return answer;
	}
	
	public List<Question> getDetails(String theme){
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		String sql=null;
		 if(theme.equals("全部")) {
 			System.out.println("oo");
 			sql = "select * from all_question order by release_time desc ";
 			  
 		}else if(theme.equals("最新"))
 		{	sql = "select * from all_question where DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(release_time) order by release_time desc ";
 		   
 		}else if(theme.equals("热帖")) {
 			
 			sql = "select * from all_question ";
 		}
		 List<Question> list=null;
			try {
              list = qr.query(sql, new BeanListHandler<Question>(Question.class));
            
         } catch (SQLException e) {
             e.printStackTrace();
        
         }
			return list;
	}
	public List<Question> findAnByTh(String th) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		String sql=null;
	     if(th.equals("热帖")) {
	    	  sql="SELECT DISTINCT * FROM all_question WHERE question_id IN(\r\n" + 
	 	   	   		"SELECT question_id AS NUM  FROM all_answer GROUP BY question_id ORDER BY NUM DESC\r\n" + 
	 	   	   		" \r\n" + 
	 	   	   		") LIMIT 0,5  ";
	     }else if(th.equals("本周")) {
	    	 sql = "select * from all_question where DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(release_time) order by release_time desc limit 0,5";
  		   
	     }else {
	    	 sql = "select * from all_question where DATE_SUB(CURDATE(), INTERVAL 3 DAY) <= date(release_time) order by release_time desc limit 0,5";
	  		   
	     }
	   	   
	   	List<Question> answer=null;
			try {
				answer= qr.query(sql, new BeanListHandler<Question>(Question.class));
			 
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
	   return answer;
	}
	
	public int countQues(String theme) {
		System.out.println(theme);
		String sql;
		if(theme.equals("全部")) {
			
			sql = "select count(*) from all_question order by release_time desc";
			  QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		        try {
		            Long count = qr.query(sql, new ScalarHandler<Long>());
		            
		            return count.intValue();
		        } catch (SQLException e) {
		            throw new RuntimeException(e);
		        }
		}else if(theme.equals("最新"))
		{	sql = "select count(*) from all_question where DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(release_time) order by release_time desc";
		    QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	        try {
	            Long count = qr.query(sql, new ScalarHandler<Long>());
	            
	            return count.intValue();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
		}else if(theme.equals("热帖")) {
			
			sql = "select count(*) from all_question  ";
		    QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	        try {
	            Long count = qr.query(sql, new ScalarHandler<Long>());
	            
	            return count.intValue();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
		}else {
			return 0;
		}
	}
	
	public List<Question> findAllQuestion() {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="select * from all_question order by release_time desc ";
  	   List<Question> allfile=null;
  	   try {
  		   allfile=qr.query(sql, new BeanListHandler<Question>(Question.class));
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	   return allfile;
	}
	
	public int count(int id) {
		  String sql = "select count(*) from all_question where question_id=? ";
		  QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	        try {
	            Long count = qr.query(sql, new ScalarHandler<Long>(),id);
	            
	            return count.intValue();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	}
	public void deleteQues(int id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		AnswerQuestionDao answedao=new AnswerQuestionDao();
		answedao.deleteCom(id);
		answedao.deleteAns(id);
  	    String sql="delete from all_question  where question_id=? ";
  	   System.out.println("删除成功");
  	   try {
  		 qr.update(sql,id);
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	  
	}
	public void deleteAnswe(int id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	      
  	    String sql="delete from comment  where answer_id=?";
  	   
  	   try {
  		 qr.update(sql,id);
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	 String sql1="delete from all_answer  where answer_id=?";
	   
	   try {
		 qr.update(sql1,id);
	   }catch(SQLException e){
		   e.printStackTrace();
	   }
  	    
	}
}