package com.iteima.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.iteima.dao.FoodDao;
import com.iteima.dao.ReleaseCompetitionDao;
import com.iteima.domain.Competion;
import com.iteima.domain.CompetitionNotice;
import com.iteima.domain.compRead;
import com.iteima.utils.JdbcUtil;

public class ReleaseCompetitionService {

	public void insertCompetition(String theme,String content,String release_time,String file,String competition_name) 
		 {
		
	ReleaseCompetitionDao releaseCompetitionDao=new ReleaseCompetitionDao();
	releaseCompetitionDao.insertCompetition(theme, content, release_time, file, competition_name);
 	
		 
		 }
public void insertCompetitionFile(int notice_id,String filename,String path) {
	ReleaseCompetitionDao releaseCompetitionDao=new ReleaseCompetitionDao();
	releaseCompetitionDao.insertCompetitionFile(notice_id, filename, path);
 	
}
public int countCompetion(String theme) {
	ReleaseCompetitionDao releaseCompetitionDao=new ReleaseCompetitionDao();
	return  releaseCompetitionDao.countCompetion(theme);
}
public void deleteComp(int id) {
	ReleaseCompetitionDao releaseCompetitionDao=new ReleaseCompetitionDao();
	releaseCompetitionDao.deleteComp(id);
}
public List<CompetitionNotice> findCopmById(int id) {
	ReleaseCompetitionDao releaseCompetitionDao=new ReleaseCompetitionDao();
	return releaseCompetitionDao.findCopmById(id);
}
public CompetitionNotice findById(int id) {
	ReleaseCompetitionDao releaseCompetitionDao=new ReleaseCompetitionDao();
	return releaseCompetitionDao.findById(id);
	
}
public List<compRead> findRead(int id) {
	ReleaseCompetitionDao releaseCompetitionDao=new ReleaseCompetitionDao();
	return releaseCompetitionDao.findRead(id);
}
public void updateFile(String content,String theme,int id) {
	ReleaseCompetitionDao releaseCompetitionDao=new ReleaseCompetitionDao();
	releaseCompetitionDao.updateFile(content, theme, id);
}
}
