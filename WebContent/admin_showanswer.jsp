<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>管理员界面</title>
    <meta name="description" content="Roxy">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- External CSS -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/template2.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="js/t2.js"></script>
    <script   type="text/javascript">
        var s_height = window.screen.height;
        var s_width = window.screen.width;
    </script>


    <style>
        .first-title{
            background-color: #6BBB45;

        }
        .carousel-inner img {
            width: 100%;
            height: 300px;
        }
    </style>
    </head>
<body>
<div class="tab-content " style="background-color: white">
            <div class=""><h4>帖子管理</h4></div>
            <div id="m1" class="container tab-pane active"><br>
             <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>回答用户</th>
                        <th>时间</th>
                        <th>回复内容</th>
                        <th>留言回复内容</th>
                        <th>回复用户名</th>
                        <th>点赞数</th>
                         <th>时间</th>
                    </tr>
                    </thead>
                    <c:forEach items="${userlist}" var="answer">
                    <tbody>
                    <tr>
                   <td>${answer.name }</td>
                   <td>发表于 ${answer.release_time}</td>
                   <td>${answer.answer}</td>
                    <c:forEach items="${replay}" var="replay1">
                   
                    <c:forEach items="${replay1}" var="replay2">
                     <c:if test="${replay2.answer_id eq answer.answer_id}">
                     <td>${replay2.content }</td>
                     <td>${replay2.username }:${replay2. replay_username}</td>
                      <td>${replay2.fabulous }</td>
                      <td>${replay2.time }</td>
                   </c:if>
                    </c:forEach>
                    
                   </c:forEach>
                   </tr> 
                   </tbody>
                   
           
</c:forEach>
</table>
</div>
</div>
</body>
</html>