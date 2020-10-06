package com.iteima.service;

import java.util.List;

import com.iteima.dao.AnswerQuestionDao;
import com.iteima.domain.Answer;
import com.iteima.domain.ReplayUser;

public class AnswerQuestionService {
	
public void insertAnswer(int question_id,int id,String answer,String release_time) {
		
	AnswerQuestionDao answerQuestionDao=new AnswerQuestionDao();
	answerQuestionDao.insertAnswer(question_id, id, answer, release_time);
	
 	}
public int countAnswer(int id) {
	AnswerQuestionDao answerQuestionDao=new AnswerQuestionDao();
	return answerQuestionDao.countAnswer(id);
}
public List<ReplayUser> findAllFile(int id) {
	AnswerQuestionDao answerQuestionDao=new AnswerQuestionDao();
	return answerQuestionDao.findAllFile(id);
}
public Answer findLastAnswer(int id) {
	AnswerQuestionDao answerQuestionDao=new AnswerQuestionDao();
	return answerQuestionDao.findLastAnswer(id);
	
}
public void findReplay(int id) {
	AnswerQuestionDao answerQuestionDao=new AnswerQuestionDao();
	answerQuestionDao.findReplay(id);
}
public  List<ReplayUser> getComment(int answer_id){
	AnswerQuestionDao answerQuestionDao=new AnswerQuestionDao();
	return answerQuestionDao.getComment(answer_id);
}
public void updateFabulous(int id) {
	AnswerQuestionDao answerQuestionDao=new AnswerQuestionDao();
	answerQuestionDao.updateFabulous(id);
}
public void insertComment(String username,String replay_username,String content,int id,int aid) {
	AnswerQuestionDao answerQuestionDao=new AnswerQuestionDao();
	answerQuestionDao.insertComment(username, replay_username, content, id,aid);
}
public void deleteComment(int id) {
	AnswerQuestionDao answerQuestionDao=new AnswerQuestionDao();
	answerQuestionDao.deleteComment(id);
}
public List<ReplayUser> findByUserName(String username) {
	AnswerQuestionDao answerQuestionDao=new AnswerQuestionDao();
	return answerQuestionDao.findByUserName(username);
}
public List<ReplayUser> findAllCom() {
	AnswerQuestionDao answerQuestionDao=new AnswerQuestionDao();
	return answerQuestionDao.findAllCom();
}
	public List<Answer> findAll() {
		AnswerQuestionDao answerQuestionDao=new AnswerQuestionDao();
		return answerQuestionDao.findAll();
	}
	public List<Answer> findByUserId(int id) {
		AnswerQuestionDao answerQuestionDao=new AnswerQuestionDao();
		return answerQuestionDao.findByUserId(id);
	}
}
