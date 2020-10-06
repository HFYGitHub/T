<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
 <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Register</title>
    <meta name="description" content="Roxy">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- External CSS -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/new-user.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script type="text/javascript" src="WebContent/js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="WebContent/js/isEmail.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>

<script type="text/javascript">
var time0 = 60;
var time = time0;  
var t;  // 用于验证按钮的60s计时

$(document).ready(function() {

	// 获取验证码按钮
	$("#btnGetVcode").click(function() {
		var btnGet = document.getElementById("btnGetVcode");
		btnGet.disabled = true;  // 为了防止多次点击
		$.ajax({
			url: 'FindPwdServlet',
			type: 'post',
			data: {email: $("input[name='eml']").val(),
				username:$("input[name='username']").val()},
			dataType: 'text',
			success: function(msg) {
				if(msg ==  0){
					btnGet.disabled = false;
					alert("请输入正确用户名和邮箱") ;
				}else if(msg == 1){
					
					alert("发送成功") ;
					useChangeBTN();
				}else if(msg == -1){
					btnGet.disabled = false;
					alert("请输入正确用户名和邮箱") ;
				}
			},error:function(msg){
			}
		});
	});
	
	
	
$("#btnVerify").click(function() {
	
	
	var message = document.getElementById("message");  // 显示提示信息
	$.ajax({
		url: 'checkCodeServlet',
		type: 'post',
		data: {code: $("input[name='code']").val()
			,email:$("input[name='eml']").val()
			,username:$("input[name='username']").val()
		},
		dataType: 'text',
		success: function(msg) {
			if(msg == -1){
				alert("用户名为空") ;
			}else if(msg == 0){
				alert("用户不存在") ;
			}else if(msg == 1){
				
			
				alert("用户密码："+"${pwd}");
			}else if(msg == -2){
				alert("验证码输入错误") ;
			
			}else if(msg == -3){
				alert("请输入正确邮箱名") ;
				
			}
		},error:function(msg){
			
		}
	});
});
});


function changeBTN(){
	if(time > 0){
		$("#btnGetVcode").text("("+time+"s)"+"重新获取");
		time = time - 1;
	}
	else{
		var btnGet = document.getElementById("btnGetVcode");
		btnGet.disabled = false;
		$("#btnGetVcode").text("获取验证码");
		clearInterval(t);
		time = time0;
	}
}
function useChangeBTN(){
	$("#btnGetVcode").text("("+time+"s)"+"重新获取");
	time = time - 1;
	t = setInterval("changeBTN()", 1000);  // 1s调用一次
}
</script>
<body>
<form id="form0" name="form0" AUTOCOMPLETE="OFF">
 <div class="d-flex  info offset-3 cas" style="">
    <div class="login-bg rounded col-sm-4" style="padding: 30px">
        <div class="text-center" style="color: #0099CC">
            <h3>欢迎来到</h3>
            <a href="main.jsp" style="color: #0066CC"><h2>你的USC</h2></a>
            <h3>南华校园交流圈</h3>
        </div>
        <div class="text-center" style="">
            <img alt="加载" class="img-fluid" src="img/loading.gif" style="height: 300px;width: 300px">
        </div>
    </div>
    <div class="login-info rounded d-flex flex-column col-sm-4" style="">
        <div class="text-center">
            <img alt="logo" class="img-fluid" src="img/LOGO1.png" style="width: 350px;height: 200px">
        </div>
        <div>
         <span id="message"></span>
        </div>

        <div class="form-group">
            <div class="d-flex flex-row in-css">
                <img class="img-fluid" src="img/icon/huiyuan.png" alt="用户"  style="height: 30px;width: 30px">
                <input type="text" class="form-control" id="usr" placeholder="请输入用户名" name="username">
            </div>
        </div>

        <div class="form-group">
            <div class="d-flex flex-row in-css">
                <img class="img-fluid" src="img/icon/mima.png" alt="邮箱"  style="height: 30px;width: 30px">
                <input type="email" class="form-control" placeholder="请输入邮箱号码" name="eml" id="eml">
            </div>
        </div>
        <div class="form-group">
            <div class="d-flex flex-row in-css">
                <img class="img-fluid" src="img/icon/mima.png" alt="验证码"  style="height: 30px;width: 30px">
                <input type="text" class="form-control" name="code" placeholder="请输入邮箱验证码">
                <a target="_self" class="col-sm-5" style="padding: 0">
                    <button type="button" id="btnGetVcode" style="cursor:pointer" class="text-nowrap form-control btn btn-primary">获取验证码</button>
                </a>
            </div>
        </div>
        <a class="register offset-10 ml-auto" href="login.jsp" style="float: right;">返回登录</a>
        <a target="_self">
		    <button type="button" id="btnVerify" class="offset-1 btn btn-primary col-sm-10" style="cursor:pointer">找回密码</button>
        </a>


    </div>

</div>
</form>
</body>
</html>