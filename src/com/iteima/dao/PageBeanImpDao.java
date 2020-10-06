package com.iteima.dao;

import com.iteima.domain.Competion;
import com.iteima.domain.CompetitionNotice;
import com.iteima.domain.File;
import com.iteima.domain.Food;
import com.iteima.domain.PageBean;
import com.iteima.domain.Question;

public interface PageBeanImpDao {
	
		   /*
	     * 分页查询数据
	     * */
	    public  void  getAll(PageBean<File> pageBean,String theme);
	    
	    /*
	     * 查询总记录数
	     * */
	    public int getTotalCount(String theme);
	    public void getAllQuestion(PageBean<Question> pageBean,String theme,String key) ;
	    public void getAllFile(PageBean<File> pb,String key) ;
	    public void getAllFood(PageBean<Food> pb,String key);
	    public void getAllCompNotice(PageBean<CompetitionNotice> pageBean,String theme,String key) ;
	    public void getAllComp(PageBean<CompetitionNotice> pageBean,String theme);
	    public void getAllBYkey(PageBean<File> pageBean,String key) ;
	         
	}

