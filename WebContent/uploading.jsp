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
<style type="text/css">
    .father-scroll {
        overflow-y: scroll;
        width: 200px;
        height: 100px;
    }

    .theme-scroll {
        overflow-y: scroll;
        width: 50px;
        height: 20px;
    }

    /*  .theme{
     height: 20px;
     width: 20px;} */

</style>
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $(":input[type=button][value=add]").bind("click", function () {
            var $br = $("<br />");
            var $img = $("<img src='img/icon/上传.png' alt='上传' class='img-fluid ' style='height: 100px;width: 100px;'>");
            var $file = $("<input class='btn btn-primary' type='file' name='name1' />");
            var $button = $("<input class='btn btn-danger' type='button' value='delete' style='width: 80px'>");
            $(this).after($br).after($button).after($file).after($img).after($br);
            $button.bind("click", function () {
                $br.remove()
                $file.remove();
                $button.remove();
                $img.remove();
            })
        })
    });
</script>
<body>
<div class="d-flex flex-row offset-4" style="padding: 10px;">
    <h2 class="">Upload File1</h2>
    <a href="/T/FileIndexServlet" class="offset-3">
        <button class="btn btn-primary">返回上一页</button>
    </a>
</div>
<HR>


<form name="uploadForm" method="POST"
      enctype="MULTIPART/FORM-DATA"
      action="/T/UploadServlet">

    <div class="d-flex flex-row">
        <div class="offset-1 d-flex flex-column col-sm-4">
            <span>主题:</span>
            <select name="sear">
                <option value="经管">经管</option>
                <option value="物理">物理</option>
                <option value="英语">英语</option>
                <option value="软件">软件</option>
                <option value="文学">文学</option>
                <option value="会计">会计</option>
                <option value="生物">生物</option>
                <option value="设艺">设艺</option>
                <option value="化工">化工</option>
                <option value="医学">医学</option>
                <option value="马原">马原</option>
                <option value="高数">高数</option>
                <option value="毛概">毛概</option>
            </select><br/>
            <img src="img/icon/上传.png" alt="上传" class="img-fluid" style="height: 100px;width: 100px;">
            <input class="btn btn-primary" type="file" name="file1" size="30"/> <br/>
        </div>
        <div class="offset-1" style="border:2px solid ;float:left;"></div>
        <div class="offset-1 col-sm-5">
            <input class="btn btn-info" type="button" value="add" style="width: 80px"/><br/>
        </div>
    </div>
    <div class="d-flex flex-row offset-5">
        <input class="btn btn-primary" type="submit" name="submit" value="上传"> <br/>
        <input class="offset-2 btn btn-primary" type="reset" name="reset" value="重置"> <br/>
    </div>
</form>


</body>
</html>