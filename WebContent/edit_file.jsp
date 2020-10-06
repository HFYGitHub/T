<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Register</title>
    <meta name="description" content="Roxy">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- External CSS -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/new-user.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script type="text/javascript" src="WebContent/js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="WebContent/js/isEmail.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
 <script type="text/javascript">

$(document).ready(function() {
	$("#edit").click(function() {
		
		$("input[name='file']").attr("disabled",false);
		
		$("#f").css({display:'visible'});
		});
	
});
</script>
<body>

                   
<div class="tab-content " style="background-color: white">
    <div class="d-flex flex-row" style="padding: 15px">
        <h4 class="mr-auto">编辑资料</h4>
        <a href="/T/FileIndexServlet">
            <button class="btn btn-primary">返回</button>
        </a>
    </div>
    <div id="m1" class="container-fluid tab-pane active"><br>
    <form name="uploadForm" method="POST"
      enctype="MULTIPART/FORM-DATA"
      action="/T/EditFileServlet?file_id=${file_id }">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>赛事详情</th>
               
            </tr>
            </thead>
            <tbody>
          
              
             <c:forEach items="${file}" var="file" varStatus="status">

                <tr><td>下载次数:</td><td><input type="text"  value="${file.downnum }" name="num"  readonly="readonly"></td></tr>
                <tr><td>发布时间:</td><td><input type="text"  value="${file.time }" name="release_time"  readonly="readonly"></td></tr>
                <tr><td>资料分类:</td><td><input type="text"  value="${file.theme}" name="theme"  readonly="readonly"></td></tr>
                <tr><td>文件附件:</td><td><a><input type="text"  value="${file.filename}" name="file"  disabled="disabled"></a></td></tr>
                <tr><td>修改附件:</td><td><a> <input type="file" id="f" name="f" style="dispaly:none"/> </a></td></tr>
                 <tr>
                 <td><a ><button type="button" class="btn btn-primary" id="edit">修改</button></a> </td>
                 <td><a ><input class="btn btn-primary" type="submit" name="submit" value="保存"></a> </td>
               
             </tr>
                    
               
                
         

            </c:forEach>

             
            </tbody>
            </table>
            </form>
            </div>
            </div>
            
                    
                   
</body>
</html>

