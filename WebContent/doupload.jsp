<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jspsmart.upload.SmartUpload" %> 
<%@page import="com.jspsmart.upload.SmartUpload"%>
<%@page import="com.jspsmart.upload.File"%>
<%@page import="com.iteima.service.FileService"%>

<%

    //----处理上传文件
    /*
        使用smartupload
            1、添加组件jar包至WEB-INF/lib包中
            2、设置form表单的提交类型为二进制类型
    */
    request.setCharacterEncoding("utf-8");
    //创建smartupload组件
    SmartUpload su = new SmartUpload();

    //初始化组件上下文
    su.initialize(pageContext);

    try{
        
        su.setAllowedFilesList("doc");
        su.setAllowedFilesList("zip");
        su.setAllowedFilesList("pdf");
        su.setAllowedFilesList("docx");
        su.setAllowedFilesList("rar");

        su.setAllowedFilesList("docx");
        su.setAllowedFilesList("ppt");
        su.setAllowedFilesList("pptx");
        su.setDeniedFilesList("bat");
        
        //限制上传文件的大小
        //su.setMaxFileSize(2000);

        //上传文件
        su.upload();
    }catch(Exception e){
        %>
            <script type="text/javascript">
                alert("不允许上传：bat,exe,jsp,html,htm,java,class文件类型");
                location.href="index.jsp";
            </script>
        <%
    }
    
    out.println("上传"+su.save("upload\\")+"个文件成功!!!");
    
    //得到表单项
    String theme =  new String(su.getRequest().getParameter("sear").getBytes("gbk"),"utf-8");
    
    
    /*
        实现多文件上传
    */
    for(int i = 0; i < su.getFiles().getCount(); i++){
    
        
        //获取单个文件
        File file = su.getFiles().getFile(i);
        
        //判断当前file是否选择了文件;如果没有则继续
        if(file.isMissing())continue;
        
        //设置上传服务器的位置
        String path = "download\\";
        
        //得到上传文件的名称
       // String filename = file.getFileName();
        String  filename=new String(file.getFileName().getBytes("gbk"),"utf-8"); 
        //上传文件的路径
        path = path + filename;
        //保存文件
        file.saveAs(path,SmartUpload.SAVE_VIRTUAL);
        FileService file1=new FileService();
        file1.insertFile(filename, "download/"+filename, theme);
        out.println("<table border=1>");
        out.println("<tr><td>主题:</td><td>"+theme+"</td></tr>");
        out.println("<tr><td>上传的文件名称（filename):</td><td>"+filename+"</td></tr>");
        out.println("<tr><td>上传的文件表单项名称（fliedname):</td><td>"+file.getFieldName()+"</td></tr>");
        out.println("<tr><td>上传的文件的大小（长度）（size):</td><td>"+file.getSize()+"</td></tr>");
        out.println("<tr><td>上传的文件的扩展名（ext):</td><td>"+file.getFileExt()+"</td></tr>");
        out.println("</table><br/>");
        
    }

%>
