<%@ page language="java" contentType="text/html; charset=UTF-8" 
 pageEncoding="UTF-8"%> 
 <%@ page import="com.jspsmart.upload.SmartUpload"%>
<%@ page import="com.jspsmart.upload.SmartUploadException"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="com.iteima.service.FileService"%>
<%
response.setCharacterEncoding("utf-8");  
response.setHeader("iso-8859-1","utf-8");  
request.setCharacterEncoding("utf-8");  
response.reset();
String name=request.getParameter("filename");
String username=request.getParameter("username");
String currentpage=request.getParameter("currentpage");
int file_id = Integer.parseInt(request.getParameter("file_id"));

String theme=request.getParameter("theme");
SmartUpload su = new SmartUpload();//创建对象
su.initialize(getServletConfig(), request, response);//初始化
try {
    su.downloadFile("/download/"+name);//路径加文件名
    //su.setContentDisposition();
} catch (SmartUploadException e) {
    e.printStackTrace();
}

FileService fileservice=new FileService();
fileservice.updateDownNum(name);
fileservice.insertUserD(file_id,username);

%>
<!DOCTYPE html > 
 
<html lang="en"> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>Insert title here</title> 
</head> 
<body> 

 
</body> 
</html> 
