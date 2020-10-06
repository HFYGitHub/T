package com.iteima.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.iteima.domain.User;
import com.iteima.service.FoodService;
import com.iteima.service.User_InformationService;

/**
 * Servlet implementation class PublisHFood
 */
@WebServlet("/PublisHFood")
public class PublisHFood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublisHFood() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=request.getParameter("username");
		String filename = null;
		String text = null;
		String introduce = null;
		String image =null;
		// �����ϴ�ͼƬ�ı���·��
		String savePath = request.getSession().getServletContext().getRealPath("/img/img/food");
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
				String fieldName = item.getFieldName();
                // �����ǰ������ֶ���Ϊusername
                if(fieldName.equals("text")) {
                // ��ӡ��ǰ��������ݣ����û���username���������������
                	text=item.getString("UTF-8");
               }
                if(fieldName.equals("introduce")) {
                    // ��ӡ��ǰ��������ݣ����û���username���������������
               	 introduce=item.getString("UTF-8");
                   }
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
					

		             image =  filename;
		    		
		        
				} else {  //������ͼƬ�����ϴ�����ʧ��
					return ;
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		System.out.println(introduce+" "+image+" "+text);
		FoodService foodservice=new FoodService();
		foodservice.insertFood(username, introduce, image, text); 
		request.getRequestDispatcher("/FoodShareServlet?username=username").forward(request, response);
	}
}