<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>问题咨询</title>
    <meta name="description" content="Roxy">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- External CSS -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/template1.css">
    <link rel="stylesheet" href="css/talk.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="js/t1.js"></script>

    <script type="text/javascript" src="WebContent/js/jquery-1.11.3.js"></script>
    <script  language="javascript" type="text/javascript">
        var s_height = window.screen.height;
        var s_width = window.screen.width;
    </script>

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
<script type="text/javascript">
    function a(){
        $.ajax({
            url:"QuestionShowServlet",//servlet文件的名称
            type:"GET",
            success:function(e){
                alert("servlet调用成功！");
            }
        });

    }
    $(document).ready(function() {


        $("#publish").click(function() {


            var username="${username}";
            var category=$("#category").find("option:selected").text();

            var content=editor.txt.text();
            alert(category+username+content);
            $.ajax({
                url: 'QuestionServel',
                type: 'post',
                data: {username:username,
                    categroy: category,
                    content: content,
                    title: $("input[id='title']").val()},

                dataType: 'text',
                success: function() {
                    window.location.href="/T/ReplayAllQuestion?username="+"${username }"+"&currentPage="+"${requestScope.pageBean.currentPage }"+"&theme="+"${theme}";
                }
            });
        });
    });


    $(document).ready(function() {

        // 获取发布回复按钮
        $(".sub").click(function() {
            var username="${username}";
            var id=$(".sub").attr("id");
            alert(username+id);
            $.ajax({
                url: 'AnswerQuestionServel',
                type: 'post',
                data: {username:username,
                    id:id,
                    answer: $("input[id='answer']").val()},

                dataType: 'text',
                success: function() {
                    window.location.href="/T/ReplayAllQuestion?username="+"${username }"+"&currentPage="+"${requestScope.pageBean.currentPage }"+"&theme="+"${theme}";

                }
            });
        });
    });
</script>
<body>

<nav class="first-title d-flex flex-row " >
    <h3 class="name-title text-white" > Y O </br>U S C</h3>
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
    <div class="f2-item p-4"><a href="/T/ReplayAllQuestion?username=${username }&currentPage=0&theme=全部" >问题咨询</a></div>
    <div class="f2-item p-4"><a href="/T/ShowAllNotice?username=${username }&currentPage=0&theme=CF赛事" >比赛通知</a></div>
    <div class="f2-item p-4"><a href="/T/FoodShareServlet?username=${username}">美食天下</a></div>
    <div class="f2-item p-4"> <a href="/T/IndexServlet?currentPage=0&theme=软件&username=${username}" >资料分享</a></div>
</div>

<div class="t1 container-fluid col-sm-8 offset-2">
    <!--头部-->
    <div class="t1-head border">
        <div class="">
            <span class="icon1">
                    <img src="img/icon/zhuye.png" class="img1 ">
                </span>
        </div>
        <div class="head-info">
            <span class="text-white">
                <strong>今日：</strong>
                <span class="pipe">|</span>
                <strong>主题：</strong>
                <span class="pipe">|</span>
            </span>
        </div>
        <div class="bulletin border">
            <div class="jumbotron blt-text" style="text-align: center">
                <h1 class="">公告</h1>
                <p>1.请勿发表意义不明、内容空洞、语序错乱、标题党的主题！</p>
                <p>2.请勿发表涉及政治、成人、暴力、色 情、广告等相关内容！</p>
                <p>3.请勿发表引战内容，避免来源不明确、具有争议性的信息！</p>
                <p>4.谢谢合作！</p>
            </div>
        </div>
    </div>
    <!--中心内容-->
    <div class="t1-center">
        <div class="mb-3 border-bottom">
            <span class="icon1">
                    <img src="img/icon/zhuye.png" class="img1 ">
                </span>
            <a href="jlq.html" class="nvhm" title="首页">交流圈</a> <em>›</em>
            <a href="question.html">问题咨询</a> <em>›</em> <a href="question.html">问题咨询</a>
        </div>

        <div class="d-flex flex-row offset-2 col-sm-8">
            <a href="#" class="send-btn mr-auto"><button class="btn-primary">回复</button></a>
            <ul class="pagination pagination-sm">
                <li class="page-item"><a class="page-link" href="#"><</a></li>
                <li class="page-item active"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">></a></li>
            </ul>
        </div>
        <div class="">
            <table cellspacing="0" cellpadding="0">
                <tbody>
                    <tr>
                        <td class=" border-right">
                            <span class="n-cnumber">浏览:10</span>
                            &emsp;
                            <span class="rnumber">回复:3</span>
                            &emsp;&emsp;&emsp;&emsp;&emsp;
                        </td>
                        <td class="">
                            <span class="n-head border-bottom">标题</span>
                        </td>
                    </tr>
                </tbody>
            </table>
            <hr>
        </div>
        <div class="row">
            <div class="user-card d-flex flex-column col-sm-2 border-right">

                <div>
                    <span class="user-name">id</span>
                    <hr>
                </div>
                <div>
                    <span class="user-img"><img alt="头像"  class="img-fluid" src="img/bg-white.jpg"></span>
                    <hr>
                </div>
                <div>
                    <span class="">123</span>
                    <hr>
                </div>
            </div>

            <div class="note-info d-flex flex-column col-sm-9 " style="padding: 0">

                <div class=" flex-column">
                    <span class="n-infos text-center" >
                        <span class="n-stime"> 发表于 2019-10-12 19:55:24 </span>
                        <span class="fg">|</span>
                        <span><a href="#">只看该作者</a></span>
                    </span>
                    <hr style="padding: 0">
                    <span class="n-center">内容</span>
                </div>
            </div>
        </div>
        <div class="row border">
            <div class="user-card d-flex flex-column col-sm-2">
                <span class="user-name border-bottom">fly-sk</span>
                <span class="user-img"><img alt="头像" class="img-fluid" src="img/wbg1.jpg"></span>
                <span class=""></span>
            </div>

            <div class="note-info d-inline-flex flex-column col-sm-9 border" style="padding: 0">
                <span class="n-infos border-bottom">
                    <span class="n-stime">发表于 2019-10-12 20:13:05</span>
                    <span class="fg">|</span>
                    <span><a href="#">只看该作者</a></span>
                </span>
                <span class="n-center ">内容不错，支持一下</span>
            </div>
        </div>


        <div class="d-flex flex-row offset-2 col-sm-8">
            <a href="#" class="send-btn mr-auto"><button class="btn-primary">回复</button></a>
            <ul class="pagination pagination-sm">
                <li class="page-item"><a class="page-link" href="#"><</a></li>
                <li class="page-item active"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">></a></li>
            </ul>
        </div>
        <div class="border-top row">
            <div class="col-sm-2" style="padding-top: 100px">
                <span class="user-img"><img alt="头像" class="img-fluid" src="img/loading.gif"></span>
            </div>
            <div class="send-info col-sm-9">
                <div id="editor">
                    <p>请输入帖子内容</p>
                </div>
                <!--加载富文本编辑器-->
                <script type="text/javascript" src="//unpkg.com/wangeditor/release/wangEditor.min.js"></script>
                <script type="text/javascript">
                    var E = window.wangEditor;
                    var editor = new E('#editor');
                    // 或者 var editor = new E( document.getElementById('editor') )
                    editor.customConfig.uploadImgShowBase64 = true;
                    editor.create();
                </script>

                <button class="send-info-btn btn-primary">发表帖子</button>
            </div>
        </div>
    </div>
    <!--底部-->
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
</html>