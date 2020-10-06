<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>食物讨论</title>
    <meta name="description" content="Roxy">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- External CSS -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/talk.css">
    <link rel="stylesheet" href="css/foodTalk.css">

    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="js/t1.js"></script>
    <script src="js/t2.js"></script>
    <script src="js/talk.js"></script>

    <script   type="text/javascript">
        var s_height = window.screen.height;
        var s_width = window.screen.width;

        function forwardPage() {
        	
        	var com= document.getElementById("txt").value;
        	
        	window.location.href = "/T/FoodDetailServlet?food_id="+ "${food_id}"+"&content="+com.toString()+"&username="+"${username}"+"&introduce="+"${introduce}"+"&img="+"${img}"+"&num="+"${num}"+"&theme="+"${theme}"+"&fabulous="+"${fabulous}"+"&publish_time="+"${publish_time}";

        }

     
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
    <div class="f2-item p-4"><a href="/T/ShowAllNotice?username=${username }&currentPage=0&theme=CF赛事" >比赛通知</a></div>
    <div class="f2-item p-4"><a href="/T/FoodShareServlet?username=${username}">美食天下</a></div>
    <div class="f2-item p-4"> <a href="/T/IndexServlet?currentPage=0&theme=软件&username=${username}" >资料分享</a></div>
</div>
    <div class="t1-center col-sm-12">
        <div class="u-information">
            

            <div class="row ">

                <div class="user-card d-flex flex-column offset-1 col-sm-1 border text-center">
                    <span class="user-name ">${publish_name}</span>
                    <hr>
                    <span class="user-img"><img alt="头像" class="img-fluid" src="imgs/${img }"></span>
                    <hr>
                    <hr>
                    <hr>
                    <hr>
                     <span>  <a href="javascript:history.go(-1)" >返回</a></span>
                </div>

                <div class="note-info d-flex flex-column col-sm-8 " style="padding: 0">
                    <span class="n-head border-bottom" style="color:#444;padding-left: 20px;"><h4>${theme}</h4></span>
                    <span class="n-infos text-center">
                        <span class="n-stime"> 发表于 ${time} </span>
                        <span class="fg">|</span>
                        <span class="n-cnumber">浏览:${num}</span>
                        <span class="fg">|</span>
                        <span class="rnumber">点赞数:${fabulous}</span>
                        <span class="fg">|</span>
                        <span class="rnumber">留言数：${total_num}</span>
                    </span>
                    <hr>
                    <span class="n-center">
                        <h2>${introduce}</h2>
                        <p><img alt="图片" src="img/img/food/${food_img }" style="width:300px;height:300px;" ></p>
                    </span>
                    <hr>
                    <a class="zan" href = "/T/FoodFabulousServlet?food_id=${food_id}&introduce=${introduce}&img=${img}&num=${num}&theme=${theme}&fabulous=${fabulous}&publish_time=${time}&flag=美食">
                        <img alt="点赞" class="img-fluid zan-img" src="img/img/ic/like-outline.png" style="">
                    </a>
                    <hr>
                    <hr>
                    <c:if test="${username eq publish_name }">
                    <span>  <a href="/T/FoodDetailServlet?username=${username }&food_id=${food_id}&food_img=${food_img}&introduce=${introduce}&fabulous=${fabulous}&publish_time=${release_time}&theme=${theme}&num=${num}&th=删除">删除</a></span>
                    </c:if>
                </div>
            </div>

        </div>
        <div class="u-discord offset-2 col-sm-8">
            <div class="u-s-img">
                <span class="user-img"><img alt="头像" class="img-fluid" src="img/img/head_img/road__easyiconnet.png"></span>
            </div>
            <div class="send-info border-bottom" >
                <textarea class="form-control" rows="3" style="resize: none" id="txt"></textarea>
                <div class="d-flex flex-row">
                   
                    <button class="btn btn-outline-primary col-sm-1 " onclick="forwardPage()">发 送</button>
                </div>
            </div>
            <c:forEach items="${allfoodtalk}" var="foodtalk">
            <div class="row u-s-info border-bottom">
                <div class="u-s-img">
                 <c:forEach items="${us}" var="us">
                 <c:if test="${foodtalk.username eq us.name }">
                    <span class="user-img"><img alt="头像" class="img-fluid" src="imgs/${us.image }"></span>
                 </c:if>
                 </c:forEach>
                </div>
                <div class="note-info d-inline-flex flex-column col-sm-9 " style="padding: 0">
                    <span class="u-s-text">
                        <a href="" class="user-name">${foodtalk.username}</a>
                        &emsp;
                        <span class="n-time ">发表于 ${foodtalk.time}</span>
                    </span>
                    <span class="n-center ">${foodtalk.content}</span>
                    <c:if test="${foodtalk.username eq username }">
                        <a href="/T/ManageFoodTalk?username=${username}&food_id=${food_id}&time=${foodtalk.time}&introduce=${introduce}&img=${img}&num=${num}&theme=${theme}&fabulous=${fabulous}&publish_time=${publish_time}" >删除</a>
                    </c:if>
                    <span class="u-s-zan">
                        <span class="zan-number float-right" style="padding-left: 10px">${foodtalk.like_num}</span>
                        <a class="zan float-right" href = "/T/FoodFabulousServlet?food_id=${food_id}&introduce=${introduce}&img=${img}&num=${num}&theme=${theme}&fabulous=${fabulous}&publish_time=${time}&flag=讨论&foodtalk.username=${foodtalk.username}&foodtalk.time=${foodtalk.time}">
                            <img alt="点赞" class="img-fluid zan-img" src="img/img/ic/like-outline.png">
                        </a>
                    </span>
                </div>
            </div>
            </c:forEach>
            <div class="text-center u-s-f">
                <h4>没有更多的评论啦！</h4>
            </div>
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