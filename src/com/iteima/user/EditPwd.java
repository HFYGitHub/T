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
		    //���Ա���
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
						
						//����Ҫ���͵�����
						sendEmail.setReceiveMailAccount(email);
						//����8λ����֤��
						Random random=new Random();
						String str="";
						for(int i=0;i<8;i++) {
							int n=random.nextInt(10);
							str+=n;
						}
						
						//���������ɵ���֤�롣
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
						out.print(-1);//�û��������䲻һ��
					}
					
				}else {
					out.print(0);//ԭ�������
				}
			
			
			out.flush();
			out.close();
	}
	
	

}
