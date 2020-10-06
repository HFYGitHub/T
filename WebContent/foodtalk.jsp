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
        var username,replay_id,re_replay_id,replay_username,answer_id,question_id,theme,user_id;

        
 function forward() {
        	
        	var com= document.getElementById("txt").value;
        	
        	var foodimg="${food_img}"
        	window.location.href = "/T/FoodDetailServlet?food_id="+ "${food_id}"+"&content="+com.toString()+"&username="+"${username}"+"&introduce="+"${introduce}"+"&num="+"${num}"+"&theme="+"${theme}"+"&fabulous="+"${fabulous}"+"&publish_time="+"${publish_time}"+"&img="+foodimg.toString();

        }


    </script>
    <style>
        .follow{
            color: #444;
            background: #ffe300;
            border: 1px solid #ffe300;
            border-radius: 4px;
            cursor: pointer;
        }
        .btn-share{
            background-color: rgba(255,255,255,0.5);
            background-image: url(img/newic/share.png);
            padding: 0 18px 0 42px;
            line-height: 32px;
            font-size: 12px;
            margin-left: 10px;
            float: right;
            background-repeat: no-repeat;
            background-position: 18px center;
            -webkit-box-sizing: border-box;
            box-sizing: border-box;
            background-size: 18px auto;
        }
        .btn-collect{
            background-color: rgba(255,255,255,0.5);
            background-image: url(img/newic/collect.png);
            padding: 0 18px 0 42px;
            line-height: 32px;
            font-size: 12px;
            margin-left: 10px;
            float: right;
            background-repeat: no-repeat;
            background-position: 18px center;
            -webkit-box-sizing: border-box;
            box-sizing: border-box;
            background-size: 18px auto;
        }
        .bimg{


            color: #666;
            background: 0 0;
            border: 1px solid #bbb;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>

</head>
<body>

<nav class="first-title d-flex flex-row " >
    <h3 class="name-title text-white" > Y O <br/>U S C</h3>
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
    <div class="d-flex flex-row">
        <HR>
        <div class=" col-sm-8 border-top border-bottom" style="background-color: white;padding-top: 20px;padding-bottom: 10px">
            <div class="offset-2  d-flex flex-column">
                <h2>标题：${theme}</h2>
                <span class="n-infos">
                        <span class="n-stime">发表于 ：${time}</span>
                    </span>
                <span class="n-infos">
                        <span class="rnumber">分类：${theme}</span>
                    </span>
                <span class="n-infos" style="padding-right: 10px">
                        <span class="n-cnumber float-right"><img src="img/newic/redu.png" alt="浏览数" class="img-fluid" style="width: 25px;height: 25px">${num}</span>
                        <span class="n-cnumber float-right">&emsp;|&emsp;</span>
                        <span class="n-cnumber float-right"><img src="img/newic/liaotian.png" alt="评论数" class="img-fluid" style="width: 25px;height: 25px">${total_num}</span>
                        <span class="n-cnumber float-right">&emsp;|&emsp;</span>
                        <span class="n-cnumber float-right"><img src="img/newic/dianzan1.png" alt="点赞数" class="img-fluid" style="width: 25px;height: 25px">${fabulous}</span>
                    </span>
            </div>
        </div>
        <div class="user-card d-flex flex-row  col-sm-4 border-bottom border-left border-top text-center">
            <span class="user-img" style="margin: 20px"><img alt="头像" class="img-fluid" src="imgs/${img }"></span>
            <div class="d-flex flex-column" style="padding-top: 10px;padding-bottom: 20px">
                <span class="user-name ">${publish_name}</span>
                <span><a href="/T/FoodShareServlet?username=${username}" >返回</a></span>
            </div>


        </div>
        <hr>

    </div>
    <div class="u-information">
        <div class="offset-2 col-sm-8 ">
            <div class=" note-info d-flex flex-column " style="padding: 0">
                <div class="n-center border-bottom">
                    <h2>${introduce}</h2>
                    <p><img alt="图片" src="img/img/food/${food_img }" style="width:300px;height:300px;" ></p>
                    <p>${content}</p>
                    <div class="offset-5 col-sm-1 d-flex flex-column" style="margin-top:30px;color: #999;background: #eee;border-radius: 50px;padding-top: 15px;align-items: center">
                      <a class="zan" href = "/T/FoodFabulousServlet?food_id=${food_id}&introduce=${introduce}&img=${img}&num=${num}&theme=${theme}&fabulous=${fabulous}&publish_time=${time}&flag=美食&food_img=${food_img}">
                         <img src="img/newic/dz.png" alt="点赞" class="img-fluid" style="width: 30px;height: 30px">
                       </a> ${fabulous}
                      </div>
                      
                       
                   
                  
                    
                </div>
                <div class="">
                     <c:if test="${username eq publish_name }">
                       
                        <a class="zan float-right" href="/T/FoodDetailServlet?username=${username }&food_id=${food_id}&food_img=${food_img}&introduce=${introduce}&fabulous=${fabulous}&publish_time=${release_time}&theme=${theme}&num=${num}&th=删除"> 
                         <img src="img/newic/delete.png" alt="删除" class="img-fluid" style="width: 30px;height: 30px">
                       </a>
                      </c:if>
                </div>

              
            </div>
        </div>
    </div>
    <div class="u-discord offset-2 col-sm-8">

        <div class="send-info border-bottom" >
            <textarea class="form-control" rows="2" style="resize: none" id="txt"></textarea>
            <div class="">
             <button class="sub" onclick="forward()">回复</button>
             
            </div>
        </div>

        <c:forEach items="${allfoodtalk}" var="foodtalk">

            <div class="row u-s-info border-bottom offset-1 col-sm-9">
                <div class="u-s-img">
                    <c:forEach items="${us}" var="us">
                        <c:if test="${foodtalk.username eq us.name }">
                            <span class="user-img"><img alt="头像" class="img-fluid" src="imgs/${us.image }"></span>
                        </c:if>
                    </c:forEach>
                </div>
                <div class="note-info d-inline-flex flex-column col-sm-11 " style="padding: 0">
                    <span class="u-s-text">
                        <a href="" class="user-name">${foodtalk.username}</a>
                        &emsp;
                        <span class="n-time ">发表于 ${foodtalk.time}</span>
                    </span>
                    <span class="n-center ">${foodtalk.content}</span>
                    <div id="show" class="d-flex flex-row offset-10" style="padding-right: 20px">
                        
                        <a href="/T/FoodFabulousServlet?food_id=${food_id}&introduce=${introduce}&img=${img}&num=${num}&theme=${theme}&fabulous=${fabulous}&publish_time=${time}&flag=讨论&foodtalk.username=${foodtalk.username}&foodtalk.time=${foodtalk.time}&food_img=${food_img}" style="float: right"  class="view-number" >
                            <img alt="点赞" class="img-fluid" src="img/newic/dianzan.png" style="width: 30px;height: 30px">
                        </a>${foodtalk.like_num}
                        <c:if test="${foodtalk.username eq username }">
                        <span id="deletean"> <a href="/T/ManageFoodTalk?username=${username}&food_id=${food_id}&time=${foodtalk.time}&introduce=${introduce}&img=${img}&num=${num}&theme=${theme}&fabulous=${fabulous}&publish_time=${publish_time}&img=${food_img}" id="">
                         <img alt="删除" class="img-fluid" src="img/newic/delete.png" style="width: 30px;height: 30px;float: right"   class="view-number" >
                        </a></span>
                    </c:if>
                    </div>
                    &emsp;
                    
                    
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