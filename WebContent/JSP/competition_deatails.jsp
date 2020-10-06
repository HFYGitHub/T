<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>故事分享</title>
    <meta name="description" content="Roxy">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- External CSS -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/talk.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="js/t2.js"></script>
    <script src="js/talk.js"></script>
    <script   type="text/javascript">
        var s_height = window.screen.height;
        var s_width = window.screen.width;
        
       
    </script>
    <link rel="stylesheet" href="css/template1.css">
   <script src="js/t1.js"></script>

    <script type="text/javascript" src="WebContent/js/jquery-1.11.3.js"></script>
   

    <style type="text/css">
        .blt-text{
            background-image:url("img/bulletin.png");
            background-size: 100% 100%;
            background-repeat: no-repeat;
        }
        body{
            background-image:url("img/bg2.png");
            background-size: 100% 100%;
            background-repeat: no-repeat;
        }
    </style>
</head>
<body>

<nav class="first-title d-flex flex-row " >
    <h3 class="name-title text-white" > Y O U S C</h3>
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
        <li class="list-inline-item">
        <a class="nav-link" href="user_infomation.jsp?username=${username }">个人中心</a>
        </li>
        <li class="list-inline-item">
          <a class="register-user" href="login.jsp">退出</a>
       </li>
    </ul>
    <div class="offset-3">
        <img alt="logo" src="img/logo.png" style="height: 60px; width: 300px">
    </div>
    
</nav>
<div class="f2 d-flex text-center ">
    <div class="f2-item p-4"><a href="/T/ReplayAllQuestion?username=${username }&currentPage=0&theme=全部" >问题咨询</a></div>
    <div class="f2-item p-4"><a href="/T/ShowAllNotice?username=${username }&currentPage=0&theme=CF赛事" >比赛通知</a></div>
    <div class="f2-item p-4"><a href="/T/FoodShareServlet?username=${username}">美食天下</a></div>
    <div class="f2-item p-4"> <a href="/T/IndexServlet?currentPage=0&theme=软件&username=${username}" >资料分享</a></div>
</div>

<div class="t1 container-fluid col-sm-8 offset-2">
 
    <!--中心内容-->
    <div class="t1-center">
    <a href="javascript:history.go(-1)" class="offset-6"><button class="btn btn-primary">返回</button></a>
       <c:forEach items="${compeNotice }" var="compe">
        <div class="">
            <table cellspacing="0" cellpadding="0">
                <tbody>
                    <tr>
                        <td class=" border-right">
                            <span class="n-cnumber">浏览:${compe.read_num}</span>
                           
                            &emsp;&emsp;&emsp;&emsp;&emsp;
                        </td>
                        <td class="">
                            <span class="n-head border-bottom">${compe.theme}</span>
                        </td>
                    </tr>
                </tbody>
            </table>
            <hr>
        </div>
        <div class="row">
            <div class="user-card d-flex flex-column col-sm-2 border-right">

                <div>
                    <span class="user-name">${compe.competition_name}</span>
                    <hr>
                </div>
                <div>
                    <span class="user-img"><img alt="头像"  class="img-fluid" src="imgs/oranage.jpg"></span>
                    <hr>
                </div>
                <div>
                    
                    <hr>
                </div>
            </div>

            <div class="note-info d-flex flex-column col-sm-9 " style="padding: 0">

                <div class=" flex-column">
                    <span class="n-infos text-center" >
                        <span class="n-stime"> 发表于 ${compe.release_time} </span>
                    </span>
                    <hr style="padding: 0">
                    <span class="n-center">${compe.content}</span><br/>
                    <span class="n-center"><a href="downNoticeFile.jsp?filename=${compe.file}&username=${username}&notice_id=${compe.notice_id}">${compe.file}</a></span>
                </div>
            </div>
        </div>
        </c:forEach>

</div>
      
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
</body>