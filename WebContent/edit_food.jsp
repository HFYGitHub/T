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

	// 获取验证码按钮
	$("#edit").click(function() {
		var org_filename="C2M1.pdf";
		var filename=$("#filename").val();
		var theme=$("#theme").val();;
		alert(theme);
		alert(filename);
		$.ajax({
			url: 'EditFileServlet',
			type: 'post',
			data: {theme:theme,
				filename:filename,
				org_filename: org_filename},
			dataType: 'text',
			success: function() {
				alert("修改成功");
			}
		});
	});
});
</script>
<body>
<a href="/T/FoodIndexServlet">返回</a>
<div id="m1" class="container tab-pane active"><br>
     <table class="table table-hover">


                     <thead>
                    <tr>
                        <th>编号</th>
                        <th>评论></th>
                        <th>分享时间</th>
                        <th>用户名</th>
                    </tr>
                    </thead>
                     <c:forEach items="${food}" var="food" varStatus="status">
					<tr>
					<td>${status.index + 1}</td>	
                    <td>${food.content }</td>
                     <td>${food.time }</td>
                    <td>${food.username }</td>
                    </tr>
                     
                     </c:forEach>
                    
                    </table>
     </div>              
</body>
</html>