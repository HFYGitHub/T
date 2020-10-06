<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>食物讨论</title>
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
        var username,replay_id,re_replay_id,replay_username,answer_id,question_id,theme,user_id;
      
        $(document).ready(function() {
        	 $("#comment").click(function() {
        		 var test=document.getElementById("txt1").value;
        		$.ajax({
        				url: 'TTT',
        				type: 'post',
        				data: {username:username,
        					replay_username:replay_username,
        					answer_id:answer_id,
        					re_replay_id:re_replay_id,
        					theme:theme,
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
        	 
        	 
            $("#delete a").click(function() {
            	var user_id="${user_id}";
                var username="${username}";
                var theme="${theme}";
                var question_id="${q_id}";
 				var replay_id=$(this).attr("id");
 				
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
            
            
           
        			 $("#deletean a").click(function() {
        				 
                      
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
                // 回复信息
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
        		
        	// 获取发布回复按钮
        	
        	var com= document.getElementById("txt").value;
        	var username="${username}";
        	var id="${q_id}";
        	var theme="${theme}";
        	var user_id="${user_id}";
        	
        	
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

<nav class="first-title d-flex flex-row " >
    <h3 class="name-title text-white" > Y O </br>U S C</h3>
    <ul class="list-inline dh">
        <li class="list-inline-item">
            <a class="" href="/T/ShowQuestionAtMain?username=${username}">首页</a>
        </li>
        <li class="list-inline-item">
            <a class="" href="#">联系</a>
        </li>
        <li class="list-inline-item">
            <a class="" href="#">关于</a>
        </li>
    </ul>
    <div class="offset-3">
        <img alt="logo" src="img/logo.png" style="height: 60px; width: 300px">
    </div>
    <c:if test="${empty user} ">
        <div class="u-info offset-4">
            <a class="login-user" href="login.jsp">登录</a>
            <a> | </a>
            <a class="register-user" href="register.jsp">注册</a>
        </div>
    </c:if>
    <div class="u-info offset-3">
        <a class="" href="user_infomation.jsp"  >欢迎您：${user.name}</a>
        &emsp;&emsp;
        <a class="" style="color: red" href="login.jsp">退出</a>
    </div>
</nav>
<div class="f2 d-flex text-center ">
    <div class="f2-item p-4"><a href="/T/ReplayAllQuestion?username=${username }&currentPage=0&theme=全部" >问题咨询</a></div>
    <div class="f2-item p-4"><a href="/T/ShowAllNotice?username=${username }&currentPage=0&theme=CF赛事" >比赛通知</a></div>
    <div class="f2-item p-4"><a href="/T/FoodShareServlet?username=${username}">美食天下</a></div>
    <div class="f2-item p-4"> <a href="/T/IndexServlet?currentPage=0&theme=软件&username=${username}" >资料分享</a></div>
</div>
    <div class="t1-center col-sm-12">
        <div class="u-information">
            

            <div class="row ">
               
                <div class="user-card d-flex flex-column offset-1 col-sm-1 border text-center">
                    <span class="user-name ">${user_name}</span>
                    <hr>
                    <span class="user-img"><img alt="头像" class="img-fluid" src="imgs/${image }"></span>
                    <hr>
                    <hr>
                    <hr>
                    <hr>
                     <span>  <a href="javascript:history.go(-1)" >返回</a></span>
                </div>

                <div class="note-info d-flex flex-column col-sm-8 " style="padding: 0">
                    <span class="n-head border-bottom" style="color:#444;padding-left: 20px;"><h4>标题：${title}</h4></span>
                    <span class="n-infos text-center">
                        <span class="n-stime">发表于 ：${release_time}</span>
                        <span class="fg">|</span>
                        <span class="n-cnumber">留言数:${num}</span>
                        <span class="fg">|</span>
                        <span class="rnumber">分类:${category}</span>
                    </span>
                    <hr>
                    <span class="n-center">
                        <h2>问题：</h2>
                        <p>${content}</p>
                    </span>
                    <hr>
                     <c:if test="${username eq user_name }">
                    <a class="zan float-right" href="/T/AllReplayShow?question_id=${ q_id}&username=${username}&user_id=${user_id}&theme=${theme}&th=删除"> <img alt="点赞" class="img-fluid zan-img" src="img/img/icon/zhuanfa.png  " style=""></a>
                    </c:if>
                    
                </div>
            </div>

        </div>
       <div class="u-discord offset-2 col-sm-8">
           
            <div class="send-info border-bottom" >
                <textarea class="form-control" rows="3" style="resize: none" id="txt"></textarea>
                <div class="d-flex flex-row">
                     <input type="button" class="sub" id="sub"  value="回复"/>
                     </div>
            </div>
            

 <c:forEach items="${userlist}" var="answer">

            <div class="row u-s-info border-bottom">
                <div class="u-s-img">
                    <span class="user-img"><img alt="头像" class="img-fluid" src="imgs/${answer.image }"></span>
                </div>
                <div class="note-info d-inline-flex flex-column col-sm-9 " style="padding: 0">
                    <span class="u-s-text">
                        <a href="" class="user-name">${answer.name }</a>
                        &emsp;
                        <span class="n-time ">发表于 ${answer.release_time}</span>
                    </span>
                    <span class="n-center ">${answer.answer}</span>
                    <span id="show"><a href="" data-src="#discord" class="view-number" data-toggle="collapse" data-rep_name="${answer.name }" data-rep_id="0"  data-anw_id="${answer.answer_id }" data-user_id="${user_id }" data-theme="${theme}" data-question_id="${q_id}"><img alt="讨论" class="img-fluid" src="img/ic/comment-outline.png"></a>
                     </span>
                    <c:if test="${answer.name eq username }">
                    <span id="deletean"> <a href="#" id="${answer.answer_id }">删除</a></span>
                    </c:if>
                    <c:forEach items="${rep }" var="rep">
                    <c:if test="${answer.answer_id eq rep.answer_id }">
                 
                    <div class="row u-s-info border-bottom">
                     <div class="u-s-img">
                    <span class="user-img"><img alt="头像" class="img-fluid" src="imgs/${rep.image }"></span>
                     </div>
                      <div class="note-info d-inline-flex flex-column col-sm-9 " style="padding: 0">
                    <span class="u-s-text">
                        <a href="" class="user-name">${rep.username}</a>
                        &emsp;
                        <span class="n-time ">发表于 ${rep.time}</span>
                        &emsp;
                        <span id="fabulous"><a href="#" id="${rep.re_repaly_id}" data-id="${rep.replay_id }"> ${rep.fabulous } </a></span>
                    </span>
                    <span class="n-center ">${rep.content}</span>
                   <span id="show"><a class="zan float-right" href="" data-src="#discord" class="view-number" data-toggle="collapse" data-rep_name="${rep.username }" data-rep_id="${rep.replay_id }" data-username="${ username }"  data-anw_id="${rep.answer_id }" data-user_id="${user_id }" data-theme="${theme}" data-question_id="${q_id}"><img alt="讨论" class="img-fluid" src="img/ic/comment-outline.png"></a>
                     </span>
                   <c:if test="${rep.username eq username }">
                    <span id="delete"> <a href="#" id="${ rep.replay_id}"    >删除</a></span>
                    </c:if>
                    
                 </div>
                    </div>
                    </c:if>
                    </c:forEach>
                   
                </div>
            </div>
</c:forEach>

            <div id="discord" class="collapse"  >
                        <div class="send-discord" style="padding: 20px">
                            <input type="text" class="form-control" id="txt1">
                            <div class="d-flex flex-row">
                                
                                <button class="btn btu-s col-sm-2 text-white "  id="comment">评 论</button>
                            </div>
                        </div>
            </div> 
            <div class="text-center u-s-f">
                <h4>没有更多的评论啦！</h4>
            </div>
        </div>
    </div>



<footer class="t1-footer mastfoot my-3">
    <div class="inner container">
        <div class="row">
            <div class="col-lg-4 col-md-12 d-flex align-items-center">

            </div>
            <div class="col-lg-4 col-md-12 d-flex align-items-center">
                <p class="mx-auto text-center mb-0">Copyright &copy; 2020.南华大学交流圈 </p>
            </div>
        </div>
    </div>
</footer>
</body>