<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

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
   <script type="text/javascript" src="WebContent/js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="WebContent/js/isEmail.js"></script>
    

    <style>
        .first-title{
            background-color: #99BCE2;
        }
        .first-title a{
            color: #005179;
        }
        .card{
            padding: 0;
        }
        .card-header{
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
    var time0 = 60;
    var time = time0;  
    var t;  // 用于验证按钮的60s计时
    $(document).ready(function() {
       
        $("#getCode").click(function() {
        	var btnGet = document.getElementById("getCode");
    		
        	var num=0;
        	if($("input[name='pwd']").val()==null||$("input[name='pwd']").val().trim()==""){
        		  num=1;
        		  $("#pwd")[0].style.border="red";
        	}
        	if($("input[name='new-pwd']").val()==null||$("input[name='new-pwd']").val().trim()==""){
        		  num=1;
        		  $("#new-pwd")[0].style.border="red";
        	}
        	if($("input[name='sure-new']").val()==null||$("input[name='sure-new']").val().trim()==""){
        		   num=1;
        		  $("#sure-new")[0].style.border="red";
        	}
        	if($("input[name='eml']").val()==null||$("input[name='eml']").val().trim()==""){
        		  num=1;
        		  $("#eml")[0].style.border="red";
        	}
        	if($("input[name='new-pwd']").val()!=$("input[name='sure-new']").val()){
        		num=1;
        	
        	}
        	if(num==0){ 
        		 var reg=/^\w{5,}@[a-z0-9]{2,3}\.[a-z]+$|\,$/;
        		 var email=$("input[name='eml']").val();
        		 if(reg.test(email)){
        			 
        			 btnGet.disabled = true;  // 为了防止多次点击
        			 $.ajax({
        					url: 'EditPwd',
        					type: 'post',
        					data: {username:"${username}",
     	           				org_pwd:$("input[name='pwd']").val(),
     	           				new_pwd:$("input[name='new-pwd']").val(),
     	           				email:email,
     	           				method:"getCode"},
        					dataType: 'text',
        					success: function(msg) {
        						if(msg ==  0){
        							 btnGet.disabled = false;  
             						 alert("密码错误");
        						}else if(msg == -1){
        							 btnGet.disabled = false;  
             						 alert("用户名与邮箱不匹配");
        						}else{
        							alert("验证码已发送");
        						}
        					},error:function(msg){
        					}
        				});
        			
        			 
        			 
        			 
        		 }else{
        			 $("#eml")[0].style.border="red";
        		 }
        	}
        	
        	
        	

        });
        
        

        $("#setpwd").click(function() {
                	
                	var num=0;
                	if($("input[name='pwd']").val()==null||$("input[name='pwd']").val().trim()==""){
                		  num=1;
                		  $("#pwd")[0].style.border="red";
                	}
                	if($("input[name='new-pwd']").val()==null||$("input[name='new-pwd']").val().trim()==""){
                		  num=1;
                		  $("#new-pwd")[0].style.border="red";
                	}
                	if($("input[name='sure-new']").val()==null||$("input[name='sure-new']").val().trim()==""){
                		   num=1;
                		  $("#sure-new")[0].style.border="red";
                	}
                	if($("input[name='eml']").val()==null||$("input[name='eml']").val().trim()==""){
                		  num=1;
                		  $("#eml")[0].style.border="red";
                	}
                	if($("input[name='new-pwd']").val()!=$("input[name='sure-new']").val()){
                		num=1;
                		 $("#new-pwd")[0].style.border="red";
                		 $("#sure-new")[0].style.border="red";
                	}
                	if($("input[name='yzm']").val()==null||$("input[name='yzm']").val().trim()==""){
                		num=1;
                		$("#yzm")[0].style.border="red";
                	}
                	if(num==0){
                		 var email=$("input[name='eml']").val();
                		 
                		 $.ajax({
         					url: 'Edit',
         					type: 'post',
         					data: {username:"${username}",
     	           				org_pwd:$("input[name='pwd']").val(),
     	           				new_pwd:$("input[name='new-pwd']").val(),
     	           				email:email,
     	           				code:$("input[name='yzm']").val(),
     	           				method:"changepwd",
     	           				},
         					dataType: 'text',
         					success: function(msg) {
         						if(msg==0){
         							 alert("未发送验证码");
         						}else if(msg == -1){
         							 alert("验证码输入错误");
         						}else if(msg == -2){
         							alert("用户信息错误");
         						}else if(msg==1){
            						 alert("修改成功");
         						}	 
             					
         					},error:function(msg){
         					}
         				});
                			
                			 
                			 
                		 
                	}
                	
                	
                	

                });
           
      
    });
    
    function changeBTN(){
    	if(time > 0){
    		$("#getCode").text("("+time+"s)"+"重新获取");
    		time = time - 1;
    	}
    	else{
    		var btnGet = document.getElementById("getCode");
    		btnGet.disabled = false;
    		$("#getCode").text("获取验证码");
    		clearInterval(t);
    		time = time0;
    	}
    }
    function useChangeBTN(){
    	$("#getCode").text("("+time+"s)"+"重新获取");
    	time = time - 1;
    	t = setInterval("changeBTN()", 1000);  // 1s调用一次
    }
</script>
<body>
<div class="offset-1 col-sm-9"><br>
            <h3>修改密码</h3>
            <p>您必须填写原密码才能修改下面的资料</p>
            <hr />
            
                <div class="form-group">
                    <label for="pwd"><span style="color: red">*</span>旧密码:</label>
                    <input type="password" class="form-control" id="pwd" placeholder="请输入旧密码" name="pwd">
                </div>
                <div class="form-group">
                    <label for="new-pwd">新密码:</label>
                    <input type="password" class="form-control" id="new-pwd" placeholder="请输入新密码" name="new-pwd">
                </div>
                <div class="form-group">
                    <label for="sure-new">确认新密码:</label>
                    <input type="password" class="form-control" id="sure-new" placeholder="请输入确认新密码" name="sure-new">
                </div>
                <div class="form-group">
                    <label for="eml"><span style="color: red">*</span>邮箱:</label>
                    <input type="email" class="form-control" id="eml" placeholder="请输入邮箱号码" name="eml">
                </div>
                <div class="form-group">
                    <label for="yzm">邮箱验证码:</label>
                    <input type="text" class="form-control" id="yzm" placeholder="请输入邮箱验证码" name="yzm">
                    <input type="button" class="btn-pwd btn btn-info" value="获取验证码" id="getCode">
                </div>
                <input type="button" class="offset-5 btn-pwd btn btn-info" value="提交" id="setpwd">
           
        </div>
</body>
</html>