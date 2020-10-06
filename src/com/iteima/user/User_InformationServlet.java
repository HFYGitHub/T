package com.iteima.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iteima.domain.CompetitionNotice;
import com.iteima.domain.File;
import com.iteima.domain.Food;
import com.iteima.domain.PageBean;
import com.iteima.domain.User;
import com.iteima.domain.UserDownFile;
import com.iteima.domain.UserFile;
import com.iteima.service.FileService;
import com.iteima.service.FoodService;
import com.iteima.service.IPageBeanService;
import com.iteima.service.PageBeanService;
import com.iteima.service.UserService;
import com.iteima.service.User_InformationService;



@WebServlet("/User_InformationServlet")
public class User_InformationServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//1.获取请求参数
		
		String username=request.getParameter("username");
		FileService fileservice=new FileService();
		List<UserFile> uf=new ArrayList<>();
		List<UserDownFile> udf=fileservice.findFileByUser(username);//获取所有下载过的文件
		
		for(UserDownFile f:udf) {
			
			File file=fileservice.findFileByFile_id(f.getfileid());
			UserFile uf1=new UserFile();
			uf1.setDown_num(fileservice.countUserDown(username,f.getfileid() ));//统计次数
			uf1.setDown_time(f.getDown_time());
			uf1.setFile_id(f.getfileid());
			uf1.setFilename(file.getFilename());
			uf1.setTheme(file.getTheme());
			uf1.setUsername(f.getUsername());
			uf.add(uf1);
		}
		
		User_InformationService user_InformationService=new User_InformationService();
		UserService userservice=new UserService();
		
		User u=userservice.findUserByName(username);
		  String image=u.getImage();
		  List<User> allinformation=user_InformationService.Show_Information(username);
		  System.out.println(allinformation);
		 request.setAttribute("allinformation", allinformation);
		 request.setAttribute("username", username);
		 request.setAttribute("image", image);
		 request.setAttribute("uf", uf);
		
		 request.getRequestDispatcher("/user_information.jsp").forward(request, response);
		
	}
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doGet(request, response);
		    
	 }
}
