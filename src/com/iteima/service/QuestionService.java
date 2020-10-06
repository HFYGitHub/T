package com.iteima.service;

import java.util.List;

import com.iteima.dao.QuestionDao;
import com.iteima.domain.Answer;
import com.iteima.domain.Question;

public class QuestionService {
	public void insertQues(int id,String category,String title,String content,String release_time) {
		
		QuestionDao quesdao=new QuestionDao();
    	 quesdao.insertQues(id,category,title,content,release_time);
 	}
	public List<Question> findAllQuestion() {

		QuestionDao quesdao=new QuestionDao();
		return quesdao.findAllQuestion();
		
	}
	public List<Question> getDetails(String theme){
		QuestionDao quesdao=new QuestionDao();
		return quesdao.getDetails(theme);
	}
	 public int countQues(String theme) {
		 QuestionDao quesdao=new QuestionDao();
    	return  quesdao.countQues(theme);
     }
	 public Question findQuesById(int id,int user_id) {
		 QuestionDao quesdao=new QuestionDao();
	    	return  quesdao.findQuesById(id,user_id);
	 }
		public List<Answer> findAnById(int id) {
		 QuestionDao quesdao=new QuestionDao();
	    	return  quesdao.findAnById(id);
	 }
		public List<Question> findAllQues() {
			QuestionDao quesdao=new QuestionDao();
	    	return  quesdao.findAllQues();
		}
		public void deleteQues(int id) {
			QuestionDao quesdao=new QuestionDao();
			quesdao.deleteQues(id);
		}
		public void deleteAnswe(int id) {
			QuestionDao quesdao=new QuestionDao();
			quesdao.deleteAnswe(id);
		}
		public List<Question> findAnByTh(String th) {
			QuestionDao quesdao=new QuestionDao();
	    	return  quesdao.findAnByTh(th);
		}
		public List<Question> findQuesByUserId(int id) {
			QuestionDao quesdao=new QuestionDao();
	    	return  quesdao.findQuesByUserId(id);
		}
}
