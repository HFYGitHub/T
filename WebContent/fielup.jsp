<%@ page language="java" contentType="text/html; charset=UTF-8" 
 pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>Insert title here</title> 
</head> 
<body> 
 <form action="http://localhost:8080/T/FileUpload" method="post" enctype="multipart/form-data"> 
 <br> 
 文件一：<input type="file" name="file1" /> <br> 
 文件二：<input type="file" name="file2" /> <br> 
 上传者:<input type="text" name="uploader"/> <br> 
  日期:<input type="text" name="date"/> <br> 
  <input type="submit" value="提交"/> 
  
 </form> 
</body> 
</html> 