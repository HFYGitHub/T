<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="http://localhost:8080/T/test?fileName=111.doc" method="POST"   >
<input type="submit" value="下载"/>
</form>
</body>
</html>




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
         				url: 'EditPwd',
         				type: 'post',
         				data: {
         					
 	           				username:"${username}",
 	           				org_pwd:$("input[name='pwd']").val(),
 	           				new_pwd:$("input[name='new-pwd']").val(),
 	           				email:email,
 	           				code:$("input[name='yzm']").val(),
 	           				method:"changepwd"
         					},
         				dataType: 'text',
         				success: function(msg) {
         					
         					if(msg==0){
         						
         						 alert("密码错误");
         					}else if(msg==-1){
         						 alert("验证码输入错误");
         					}else if(msg==-2){
         						 alert("用户信息错误");
         					}else{
         						 alert("修改成功");
         						 
         					}
         				}	
         			});
        			 
        			 
        			 
        		 
        	}
        	
        	
        	

        });