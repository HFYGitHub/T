<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.iteima.domain.File"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>资料共享</title>
    <meta name="description" content="Roxy">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- External CSS -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
    <link rel="stylesheet" href="css/talk.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="js/t1.js"></script>


    <style>

        .first-title{


        }
        body{
            background-color: #34A0EB;
        }
        .s-info{
            padding-top: 200px;
        }
    </style>
    
    <script type="text/javascript">
      $(document).ready(function () {

        // 获取验证码按钮
        $("#search").click(function () {
            var key = $("input[id='search_txt']").val();
            alert(key);
            window.location.href = "/T/IndexServlet?currentPage=0&key=" + key.toString();

        });
    });
      </script>
</head>
<body>

<nav class="first-title d-flex flex-row " >
    <h3 class="name-title text-white" > Y O </br>U S C</h3>
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

<div class="f2 d-flex text-center ">
    <div class="f2-item p-4"><a href="/T/ReplayAllQuestion?username=${username }&currentPage=0&theme=全部" >问题咨询</a></div>
    <div class="f2-item p-4"><a href="/T/ShowAllNotice?username=${username }&currentPage=0&theme=请选择一个比赛类型" >比赛通知</a></div>
    <div class="f2-item p-4"><a href="/T/FoodShareServlet?username=${username}">美食天下</a></div>
    <div class="f2-item p-4"> <a href="/T/IndexServlet?currentPage=0&theme=软件&username=${username}" >资料分享</a></div>
</div>

<div class="t1 container-fluid">
    <div class="s-info offset-4">
        <h1 class="text-white font-weight-bold display-2">南 华 资 料 查 询</h1>
        <h3 class="offset-2 text-white font-weight-bold display-4 mb-4">搜 你 想 搜</h3>
    </div>

    <div class="input-group col-sm-8 offset-2 mb-5">
        <div class="input-group-prepend">
            <span class="input-group-text "><img class="img-fluid" style="width: 20px; height: 20px;" src="img/icon/sousuo.png"></span>
        </div>
        <input type="text" class="form-control" placeholder="请输入要查询的资料关键字" id="search_txt">
        <button class="btn btn-outline-light" id="search">搜索</button>
    </div>

    <div class="col-sm-8 offset-2">
        <div class="jumbotron">
            <!-- Nav pills -->
           
            <ul class="nav nav-pills" role="tablist">
            <li class="nav-item">
                    <a class="nav-link active" href="/T/IndexServlet?currentPage=${requestScope.pageBean.currentPage}&theme=毛概">毛概</a>
                </li>
             <li class="nav-item">
                    <a class="nav-link " href="/T/IndexServlet?currentPage=${requestScope.pageBean.currentPage}&theme=经管">经管</a>
                </li>
             <li class="nav-item">
                    <a class="nav-link " href="/T/IndexServlet?currentPage=${requestScope.pageBean.currentPage}&theme=英语">英语</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="/T/IndexServlet?currentPage=${requestScope.pageBean.currentPage}&theme=文学">文学</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="/T/IndexServlet?currentPage=${requestScope.pageBean.currentPage}&theme=高数">高数</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="/T/IndexServlet?currentPage=${requestScope.pageBean.currentPage}&theme=马原">马原</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="/T/IndexServlet?currentPage=${requestScope.pageBean.currentPage}&theme=医学">医学</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="/T/IndexServlet?currentPage=${requestScope.pageBean.currentPage}&theme=化工">化工</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="/T/IndexServlet?currentPage=${requestScope.pageBean.currentPage}&theme=设艺">设艺</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="/T/IndexServlet?currentPage=${requestScope.pageBean.currentPage}&theme=生物">生物</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/T/IndexServlet?currentPage=${requestScope.pageBean.currentPage}&theme=会计">会计</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/T/IndexServlet?currentPage=${requestScope.pageBean.currentPage}&theme=物理">物理</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/T/IndexServlet?currentPage=${requestScope.pageBean.currentPage}&theme=软件">软件</a>
                </li>
            </ul>

            <!-- Tab panes -->
            <div class="tab-content">
                <div id="m1" class="container tab-pane active"><br>
                   
                    <div>
	                    	<table class="table table-hover">
							    <thead>
							      <tr>
							        <th>编号</th>
							        <th>文件名</th>
							        <th>下载数</th>
							        <th>上传时间</th>
							      </tr>
							    </thead>
							    <c:choose>
							    <c:when test="${not empty requestScope.pageBean.list }">
							    <c:forEach items="${requestScope.pageBean.list }" var="file" varStatus="status">
							    <tbody>
							      <tr>
							        <td>${ status.index + 1}</td>
							        <td><a href="down.jsp?filename=${file.filename }&username=${username}&theme=${theme}&file_id=${file.fileid}" >${file.filename}</a></td>
							        <td>${file.downnum}</td>
							        <td>${file.time}</td>
							      </tr>
							    </tbody>
							    </c:forEach>
							    
							    </c:when>
							    
							    </c:choose>
							    <tr>
            <td colspan="8" align="center">
            <a href="/T/IndexServlet?currentPage=1&theme=${theme}">首页</a>
            <a href="/T/IndexServlet?currentPage=${requestScope.pageBean.currentPage - 1}&theme=${theme}">上一页</a>
            <a href="/T/IndexServlet?currentPage=${requestScope.pageBean.currentPage + 1}&theme=${theme}">下一页</a>
            <a href="/T/IndexServlet?currentPage=${requestScope.pageBean.totalPage}&theme=${theme}">末页</a>
            </td>
        </tr>
		 </table>
							 
                    </div>  
                </div>
            </div>
        </div>
    </div>
</div>



<!--底部-->
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

</body>
</html>