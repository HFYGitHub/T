<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>个人中心</title>
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

            window.location.href = "/T/ManageMyFile?username=${username}&key=" + key.toString()+"&th=搜索";

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
    <div class=""><h4>已下载文件</h4></div>
    <div id="m1" class=" tab-pane active"><br>
        <table class="table table-hover">
            <thead>
                <tr class="text-center">
                    <th>编号</th>
                    <th>文件名</th>
                    <th>下载时间</th>
                    <th>下载次数</th>
                    <th>所属分类</th>
                </tr>
            </thead>
            <tbody>
            <tr>
                <c:choose>
                    <c:when test="${not empty uf }">
                        <c:forEach items="${uf }" var="file" varStatus="status">
                            <tr class="text-center">
                                <td>${status.index + 1}</td>
                                <td>${file.filename }</td>
                                <td>${file.down_time }</td>
                                <td>${file.down_num }</td>
                                <td>${file.theme }</td>

                            </tr>
                        </c:forEach>
                    </c:when>
                </c:choose>




            </tbody>
        </table>


    </div>
</div>

</body>
</html>