<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Home</title>
    <meta name="description" content="Roxy">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- External CSS -->
    <link rel="stylesheet" href="vendor/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="vendor/select2/select2.min.css">
    <link rel="stylesheet" href="vendor/owlcarousel/owl.carousel.min.css">
    <link rel="stylesheet" href="vendor/lightcase/lightcase.css">
    <link rel="stylesheet" href="css/aos.css"/>

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400|Work+Sans:300,400,700" rel="stylesheet">

    <!-- CSS -->
    <link rel="stylesheet" href="css/style.min.css">
    <link rel="stylesheet" href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
          integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

    <!-- Modernizr JS for IE8 support of HTML5 elements and media queries -->
    <script src="js/modernizr.js"></script>
    <!-- 现代写法，推荐(不支持 IE) -->
    <script >
        fetch('https://v1.hitokoto.cn')
            .then(response => response.json())
            .then(data => {
                const hitokoto = document.getElementById('hitokoto');
                hitokoto.innerText = data.hitokoto;
            })
            .catch(console.error)
    </script>

</head>
<body data-spy="scroll" data-target="#navbar" class="static-layout">
<nav id="header-navbar" class="navbar navbar-expand-lg py-4">
    <div class="container">
        <a class="navbar-brand d-flex align-items-center text-white" href="/T/ShowQuestionAtMain?username=${username}">
            <h3 class="font-weight-bolder mb-0">YOUR USC</h3>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-nav-header"
                aria-controls="navbar-nav-header" aria-expanded="false" aria-label="Toggle navigation">
            <span class="lnr lnr-menu"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbar-nav-header">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/T/ShowQuestionAtMain?username=${username}">首页</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/T/ShowQuestionAtMain?username=${username}#section-featurettes">关于</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/T/ShowQuestionAtMain?username=${username}#reservation">联系</a>
                </li>
                <!--                <li class="nav-item">-->
                <!--                    <a id="side-search-open" class="nav-link" href="#">-->
                <!--                        <span class="lnr lnr-magnifier"></span>-->
                <!--                    </a>-->
                <!--                </li>-->
                <li class="nav-item only-desktop">
                    <a class="nav-link" id="side-nav-open" href="#">
                        <span class="lnr lnr-menu"></span>
                    </a>
                </li>
                <li class="nav-item " style="padding: 8px">
                    <a class="" href="user_infomation.jsp" style="color: white" >欢迎您：${username}</a>
                    &emsp;&emsp;
                    <a class="" style="color: chartreuse" href="login.jsp">退出</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div id="side-nav" class="sidenav">
    <a href="javascript:void(0)" id="side-nav-close">&times;</a>

    <div class="sidenav-content">
        <p>
            联系负责人
        </p>
        <p>
            <span class="fs-16 primary-color">(QQ) 1826864441</span>
        </p>
        <p>1826864441@qq.com</p>
    </div>
</div>
<div id="side-search" class="sidenav">
    <a href="javascript:void(0)" id="side-search-close">&times;</a>
    <div class="sidenav-content">
        <form action="">

            <div class="input-group md-form form-sm form-2 pl-0">
                <input class="form-control my-0 py-1 red-border" type="text" placeholder="Search" aria-label="Search">
                <div class="input-group-append">
                    <button class="input-group-text red lighten-3" id="basic-text1">
                        <span class="lnr lnr-magnifier"></span>
                    </button>
                </div>
            </div>

        </form>
    </div>

</div>
<div class="jumbotron d-flex align-items-center">
    <div class="container text-center">
        <h1 class="display-1 mb-4">YO<br>USC</h1>
    </div>
    <div class="rectangle-1"></div>
    <div class="rectangle-2"></div>
    <div class="rectangle-transparent-1"></div>
    <div class="rectangle-transparent-2"></div>
    <div class="circle-1"></div>
    <div class="circle-2"></div>
    <div class="circle-3"></div>
    <div class="triangle triangle-1">
        <img src="img/obj_triangle.png" alt="">
    </div>
    <div class="triangle triangle-2">
        <img src="img/obj_triangle.png" alt="">
    </div>
    <div class="triangle triangle-3">
        <img src="img/obj_triangle.png" alt="">
    </div>
    <div class="triangle triangle-4">
        <img src="img/obj_triangle.png" alt="">
    </div>
</div>    <!-- Features Section-->
<section id="features" class="bg-white">
    <div class="container">
        <div class="section-content">
            <!-- Section Title -->
            <div class="title-wrap mb-5" data-aos="fade-up">
                <h2 class="section-title">
                    板块内容
                </h2>
                <p class="section-sub-title">让我们一起谈天说地 <br> 分享你的喜怒哀乐</p>
            </div>
            <!-- End of Section Title -->
            <div class="row">
                <!-- Features Holder-->
                <div class="col-md-10 offset-md-1 features-holder">
                    <div class="row">
                        <!-- Features Item -->
                        <div class="col-md-4 col-sm-12 text-center mt-4">
                            <div class="shadow rounded feature-item p-4 mb-4" data-aos="fade-up">
                                <div class="my-4">
                                    <i class="lnr lnr-cog fs-40"></i>
                                </div>
                                <h4><a href="/T/ReplayAllQuestion?username=${username }&currentPage=0&theme=全部" >问题咨询</a></h4>
                                <p>不会有人还不知道吧</p>
                            </div>
                            <div class="shadow rounded feature-item p-4 mb-4" data-aos="fade-up">
                                <div class="my-4">
                                    <i class="lnr lnr-frame-contract fs-40"></i>
                                </div>
                                <h4><a href="/T/ShowAllNotice?username=${username }&currentPage=0&theme=请选择一个比赛类型" >比赛通知</a></h4>
                                <p>让我们看看今天有哪些比赛</p>
                            </div>
                        </div>
                        <!-- End of Feature Item -->
                        <!-- Features Item -->
                        <div class="col-md-4 col-sm-12 text-center">
                            <div class="shadow rounded feature-item p-4 mb-4" data-aos="fade-up">
                                <div class="my-4">
                                    <i class="lnr lnr-bubble fs-40"></i>
                                </div>
                                <h4><a href="/T/ReplayAllQuestion?username=${username }&currentPage=0&theme=全部" >情感分享</a></h4>
                                <p>大型网友相亲会？</p>
                            </div>
                            <div class="shadow rounded feature-item p-4 mb-4" data-aos="fade-up">
                                <div class="my-4">
                                    <i class="lnr lnr-magic-wand fs-40"></i>
                                </div>
                                <h4><a href=href="/T/FoodShareServlet?username=${username}" >美食天下</a></h4>
                                <p>吃吃吃，只要吃不胖，就往死里吃</p>
                            </div>
                        </div>
                        <!-- End of Feature Item -->
                        <!-- Features Item -->
                        <div class="col-md-4 col-sm-12 text-center mt-4">
                            <div class="shadow rounded feature-item p-4 mb-4" data-aos="fade-up">
                                <div class="my-4">
                                    <i class="lnr lnr-clock fs-40"></i>
                                </div>
                                <h4><a href="/T/IndexServlet?currentPage=0&theme=软件&username=${username}" >资料分享</a></h4>
                                <p>考试？复习？四六级？统统不在话下</p>
                            </div>
                            <!--                            <div class="shadow rounded feature-item p-4 mb-4" data-aos="fade-up">-->
                            <!--                                <div class="my-4">-->
                            <!--                                    <i class="lnr lnr-thumbs-up fs-40"></i>-->
                            <!--                                </div>-->
                            <!--                                <h4></h4>-->
                            <!--                                <p></p>-->
                            <!--                            </div>-->
                        </div>
                        <!-- End of Feature Item -->
                    </div>
                </div>
                <!-- End of Features Holder-->
            </div>
        </div>
    </div>
</section>
<!-- End of Features Section-->
<section id="section-featurettes" class="featurettes overlay bg-fixed" style="background-image: url(img/bg.jpg);">

    <div class="container">
        <div class="section-content">
            <div class="row">
                <div class="col-md-12">
                    <div class="row align-items-center text-white">

                        <div class="col-md-4 offset-md-2 col-sm-6" data-aos="fade-right">
                            <h4 class="mb-4">初衷</h4>
                            <p>我们是南华大学的学子，本着想创造一个良好方便快捷的南华大学网络交流氛围，让南华学子交流更加融洽的初衷，从而创建了此网站！</p>
                            <h4 class="mb-4">版权声明</h4>
                            <p>本网站的所有资料信息都来源于团队收集或公开网络资源，若有不小心侵犯了您的权益，请与我们联系，我们会尽快处理。此外，网站帖子信息属于用户个人观点，不代表本站团队的观点，各种信息希望大家能够自行分辨。</p>
                            <h4 class="mb-4">联系方式</h4>
                            <P>如果您对我们网站有任何的建议和意见，欢迎随时与我们联系，联系方式如下：QQ：1826864441，您同样也可以填下本站底部的表单信息进行反馈，希望您在本站能够拥有美好的一天！</P>
                        </div><!--/ .col-md-4.col-md-offset-2.col-sm-6 -->

                        <div class="col-md-4 offset-md-right-2 col-sm-6" data-aos="flip-right">
                            <img class="my-5" src="img/app-profile-mockup.png" alt="">
                        </div><!--/ .col-md-4.col-md-offset-right-2.col-sm-6 -->

                    </div><!--/ .featurettes-item -->

                </div><!--/ .col-md-12 -->

            </div><!--/ .row -->
        </div>
    </div><!--/ .container -->

</section>


<!-- End of Client Section -->    <!-- Reservation Section -->
<section id="reservation" class="bg-white section-content">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-5 offset-lg-1 mb-5 mb-lg-0" data-aos="fade-right">
                <div class="bg-white p-5 shadow">
                    <div class="heading-section text-center">
                        <h2 class="mb-4">
                            联系我们
                        </h2>
                    </div>
                    <form method="post" name="contact-us" action="">
                        <div class="row">
                            <div class="col-md-12 form-group">
                                <input type="text" class="form-control" id="name" name="name" placeholder="名字">
                            </div>
                            <div class="col-md-12 form-group">
                                <input type="text" class="form-control" id="email" name="email" placeholder="邮箱">
                            </div>
                            <div class="col-md-12 form-group">
                                <input type="number" class="form-control" id="phoneNumber" name="phoneNumber"
                                       placeholder="电话">
                            </div>
                            <div class="col-md-12 form-group">
                                <input type="text" class="form-control" id="websiteUrl" name="websiteUrl"
                                       placeholder="问题类型？（建议/求助 等）">
                            </div>
                            <div class="col-md-12 form-group">
                                <textarea class="form-control" id="message" name="message" rows="6"
                                          placeholder="想告诉我们什么？ ..."></textarea>
                            </div>
                            <div class="col-md-12 text-center">
                                <button class="btn btn-primary btn-shadow btn-lg" type="submit" name="submit">提交
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-lg-4 offset-lg-1" data-aos="fade-left">
                <h2 class="mb-4">
                    你有什么问题都可以向我们咨询
                </h2>
                <p class="mb-4">合作，反馈，建议等都是可以的</p>

                <ul class="list-inline py-2">
                    <li class="list-inline-item text-center">
                        <span class="lnr fs-40 lnr-rocket"></span>
                        <p>畅言</p>
                    </li>
                    <li class="list-inline-item text-center">
                        <span class="lnr fs-40 lnr-magic-wand"></span>
                        <p>洽谈</p>
                    </li>
                    <li class="list-inline-item text-center">
                        <span class="lnr fs-40 lnr-cog"></span>
                        <p>尽情</p>
                    </li>
                </ul>

                <a href="#" class="btn btn-link p-0">
                    <span>返回首页</span>
                    <span class="lnr lnr-arrow-right"></span>
                </a>
            </div>
        </div>

    </div>
</section>
<!-- End of Reservation Section -->    <!-- Features Section-->
<section id="cta" class="bg-fixed overlay" style="background-image: url(img/bg.jpg);">
    <div class="container">
        <div class="section-content" data-aos="fade-up">
            <div class="row">
                <div class="col-md-12 text-center">
                    <h2 class="mb-2" id="hitokoto">:D 获取中...</h2>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- End of Features Section-->
<footer class="mastfoot my-3">
    <div class="inner container">
        <div class="row">
            <div class="col-lg-4 col-md-12 d-flex align-items-center">

            </div>
            <div class="col-lg-4 col-md-12 d-flex align-items-center">
                <p class="mx-auto text-center mb-0">Copyright &copy; 2020.南华大学交流圈 </p>
            </div>


        </div>
    </div>
</footer>    <!-- External JS -->
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script src="vendor/bootstrap/popper.min.js"></script>
<script src="vendor/bootstrap/bootstrap.min.js"></script>
<script src="vendor/select2/select2.min.js "></script>
<script src="vendor/owlcarousel/owl.carousel.min.js"></script>
<script src="vendor/stellar/jquery.stellar.js" type="text/javascript" charset="utf-8"></script>
<script src="vendor/isotope/isotope.min.js"></script>
<script src="vendor/lightcase/lightcase.js"></script>
<script src="vendor/waypoints/waypoint.min.js"></script>
<script src="js/aos.js"></script>

<!-- Main JS -->
<script src="js/app.min.js "></script>
<script src="//localhost:35729/livereload.js"></script>
</body>
</html>
