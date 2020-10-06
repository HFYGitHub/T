package com.iteima.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iteima.domain.PageBean;
import com.iteima.domain.Question;
import com.iteima.service.IPageBeanService;
import com.iteima.service.PageBeanService;

/**
 * Servlet implementation class ManageQuestion
 */
@WebServlet("/ManageQuestion")
public class ManageQuestion extends HttpServlet {
	 private IPageBeanService service = new PageBeanService();
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session=request.getSession();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			//1.��ȡ�������
			
			
				String theme="ȫ��";
			
			        try {
			            //��ȡ����ǰҳ������(��һ�η���ʱ��ǰҳΪnull)
			            String currPage = request.getParameter("currentPage");
			            String key = request.getParameter("key");
			            //�ж�   ��һ��������Ĭ��ֵ
			            if(currPage == null || "".equals(currPage)){
			                currPage = "1";
			            }
			            System.out.println(key);
			            //ת��   ��jsp��ȡ�Ķ����ַ����͵�    ��ת��Ϊ���β��ܱ��浽javaBean��
			            int currentPage = Integer.parseInt(currPage);
			            
			            PageBean<Question> pb = new PageBean<Question>();
			            pb.setCurrentPage(currentPage);
			            
			            //����service��
			            service.getAllQuestion(pb, theme,key);
			            
			            //���������
			            request.setAttribute("pageBean", pb);
			            request.setAttribute("key", key);
			        } catch (NumberFormatException e) {
			            e.printStackTrace();
			           
			        }
			        
			        //��ת
			        request.getRequestDispatcher("/admin_question.jsp").forward(request, response);
		}
		@Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        doGet(req, resp);
	    }
	}
