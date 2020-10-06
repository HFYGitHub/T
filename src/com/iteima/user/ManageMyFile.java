package com.iteima.user;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iteima.domain.File;
import com.iteima.domain.User;
import com.iteima.domain.UserDownFile;
import com.iteima.domain.UserFile;
import com.iteima.service.FileService;
import com.iteima.service.User_InformationService;

@WebServlet("/ManageMyFile")
public class ManageMyFile extends HttpServlet{
private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		//处理乱码：2.doGet/doPost的response方向
		response.setContentType("text/html;charset=utf-8");
		//1.获取请求参数
		String username=request.getParameter("username");//当前登陆用户
		String th=request.getParameter("th");//获取当前编辑条件
		String key=request.getParameter("key");
		FileService fileservice=new FileService();
		List<UserFile> uf=new ArrayList<>();
		List<UserDownFile> udf=fileservice.findFileByUser(username);//获取所有下载过的文件
		
		if(th.equals("搜索")){
			
			for(UserDownFile f:udf) {
				
				File file=fileservice.findFileByFile_id(f.getfileid());
				UserFile uf1=new UserFile();System.out.println(f.getUsername()+" "+file.getFilename());
				
				if(f.getUsername().toUpperCase().indexOf(key.toUpperCase())!=-1||file.getFilename().toUpperCase().indexOf(key.toUpperCase())!=-1||file.getTheme().toUpperCase().indexOf(key.toUpperCase())!=-1) {
					uf1.setDown_num(fileservice.countUserDown(username,f.getfileid() ));//统计次数
					uf1.setDown_time(f.getDown_time());
					uf1.setFile_id(f.getfileid());
					uf1.setFilename(file.getFilename());
					uf1.setTheme(file.getTheme());
					uf1.setUsername(f.getUsername());
					uf.add(uf1);
				}
				
			}
		}else if(th.equals("我的下载")||key==null){
			
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
			
			
		}
		
		 request.setAttribute("username", username);
		 request.setAttribute("uf", uf);
		 request.getRequestDispatcher("/user_download.jsp").forward(request, response);
		
	}

	
		 
	

	

}

