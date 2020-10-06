package com.iteima.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iteima.domain.Answer;
import com.iteima.domain.AnswerUser;
import com.iteima.domain.Question;
import com.iteima.domain.ReplayUser;
import com.iteima.domain.User;
import com.iteima.service.AnswerQuestionService;
import com.iteima.service.QuestionService;
import com.iteima.service.UserService;

/**
 * Servlet implementation class EditQuestion
 */
@WebServlet("/EditQuestion")
public class EditQuestion extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1.获取请求
		 * 2.检查连接到数据库中
		 * 3.检查用户名密码是否在正确
		 * 4.登陆成功，显示用户信息
		 * 5.登陆失败给一个错误提示
		 */
		HttpSession session=request.getSession();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
	    String th=request.getParameter("th");
	    int question_id = Integer.parseInt(request.getParameter("question_id"));
	    int user_id = Integer.parseInt(request.getParameter("user_id"));
	    System.out.println(question_id+" "+user_id+" "+th);
	    QuestionService ques=new QuestionService();
	    if(th.equals("删除")) {
	    	//1.获取请求参数
			
	    	
			
			 ques.deleteQues(question_id);
			 
			 request.getRequestDispatcher("/ManageQuestion").forward(request, response);
	    }else {
	    	UserService userservice=new UserService();
			User user=userservice.findUserById(user_id);
			String user_name =user.getName();
			
			Question question=ques.findQuesById(question_id, user_id);
			List<Answer> answer=ques.findAnById(question_id);
			List<AnswerUser> userlist=new ArrayList<>();
			List<List<ReplayUser>> replay = new ArrayList<>();
			AnswerQuestionService answerques=new AnswerQuestionService();
			int num=0;
			for(Answer an:answer) {
				System.out.println(an.getAnswer_id());
				AnswerUser anuser=new AnswerUser();
				num++;
				List<ReplayUser> replay1=answerques.findAllFile(an.getAnswer_id());
		             
			      for(ReplayUser r:replay1) {
			    	  System.out.println(r.getContent());
			      }
				User us=userservice.findUserById(an.getUser_id());
				anuser.setQuestion_id(an.getQuestion_id());
				anuser.setUser_id(an.getUser_id());
				anuser.setAnswer(an.getAnswer());
				anuser.setRelease_time(an.getRelease_time());
				anuser.setAnswer_id(an.getAnswer_id());
				anuser.setName(us.getName());
				userlist.add(anuser);
				replay.add( replay1);
				
			}
			
			request.setAttribute("user_name", user_name);//发布问题的用户名
			request.setAttribute("user_id", user_id);
			request.setAttribute("q_id", question_id);//发布问题的用户名
			request.setAttribute("category", question.getCategory());
			request.setAttribute("release_time", question.getRelease_time());
			request.setAttribute("title", question.getTitle());
			request.setAttribute("content", question.getContent());
			request.setAttribute("userlist", userlist);
			request.setAttribute("num", num);
			request.setAttribute("replay", replay);
			 request.getRequestDispatcher("/admin_showanswer.jsp").forward(request, response);
	    }
     	
	}
	}