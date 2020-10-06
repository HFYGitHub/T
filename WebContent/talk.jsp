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
    <div class="u-info offset-4">
        <a class="login-user" href="login.jsp">登录</a>
        <a> | </a>
        <a class="register-user" href="register.jsp">注册</a>
    </div>
</nav>
    <div class="f2 d-flex text-center ">
        <div class="f2-item p-4"><a href="#" >问题咨询</a></div>
        <div class="f2-item p-4"><a href="#">比赛通知</a></div>
        <div class="f2-item p-4"><a href="#">情感分享</a></div>
        <div class="f2-item p-4"><a href="foodshare.jsp">美食天下</a></div>
        <div class="f2-item p-4"><a href="dataShare.jsp">资料分享</a></div>
    </div>
<div class="it-body d-flex flex-row">
    <div class="col-sm-9" style="padding: 0">
        <!--轮播图-->
        <div class="shows col-sm-12">
            <div id="demo" class="first-img carousel slide " data-ride="carousel">
                <!-- 指示符 -->
                <ul class="carousel-indicators">
                    <li data-target="#demo" data-slide-to="0" class="active"></li>
                    <li data-target="#demo" data-slide-to="1"></li>
                    <li data-target="#demo" data-slide-to="2"></li>
                </ul>

                <!-- 轮播图片 -->
                <div class="carousel-inner ">
                    <div class="carousel-item active ">
                        <img alt="图片" class="img-fluid " src=
                                "https://dimg08.c-ctrip.com/images/tg/712/889/956/810b8ad5fac34f468cc2720997523572_C_671_10000_Q90.jpg">
                    </div>
                    <div class="carousel-item">
                        <img alt="图片" class="img-fluid" src=
                                "http://static.dcfever.com/media/sharing/08/09/02/351220340621.jpg">
                    </div>
                    <div class="carousel-item">
                        <img alt="图片" class="img-fluid" src=
                                "http://static.dcfever.com/media/sharing/08/09/02/351220340621.jpg">
                    </div>
                </div>

                <!-- 左右切换按钮 -->
                <a class="carousel-control-prev" href="#demo" data-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                </a>
                <a class="carousel-control-next" href="#demo" data-slide="next">
                    <span class="carousel-control-next-icon"></span>
                </a>
            </div>
        </div>
<div class="d-flex flex-row"> 
        <div class="c-info col-sm-5">
            

            <div class="u-share" >
            <c:forEach items="${allfood}" var="food">
    		
    
                <div class="card" style="margin-bottom: 40px">
                    <img class="card-img-top img-fluid"  src="img/img/food/${food.img_name }" alt="Card image" style="z-index: 0;height: 200px;width:100%">

                    <img class="rounded-circle image-responsive u-head" src="img/img/photo-1.jpg" alt="头像"/>

                    <div class="card-body" style="z-index: 0">
                        <div class="offset-4 d-flex flex-row">
                           
                            <div class="t-number" style="padding-left: 15px">${food.release_time}</div>
                        </div>
                        <p class="card-text">${food.introduce}</p>
                    </div>

                    <div class="card-footer c-f d-flex flex-row">
                        <a class="zan" href="/T/FoodDetailServlet?food_id=${food.food_id}&introduce=${food.introduce}&img=${food.img_name}&publish_time=${food.release_time}&theme=${food.text}&num=${food.number}&fabulous=${food.fabulous}&username=${username}" class="view-number">
                            <img alt="点赞" class="img-fluid zan-img" src="img/img/ic/like-outline.png"/>
                           
                        </a>
                        <div class="l-number" style="padding-right: 20px">${food.fabulous}</div>
                        <a href="/T/FoodDetailServlet?food_id=${food.food_id}&introduce=${food.introduce}&img=${food.img_name}&publish_time=${food.release_time}&theme=${food.text}&num=${food.number}&fabulous=${food.fabulous}&username=${username}" class="view-number"  id="${food.food_id }" data-toggle="collapse"><img alt="评论" class="img-fluid" src="img/img/ic/comment-outline.png"></a>

                        <div class="d-number">${food.number}</div>
                    </div>
                   
                <div id="${food.food_id }" class="collapse ">
                         <textarea class="form-control" rows="3" style="resize: none"></textarea>
                <div class="d-flex flex-row">
                    
                    <button class="btn btu-s col-sm-2 text-white ">发 送</button>
                </div>
                    </div>
                </div>
     </c:forEach>  
    </div>           
        </div>
        </div>
    </div>
    <div class="col-sm-3 user-info" style="background-color: #EDF1F2">
        <div class="card bulletin">
            <div class="card-header text-center" style="background-color: #5DAAA0">公告栏</div>
            <div class="card-body">
                <h5 class="text-center">
                    1请勿发表意义不明、内容空洞、语序错乱、标题党的主题！
                    2请勿发表涉及政治、成人、暴力、色 情、广告等相关内容！
                    3请勿发表引战内容，避免来源不明确、具有争议性的信息！
                    4谢谢合作！
                </h5>
            </div>
        </div>
        <div class="card top-5">
            <div class="card-header text-center" style="background-color: #5DAAA0">今日热点</div>
            <div class="card-body d-flex flex-column text-center">
             <c:forEach items="${hotfood }" var="food" varStatus="status">
             <div >
               <table style="width:300px;height:500px;">
				<tr>
				<td><img src="img/img/food/${food.img_name }" style="width:50px;height:60px;radius:100%"></td>
				<td> ${ status.index + 1}.<a href="/T/FoodDetailServlet?food_id=${food.food_id}&introduce=${food.introduce}&img=${food.img_name}&publish_time=${food.release_time}&theme=${food.text}&num=${food.number}&fabulous=${food.fabulous}&username=${username}">${food.introduce}</a></td>
				</tr>
				</table>
             </div>
							
                </c:forEach>
            </div>
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