<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>比赛通知</title>
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

    <script   type="text/javascript">
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



 <script   type="text/javascript">
        $(document).ready(function() {
        	
        	 $("#s-btn").click(function() {
        		  var key = $("input[id='s-key']").val();
        		  var options=$("#category option:selected"); //获取选中的项
                  var flag=  options.val();
        		
        		  window.location.href="/T/ShowAllNotice?username=${username }&currentPage=0&theme="+flag+"&key="+key;
        		  
        		  
        	 });
        	 $(".text-center").click(function() {
        		var compe_id=$(this).attr("id");
        		 window.location.href="/T/CompetitionDeatils?compe_id="+compe_id+"&username=${username}";
        		});
        	 
        	
        });
        		</script>
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
   
    
</nav>
<div class="f2 d-flex text-center ">
    <div class="f2-item p-4"><a href="/T/ReplayAllQuestion?username=${username }&currentPage=0&theme=全部" >问题咨询</a></div>
    <div class="f2-item p-4"><a href="/T/ShowAllNotice?username=${username }&currentPage=0&theme=CF赛事" >比赛通知</a></div>
    <div class="f2-item p-4"><a href="/T/FoodShareServlet?username=${username}">美食天下</a></div>
    <div class="f2-item p-4"> <a href="/T/IndexServlet?currentPage=0&theme=软件&username=${username}" >资料分享</a></div>
</div>

<div class="t1 container-fluid col-sm-8 offset-2">
    <!--头部-->
    <div class="t1-head ">
        <span class="icon1">
                <img src="img/icon/zhuye.png"  class="img1">
            </span>
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
<%--            <div class="">--%>
<%--                <ul class="t1-tags list-inline">--%>
<%--                    <li class="tag list-inline-item" id="tag1"><a href="/T/ShowAllNotice?username=${username }&currentPage=0&theme=创新创业赛事">创新创业赛事</a></li>--%>
<%--                    <li class="tag list-inline-item" id="tag2"><a href="/T/ShowAllNotice?username=${username }&currentPage=0&theme=ACM赛事">创新创业赛事</a></li>--%>
<%--                    <li class="tag list-inline-item" id="tag3"><a href="/T/ShowAllNotice?username=${username }&currentPage=0&theme=CF赛事">CF赛事</a></li>--%>
<%--                    <li class="tag list-inline-item" id="tag4"><a href="/T/ShowAllNotice?username=${username }&currentPage=0&theme=CTF赛事">CTF赛事</a></li>--%>
<%--                </ul>--%>
<%--            </div>--%>
            <div class="nodes">
                <div class="d-flex flex-row" style="padding-left: 30px;margin-bottom: 30px;">
                    <span class="h-25">比赛类型:</span>
                    <div class="info-select h-25">
                        <select name="cars" id="category">
                            <option value="请选择一个比赛类型">请选择一个比赛类型</option>
                            <option value="创新创业赛事">创新创业赛事</option>
                            <option value="ACM赛事">ACM赛事</option>
                            <option value="CF赛事">CF赛事</option>
                            <option value="CTF赛事">CTF赛事</option>
                        </select>
                    </div>
                    <input style="margin-left: 30px;margin-right: 10px" type="text" class="h-25" placeholder="请输入要查询的关键字" id="s-key">
                    <button class=" btn-primary h-25" id="s-btn">搜索</button>
                </div>
                <div class="node d-flex flex-row border-bottom" style="margin-bottom: 20px;">
                    <table class="table table-hover">
                        <thead>
                            <tr class="text-center">
                                <th>赛事编号</th>
                                <th>赛事类型</th>
                                <th>赛事名称</th>
                                <th>发布时间</th>
                                <th>浏览量</th>
                            </tr>
                        </thead>
                        <c:forEach items="${requestScope.pageBean.list }" var="notice" varStatus="status">
                                    <tbody>
                                      <tr class="text-center" id="${ notice.notice_id }">
                                          <td>${notice.notice_id }</td>
                                          <td><a href="#" style="color: #34A0EB">${notice.theme }</a></td>
                                          <td><a href="#" style="color: #34A0EB">${notice.competition_name}</a></td>
                                          <td>${notice.release_time }</td>
                                          <td>${notice.read_num }</td>
                                      </tr>
                                    </tbody>
                        </c:forEach>
                                    <tr>
                                        <td></td>
                                        <td class="page-item active"><a class="page-link" href="/T/ShowAllNotice?username=${username }&currentPage=1&theme=${theme}">首页</a></td>
                                        <td class="page-item"><a class="page-link" href="/T/ShowAllNotice?username=${username }&currentPage${requestScope.pageBean.currentPage - 1}&theme=${theme}">上一页</a></td>
                                        <td class="page-item"><a class="page-link" href="/T/ShowAllNotice?username=${username }&currentPage=${requestScope.pageBean.currentPage + 1}&theme=${theme}">下一页</a></td>
                                        <td class="page-item"><a class="page-link" href="/T/ShowAllNotice?username=${username }&currentPage=${requestScope.pageBean.totalPage}&theme=${theme}">末页</a></td>
                                    </tr>
                    </table>
                </div>
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
