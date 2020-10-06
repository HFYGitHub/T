package com.iteima.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iteima.domain.User;
import com.iteima.service.UserService;
import com.iteima.utils.MailUtil;

/**
 * Servlet implementation class EditPwd
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/EditPwd"})
public class EditPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    
		
			response.setContentType("text/html");
		    //语言编码
			response.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter  out = response.getWriter();
		    MailUtil sendEmail=new MailUtil();
		    String email = request.getParameter("email");
		    String method = request.getParameter("method");
		    String org_pwd = request.getParameter("org_pwd");

		   
			String username = request.getParameter("username");
			UserService userservice=new UserService();
			
			
				System.out.print(method);
				User user=userservice.findUserName(username); 
				
				String pwd=user.getPassword();
				System.out.println(pwd+" "+user.getPassword());
				if(pwd.equals(org_pwd)) {
					if(email.equals(user.getEmail())) {
						System.out.println(email+" "+user.getEmail());
						
						//设置要发送的邮箱
						sendEmail.setReceiveMailAccount(email);
						//创建8位发验证码
						Random random=new Random();
						String str="";
						for(int i=0;i<8;i++) {
							int n=random.nextInt(10);
							str+=n;
						}
						
						//输出随机生成的验证码。
						System.out.print(str);
						System.out.print("\n");
						System.out.print("\n");
						
						sendEmail.setInfo(str);
						try {
							sendEmail.Send();
						
						} catch (Exception e) {
							e.printStackTrace();
					}
						out.print(1);
						this.getServletContext().setAttribute("vc", str);	
					}else {
						out.print(-1);//用户名与邮箱不一致
					}
					
				}else {
					out.print(0);//原密码错误
				}
			
			
			out.flush();
			out.close();
	}
	
	

}
