package com.iteima.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iteima.domain.CompetitionNotice;
import com.iteima.service.CompNoticeService;

/**
 * Servlet implementation class CompeDeatils
 */

/**
 * Servlet implementation class CompetitionDeatils
 */
@WebServlet("/CompeDeatils")
public class CompeDeatils extends HttpServlet  {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompeDeatils() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int compe_id=Integer.parseInt(request.getParameter("compe_id"));
	String username=(request.getParameter("username"));
	CompNoticeService compe=new CompNoticeService();
	List<CompetitionNotice> compeNotice=compe.findCompById(compe_id);
	compe.updateLookNum(compe_id);
	compe.insertNoticeRead(compe_id, username);
	request.setAttribute("compeNotice",compeNotice);
	request.setAttribute("username",username);
	request.getRequestDispatcher("user_compedatils.jsp").forward(request, response);
	}

}
