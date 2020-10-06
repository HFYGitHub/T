<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>美食分享</title>
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
        var s_height = document.documentElement.clientHeight;

        $(".user-info").css({
            height:s_height
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
        <a class="" href="user_infomation.jsp"  >欢迎您：${username}</a>
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
                    <div class="send-info "  style="background-color: #F7F7F7">
                        <form method="post"
                              action="/T/PublisHFood?username=${username}"
                              enctype="multipart/form-data">
                            <div>
                                <table class="container-fluid">
                                    <tbody>
                                        <tr>
                                            <td style="width: 10%">感想：</td>
                                            <td>
                                                <textarea class="form-control" rows="3" style="resize: none" name="introduce"></textarea>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td style="width: 10%">分类：</td>
                                            <td>
                                                <select name="text">

                                                        <option value="烧烤">烧烤</option>
                                                        <option value="甜点">甜点</option>
                                                        <option value="早餐">早餐</option>
                                                        <option value="料理">料理</option>
                                                        <option value="火锅麻辣烫">火锅麻辣烫</option>
                                                        <option value="面食">面食</option>
                                                        <option value="轻食沙拉">轻食沙拉</option>
                                                        <option value="地方菜系">地方菜系</option>

                                                        <option value="其他">其他</option>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td style="width: 10%">照片：</td>
                                            <td>
                                                <input  type="file" name="file" id="showimage"/>
                                              </td>
                                        </tr>
                                    </tbody>
                                </table>
                                <div class="d-flex flex-row offset-5">
                                  <input type="submit" class="btn btu-s col-sm-2 text-white " value="发布"/>
                                </div>
                            </div>
                        </form>
                    </div>

                    <div class="u-share" >
                    <c:forEach items="${allfood_left}" var="food">
                        <div class="card" style="margin-bottom: 40px">
                            <img class="card-img-top img-fluid"  src="img/img/food/${food.img_name }" alt="Card image" style="z-index: 0;height: 200px;width:100%">

                            
                             <c:forEach items="${user}" var="us">
                             <c:if test="${food.id eq us.id }">
                  				  <img class="rounded-circle image-responsive u-head" src="imgs//${us.image }" alt="头像"/>
							</c:if>
							</c:forEach>

                            <div class="card-body" style="z-index: 0">
                                <div class="offset-4 d-flex flex-row">

                                    <div class="t-number" style="padding-left: 15px">${food.release_time}</div>
                                </div>
                                <p class="card-text">${food.introduce}</p>
                            </div>

                            <div class="card-footer c-f d-flex flex-row">
                                <a class="zan" href="/T/FoodDetailServlet?food_id=${food.food_id}&introduce=${food.introduce}&img=${food.img_name}&publish_time=${food.release_time}&theme=${food.text}&num=${food.number}&fabulous=${food.fabulous}&username=${username}" class="view-number">
                                    <img alt="详情" class="img-fluid zan-img" src="img/newic/liaotian.png"/>
                                </a>
                                
                                
                            </div>

                            <div id="pl" class="collapse ">
                                <form action="" method="get">
                                    <textarea class="form-control" rows="3" style="resize: none"></textarea>
                                    <div class="d-flex flex-row">
                                        <button type="submit" class="btn btu-s col-sm-2 text-white ">发 送</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </c:forEach>
                    </div>
                </div>

            <div class="c-info col-sm-5">

                <div class="u-share" >
                    <c:forEach items="${allfood_right}" var="food">
                        <div class="card" style="margin-bottom: 40px">
                            <img class="card-img-top img-fluid"  src="img/img/food/${food.img_name }" alt="Card image" style="z-index: 0;height: 200px;width:100%">

                             <c:forEach items="${user}" var="us">
                             <c:if test="${food.id eq us.id }">
                  				  <img class="rounded-circle image-responsive u-head" src="imgs/${us.image }" alt="头像"/>
							</c:if>
							</c:forEach>

                            <div class="card-body" style="z-index: 0">
                                <div class="offset-4 d-flex flex-row">

                                    <div class="t-number" style="padding-left: 15px">${food.release_time}</div>
                                </div>
                                <p class="card-text">${food.introduce}</p>
                            </div>

                            <div class="card-footer c-f d-flex flex-row">
                                <a class="zan" href="/T/FoodDetailServlet?food_id=${food.food_id}&introduce=${food.introduce}&img=${food.img_name}&publish_time=${food.release_time}&theme=${food.text}&num=${food.number}&fabulous=${food.fabulous}&username=${username}" class="view-number">
                                   <img alt="详情" class="img-fluid zan-img" src="img/newic/liaotian.png"/>
                                </a>
                                
                               
                            </div>

                            <div id="pl2" class="collapse ">
                                <form action="" method="get">
                                    <textarea class="form-control" rows="3" style="resize: none"></textarea>
                                    <div class="d-flex flex-row">
                                        <button type="submit" class="btn btu-s col-sm-2 text-white ">发 送</button>
                                    </div>
                                </form>
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
                <h5 class=" text-justify">
                    1、请勿发表意义不明、内容空洞、语序错乱、标题党的主题！</br>
                    2、请勿发表涉及政治、成人、暴力、色 情、广告等相关内容！</br>
                    3、请勿发表引战内容，避免来源不明确、具有争议性的信息！</br>
                    4、谢谢合作！</br>
                </h5>
            </div>
        </div>
        <div class="card top-5">
            <div class="card-header text-center" style="background-color: #5DAAA0">今日热点</div>
            <div class="card-body d-flex flex-column text-center">
             <c:forEach items="${hotfood }" var="food" varStatus="status">
             <div class="" style="margin: 30px;">
               <table>
                    <tr >
                        <td><img class="img-fluid rounded-circle image-responsive" src="img/img/food/${food.img_name }" style="width:100px;height:100px;radius:100%"></td>
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