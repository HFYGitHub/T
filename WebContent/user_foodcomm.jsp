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
        var time;
      
        $(document).ready(function() {
        	 $("#comment").click(function() {
        		 var com= document.getElementById("txt1").value;
               	var username="${username}";
               	var content="${theme}";
               	var food_id="${food_id}";
               
          		
               	$.ajax({
           			url: 'EditFoodService',
           			type: 'post',
           			data: {username:username,
           				
           				us_image:"${us_image}",
           				food_id:food_id,
           				content:com,
           				th:"插入评论"},
           			
           			dataType: 'text',
           			success: function() {
           				window.location.reload();
           				
           			}
           		});
        		});
        	 
        	 $("#delete a").click(function() {
        		 
        		 var foodtalk_time=$(this).attr("data-tim");
        		 alert(foodtalk_time);
        	    		 $.ajax({
        	    				url: 'EditFoodService',
        	    				type: 'post',
        	    				data: {
        	    					
        	    					us_image:"${image}",
        	           				food_id:"${food_id}",
        	           				username:"${username}",
        	    					
        	    					foodtalk_time:foodtalk_time,
        	    					th:"删除"
        	    					},
        	    				dataType: 'text',
        	    				success: function() {
        	    					 window.location.reload();
        	    				}	
        	    			});
        	    		});
        	 
        	 
        	$("#fa a").click(function() {
        		var food_id=$(this).attr("data-food_id");
        		 $.ajax({
        				url: 'EditFoodService',
        				type: 'post',
        				data: {
        					food_id:food_id,
        					username:"${username}",
        					us_image:"${image}",
        					th:"动态点赞"
        					},
        				dataType: 'text',
        				success: function() {
        					 window.location.reload();
        				}	
        			});
        		});
        	$("#talk_fa a").click(function() {
        		var foodtalk_time=$(this).attr("data-foodtalk_time");
        		var food_id=$(this).attr("data-food_id");

        		var food_username=$(this).attr("data-foodtalk_username");
        		 $.ajax({
        				url: 'EditFoodService',
        				type: 'post',
        				data: {
        					food_id:food_id,
        					food_username:food_username,
        					us_image:"${image}",
	           				food_id:"${food_id}",
	           				username:"${username}",
        					foodtalk_time:foodtalk_time,
        					th:"点赞评论"
        					},
        				dataType: 'text',
        				success: function() {
        					 window.location.reload();
        				}	
        			});
        		});
        	
        	 $("#comm a").click(function() {
                 var address =$(this).attr("data-src");
                  $(this).attr("href",address);
                
                 
             });
      
     
       
       
   		
       });
        
        </script>
</head>
<body>
<div>
<table>
<tr>
<td rowspan="2"><img  src="imgs/${us_image }" style="width:100px;height:100px;border-radius:50%"></td>
<td>${publish_name}</td>
<td>总浏览人数：${num}</td>

</tr>
<tr>

<td>${time}&nbsp;${theme}</td>

</tr>
<tr>
<td>${introduce}</td>
<td ><img  src="img/img/food/${img }" style="width:100px;height:100px;border-radius:50%"></td>

</tr>
<tr>
<td id="fa"><a  href="" class="view-number" data-toggle="collapse"  data-food_id="${food_id }"><img  class="img-fluid" src="img/img/ic/like.png" style="width:100px;height:100px;border-radius:50%">&nbsp;${fabulous}</a></td>
<td id="comm"><a  href="" class="view-number" data-src="#discord" data-toggle="collapse"  ><img  class="img-fluid" src="img/img/ic/comment-outline.png" style="width:100px;height:100px;border-radius:50%">&nbsp;${total_num}</a></td>

</tr>

</table>



<c:forEach items="${allfoodtalk }" var="foodtalk">
<div>
<table>
<tr>

<c:forEach items="${alluser1 }" var="alluser1">

<c:if test="${foodtalk.username eq alluser1.name}">
<td rowspan="3"><img  src="imgs/${alluser1.image }" style="width:100px;height:100px;border-radius:50%"></td>
              
</c:if>
</c:forEach>
<td>${foodtalk.username}</td>
<td>${foodtalk.time}</td>
</tr>

<tr>
<td>${foodtalk.content}</td>
</tr>
<tr>
<td id="talk_fa"><a  href="" class="view-number" data-foodtalk_food_id="${food_id}" data-foodtalk_username="${foodtalk.username}" data-foodtalk_time="${foodtalk.time}" data-toggle="collapse"  ><img  class="img-fluid" src="img/img/ic/like.png" style="width:100px;height:100px;border-radius:50%">&nbsp;${foodtalk.like_num}</a></td>

<c:if test="${foodtalk.username eq username }">
<td id="delete"><a href="" data-tim="${foodtalk.time}">删除</a></td>
                          
</c:if>
</tr>

</table>
</div>
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