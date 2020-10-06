package com.iteima.service;

import com.iteima.domain.Competion;
import com.iteima.domain.CompetitionNotice;
import com.iteima.domain.File;
import com.iteima.domain.Food;
import com.iteima.domain.PageBean;
import com.iteima.domain.Question;

public interface IPageBeanService {
	public void getAll(PageBean<File> pb,String theme);
	public void getAllFile(PageBean<File> pb,String key) ;
	public void getAllFood(PageBean<Food> pb,String key) ;
	public void getAllQuestion(PageBean<Question> pb,String theme,String key);
	public void getAllComp(PageBean<CompetitionNotice> pageBean,String theme);
	 public void getAllCompNotice(PageBean<CompetitionNotice> pageBean,String theme,String key);
	 public void getAllBYkey(PageBean<File> pageBean,String theme) ;
}
