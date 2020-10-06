package com.iteima.servlet;

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
import com.iteima.domain.Question;
import com.iteima.domain.ReplayUser;
import com.iteima.domain.User;
import com.iteima.service.AnswerQuestionService;
import com.iteima.service.QuestionService;
import com.iteima.service.UserService;
import com.iteima.test.BorrowSubOrderServiceImpl;

/**
 * Servlet implementation class ManageCmmment
 */




@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/ManageCmmment"})
public class ManageCmmment extends HttpServlet {
	public ManageCmmment() {
		// TODO Auto-generated constructor stub
		System.out.println("初始化");
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		doPost(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		//处理乱码：2.doGet/doPost的response方向
		response.setContentType("text/html;charset=utf-8");
			
		//1.获取请求参数
		String th=request.getParameter("th");
		String username=request.getParameter("username");//当前登陆用户
		int q_id=Integer.parseInt(request.getParameter("question_id"));
		String theme=request.getParameter("theme");
		int user_id=Integer.parseInt(request.getParameter("user_id"));//发布问题的用户名
		 AnswerQuestionService answerques1=new AnswerQuestionService();
		int replay_id=Integer.parseInt(request.getParameter("replay_id"));
		if(th.equals("点赞")) {
			System.out.println("ll");
			
			 answerques1.updateFabulous(replay_id);
		}else if(th.equals("删除")){
			System.out.println("删除");
			 answerques1.deleteComment(replay_id);
		}
		else{
			String content=request.getParameter("content");
			String rep_username=request.getParameter("replay_username");//当前用户回复的用户名
			int re_replay_id=Integer.parseInt(request.getParameter("re_replay_id"));//当前用户回复的用户的replay_Id
			answerques1.insertComment(username, rep_username, content, re_replay_id,1);
		}
		
		
		
		UserService userservice=new UserService();
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

