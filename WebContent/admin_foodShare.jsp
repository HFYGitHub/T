<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>管理员界面</title>
    <meta name="description" content="Roxy">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- External CSS -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/template2.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="js/t2.js"></script>
    <script  type="text/javascript">
        var s_height = window.screen.height;
        var s_width = window.screen.width;
    </script>


    <style>
        .first-title{
            background-color: #6BBB45;

        }
        .carousel-inner img {
            width: 100%;
            height: 300px;
        }

    </style>
    </head>
       <script type="text/javascript">

$(document).ready(function() {

	// 获取验证码按钮
	$("#search").click(function() {
		var key=$("input[id='search_txt']").val();

		window.location.href="/T/FoodIndexServlet?currentPage=${requestScope.pageBean.currentPage}&key="+key.toString();

	});
});
</script>
<body>
<div class="input-group col-sm-3 offset-7 mb-5" style="padding-top: 30px; padding-bottom: 30px;">
            <div class="input-group-prepend">
                <span class="input-group-text "><img class="img-fluid" style="width: 20px; height: 20px;" src="img/icon/sousuo.png"></span>
            </div>
            <input type="text" class="form-control" placeholder="" id="search_txt">
            <button class="btn btn-outline-primary" id="search">搜索</button>
        </div>
        <!-- Tab panes -->
        <div class="tab-content " style="background-color: white">
            <div class=""><h4>帖子管理</h4></div>
            <div id="m1" class=" tab-pane active"><br>
                <table class="table table-hover">
                    <thead>
                        <tr class="text-center">
                            <th>编号</th>
                            <th>图片</th>
                            <th>美食类型</th>
                            <th>分享时间</th>
                            <th>喜爱值</th>
                            <th>浏览数</th>
                            <th>介绍</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:choose>
                            <c:when test="${not empty requestScope.pageBean.list }">
                                <c:forEach items="${requestScope.pageBean.list }" var="food" varStatus="status">

                                    <tr class="text-center">
                                        <td>${status.index + 1}</td>
                                        <td><img alt="照片" class="food-img" style="width:300px;height:150px;" src="img/food/${food.img_name}" ></td>
                                        <td>${food.text }</td>
                                        <td>${food.release_time }</td>
                                        <td>${food.fabulous }</td>
                                        <td>${food.number }</td>
                                        <td>${food.introduce }</td>
                                        <td>
                                            <a href="/T/SearchFoodServlet?food_id=${food.food_id }" class="btn btn-outline-primary">查看留言</a>
                                            <a href="/T/ManageFoodServlet?food_id=${food.food_id }" class="btn btn-outline-primary">删除帖子</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                        </c:choose>
                            <tr class="text-center">
                                <td></td>
                                <td><a href="/T/FoodIndexServlet?currentPage=1&key=${key}">首页</a></td>
                                <td><a href="/T/FoodIndexServlet?currentPage=${requestScope.pageBean.currentPage - 1}&key=${key}">上一页</a></td>
                                <td><a href="/T/FoodIndexServlet?currentPage=${requestScope.pageBean.currentPage + 1}&key=${key}">下一页</a></td>
                                <td><a href="/T/FoodIndexServlet?currentPage=${requestScope.pageBean.totalPage}&key=${key}">末页</a></td>
                                <td></td>
                            </tr>
                    </tbody>
                </table>
            </div>
      </div>
</body>
