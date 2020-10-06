<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Login</title>
    <meta name="description" content="Roxy">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- External CSS -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/new-user.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <style>




    </style>
    <script>
     function check(){
    	 var name=$("#username").val();
    	 var password=$("#password").val();
    	 if(name==""||password==""){
    		 $("#message").text("账号或密码不能为空!");
    		 return false;
    	 }
    	 return true;
     }
    
    </script>
</head>
<body>


<div class="d-flex  info offset-3 cas" style="">
    <div class="login-bg rounded col-sm-4" style="padding: 30px">
        <div class="text-center" style="color: #0099CC">
            <h3>欢迎来到</h3>
            <a href="main.jsp" style="color: #0066CC"><h2>你的USC</h2></a>
            <h3>南华校园交流圈</h3>
        </div>
        <div class="text-center" style="">
            <img alt="加载" class="img-fluid" src="img/loading.gif" style="height: 300px;width: 300px">
        </div>
    </div>
    <div class="login-info rounded d-flex flex-column col-sm-4" style="">
        <div class="text-center">
            <img alt="logo" class="img-fluid" src="img/LOGO1.png" style="width: 350px;height: 200px">
        </div>
        <div>
        <span  style="color:red;">${err}</span>
        </div>
        <form action="/T/LoginServel"  method="get" >
        <input type="hidden" name="method" value="login"/>
            <div class="form-group ">
                <div class="d-flex flex-row in-css">
                    <img class="img-fluid" src="img/icon/huiyuan.png" alt="用户"  style="height: 30px;width: 30px">
                    <input type="text" class="form-control" id="usr" placeholder="请输入用户名" name="username">
                </div>
            </div>
            <div class="form-group ">
                <div class="d-flex flex-row in-css">
                    <img class="img-fluid" src="img/icon/mima.png" alt="用户"  style="height: 30px;width: 30px">
                    <input type="password" class="form-control" id="pwd" placeholder="请输入密码" name="pwd">
                    <a class="small text-nowrap" href="findPwd.jsp" style="color: #ABABAB">找回密码？</a>
                </div>
            </div>
            <div class="d-flex flex-row mr-auto">
                <a class="offset-10" href="register.jsp" style="float: right">注册</a>
            </div>
            <input type="submit" class="login-btn btn btn-info col-sm-10" value="登录">
        </form>
    </div>

</div>

</body>
</html>