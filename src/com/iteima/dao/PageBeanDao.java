package com.iteima.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.iteima.domain.Competion;
import com.iteima.domain.CompetitionNotice;
import com.iteima.domain.File;
import com.iteima.domain.Food;
import com.iteima.domain.PageBean;
import com.iteima.domain.Question;
import com.iteima.service.CompNoticeService;
import com.iteima.service.FileService;
import com.iteima.service.FoodService;
import com.iteima.service.QuestionService;
import com.iteima.service.ReleaseCompetitionService;
import com.iteima.utils.JdbcUtil;

public class PageBeanDao implements PageBeanImpDao{


    @Override
    public void getAll(PageBean<File> pageBean,String theme) {
        
        //��ѯ�ܼ�¼����  �����ñ��浽pageBean������
        int totalCount = getTotalCount(theme);
        pageBean.setTotalCount(totalCount);
        
        /*
         * ���⣺ jspҳ�棬�����ǰҳΪ��ҳ���ٵ����һҳ����
         *              �����ǰҳΪĩҳ���ٵ���һҳ��ʾ�����⣡
         * �����
         *        1. �����ǰҳ <= 0;       ��ǰҳ���õ�ǰҳΪ1;
         *        2. �����ǰҳ > ���ҳ����  ��ǰҳ����Ϊ���ҳ��
         */
        
        if(pageBean.getCurrentPage() <= 0){
            pageBean.setCurrentPage(1);
        }else if(pageBean.getCurrentPage() > pageBean.getTotalPage()){
            pageBean.setCurrentPage(pageBean.getTotalPage());
        }

        //��ȡ��ǰҳ�������ѯ����ʼ�С���������
        int currentPage = pageBean.getCurrentPage();
        int index = (currentPage - 1)*pageBean.getPageCount();
        int count = pageBean.getPageCount();
        
       
         String sql = "select * from file_data where theme=? limit ?,?";
        
         QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
         List<File> list=null;
        try {
             list = qr.query(sql, new BeanListHandler<File>(File.class),theme,index,count);
            pageBean.setList(list);
        } catch (SQLException e) {
            e.printStackTrace();
       
        }
    }
    
    @Override
    public void getAllBYkey(PageBean<File> pageBean,String theme) {
        
        //��ѯ�ܼ�¼����  �����ñ��浽pageBean������
        int totalCount = getAllCount();
        pageBean.setTotalCount(totalCount);
        
        /*
         * ���⣺ jspҳ�棬�����ǰҳΪ��ҳ���ٵ����һҳ����
         *              �����ǰҳΪĩҳ���ٵ���һҳ��ʾ�����⣡
         * �����
         *        1. �����ǰҳ <= 0;       ��ǰҳ���õ�ǰҳΪ1;
         *        2. �����ǰҳ > ���ҳ����  ��ǰҳ����Ϊ���ҳ��
         */
        
        if(pageBean.getCurrentPage() <= 0){
            pageBean.setCurrentPage(1);
        }else if(pageBean.getCurrentPage() > pageBean.getTotalPage()){
            pageBean.setCurrentPage(pageBean.getTotalPage());
        }

        //��ȡ��ǰҳ�������ѯ����ʼ�С���������
        int currentPage = pageBean.getCurrentPage();
        int index = (currentPage - 1)*pageBean.getPageCount();
        int count = pageBean.getPageCount();
        
       
         String sql = "select * from file_data where theme like '%"+theme+"%' or filename like '%"+theme+"%' limit ?,?";
        
         QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
         List<File> list=null;
        try {
             list = qr.query(sql, new BeanListHandler<File>(File.class),index,count);
            pageBean.setList(list);
        } catch (SQLException e) {
            e.printStackTrace();
       
        }
    }
    @Override
    public void getAllQuestion(PageBean<Question> pageBean,String theme,String key) {
        
        //��ѯ�ܼ�¼����  �����ñ��浽pageBean������
        int totalCount = getTotalCountQues(theme);
        pageBean.setTotalCount(totalCount);
        
        /*
         * ���⣺ jspҳ�棬�����ǰҳΪ��ҳ���ٵ����һҳ����
         *              �����ǰҳΪĩҳ���ٵ���һҳ��ʾ�����⣡
         * �����
         *        1. �����ǰҳ <= 0;       ��ǰҳ���õ�ǰҳΪ1;
         *        2. �����ǰҳ > ���ҳ����  ��ǰҳ����Ϊ���ҳ��
         */
        
        if(pageBean.getCurrentPage() <= 0){
            pageBean.setCurrentPage(1);
        }else if(pageBean.getCurrentPage() > pageBean.getTotalPage()){
            pageBean.setCurrentPage(pageBean.getTotalPage());
        }

        //��ȡ��ǰҳ�������ѯ����ʼ�С���������
        int currentPage = pageBean.getCurrentPage();
        int index = (currentPage - 1)*pageBean.getPageCount();
        int count = pageBean.getPageCount();
       
        
        
         QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
        if(key==null||key.trim()=="") {
        	try {
            	String sql=null;
            if(theme.equals("ȫ��")) {
    			System.out.println("oo");
    			sql = "select * from all_question order by release_time desc limit ?,?";
    			  
    		}else if(theme.equals("����"))
    		{	sql = "select * from all_question where DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(release_time) order by release_time desc limit ?,?";
    		   
    		}else if(theme.equals("����")) {
    			
    			sql = "select * from all_question limit ?,? ";
    		}
                List<Question> list = qr.query(sql, new BeanListHandler<Question>(Question.class),index,count);
                pageBean.setList(list);
            } catch (SQLException e) {
                e.printStackTrace();
           
            }
        }
        else {
        	try {
            	String sql=null;
            if(theme.equals("ȫ��")) {
    			System.out.println("oo");
    			sql = "select * from all_question where category like '%"+key+"%' or title like '%"+key+"%' or content like '%"+key+"%'  order by release_time desc limit ?,?";
    			  
    		}else if(theme.equals("����"))
    		{	sql = "select * from all_question where DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(release_time) and (category like '%"+key+"%' or title like '%"+key+"%' or content like '%"+key+"%') order by release_time desc limit ?,?";
    		   
    		}else if(theme.equals("����")) {
    			
    			sql = "select * from all_question where category like '%"+key+"%' or title like '%"+key+"%' or content like '%"+key+"%' limit ?,? ";
    		}
                List<Question> list = qr.query(sql, new BeanListHandler<Question>(Question.class),index,count);
                pageBean.setList(list);
            } catch (SQLException e) {
                e.printStackTrace();
           
            }
        }
    }
    @Override
    public void getAllCompNotice(PageBean<CompetitionNotice> pageBean,String theme,String key) {
        
        //��ѯ�ܼ�¼����  �����ñ��浽pageBean������
        int totalCount = getTotalCountCompNotice(theme,key);
        pageBean.setTotalCount(totalCount);
        
        /*
         * ���⣺ jspҳ�棬�����ǰҳΪ��ҳ���ٵ����һҳ����
         *              �����ǰҳΪĩҳ���ٵ���һҳ��ʾ�����⣡
         * �����
         *        1. �����ǰҳ <= 0;       ��ǰҳ���õ�ǰҳΪ1;
         *        2. �����ǰҳ > ���ҳ����  ��ǰҳ����Ϊ���ҳ��
         */
        
        if(pageBean.getCurrentPage() <= 0){
            pageBean.setCurrentPage(1);
        }else if(pageBean.getCurrentPage() > pageBean.getTotalPage()){
            pageBean.setCurrentPage(pageBean.getTotalPage());
        }

        //��ȡ��ǰҳ�������ѯ����ʼ�С���������
        int currentPage = pageBean.getCurrentPage();
        int index = (currentPage - 1)*pageBean.getPageCount();
        int count = pageBean.getPageCount();
       
        
        
         QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
        
         if(key!=null) {
 			key=key.trim();
 		}
           
 		if(theme!=null&key!=null&&!theme.equals("��ѡ��һ����������")) {
 			 String sql = "select * from all_competitionnotice  where theme=? and (content like '%"+key+"%'  or competition_name like '%"+key+"%') order by release_time desc limit ?,?";
 			
 		        try {
 		        	  List<CompetitionNotice> list = qr.query(sql, new BeanListHandler<CompetitionNotice>(CompetitionNotice.class),theme,index,count);
 		             pageBean.setList(list);
 		        } catch (SQLException e) {
 		            throw new RuntimeException(e);
 		        }
 		}else if(key!=null&&(theme==null||theme.equals("��ѡ��һ����������"))) {
 			String sql = "select * from all_competitionnotice  where  (content like '%"+key+"%'  or competition_name like '%"+key+"%') order by release_time desc limit ?,?";
 			  try {
 		        	  List<CompetitionNotice> list = qr.query(sql, new BeanListHandler<CompetitionNotice>(CompetitionNotice.class),index,count);
 		             pageBean.setList(list);
 		        } catch (SQLException e) {
 		            throw new RuntimeException(e);
 		        }
 		}else if(key==null&&(theme!=null&&!theme.equals("��ѡ��һ����������"))){
 			String sql = "select * from all_competitionnotice  where  theme=? order by release_time desc limit ?,?";
 			  try {
 		        	  List<CompetitionNotice> list = qr.query(sql, new BeanListHandler<CompetitionNotice>(CompetitionNotice.class),theme,index,count);
 		             pageBean.setList(list);
 		        } catch (SQLException e) {
 		            throw new RuntimeException(e);
 		        }
 		}else {
 			String sql = "select * from all_competitionnotice order by release_time desc limit ?,?";
 			    try {
 		        	  List<CompetitionNotice> list = qr.query(sql, new BeanListHandler<CompetitionNotice>(CompetitionNotice.class),index,count);
 		             pageBean.setList(list);
 		        } catch (SQLException e) {
 		            throw new RuntimeException(e);
 		        }
 		}


			
		
            
    }
    public void getAllFile(PageBean<File> pageBean,String key) {
    	
    	  //��ѯ�ܼ�¼����  �����ñ��浽pageBean������
        int totalCount = getTotalCount();
        pageBean.setTotalCount(totalCount);
        
        /*
         * ���⣺ jspҳ�棬�����ǰҳΪ��ҳ���ٵ����һҳ����
         *              �����ǰҳΪĩҳ���ٵ���һҳ��ʾ�����⣡
         * �����
         *        1. �����ǰҳ <= 0;       ��ǰҳ���õ�ǰҳΪ1;
         *        2. �����ǰҳ > ���ҳ����  ��ǰҳ����Ϊ���ҳ��
         */
        
        if(pageBean.getCurrentPage() <= 0){
            pageBean.setCurrentPage(1);
        }else if(pageBean.getCurrentPage() > pageBean.getTotalPage()){
            pageBean.setCurrentPage(pageBean.getTotalPage());
        }
        //��ȡ��ǰҳ�������ѯ����ʼ�С���������
        int currentPage = pageBean.getCurrentPage();
        int index = (currentPage - 1)*pageBean.getPageCount();
        int count = pageBean.getPageCount();
        
    	if(key==null||key=="") {
    		String sql = "select * from file_data   limit ?,?";
            
            QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
           
           try {
               List<File> list = qr.query(sql, new BeanListHandler<File>(File.class),index,count);
               pageBean.setList(list);
           } catch (SQLException e) {
               e.printStackTrace();
          
           }
   	}else {
   		   
   		String sql = "select * from file_data where filename like '%"+key+"%' limit ?,?";
        
        QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
       
       try {
           List<File> list = qr.query(sql, new BeanListHandler<File>(File.class),index,count);
           pageBean.setList(list);
       } catch (SQLException e) {
           e.printStackTrace();
      
       }
   	}
         
    }
    
    public void getAllFood(PageBean<Food> pageBean,String key) {
    	//��ѯ�ܼ�¼����  �����ñ��浽pageBean������
        int totalCount = getTotalFoodCount();
        pageBean.setTotalCount(totalCount);
        
        /*
         * ���⣺ jspҳ�棬�����ǰҳΪ��ҳ���ٵ����һҳ����
         *              �����ǰҳΪĩҳ���ٵ���һҳ��ʾ�����⣡
         * �����
         *        1. �����ǰҳ <= 0;       ��ǰҳ���õ�ǰҳΪ1;
         *        2. �����ǰҳ > ���ҳ����  ��ǰҳ����Ϊ���ҳ��
         */
        
        if(pageBean.getCurrentPage() <= 0){
            pageBean.setCurrentPage(1);
        }else if(pageBean.getCurrentPage() > pageBean.getTotalPage()){
            pageBean.setCurrentPage(pageBean.getTotalPage());
        }

        //��ȡ��ǰҳ�������ѯ����ʼ�С���������
        int currentPage = pageBean.getCurrentPage();
        int index = (currentPage - 1)*pageBean.getPageCount();
        int count = pageBean.getPageCount();
        
        
        if(key==null||key=="") {
        	String sql = "select * from food_data   limit ?,?";
            QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
           
           
            try {
                List<Food> list = qr.query(sql, new BeanListHandler<Food>(Food.class),index,count);
                pageBean.setList(list);
            } catch (SQLException e) {
                e.printStackTrace();
           
            }
   	}else {
   		   
   		String sql = "select * from food_data where  text like '%"+key+"%' or introduce like '%"+key+"%' limit ?,?";
        
        QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
       
        try {
            List<Food> list = qr.query(sql, new BeanListHandler<Food>(Food.class),index,count);
            pageBean.setList(list);
        } catch (SQLException e) {
            e.printStackTrace();
       
        }
   	}
     
    	
  	  
    }
  
    public void getAllComp(PageBean<CompetitionNotice> pageBean,String key) {
    	//��ѯ�ܼ�¼����  �����ñ��浽pageBean������
        int totalCount = getTotalCompetionCount(key);
        pageBean.setTotalCount(totalCount);
        
        /*
         * ���⣺ jspҳ�棬�����ǰҳΪ��ҳ���ٵ����һҳ����
         *              �����ǰҳΪĩҳ���ٵ���һҳ��ʾ�����⣡
         * �����
         *        1. �����ǰҳ <= 0;       ��ǰҳ���õ�ǰҳΪ1;
         *        2. �����ǰҳ > ���ҳ����  ��ǰҳ����Ϊ���ҳ��
         */
        
        if(pageBean.getCurrentPage() <= 0){
            pageBean.setCurrentPage(1);
        }else if(pageBean.getCurrentPage() > pageBean.getTotalPage()){
            pageBean.setCurrentPage(pageBean.getTotalPage());
        }

        //��ȡ��ǰҳ�������ѯ����ʼ�С���������
        int currentPage = pageBean.getCurrentPage();
        int index = (currentPage - 1)*pageBean.getPageCount();
        int count = pageBean.getPageCount();
        
        if(key==null||key=="") {
        	String sql = "select * from all_competitionnotice order by  release_time desc limit ?,?";
	        
            QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
           
           
        	   try {
                   List<CompetitionNotice> list = qr.query(sql, new BeanListHandler<CompetitionNotice>(CompetitionNotice.class),index,count);
                   pageBean.setList(list);
               } catch (SQLException e) {
                   e.printStackTrace();
              
               }
   	}else {
   		   
   		String sql = "select * from all_competitionnotice where theme like '%"+key+"%' or content like '%"+key+"%' limit ?,?";
        
        QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
       
        try {
            List<CompetitionNotice> list = qr.query(sql, new BeanListHandler<CompetitionNotice>(CompetitionNotice.class),index,count);
            pageBean.setList(list);
        } catch (SQLException e) {
            e.printStackTrace();
       
        }
   	}
     
    	
  	  
    }
    public int getTotalCount(String theme) {
    	 FileService fileservice=new FileService();
    	 int num=fileservice.countFile(theme);
         return num;
    }
    public int getAllCount() {
   	 FileService fileservice=new FileService();
   	 int num=fileservice.countAllFile();
        return num;
   }
    public int getTotalCount() {
   	 FileService fileservice=new FileService();
   	 int num=fileservice.countFile();
        return num;
   }
    public int getTotalCountQues(String theme) {
      	 QuestionService fileservice=new QuestionService();
      	 int num=fileservice.countQues(theme);
           return num;
      }  
    public int getTotalFoodCount() {
    	FoodService foodservice=new FoodService();
      	 int num=foodservice.countFood();
           return num;
      }
    public int getTotalCompetionCount(String theme) {
    	ReleaseCompetitionService foodservice=new ReleaseCompetitionService();
      	 int num=foodservice.countCompetion(theme);
           return num;
      }
    public int getTotalCountCompNotice(String theme,String key) {
    	CompNoticeService fileservice=new CompNoticeService();
     	 int num=fileservice.countCompNotice(theme,key);
          return num;
     }

	
}
    

