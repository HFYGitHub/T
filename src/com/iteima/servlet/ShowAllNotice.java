package com.iteima.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iteima.domain.CompetitionNotice;
import com.iteima.domain.PageBean;

import com.iteima.service.IPageBeanService;
import com.iteima.service.PageBeanService;

@WebServlet("/ShowAllNotice")
public class ShowAllNotice extends HttpServlet {
	 private IPageBeanService service = new PageBeanService();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//1.获取请求参数
		
		
		    String key=request.getParameter("key");
			String username=request.getParameter("username");
			String theme=request.getParameter("theme");
		    System.out.println(username);
		    System.out.println(theme);
		        try {
		            //获取“当前页”参数(第一次访问时当前页为null)
		            String currPage = request.getParameter("currentPage");
		            
		            //判断   第一次是设置默认值
		            if(currPage == null || "".equals(currPage)){
		                currPage = "1";
		            }
		            
		            //转换   从jsp获取的都是字符串型的    需转换为整形才能保存到javaBean中
		            int currentPage = Integer.parseInt(currPage);
		            
		            PageBean<CompetitionNotice> pb = new PageBean<CompetitionNotice>();
		            pb.setCurrentPage(currentPage);
		            
		            //调用service层
		            service.getAllCompNotice(pb, theme,key);
		            
		            //保存域对象
		            request.setAttribute("pageBean", pb);
		            request.setAttribute("username", username);
		            request.setAttribute("theme", theme);
		        } catch (NumberFormatException e) {
		            e.printStackTrace();
		           
		        }
		        
		        //跳转
		        request.getRequestDispatcher("/competition.jsp").forward(request, response);
	}

}
