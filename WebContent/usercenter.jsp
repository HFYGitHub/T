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

        .carousel-inner img {
            width: 100%;
            height: 300px;
        }
    </style>
</head>



<body>
<!--头部导航-->
<nav class="first-title d-flex flex-row " >
    <h3 class="name-title text-white" > Y O U S C</h3>
    <ul class="list-inline dh">
        <li class="list-inline-item">
            <a class="" href="main.jsp">首页</a>
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
    
</nav>


<div class="d-flex flex-row">
    <div class="note-select col-sm-2 d-flex flex-column"  style="background-color: #191718;">
        <span class="logo text-center mb-3">你的USC</span>
        <span class="admin-img mb-5 text-center"><img  class="img-fluid" src="img/head_img/tornado__easyiconnet.png"></span>
      
            
                    <a class="nav-link"  href="/T/ManageMyFile?username=${username }&th=我的下载"  >我的下载</a>
    </div>
</div>