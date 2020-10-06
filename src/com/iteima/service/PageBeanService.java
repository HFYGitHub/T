package com.iteima.service;

import com.iteima.dao.PageBeanDao;
import com.iteima.domain.Competion;
import com.iteima.domain.CompetitionNotice;
import com.iteima.domain.File;
import com.iteima.domain.Food;
import com.iteima.domain.PageBean;
import com.iteima.domain.Question;

public class PageBeanService implements IPageBeanService {
    
    // ´´½¨DaoÊµÀý
    private PageBeanDao pagebeanDao = new PageBeanDao();

    @Override
    public void getAll(PageBean<File> pb,String theme) {
        try {
        	pagebeanDao.getAll(pb,theme);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void getAllBYkey(PageBean<File> pageBean,String theme) {
    	try {
        	pagebeanDao.getAllBYkey(pageBean,theme);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void getAllFile(PageBean<File> pb,String key) {
        try {
        	pagebeanDao.getAllFile(pb,key);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
	public void getAllFood(PageBean<Food> pb,String key)
	{
    	try {
        	pagebeanDao.getAllFood(pb,key);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
    public void getAllQuestion(PageBean<Question> pb,String theme,String key) {
    	try {
        	pagebeanDao.getAllQuestion(pb,theme,key);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void getAllComp(PageBean<CompetitionNotice> pageBean,String theme) {
    	try {
        	pagebeanDao.getAllComp(pageBean,theme);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void getAllCompNotice(PageBean<CompetitionNotice> pageBean,String theme,String key) {
    	try {
        	pagebeanDao.getAllCompNotice(pageBean,theme,key);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
