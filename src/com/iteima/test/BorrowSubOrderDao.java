//package com.iteima.servlet;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.iteima.domain.Answer;
//import com.iteima.domain.AnswerUser;
//import com.iteima.domain.ListProperties;
//import com.iteima.domain.Question;
//import com.iteima.domain.ReplayUser;
//import com.iteima.domain.User;
//import com.iteima.service.AnswerQuestionService;
//import com.iteima.service.QuestionService;
//import com.iteima.service.UserService;
//
///**
// * Servlet implementation class AllReplayShow
// */
//@WebServlet("/AllReplayShow")
//public class AllReplayShow extends HttpServlet {
//	
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		//处理乱码：2.doGet/doPost的response方向
//		response.setContentType("text/html;charset=utf-8");
//			
//		//1.获取请求参数
//	
//		String username=request.getParameter("username");//当前登陆用户
//		int q_id=Integer.parseInt(request.getParameter("question_id"));
//		String theme=request.getParameter("theme");
//		int user_id=Integer.parseInt(request.getParameter("user_id"));//发布问题的用户名
//		UserService userservice=new UserService();
//		User user=userservice.findUserById(user_id);
//		String user_name =user.getName();
//		QuestionService ques=new QuestionService();
//		Question question=ques.findQuesById(q_id, user_id);
//		List<Answer> answer=ques.findAnById(q_id);
//		List<AnswerUser> userlist=new ArrayList<>();
//		List<List<ReplayUser>> replay = new ArrayList<>();
//		List<List<ReplayUser>> allcomments = new ArrayList<>();
//		List<ReplayUser> allcomment =new ArrayList<>();
//		AnswerQuestionService answerques=new AnswerQuestionService();
//		List<ListProperties>   ppList = new ArrayList<ListProperties>();
//		
//		      
//		 
//		 
//		int num=0;
//		for(Answer an:answer) {
//			AnswerUser anuser=new AnswerUser();
//			num++;
//			List<ReplayUser> replay1=answerques.findAllFile(an.getAnswer_id());
//			
//			
//			User us=userservice.findUserById(an.getUser_id());
//			anuser.setQuestion_id(an.getQuestion_id());
//			anuser.setUser_id(an.getUser_id());
//			anuser.setAnswer(an.getAnswer());
//			anuser.setRelease_time(an.getRelease_time());
//			anuser.setAnswer_id(an.getAnswer_id());
//			anuser.setName(us.getName());
//
//		    allcomment=answerques.getComment(an.getAnswer_id());
//			allcomments.add(allcomment);
//			userlist.add(anuser);
//			replay.add( replay1);
//
//			}
//		
//		  ListProperties listProperties = null;
//	        int key = 0;
//	        for (List<ReplayUser> pp : allcomments) {
//	            listProperties = new ListProperties();
//	            listProperties.setValueList(pp);
//	            listProperties.setKey(key+"");
//	            key++;
//	            ppList.add(listProperties);
//	          
//	        }
//		
//		request.setAttribute("user_name", user_name);//发布问题的用户名
//		request.setAttribute("user_id", user_id);
//		request.setAttribute("q_id", q_id);//发布问题的用户名
//		request.setAttribute("category", question.getCategory());
//		request.setAttribute("release_time", question.getRelease_time());
//		request.setAttribute("title", question.getTitle());
//		request.setAttribute("content", question.getContent());
//		request.setAttribute("userlist", userlist);
//		request.setAttribute("num", num);
//		request.setAttribute("username", username);
//		request.setAttribute("theme", theme);
//		request.setAttribute("replay", replay);
//		request.setAttribute("ppList", ppList);
//		 request.getRequestDispatcher("/showanswer.jsp").forward(request, response);
//	}
//
//	
//}
