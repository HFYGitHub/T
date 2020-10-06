package com.iteima.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.iteima.dao.PhotoDao;
import com.iteima.dao.User_InformationDao;
import com.iteima.domain.User;
import com.iteima.service.User_InformationService;

@WebServlet("/PhotoServlet")
public class PhotoServlet extends HttpServlet {
	public PhotoServlet() {
		super();
	}
     
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
    
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=request.getParameter("username");
		String method = request.getParameter("method");
		request.setAttribute("message", "");
		request.setAttribute("path", "");
		String filename = null;
		// �����ϴ�ͼƬ�ı���·��
		String savePath = request.getSession().getServletContext().getRealPath("/imgs");
		File file = new File(savePath);
		// �ж��ϴ��ļ��ı���Ŀ¼�Ƿ����
		if (!file.exists() && !file.isDirectory()) {
			System.out.println(savePath + "Ŀ¼�����ڣ���Ҫ����");
			// ����Ŀ¼
			file.mkdir();
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 2������һ���ļ��ϴ�������
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		// 3���ж��ύ�����������Ƿ����ϴ���������
		if (!ServletFileUpload.isMultipartContent(request)) {
			// ���մ�ͳ��ʽ��ȡ����
			return;
		}
		try {
			List<FileItem> list = upload.parseRequest(request);
			System.out.println(list.toString());// �ļ���·�� �Լ������·��
			for (FileItem item : list) {
				 filename = item.getName();// ���һ������ļ�����
				if (filename == null || filename.trim().equals("")) {// �����Մt���^
					continue;
				}
				// ���e ��Ҫ�^�V�ļ����Q java.io.FileNotFoundException:
				// G:\����02\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\FaceUp\WEB-INF\images\C:\Users\Ray\Pictures\2.jpeg
				// (�ļ�����Ŀ¼�������﷨����ȷ��)
 
				filename = filename.substring(filename.lastIndexOf("\\") + 1);
//				System.out.print(filename);
				if (filename.substring(filename.lastIndexOf(".") + 1).equals("png")
						|| filename.substring(filename.lastIndexOf(".") + 1).equals("jpg")
						|| filename.substring(filename.lastIndexOf(".") + 1).equals("jpeg")) {
					InputStream in = item.getInputStream();// �@���ς���ݔ����
					FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);// ָ��web-infĿ��µ�images�ļ�
		
                     
					int len = 0;
					byte buffer[] = new byte[1024];
					while ((len = in.read(buffer)) > 0)// ÿ���xȡ
					{
						out.write(buffer, 0, len);
					}
					in.close();
					out.close();
					item.delete();
					

		            String image =  filename;
		    		
		    		System.out.println(image+" "+username);
		    		User_InformationService user_InformationDao=new User_InformationService();
		    		user_InformationDao.UpdateImage(image, username);
		        
				} else {  //������ͼƬ�����ϴ�����ʧ��
					return ;
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		  User_InformationService user_InformationService=new User_InformationService();
			 List<User> allinformation=user_InformationService.Show_Information(username);
			  System.out.println(allinformation);
			 request.setAttribute("allinformation", allinformation);
			 request.setAttribute("username", username);
			 request.getRequestDispatcher("/user_information.jsp").forward(request, response);
		
	}
}