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

            window.location.href = "/T/AllCompetition?currentPage=${requestScope.pageBean.currentPage}&key=" + key.toString();

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
    <div class="d-flex flex-row" style="padding: 15px">
        <h4 class="mr-auto">帖子管理</h4>
        <button type="button"  class="btn btn-primary" data-toggle="modal" data-target="#myModal">发布赛事</button>
     <!-- 模态框 -->
        <div class="modal fade" id="myModal">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- 模态框头部 -->
                    <div class="modal-header">
                        <h4 class="modal-title">赛事发布</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- 模态框主体 -->
                    <div class="modal-body">
                       <form name="uploadForm" method="POST" 
        enctype="MULTIPART/FORM-DATA" 
        action="/T/ReleaseCompetitionServlet" >

                            <div class="d-flex flex-row">
                                <div class="offset-1 d-flex flex-column">
                                    <span>请选择一个主题:</span>
                                    <select name="cars" id="theme">
                  						 
                  						  <option value="创新创业赛事">创新创业赛事</option>
                  						  <option value="ACM赛事">ACM赛事</option>
                  						  <option value="CF赛事">CF赛事</option>
                 					   <option value="CTF赛事">CTF赛事</option>
                                      </select><br/>
                                      
                                       
        赛事内容：
        <textarea rows="4" cols="20" name="content">   </textarea>
       赛事名称：
       <input type="text" name="comprname" /> <br/>
              附件：	
         
         <input class="btn" type="file" name="file1" /><br/>
        <div class="offset-3 d-flex flex-row" style="padding-top: 20px;padding-bottom: -3%">
        <input type="submit" name="submit" value="发布赛事" class="btn btn-primary" > <br/>
      
        <input class="btn btn-primary offset-2" type="reset" name="reset" value="重置"> <br/>
          
          </div>  
          </div>
          </div>                 
          </form>  
          </div>
              
                                   

                    <!-- 模态框底部 -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <div id="m1" class="container-fluid tab-pane active"><br>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>编号</th>
                <th>赛事主题</th>
                <th>内容</th>
                <th>上传时间</th>
                <th>阅读次数</th>
                <th>附件</th>
                <th>编辑</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <c:choose>
                <c:when test="${not empty requestScope.pageBean.list }">
                <c:forEach items="${requestScope.pageBean.list }" var="file" varStatus="status">

            <tr>
                <td>${status.index + 1}</td>
                <td>${file.theme }</td>
                <td>${file.content }</td>
                <td>${file.release_time }</td>
                <td>${file.read_num }</td>
                <td>${file.file }</td>
                <td>
                    <a href="/T/ManageCompServlet?notice_id=${file.notice_id }&currentPage=${requestScope.pageBean.currentPage }">删除</a>
                    <a href="/T/EditCompServlet?id=${file.notice_id }">编辑</a>
                </td>
            </tr>

            </c:forEach>

            </c:when>
            </c:choose>

            <tr>
                <td></td>
                <td><a href="/T/AllCompetition?currentPage=1&key=${key}">首页</a></td>
                <td><a href="/T/AllCompetition?currentPage=${requestScope.pageBean.currentPage - 1}&key=${key}">上一页</a></td>
                <td><a href="/T/AllCompetition?currentPage=${requestScope.pageBean.currentPage + 1}&key=${key}">下一页</a></td>
                <td><a href="/T/AllCompetition?currentPage=${requestScope.pageBean.totalPage}&key=${key}">末页</a></td>
                <td></td>
            </tr>
            </tbody>
        </table>


    </div>
</div>

</body>
</html>