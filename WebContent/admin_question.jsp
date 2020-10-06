<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
<script type="text/javascript">
    var s_height = window.screen.height;
    var s_width = window.screen.width;
</script>


<style>
    .first-title {
        background-color: #6BBB45;

    }

    .carousel-inner img {
        width: 100%;
        height: 300px;
    }
</style>
</head>
<script type="text/javascript">

    $(document).ready(function () {

        // 获取验证码按钮
        $("#search").click(function () {
            var key = $("input[id='search_txt']").val();

            window.location.href = "/T/ManageQuestion?currentPage=${requestScope.pageBean.currentPage}&key=" + key.toString();

        });
    });
</script>
<body>
<div class="input-group col-sm-3 offset-7 mb-5" style="padding-top: 30px; padding-bottom: 30px;">
    <div class="input-group-prepend">
        <span class="input-group-text "><img class="img-fluid" style="width: 20px; height: 20px;"
                                             src="img/icon/sousuo.png"></span>
    </div>
    <input type="text" class="form-control" placeholder="请输入文件名关键字" id="search_txt">
    <button class="btn btn-outline-primary" id="search">搜索</button>
</div>
<!-- Tab panes -->
<div class="tab-content " style="background-color: white">
    <div class=""><h4>帖子管理</h4></div>
    <div id="m1" class="tab-pane active"><br>
        <table class="table table-hover">


            <thead>
            <tr class="text-center">
                <th>编号</th>
                <th>标题</th>
                <th>分类</th>
                <th>问题</th>
                <th>发布时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <c:forEach items="${requestScope.pageBean.list }" var="question" varStatus="status">
            <tbody>
            <tr class="text-center">
                <td>${ status.index + 1}</td>
                <td>${question.title }</td>
                <td>${question.category }</td>
                <td>${question.content }</td>
                <td>${question.release_time }</td>
                <td>

                    <a href="/T/EditQuestion?question_id=${question.question_id }&user_id=${question.user_id }&currentPage=${requestScope.pageBean.currentPage }&th=删除"
                       class="btn btn-outline-primary">删除</a>
                </td>
            </tr>
            </c:forEach>


            <tr class="text-center">
                <td></td>
                <td>
                    <a href="/T/ManageQuestion?currentPage=1&key=${key}">首页</a>
                </td>
                <td>
                    <a href="/T/ManageQuestion?currentPage=${requestScope.pageBean.currentPage - 1}&key=${key}">上一页</a>
                </td>
                <td>
                    <a href="/T/ManageQuestion?currentPage=${requestScope.pageBean.currentPage + 1}&key=${key}">下一页</a>
                </td>
                <td>
                    <a href="/T/ManageQuestion?currentPage=${requestScope.pageBean.totalPage}&key=${key}">末页</a>
                </td>
                <td></td>
            </tr>
            </tbody>
        </table>


    </div>
</div>

</body>
</html>