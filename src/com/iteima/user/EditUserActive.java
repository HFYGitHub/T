package com.iteima.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iteima.domain.Answer;
import com.iteima.domain.AnswerUser;
import com.iteima.domain.CompetitionNotice;
import com.iteima.domain.Food;
import com.iteima.domain.FoodTalk;
import com.iteima.domain.Question;
import com.iteima.domain.QuestionUser;
import com.iteima.domain.ReplayUser;
import com.iteima.domain.User;
import com.iteima.service.AnswerQuestionService;
import com.iteima.service.CompNoticeService;
import com.iteima.service.FoodService;
import com.iteima.service.QuestionService;
import com.iteima.service.UserService;
import com.iteima.service.User_InformationService;

/**
 * Servlet implementation class EditUserActive
 */
@WebServlet("/EditUserActive")
public class EditUserActive extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//语言编码
		response.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	
		String username=request.getParameter("username");
		UserService userserivce=new UserService();
		User user=userserivce.findUserByName(username);
		int userid=user.getId();
		FoodService foodservice=new FoodService();
		List<Food> food=foodservice.findAllFoodByName(user.getId());
		QuestionService quesservice=new QuestionService();
		CompNoticeService com=new CompNoticeService();
		UserService userService=new UserService();
		AnswerQuestionService an=new AnswerQuestionService();
		List<Question> ques=quesservice.findQuesByUserId(user.getId());
		 List<CompetitionNotice> competition=com.findUserComp(user.getId());
		 List<QuestionUser> quesUser=new ArrayList<>();
		 List<User> userall=userService.findAll();
		 List<Answer> answer=an.findAll();
		 List<Answer> user_answer=an.findByUserId(userid);
		 List<FoodTalk> user_foodtalk=foodservice.findFoodTalkByName(username);
		 List<ReplayUser> user_replay=an.findByUserName(username);
		 List<AnswerUser> answeruser=new ArrayList<>();
		 List<FoodTalk> foodtalk= new ArrayList<>();
		 List<Food> allfood= foodservice.findAllFood();
		 List<ReplayUser> replay=an.findAllCom();
		 List<Question> allques=quesservice.findAllQues();
		 for(Question q:ques) {
			 
			 
			 
			QuestionUser qu=new QuestionUser();
         	User u=userService.findUserById(q.getUser_id());
			qu.setPub_username(u.getName());
         	qu.setQ_id(q.getQuestion_id());
         	if(an.findLastAnswer(q.getQuestion_id())!=null) {
         		User u1=userService.findUserById(an.findLastAnswer(q.getQuestion_id()).getUser_id());//获取最后回答的用户名
	            	qu.setLast_comment_username(u1.getName());
	            	qu.setLast_time(an.findLastAnswer(q.getQuestion_id()).getRelease_time());
	            	qu.setTotal_num(an.countAnswer(q.getQuestion_id()));
	            	
	            	
         	}else {
         		qu.setLast_comment_username("暂未回答");
	            	qu.setLast_time(q.getRelease_time());
	            	qu.setTotal_num(1);
         	}
         	quesUser.add(qu);
		 }
		
		for(Food f:food) {
			List<FoodTalk> foodtalk1=foodservice.findFoodTalk(f.getFood_id());
			for(FoodTalk talk:foodtalk1) {
				foodtalk.add(talk);
			}
		}
		
		 for(Answer a:answer) {
			 User u=userService.findUserById(a.getUser_id());
			 AnswerUser auser=new AnswerUser();
			 auser.setAnswer(a.getAnswer());
			 auser.setAnswer_id(a.getAnswer_id());
			 auser.setQuestion_id(a.getQuestion_id());
			 auser.setRelease_time(a.getRelease_time());
			 auser.setUser_id(a.getUser_id());
			 auser.setImage(u.getImage());
			 auser.setName(u.getName());
			 answeruser.add(auser);
		 }
		 request.setAttribute("allfood", allfood);
		 request.setAttribute("food", food);
		 request.setAttribute("allques", allques);
		 request.setAttribute("ques", ques);
		 request.setAttribute("foodtalk", foodtalk);
		 request.setAttribute("competition", competition);
		 request.setAttribute("quesUser", quesUser);
		 request.setAttribute("answeruser", answeruser);
		 request.setAttribute("userall", userall);
		 request.setAttribute("answer", answer);
		 request.setAttribute("replay", replay);
		 request.setAttribute("image", user.getImage());
		 request.setAttribute("username", username);
		 request.setAttribute("user_foodtalk", user_foodtalk);
		 request.setAttribute("user_answer", user_answer);
		 request.setAttribute("user_replay", user_replay);

		 request.setAttribute("userid", userid);
		 request.getRequestDispatcher("/user_active.jsp").forward(request, response);
	}

}
