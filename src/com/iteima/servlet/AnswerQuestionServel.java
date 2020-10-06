package com.iteima.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iteima.domain.Answer;
import com.iteima.domain.AnswerUser;
import com.iteima.domain.Question;
import com.iteima.domain.ReplayUser;
import com.iteima.domain.User;
import com.iteima.service.AnswerQuestionService;
import com.iteima.service.QuestionService;
import com.iteima.service.UserService;
import com.iteima.test.BorrowSubOrderServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/AnswerQuestionServel"})
public class AnswerQuestionServel extends HttpServlet{

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
			/**
		 * 1.获取请求
		 * 2.检查连接到数据库中
		 */
		request.setCharacterEncoding("utf-8");
		//处理乱码：2.doGet/doPost的response方向
		response.setContentType("text/html;charset=utf-8");
			
		//1.获取请求参数
		String answer=request.getParameter("answer");
		//从登录时一直传递的参数，用户id，这是问题表里面的外键。
		String username=request.getParameter("username");
		int q_id=Integer.parseInt(request.getParameter("id"));

		String theme=request.getParameter("theme");
		int user_id=Integer.parseInt(request.getParameter("user_id"));
		UserService userservice=new UserService();
		User user1=userservice.findUserByName(username);
		int id=user1.getId();
		
		//发布时间
				java.util.Date date=new java.util.Date();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
				String release_time=sdf.format(date);	
		//输出看是否获取参数正确		
		System.out.println("回答人编号="+id+" 答案是="+answer+"时间是="+release_time);
		
		AnswerQuestionService answerQuestionService=new AnswerQuestionService();
		answerQuestionService.insertAnswer(q_id,id,answer,release_time);
		
		User user=userservice.findUserById(user_id);
		String user_name =user.getName();

		System.out.println(q_id);
		QuestionService ques=new QuestionService();
		Question question=ques.findQuesById(q_id, user_id);
		 BorrowSubOrderServiceImpl ser=new BorrowSubOrderServiceImpl();
		 List<Answer> an=ser.findCompanyAndDepts(q_id);
		 List<AnswerUser> userlist=new ArrayList<>();
		 AnswerQuestionService answerques=new AnswerQuestionService();
		 int num=0;
		 for(Answer an1:an) {
				AnswerUser anuser=new AnswerUser();
				
				
				
				User us=userservice.findUserById(an1.getUser_id());
				anuser.setQuestion_id(an1.getQuestion_id());
				anuser.setUser_id(an1.getUser_id());
				anuser.setAnswer(an1.getAnswer());
				anuser.setRelease_time(an1.getRelease_time());
				anuser.setAnswer_id(an1.getAnswer_id());
				anuser.setName(us.getName());
	            anuser.setReplayUser(an1.getReplayUser());
			   
				userlist.add(anuser);
	
				}
		 List<ReplayUser> rep=new ArrayList<>();
		
		 for(AnswerUser a:userlist) {
			 List<ReplayUser> re= answerques.getComment(a.getAnswer_id());
			 num++;
				 for(ReplayUser r:re) {
			        rep.add(r);
			        num++;
				 }
		 }

		request.setAttribute("user_name", user_name);//发布问题的用户名
		request.setAttribute("user_id", user_id);
		request.setAttribute("q_id", q_id);//发布问题的用户名
		request.setAttribute("category", question.getCategory());
		request.setAttribute("release_time", question.getRelease_time());
		request.setAttribute("title", question.getTitle());
		request.setAttribute("content", question.getContent());
		request.setAttribute("username", username);
		request.setAttribute("theme", theme);
		request.setAttribute("userlist", userlist);
		request.setAttribute("rep", rep);
		request.setAttribute("num", num);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	

}
