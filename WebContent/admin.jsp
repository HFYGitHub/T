<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>管理员界面</title>
    <meta name="description" content="Roxy">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- External CSS -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/template2.css">
    <link rel="stylesheet" href="css/talk.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="js/t2.js"></script>



    <style>
        .nav-pills .nav-link.active{
            color: #FFFFFF;
            background-color: #73FF9A;
        }
        .nav-item a{
            color: #FFDE66;
        }
        .carousel-inner img {
            width: 100%;
            height: 300px;
        }
    </style>
</head>
<script type="text/javascript">
    var s_height = document.documentElement.clientHeight;

    $(document).ready(function() {
        $(".note-select").css({
            height:s_height
        });

        $("iframe").css({
            height:s_height
        });

        // 获取验证码按钮
        $(".nav-item a").click(function() {
            var address =$(this).attr("data-src");
             $("#aa").attr("src",address);

        });
    });
</script>


<body>
<!--头部导航-->
<nav class="first-title d-flex flex-row " >
    <h3 class="name-title text-white col-sm-1" > Y O </br>U S C</h3>
    <ul class="list-inline dh">
        <li class="list-inline-item">
            <a class="" href="/T/ShowQuestionAtMain?username=${username}">首页</a>
        </li>
        <li class="list-inline-item">
            <a class="" href="#">联系</a>
        </li>
        <li class="list-inline-item">
            <a class="" href="#">关于</a>
        </li>
    </ul>
    <div class="offset-3">
        <img alt="logo" src="img/logo.png" style="height: 60px; width: 300px">
    </div>
    <c:if test="${empty user} ">
        <div class="u-info offset-4">
            <a class="login-user" href="login.jsp">登录</a>
            <a> | </a>
            <a class="register-user" href="register.jsp">注册</a>
        </div>
    </c:if>
    <div class="u-info offset-3">
        <a class="" href="user_infomation.jsp"  >欢迎您：${user.name}</a>
        &emsp;&emsp;
        <a class="" style="color: red" href="login.jsp">退出</a>
    </div>
</nav>

<div class="d-flex flex-row">
    <div class="note-select col-sm-2 d-flex flex-column"  style="background-color: #8C96FF;">
        <span class="admin-img mb-5 text-center"><img  class="img-fluid" src="img/head_img/tornado__easyiconnet.png"></span>
        <span class="nselect">
            <ul class="navbar-nav nav nav-pills text-center" role="tablist">
                <li class="nav-item" style="color: red">
                    <a class="nav-link active" data-toggle="pill" href="#" data-src="/T/ManageQuestion">问题咨询</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="pill" href="#" data-src="/T/AllCompetition">比赛通知</a>
                </li>
                
                <li class="nav-item">
                    <a class="nav-link" data-toggle="pill" href="#" data-src="/T/FoodIndexServlet">美食天下</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="pill" href="#" data-src="/T/FileIndexServlet" >资料分享</a>
                </li>
            </ul>

        </span>
    </div>
    <div class="note-pass col-sm-10 " style="background-color: #F4F4F4; padding: 0">
      
            <iframe  src="/T/ManageQuestion" id="aa" style="width:100%;height:600px;"></iframe>
	</div>
<footer class="t1-footer mastfoot my-3">
    <div class="inner container">
        <div class="row">
            <div class="col-lg-4 col-md-12 d-flex align-items-center">

            </div>
            <div class="col-lg-4 col-md-12 d-flex align-items-center">
                <p class="mx-auto text-center mb-0">Copyright &copy; 2020.南华大学交流圈 </p>
            </div>
        </div>
    </div>
</footer>
</div>