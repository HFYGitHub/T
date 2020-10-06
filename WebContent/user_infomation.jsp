<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>个人中心</title>
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
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>


    <style>
        .first-title {
            background-color: #99BCE2;
        }

        .first-title a {
            color: #005179;
        }

        .card {
            padding: 0;
        }

        .card-header {
            background-color: #92D1F4;
            color: #7F97B3;
        }


        .carousel-inner img {
            width: 100%;
            height: 300px;
        }

    </style>
</head>
<script type="text/javascript">


    var s_height = document.documentElement.clientHeight;


    $(document).ready(function () {
        $(".note-select").css({
            height:s_height
        });

        $("iframe").css({
            height:s_height
        });

        $("showimage").click(function () {

            var img = document.getElementById("showImg");

            //获取文件对象
            let file = obj.files[0];
            //获取文件阅读器
            let reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = function () {
                //给img的src设置图片url
                img.setAttribute("src", this.result);
            }
        });


        $("#search").click(function () {
            var key = $("input[id='search_txt']").val();


        });
        // 获取验证码按钮
        $("#search").click(function () {
            var key = $("input[id='search_txt']").val();

            $.ajax({
                url: 'EditUserInfor',
                type: 'post',
                data: {
                    username: "${username}",
                    key: key,
                    th: "搜索"
                },
                dataType: 'text',
                success: function () {
                    //window.location.reload();
                }
            });

        });


        // 获取验证码按钮
        $("#edit").click(function () {


            $.ajax({
                url: 'EditUserInfor',
                type: 'post',
                data: {
                    org_username: "${username}",
                    email: $("input[name='email']").val(),
                    username: $("input[name='username']").val(),
                    nickname: $("input[name='nickname']").val(),
                    sex: $("#sex option:selected").text(),
                    academy: $("input[name='academy']").val(),
                    declaration: $("input[name='declaration']").val(),
                    qq: $("input[name='qq']").val(),
                    wechat: $("input[name='qq']").val(),
                    phone: $("input[name='qq']").val()
                },
                dataType: 'text',
                success: function () {
                }
            });
        });


        $(".nav-item a").click(function () {
            var address = $(this).attr("data-src");
            $("#aa").attr("src", address);

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
    <div class="note-select col-sm-1 d-flex flex-column" style="background-color: #283138;padding: 0">
        <span class="nselect">
            <ul class="navbar-nav nav nav-pills text-center" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" data-toggle="pill" href="#"
                       data-src="/T/User_InformationServlet?username=${username }">个人信息</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="pill" href="#"
                       data-src="/T/ManageMyFile?username=${username }&th=我的下载">我的下载</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" data-toggle="pill" href="#" data-src="/T/EditUserActive?username=${username }">我的动态</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="pill" href="#"
                       data-src="user_pwd.jsp?username=${username }">密码安全</a>
                </li>

            </ul>
        </span>
    </div>
    <div class="note-pass col-sm-11 " style="background-color: #F4F4F4; padding: 0">

        <iframe src="/T/User_InformationServlet?username=${username }" id="aa" style="width:100%;height:600px;"></iframe>
    </div>
</div>


</body>