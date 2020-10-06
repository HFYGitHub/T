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
import com.iteima.domain.ListProperties;
import com.iteima.domain.Question;
import com.iteima.domain.ReplayUser;
import com.iteima.domain.User;
import com.iteima.domain.UserWithComment;
import com.iteima.service.AnswerQuestionService;
import com.iteima.service.QuestionService;
import com.iteima.service.UserService;
import com.iteima.test.BorrowSubOrderServiceImpl;

/**
 * Servlet implementation class AllReplayShow
 */
@WebServlet("/AllReplayShow")
public class AllReplayShow extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//处理乱码：2.doGet/doPost的response方向
		response.setContentType("text/html;charset=utf-8");
			
		//1.获取请求参数
		String th=null;
		th=request.getParameter("th");
		String username=request.getParameter("username");//当前登陆用户
		int q_id=Integer.parseInt(request.getParameter("question_id"));
		String theme=request.getParameter("theme");
		int user_id=Integer.parseInt(request.getParameter("user_id"));//发布问题的用户名
		QuestionService ques=new QuestionService();
		
		if(th!=null&&th.equals("删除")) {
			ques.deleteQues(q_id);
			request.getRequestDispatcher("/ReplayAllQuestion?username="+username+"&currentPage="+"0"+"&theme="+"全部").forward(request, response);
			 return;
		}
		UserService userservice=new UserService();
		User user=userservice.findUserById(user_id);
		String user_name =user.getName();
         String image=user.getImage();
		System.out.println(q_id);
		
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
				anuser.setImage(us.getImage());
	            anuser.setReplayUser(an1.getReplayUser());
			   
				userlist.add(anuser);
	
				}
		 List<UserWithComment> rep=new ArrayList<>();
		
		 for(AnswerUser a:userlist) {
			 List<ReplayUser> re= answerques.getComment(a.getAnswer_id());
			 num++;
				 for(ReplayUser r:re) {
					 UserWithComment u=new UserWithComment();
					 UserService us=new UserService();
					 User t_us=us.findUserName(r.getUsername());
					 
					 u.setAnswer_id(r.getAnswer_id());
                    u.setContent(r.getContent());
                    u.setDeptVos(r.getReplayUser());
                    u.setFabulous(r.getFabulous());
                    u.setimage(t_us.getImage());
                    u.setRe_repaly_id(r.getRe_repaly_id());
                    u.setReplay_id(r.getReplay_id());
                    u.setReplay_username(r.getReplay_username());
                    u.setTime(r.getTime());
                    u.setUsername(r.getUsername());
					 rep.add(u);
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

		request.setAttribute("image", image);
		request.setAttribute("userlist", userlist);
		request.setAttribute("rep", rep);
		request.setAttribute("num", num);
		request.getRequestDispatcher("/showanswer.jsp").forward(request, response);
	}

	
}
