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
    <script src="js/t2.js"></script>
    <script src="js/talk.js"></script>
   
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
    	
    	 $(".text-center").click(function() {
    		
    		 var q_id=$(this).attr("id");
    		 
    		 var user_id=$(this).attr("data");
    		
    		window.location.href = "/T/AllReplayShow?username=${username}&question_id=" + q_id.toString()+"&theme=${theme}&user_id=" + user_id.toString();
    	 });
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

        <div class="info-table">
            <div class="">
                <table cellspacing="0" cellpadding="0">
                    <tr class="d-flex flex-row">
                        <th colspan="2" class="mr-5">
                            <div class="tf">
                                <ul class="t1-tags list-inline">
                                    <li class="tag list-inline-item" id="tag1"><a href="/T/ReplayAllQuestion?username=${username }&currentPage=0&theme=全部">全部</a></li>
                                    <li class="tag list-inline-item" id="tag2"><a href="/T/ReplayAllQuestion?username=${username }&currentPage=0&theme=最新">最新</a></li>
                                    <li class="tag list-inline-item" id="tag4"><a href="/T/ReplayAllQuestion?username=${username }&currentPage=0&theme=热帖">热帖</a></li>
                                </ul>
                            </div>
                        </th>

                    </tr>
                </table>
            </div>
            <div class="border tab-pane active" >
                <div class="d-flex flex-row">
                    <table class="table table-hover">
                        <thead>
                        <tr class="text-center">
                            <th>编号</th>
                            <th>分类</th>
                            <th>标题</th>
                            <th>作者</th>
                            <th>回复人数</th>
                            <th>最后回复</th>
                        </tr>
                        </thead>
                        <c:forEach items="${requestScope.pageBean.list }" var="question" varStatus="status">
                            <tbody>
                            <tr class="text-center" id="${question.question_id }" data="${question.user_id }">
                                <td>${ status.index + 1}</td>
                                <td style="color: dodgerblue"><a style="color: dodgerblue" href="#">[${question.category }]</a></td>
                                <td style="color: dodgerblue"><a style="color: dodgerblue" href="#">${question.title }</a></td>
                                    <%--                                    <td>${question.content }</td>--%>
                                  <c:forEach items="${quesUser}" var="quesUser">
                                <c:if test="${question.question_id eq  quesUser.q_id}">
                                <td>
                                    <div class="d-flex flex-column">
                                        <span style="color: brown"><a style="color: brown" href="#">${quesUser.pub_username }</a></span>
                                        <span style="color: #999999">${question.release_time }</span>
                                    </div>
                                </td>
                              
                                <td>
                                    <div class="d-flex flex-column">
                                    
                                        <span style="color: #337BB3"><a style="color: #337BB3" href="#">${quesUser.total_num }</a></span>
                                      
                                    </div>
                                </td>
                                <td class="d-flex flex-column">
                                    <span style="color: #333333"><a style="color: #333333" href="#">${quesUser.last_comment_username}</a></span>
                                    <span style="color: #999999">${quesUser.last_time }</span>
                                </td>
                                </c:if>
                                </c:forEach>
                            </tr>
                            </tbody>
                        </c:forEach>
                        <tr>
                            <td></td>
                            <td class="page-item"><a class="page-link" href="/T/ReplayAllQuestion?username=${username }&currentPage=1&theme=${theme}">首页</a></td>
                            <td class="page-item"><a class="page-link" href="/T/ReplayAllQuestion?username=${username }&currentPage${requestScope.pageBean.currentPage - 1}&theme=${theme}">上一页</a></td>
                            <td class="page-item"><a class="page-link" href="/T/ReplayAllQuestion?username=${username }&currentPage=${requestScope.pageBean.currentPage + 1}&theme=${theme}">下一页</a></td>
                            <td class="page-item"><a class="page-link" href="/T/ReplayAllQuestion?username=${username }&currentPage=${requestScope.pageBean.totalPage}&theme=${theme}">末页</a></td>
                            <td></td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>

        <div class="send-title text-white">快速发帖</div>
        <div class="send-info ">
            <div class="send-info-head d-flex flex-row">
                <div class="info-select">
                    <select name="cars" id="category">
                        <option value="de">请选择一个主题</option>
                        <option value="volvo">日常生活</option>
                        <option value="saab">学术问题</option>
                        <option value="fiat">校园活动</option>
                        <option value="audi">其他</option>
                    </select>
                </div>
                <input type="text" class="info-title" size="70" style="height: 30px" id="title">
                <h6 style="color: red">请保持标题在30字以内</h6>
            </div>

            <div id="editor">

            </div>
            <!--加载富文本编辑器-->
            <script type="text/javascript" src="//unpkg.com/wangeditor/release/wangEditor.min.js"></script>
            <script type="text/javascript">
                var E = window.wangEditor;
                var editor = new E('#editor');
                editor.customConfig.uploadImgShowBase64 = true;
                // 或者 var editor = new E( document.getElementById('editor') )
                editor.customConfig.uploadImgShowBase64 = true
                editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024
                editor.customConfig.uploadImgMaxLength = 5
                editor.create();
            </script>

            <button class="send-info-btn btn-primary"  id="publish">发表帖子</button>
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