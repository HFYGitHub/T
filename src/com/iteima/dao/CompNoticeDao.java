package com.iteima.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.iteima.domain.CompetitionNotice;
import com.iteima.domain.User;
import com.iteima.domain.UserDownFile;
import com.iteima.utils.JdbcUtil;

public class CompNoticeDao {
	public List<CompetitionNotice> findCompById(int id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	
  	   String sql="select * from all_competitionnotice  where notice_id=?";
  	 List<CompetitionNotice> allfile=null;
  	   try {
  		   allfile=qr.query(sql, new BeanListHandler<CompetitionNotice>(CompetitionNotice.class),id);
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	  
  	   return allfile;
	}
	public CompetitionNotice findUserComp(int id,int user_id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	
  	   String sql="select * from competion_read  where notice_id=? and user_id=?";
  	 CompetitionNotice allfile=null;
  	   try {
  		   allfile=qr.query(sql, new BeanHandler<CompetitionNotice>(CompetitionNotice.class),id,user_id);
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	  
  	   return allfile;
	}
	
	public List<CompetitionNotice> findUserComp(int user_id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	
  	   String sql="select * from all_competitionnotice  where  notice_id in(select notice_id from competion_read where user_id=?)";
  	 List<CompetitionNotice> allfile=null;
  	   try {
  		   allfile=qr.query(sql, new BeanListHandler<CompetitionNotice>(CompetitionNotice.class),user_id);
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	  
  	   return allfile;
	}
	
	
	public void updateDownNum(int id,String username ) {
		UserDao uDao=new UserDao();
		User u=uDao.findUserByName(username);
		
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());

			String sql="update  competion_read set down_num=down_num+1 where  notice_id=? and user_id=? ";
			  
				try {
				  qr.update(sql, id,u.getId());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
	}
	
	public void updateLookNum(int id ) {
		
		
		
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());

			String sql="update  all_competitionnotice set read_num=read_num+1 where  notice_id=? ";
			  
				try {
				  qr.update(sql, id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
	}
	
	public void insertNoticeRead(int id,String username ) {
		
		
		UserDao uDao=new UserDao();
		User u=uDao.findUserByName(username);
		CompetitionNotice com=findUserComp(id,u.getId());
		if(com==null) {
			QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
			 java.util.Date date=new java.util.Date();
		 		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
		 		String time=sdf.format(date);
			 String sql="insert into competion_read(notice_id,user_id,look_num,down_num,look_time) values(?,?,?,?,?)  ";
			 
				try {
				  qr.insert(sql,new ScalarHandler(), id,u.getId(),1,0,time);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}else {
			
			QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
			 java.util.Date date=new java.util.Date();
		 		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
		 		String time=sdf.format(date);
			 String sql="update  competion_read set look_num=look_num+1 ,look_time=? where  notice_id=? and user_id=? ";
			 
				try {
				  qr.update(sql,time, id,u.getId());
				} catch (SQLException e) {
					// TODO Auto-generated catch blcko
					e.printStackTrace();
				}
			
		}
		
  	   
  	  
	}
	
	public int countCompNotice(String theme,String key) {
		System.out.println(theme);
		
	
        
        
     
          if(key!=null) {
			key=key.trim();
		}
          
		if(theme!=null&key!=null&&!theme.equals("请选择一个比赛类型")) {
			 String sql = "select count(*) from all_competitionnotice  where theme=? and (content like '%"+key+"%'  or competition_name like '%"+key+"%')";
			  QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		        try {
		            Long count = qr.query(sql,theme, new ScalarHandler<Long>());
		            
		            return count.intValue();
		        } catch (SQLException e) {
		            throw new RuntimeException(e);
		        }
		}else if(key!=null&&(theme==null||theme.equals("请选择一个比赛类型"))) {
			String sql = "select count(*) from all_competitionnotice  where  (content like '%"+key+"%'  or competition_name like '%"+key+"%')";
			  QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		        try {
		            Long count = qr.query(sql, new ScalarHandler<Long>());
		            
		            return count.intValue();
		        } catch (SQLException e) {
		            throw new RuntimeException(e);
		        }
		}else if(key==null&&(theme!=null&&!theme.equals("请选择一个比赛类型"))){
			String sql = "select count(*) from all_competitionnotice  where  theme=?";
			  QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		        try {
		            Long count = qr.query(sql,theme, new ScalarHandler<Long>());
		            
		            return count.intValue();
		        } catch (SQLException e) {
		            throw new RuntimeException(e);
		        }
		}else {
			String sql = "select count(*) from all_competitionnotice ";
			  QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		        try {
		            Long count = qr.query(sql, new ScalarHandler<Long>());
		            
		            return count.intValue();
		        } catch (SQLException e) {
		            throw new RuntimeException(e);
		        }
		}



	}
	
}
