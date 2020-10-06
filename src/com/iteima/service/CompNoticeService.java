package com.iteima.service;

import java.util.List;

import com.iteima.dao.CompNoticeDao;
import com.iteima.domain.CompetitionNotice;

public class CompNoticeService {
	
	public int countCompNotice(String theme,String key) {
		 CompNoticeDao file=new CompNoticeDao();
   	return  file.countCompNotice(theme,key);
    }
	public List<CompetitionNotice> findCompById(int id) {
		CompNoticeDao file=new CompNoticeDao();
	   	return  file.findCompById(id);
	}
	public void insertNoticeRead(int id,String username ) {
		CompNoticeDao file=new CompNoticeDao();
		file.insertNoticeRead(id, username);
	}
		public void updateDownNum(int id,String username ) {
			
			CompNoticeDao file=new CompNoticeDao();
			file.updateDownNum(id, username);
		}
		public List<CompetitionNotice> findUserComp(int user_id) {
			CompNoticeDao file=new CompNoticeDao();
		   	return  file.findUserComp(user_id);
		}
		public void updateLookNum(int id ) {
			CompNoticeDao file=new CompNoticeDao();
			file.updateLookNum(id);
		}
}
