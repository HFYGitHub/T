package com.iteima.service;

import java.util.List;


import com.iteima.dao.QuestionShowDao;
import com.iteima.domain.Question;

public class QuestionShow {

	public List<Question> Questionshow(String category){
		 QuestionShowDao questionShowDao=new QuestionShowDao();
   	 return questionShowDao.Questionshow(category);
	}
	
}
