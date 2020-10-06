<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>个人中心</title>
    <meta name="description" content="Roxy">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- External CSS -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/talk.css">
    <link rel="stylesheet" href="css/foodTalk.css">

    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="js/t1.js"></script>
    <script src="js/t2.js"></script>
    <script src="js/talk.js"></script>
      <script   type="text/javascript">
        var s_height = window.screen.height;
        var s_width = window.screen.width;
        var username,replay_id,re_replay_id,replay_username,answer_id,question_id,user_id;
      
        $(document).ready(function() {
    
        	 $("#comment").click(function() {
        		 var test=document.getElementById("txt1").value;
        		 alert(test);
        		 alert(replay_username+answer_id+re_replay_id+username+user_id+question_id);
        		 $.ajax({
        				url: 'TTT',
        				type: 'post',
        				data: {username:username,
        					replay_username:replay_username,
        					answer_id:answer_id,
        					re_replay_id:re_replay_id,
        					user_id:user_id,
        					question_id:question_id,
        					th:"回复",
        					content:test
        					},
        				dataType: 'text',
        				success: function() {
        					 window.location.reload();
        				}	
        			});
        		});
       $("#f_an a").click(function() {
                    var address =$(this).attr("data-src");
                     $(this).attr("href",address);
                     replay_username=$(this).attr("data-rep_name");//回复的用户名replay_username
                     answer_id=$(this).attr("data-anw_id");//回答id
                     re_replay_id=$(this).attr("data-rep_id");//回复的用户的replay_id
                     question_id=$(this).attr("data-question_id");
                     user_id=$(this).attr("data-user_id");
                     username="${username}";
                    
                });
       
       $("#deletean a").click(function() {
			 
           alert("删除");
           var user_id="${user_id}";
           var username="${username}";
           var theme="${theme}";
           var question_id="${q_id}";
			var answer_id=$(this).attr("id");
    		 $.ajax({
    				url: 'ManageQuesAnswer',
    				type: 'post',
    				data: {
    					username:username,
    					answer_id:answer_id,
    					theme:theme,
    					user_id:user_id,
    					question_id:question_id,
    					th:"删除"
    					},
    				dataType: 'text',
    				success: function() {
    					 window.location.reload();
    				}	
    			});
    		});
       
       $("#delete a").click(function() {
       	var user_id="${user_id}";
           var username="${username}";
           var theme="${theme}";
           var question_id="${q_id}";
			var replay_id=$(this).attr("id");
			 alert("删除");
    		 $.ajax({
    				url: 'ManageCmmment',
    				type: 'post',
    				data: {
    					username:username,
    					
    					replay_id:replay_id,
    					theme:theme,
    					user_id:user_id,
    					question_id:question_id,
    					th:"删除"
    					},
    				dataType: 'text',
    				success: function() {
    					 window.location.reload();
    				}	
    			});
    		});
       
       $("#fabulous a").click(function() {
			 
           alert("点赞");
           var user_id="${user_id}";
           var username="${username}";
           var theme="${theme}";
           var question_id="${q_id}";
			var replay_id=$(this).attr("data-id");
    		 $.ajax({
    				url: 'ManageCmmment',
    				type: 'post',
    				data: {
    					username:username,
    					replay_id:replay_id,
    					theme:theme,
    					user_id:user_id,
    					question_id:question_id,
    					th:"点赞"
    					},
    				dataType: 'text',
    				success: function() {
    					 window.location.reload();
    				}	
    			});
    		});
       
       $("#show a").click(function() {
           var address =$(this).attr("data-src");
            $(this).attr("href",address);
            replay_username=$(this).attr("data-rep_name");//回复的用户名replay_username
            answer_id=$(this).attr("data-anw_id");//回答id
            re_replay_id=$(this).attr("data-rep_id");//回复的用户的replay_id
            question_id=$(this).attr("data-question_id");
            theme=$(this).attr("data-theme");
            user_id=$(this).attr("data-user_id");
            username="${username}";
           
       });
       
       $("#sub").click(function() {
   		
    	   var com= document.getElementById("txt").value;
          	var username="${username}";
          	var id="${q_id}";
          	var theme="${theme}";
          	var user_id="${user_id}";
          	
          	alert(username+id+com+theme+user_id);
          	$.ajax({
      			url: 'AnswerQuestionServel',
      			type: 'post',
      			data: {username:username,
      				id:id,
      				answer: com,
      				user_id:user_id,
      				theme:theme},
      			
      			dataType: 'text',
      			success: function() {
      				window.location.reload();
      				
      			}
      		});
          	});
     
       
       
   		
       });
        
        </script>
</head>
<body>
<div>
<table>
<tr>
<td rowspan="2"><img  src="imgs/${image }" style="width:100px;height:100px;border-radius:50%"></td>
<td>${username}</td>

</tr>
<tr>

<td>${release_time}&nbsp;${category}</td>

</tr>
<tr>
<td>${title}</td>
</tr>
<tr>
<td>${content}</td>
<td ><a  href="" class="view-number" data-toggle="collapse"  ><img  class="img-fluid" src="img/ic/comment-outline.png" style="width:100px;height:100px;border-radius:50%">&nbsp;</a></td>

</tr>

</table>

<div class="send-info border-bottom" >
                <textarea class="form-control" rows="3" style="resize: none" id="txt"></textarea>
                <div class="d-flex flex-row">
                     <input type="button" class="sub" id="sub"  value="回复"/>
                     </div>
            </div>

<c:forEach items="${userlist }" var="answer">
<div>
<table>
<tr>
<td rowspan="3"><img  src="imgs/${image }" style="width:100px;height:100px;border-radius:50%"></td>
<td>${answer.name}</td>

</tr>

<tr>
<td>${answer.answer}</td>
</tr>
<tr>

<td id="f_an"><a id="${answer.answer_id }" href="" data-src="#discord" class="view-number" data-toggle="collapse" data-rep_name="${answer.name }" data-rep_id="0"  data-anw_id="${answer.answer_id }" data-user_id="${user_id }" data-theme="${theme}" data-question_id="${q_id}"><img  class="img-fluid" src="img/ic/comment-outline.png" style="width:100px;height:100px;border-radius:50%">&nbsp;</a></td>

<c:if test="${answer.name eq username }">
                   <td id="deletean"> <a href="#" id="${answer.answer_id }">删除</a></td>
                    </c:if>
</tr>
</table>

</div>



 <c:forEach items="${rep }" var="rep">
<c:if test="${answer.answer_id eq rep.answer_id }">
<div>
<table>
<tr>
<td><img  src="imgs/${rep.image }" style="width:100px;height:100px;border-radius:50%"></td>
<td>${rep.username}</td>
</tr>
<tr>
<td>${rep.time}</td>
</tr>
<tr>
<td></td>
<td>${rep.content}</td>
</tr>
<tr>

<td id="fabulous"><a href="#" id="${rep.re_repaly_id}" data-id="${rep.replay_id }"><img  class="img-fluid" src="img/ic/like.png" style="width:100px;height:100px;border-radius:50%">&nbsp;${rep.fabulous}</a></td>
<td id="show"><a href="" data-src="#discord" class="view-number" data-toggle="collapse" data-rep_name="${rep.username }" data-rep_id="${rep.replay_id }" data-username="${ username }"  data-anw_id="${rep.answer_id }" data-user_id="${user_id }" data-theme="${theme}" data-question_id="${q_id}"><img  class="img-fluid" src="img/ic/comment-outline.png" style="width:100px;height:100px;border-radius:50%">&nbsp;回复</a></td>

<c:if test="${rep.username eq username }">
                    <td id="delete"> <a href="#" id="${ rep.replay_id }">删除</a></td>
  </c:if>
  </tr>
</table>

</div>
</c:if>
</c:forEach>
<hr>
</c:forEach>
</div>

 <div id="discord" class="collapse"  >
                        <div class="send-discord" style="padding: 100px">
                            <input type="text" class="form-control" id="txt1">
                            <div class="d-flex flex-row">
                                
                                <button class="btn btu-s col-sm-2 text-white "  id="comment">评 论</button>
                            </div>
                        </div>
            </div> 
</body>
</html>