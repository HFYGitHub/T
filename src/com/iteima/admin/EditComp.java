package com.iteima.admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.iteima.domain.CompetitionNotice;
import com.iteima.domain.User;
import com.iteima.domain.UserReadComp;
import com.iteima.domain.compRead;
import com.iteima.service.FileService;
import com.iteima.service.ReleaseCompetitionService;
import com.iteima.service.UserService;

/**
 * Servlet implementation class EditComp
 */
@WebServlet("/EditComp")
public class EditComp extends HttpServlet {
	public EditComp() {
		// TODO Auto-generated constructor stub
		System.out.println("��ʼ��");
		
	}
	 private String tempPath;    // ��ʱ�ļ�Ŀ¼  
	 
	    // ��ʼ��  
	    public void init(ServletConfig config) throws ServletException  
	    {  
	        
	 
	       
	      
	        tempPath = "temp";  
	 
	        System.out.println("�ļ����Ŀ¼����ʱ�ļ�Ŀ¼׼����� ...");  
	    }  
	      
	    // doPost  
	    public void doPost(HttpServletRequest req, HttpServletResponse res)  
	        throws IOException, ServletException  
	    {  
	    	 res.setContentType("text/plain;charset=gbk"); 
	    	req.setCharacterEncoding("utf-8");
	    	
	    	
	    	String content=null;
	    	String path=req.getSession().getServletContext().getRealPath("/download");
	        
	        PrintWriter pw = res.getWriter();  
	        try{  
	            DiskFileItemFactory diskFactory = new DiskFileItemFactory();  
	            // threshold ���ޡ��ٽ�ֵ����Ӳ�̻��� 1M  
	            diskFactory.setSizeThreshold(4 * 1024);  
	            // repository �����ң�����ʱ�ļ�Ŀ¼  
	            diskFactory.setRepository(new File(tempPath));  
	          
	            ServletFileUpload upload = new ServletFileUpload(diskFactory);  
	            // ���������ϴ�������ļ���С 4M  
	            upload.setSizeMax(20 * 1024 * 1024);  
	            // ����HTTP������Ϣͷ  
	            List fileItems = upload.parseRequest(req);  
	            Iterator iter = fileItems.iterator();  
	            while(iter.hasNext())  
	            {  
	                FileItem item = (FileItem)iter.next();  
	                if(item.isFormField())  
	                {  
	                    System.out.println("��������� ...");  
	                    String fieldName = item.getFieldName();
	                    // �����ǰ������ֶ���Ϊusername
	                    if(fieldName.equals("content")) {
	                    // ��ӡ��ǰ��������ݣ����û���username���������������
	                    	content=item.getString("UTF-8");
	                   }
	                    processFormField(item, pw);  
	                }else{  
	                    System.out.println("�����ϴ����ļ� ...");  
	                    // ��ʱ���ļ���������������·������ע��ӹ�һ��  
	                    String filename = item.getName();    
	    		        filename = new String(filename.getBytes("gbk"),"utf-8");
	    		        System.out.println("�������ļ�����" + filename);  
	    		        int index = filename.lastIndexOf("\\");
	    		        filename = filename.substring(index + 1, filename.length());  
	    		 
	    		        long fileSize = item.getSize();  
	    		 
	    		        if("".equals(filename) && fileSize == 0)  
	    		        {             
	    		            System.out.println("�ļ���Ϊ�� ..."); 
	    		            
	    		            
	    		            int id=Integer.parseInt(req.getParameter("id"));
	    			        
		    			       
	    			        
	    			        
	    					 ReleaseCompetitionService fileservice=new ReleaseCompetitionService();
	    					 CompetitionNotice THIS=fileservice.findById(id);
	    					 String org_content=THIS.getcontent();
	    					 String org_file=THIS.getFile();
	    					
	    					 if(content==null) {
	    						 content=org_content;
	    					 }
	    					 
	    					 fileservice.updateFile(content,org_file,id);
	    				
	    					 
	    					 
	    					 
	    					 ReleaseCompetitionService readservice=new ReleaseCompetitionService();
	    					 UserService userservice=new UserService();
	    			 	      List<CompetitionNotice> comp=readservice.findCopmById(id);
	    				      List<compRead> comread=readservice.findRead(id);
	    				      List<UserReadComp> userlist=new ArrayList<>();
	    				      int num=0;
	    				      for(compRead an:comread) {
	    				    	  UserReadComp anuser=new UserReadComp();
	    							num++;
	    							
	    							User us=userservice.findUserById(an.getUser_id());
	    							
	    							anuser.setDown_num(an.getDown_num());
	    							anuser.setLook_num(an.getLook_num());
	    							anuser.setLook_time(an.getLook_time());
	    							anuser.setName(us.getName());
	    							anuser.setNotice_id(an.getNotice_id());
	    							anuser.setUser_id(an.getUser_id());
	    							userlist.add(anuser);
	    						}
	    				      req.getSession().setAttribute("num",num);
	    				      req.getSession().setAttribute("comp",comp);
	    				      req.getSession().setAttribute("id",id);
	    				      req.getSession().setAttribute("userlist",userlist);
	    				      req.getRequestDispatcher("/edit_comp.jsp").forward(req, res);
	    		            return;  
	    		        }  
	    		 
	    		        File uploadFile = new File(path + "/" + filename);  
	    		        System.out.println(uploadFile);
	    		       if(! uploadFile.exists()) {
	    		    	    item.write(uploadFile);  
	    			       
	    			        int id=Integer.parseInt(req.getParameter("id"));
	    			        
	    			       
	    			        
	    			        
	    					 ReleaseCompetitionService fileservice=new ReleaseCompetitionService();
	    					 CompetitionNotice THIS=fileservice.findById(id);
	    					 String org_content=THIS.getcontent();
	    					 
	    					 if(content==null) {
	    						 content=org_content;
	    					 }
	    					
	    					 fileservice.updateFile(content,filename,id);
	    					 ReleaseCompetitionService readservice=new ReleaseCompetitionService();
	    					 UserService userservice=new UserService();
	    			 	      List<CompetitionNotice> comp=readservice.findCopmById(id);
	    				      List<compRead> comread=readservice.findRead(id);
	    				      List<UserReadComp> userlist=new ArrayList<>();
	    				      int num=0;
	    				      for(compRead an:comread) {
	    				    	  UserReadComp anuser=new UserReadComp();
	    							num++;
	    							
	    							User us=userservice.findUserById(an.getUser_id());
	    							
	    							anuser.setDown_num(an.getDown_num());
	    							anuser.setLook_num(an.getLook_num());
	    							anuser.setLook_time(an.getLook_time());
	    							anuser.setName(us.getName());
	    							anuser.setNotice_id(an.getNotice_id());
	    							anuser.setUser_id(an.getUser_id());
	    							userlist.add(anuser);
	    						}
	    				      req.getSession().setAttribute("num",num);
	    				      req.getSession().setAttribute("comp",comp);
	    				      req.getSession().setAttribute("id",id);
	    				      req.getSession().setAttribute("userlist",userlist);
	    				      req.getRequestDispatcher("/edit_comp.jsp").forward(req, res);
	    				      return;
	    		       } else {
	    		    	   req.getRequestDispatcher("/edit_comp.jsp").forward(req, res);
	    		    	   return;
	    		    	  // req.getRequestDispatcher("/error.jsp").forward(req, res);
	    		       }
	                }  
	            }// end while()  
	 
	            pw.close();  
	        }catch(Exception e){  
	            System.out.println("ʹ�� fileupload ��ʱ�����쳣 ...");  
	          //  req.getRequestDispatcher("/error.jsp").forward(req, res);
	        }// end try ... catch ...  
	        
	        
	        
	    	
	        
	    }// end doPost()  
	 
	 
	    // ���������  
	    private void processFormField(FileItem item, PrintWriter pw)  
	        throws Exception  
	    {  
	        String name = item.getFieldName();  
	        String value = item.getString();          
	        pw.println(name + " : " + value + "\r\n");  
	    }  
	      
	  
	      
	    // doGet  
	    public void doGet(HttpServletRequest req, HttpServletResponse res)  
	        throws IOException, ServletException  
	    {  
	        doPost(req, res);  
	    }  
	


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	

}
