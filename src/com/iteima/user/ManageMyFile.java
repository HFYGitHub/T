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
		//�������룺2.doGet/doPost��response����
		response.setContentType("text/html;charset=utf-8");
		//1.��ȡ�������
		String username=request.getParameter("username");//��ǰ��½�û�
		String th=request.getParameter("th");//��ȡ��ǰ�༭����
		String key=request.getParameter("key");
		FileService fileservice=new FileService();
		List<UserFile> uf=new ArrayList<>();
		List<UserDownFile> udf=fileservice.findFileByUser(username);//��ȡ�������ع����ļ�
		
		if(th.equals("����")){
			
			for(UserDownFile f:udf) {
				
				File file=fileservice.findFileByFile_id(f.getfileid());
				UserFile uf1=new UserFile();System.out.println(f.getUsername()+" "+file.getFilename());
				
				if(f.getUsername().toUpperCase().indexOf(key.toUpperCase())!=-1||file.getFilename().toUpperCase().indexOf(key.toUpperCase())!=-1||file.getTheme().toUpperCase().indexOf(key.toUpperCase())!=-1) {
					uf1.setDown_num(fileservice.countUserDown(username,f.getfileid() ));//ͳ�ƴ���
					uf1.setDown_time(f.getDown_time());
					uf1.setFile_id(f.getfileid());
					uf1.setFilename(file.getFilename());
					uf1.setTheme(file.getTheme());
					uf1.setUsername(f.getUsername());
					uf.add(uf1);
				}
				
			}
		}else if(th.equals("�ҵ�����")||key==null){
			
			for(UserDownFile f:udf) {
				
				File file=fileservice.findFileByFile_id(f.getfileid());
				UserFile uf1=new UserFile();
				uf1.setDown_num(fileservice.countUserDown(username,f.getfileid() ));//ͳ�ƴ���
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

