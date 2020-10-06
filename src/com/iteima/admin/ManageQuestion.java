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
			//1.获取请求参数
			
			
				String theme="全部";
			
			        try {
			            //获取“当前页”参数(第一次访问时当前页为null)
			            String currPage = request.getParameter("currentPage");
			            String key = request.getParameter("key");
			            //判断   第一次是设置默认值
			            if(currPage == null || "".equals(currPage)){
			                currPage = "1";
			            }
			            System.out.println(key);
			            //转换   从jsp获取的都是字符串型的    需转换为整形才能保存到javaBean中
			            int currentPage = Integer.parseInt(currPage);
			            
			            PageBean<Question> pb = new PageBean<Question>();
			            pb.setCurrentPage(currentPage);
			            
			            //调用service层
			            service.getAllQuestion(pb, theme,key);
			            
			            //保存域对象
			            request.setAttribute("pageBean", pb);
			            request.setAttribute("key", key);
			        } catch (NumberFormatException e) {
			            e.printStackTrace();
			           
			        }
			        
			        //跳转
			        request.getRequestDispatcher("/admin_question.jsp").forward(request, response);
		}
		@Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        doGet(req, resp);
	    }
	}
