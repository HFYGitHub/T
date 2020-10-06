<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>个人中心</title>
    <meta name="description" content="Roxy">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- External CSS -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/template2.css">
    <link rel="stylesheet" href="css/talk.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="js/t2.js"></script>
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>


    <style>
        input{
            border: 0;
        }
        .first-title {
            background-color: #99BCE2;
        }

        .first-title a {
            color: #005179;
        }

        .card {
            padding: 0;
        }

        .card-header {
            background-color: #92D1F4;
            color: #7F97B3;
        }


        .carousel-inner img {
            width: 100%;
            height: 300px;
        }

    </style>
</head>
<script type="text/javascript">


    var s_height = document.documentElement.clientHeight;


    $(document).ready(function () {
        $("showimage").click(function () {

            var img = document.getElementById("showImg");

            //获取文件对象
            let file = obj.files[0];
            //获取文件阅读器
            let reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = function () {
                //给img的src设置图片url
                img.setAttribute("src", this.result);
            }
        });


        $("#search").click(function () {
            var key = $("input[id='search_txt']").val();


        });

        $("#edit").click(function () {
            $("input[name='email']").attr("disabled",false);
            $("input[name='nickname']").attr("disabled",false);
            $("input[name='academy']").attr("disabled",false);
            $("input[name='declaration']").attr("disabled",false);
            $("input[name='qq']").attr("disabled",false);
            $("input[name='wechat']").attr("disabled",false);
            $("input[name='phone']").attr("disabled",false);

        });
        // 获取验证码按钮
        $("#save").click(function () {


            $.ajax({
                url: 'EditUserInfor',
                type: 'post',
                data: {
                    org_username: "${username}",
                    email: $("input[name='email']").val(),
                    username: $("input[name='username']").val(),
                    nickname: $("input[name='nickname']").val(),
                    sex: $("#sex option:selected").text(),
                    academy: $("input[name='academy']").val(),
                    declaration: $("input[name='declaration']").val(),
                    qq: $("input[name='qq']").val(),
                    wechat: $("input[name='wechat']").val(),
                    phone: $("input[name='phone']").val()
                },
                dataType: 'text',
                success: function () {
                    $("input[name='email']").attr("disabled",true);
                    $("input[name='nickname']").attr("disabled",true);
                    $("input[name='academy']").attr("disabled",true);
                    $("input[name='declaration']").attr("disabled",true);
                    $("input[name='qq']").attr("disabled",true);
                    $("input[name='wechat']").attr("disabled",true);
                    $("input[name='phone']").attr("disabled",true);
                }
            });
        });
    });
</script>


<body>


<div>
    <c:forEach items="${allinformation}" var="information" varStatus="status">
        <div class="text-center">
            <img alt="头像" src="imgs/${information.image }" class="img-fluid" style="height: 250px;width: 250px">
            <hr />
        </div>
        <div class="d-flex flex-row">


            <div class="card col-sm-3 offset-1">

                <div class="card-header">个人资料</div>
                <div class="card-body">

                    <table >
                        <tbody>
                        <tr>
                            <td>账户名：</td>
                            <td><input type="text" value="${information.name }" name="username" readonly="readonly"/>
                            </td>
                        </tr>
                        <tr>
                            <td>昵称：</td>
                            <td><input type="text" value="${information.nickname }" name="nickname" disabled="disabled"/></td>
                        </tr>
                        <tr>
                            <td>性别：</td>
                            <td>
                                <select id="sex">
                                    <option value="${information.sex }">${information.sex }</option>

                                    <c:if test="${information.sex eq '女' }">
                                        <option value="男">男</option>
                                    </c:if>
                                    <c:if test="${information.sex eq '男' }">
                                        <option value="女">女</option>
                                    </c:if>

                                </select>
                            </td>

                        </tr>
                        <tr>
                            <td>学院：</td>
                            <td><input type="text" value="${information.academy }" name="academy" disabled="disabled"/></td>
                        </tr>

                        <tr>
                            <td>微信：</td>
                            <td><input type="text" value="${information.wechat }" name="wechat" disabled="disabled"/></td>
                        </tr>
                        <tr>
                            <td>邮箱：</td>
                            <td><input type="text" value="${information.email }" name="email" disabled="disabled"/></td>
                        </tr>
                        <tr>
                            <td>电话：</td>
                            <td><input type="text" value="${information.phone }" name="phone" disabled="disabled"/></td>
                        </tr>
                        <tr>
                            <td>QQ：</td>
                            <td><input type="text" value="${information.qq }" name="qq" disabled="disabled"/></td>
                        </tr>
                        </tbody>

                    </table>

                </div>


            </div>
            <div class="card col-sm-3" style="margin-left: 100px">
                <div class="card-header">
                    个人宣言
                </div>
                <div class="card-body" contenteditable="true">
                        ${information.declaration }
                </div>

            </div>
            <div class="card col-sm-3" style="margin-left: 100px">
                <div class="card-header">
                    操作中心
                </div>
                <div class="card-body text-center" >
                    <form method="post"
                          action="/T/PhotoServlet?method=add&username=${username}"
                          enctype="multipart/form-data">
                        <div>
                            <label>
                                <input style="position:absolute;opacity:0;" type="file" name="file" id="showimage"/>
                                <img style="width: 60px;height: 60px;" src="imgs/${information.image }" id="showImg">
                            </label>
                        </div>
                        <input type="submit" class="btn btn-primary" value="更换头像"/>
                    </form>
                    <button id="edit"  class="btn btn-primary" style="margin-top: 30px;">资料修改</button>
                    <button id="save"  class="btn btn-primary" style="margin-top: 30px;">资料保存</button>
                </div>
            </div>

        </div>
    </c:forEach>

</div>


</body>