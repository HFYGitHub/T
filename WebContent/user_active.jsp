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
<div class="" style="padding-top: 30px; padding-bottom: 30px;">
    <!-- Nav pills -->
    <ul class="nav nav-pills" role="tablist">
        <li class="nav-item">
            <a class="nav-link active" data-toggle="pill" href="#main">我的主题</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="pill" href="#reply">我的回复</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="pill" href="#info">消息通知</a>
        </li>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
        <div id="main" class="container-fluid tab-pane active"><br>
            <table class="table table-hover">
                <thead>
                <tr class="text-center">

                    <th>主题</th>
                    <th>板块</th>
                    <th>发表时间</th>
                    <th>回复人数</th>
                </tr>
                </thead>
                <c:forEach items="${ques }" var="question">
                <tbody>
                <tr class="text-center">

                    <td style="color: dodgerblue"><a style="color: dodgerblue" href="/T/AllReplayShow?username=${username}&question_id=${ question.question_id}&theme=全部&user_id=${question.user_id }&username=${username}">${question.title}</a></td>

                    <td style="color: dodgerblue"><a style="color: dodgerblue" href="/T/AllReplayShow?username=${username}&question_id=${ question.question_id}&theme=全部&user_id=${question.user_id }&username=${username}">${question.category}</a></td>

                    <td>
<%--                        <div class="d-flex flex-column">--%>
<%--                            <span style="color: #337BB3"><a style="color: #337BB3" href="#">10</a></span>--%>
<%--                            <span style="color: #999999">352</span>--%>
<%--                        </div>--%>
                            <div class="d-flex flex-column">
                              <a style="color: dodgerblue" href="/T/AllReplayShow?username=${username}&question_id=${ question.question_id}&theme=全部&user_id=${question.user_id }&username=${username}">  <span style="color: #999999">${question.release_time}</span></a>
                            </div>
                    </td>
                    <td class="d-flex flex-column">
                        <c:forEach items="${quesUser }" var="quesUser">
                            <c:if test="${quesUser.q_id eq question.question_id }">
                           <a style="color: dodgerblue" href="/T/AllReplayShow?username=${username}&question_id=${ question.question_id}&theme=全部&user_id=${question.user_id }&username=${username}">     <span style="color: #999999">${quesUser.total_num }</span></a>
                            </c:if>
                        </c:forEach>
                    </td>
                </tr>
                </tbody>
                </c:forEach>
                <c:forEach items="${food }" var="food">
                <tbody>
                <tr class="text-center">

                     <td style="color: dodgerblue"><a style="color: dodgerblue" href="/T/FoodDetailServlet?food_id=${food.food_id}&introduce=${food.introduce}&img=${food.img_name}&publish_time=${food.release_time}&theme=${food.text}&num=${food.number}&fabulous=${food.fabulous}&username=${username}">${food.text}</a></td>

                     <td style="color: dodgerblue"><a style="color: dodgerblue" href="/T/FoodDetailServlet?food_id=${food.food_id}&introduce=${food.introduce}&img=${food.img_name}&publish_time=${food.release_time}&theme=${food.text}&num=${food.number}&fabulous=${food.fabulous}&username=${username}">美食分享</a></td>
                   
                    <td >
                     <div class="d-flex flex-column">
                      <a style="color: dodgerblue" href="/T/FoodDetailServlet?food_id=${food.food_id}&introduce=${food.introduce}&img=${food.img_name}&publish_time=${food.release_time}&theme=${food.text}&num=${food.number}&fabulous=${food.fabulous}&username=${username}">
                            
                                <span style="color: #999999">${food.release_time}</span>
                           
                            </a>
                            </div>
                    </td>
                    <td class="d-flex flex-column">
                        <a style="color: dodgerblue" href="/T/FoodDetailServlet?food_id=${food.food_id}&introduce=${food.introduce}&img=${food.img_name}&publish_time=${food.release_time}&theme=${food.text}&num=${food.number}&fabulous=${food.fabulous}&username=${username}">
                                <span style="color: #999999">${food.number}</span>
                         </a> 
                    </td>
                </tr>
                </tbody>
                </c:forEach>
                <c:forEach items="${competition }" var="competition">
                <tbody>
                <tr class="text-center" >

                    <td style="color: dodgerblue"><a style="color: dodgerblue" href="/T/CompeDeatils?compe_id=${competition.notice_id }&username=${username}">${competition.theme}</a></td>

                    <td> <a style="color: dodgerblue" href="/T/CompeDeatils?compe_id=${competition.notice_id }&username=${username}">   赛事通知</a></td>

                    <td>
                        
                       <a style="color: dodgerblue" href="/T/CompeDeatils?compe_id=${competition.notice_id }&username=${username}">     ${competition.release_time}</a>
                            
                        
                    </td>
                    <td class="d-flex flex-column">
                    <a style="color: dodgerblue" href="/T/CompeDeatils?compe_id=${competition.notice_id }&username=${username}">    ${competition.read_num}</a>
                    </td>
                </tr>
                </tbody>
                </c:forEach>
            </table>
        </div>
        <div id="reply" class="container-fluid tab-pane fade"><br>
            <table class="table table-hover">
                <thead>
                <tr class="text-center">

                    <th>帖子</th>
                    <th>板块</th>
                    <th>回复内容</th>
                    <th>回复时间</th>
                </tr>
                </thead>
                <c:forEach items="${allques }" var="question">
                <c:forEach items="${user_answer }" var="user_answer">
                <c:if test="${user_answer.question_id eq  question.question_id}">
                <tbody>
                <tr class="text-center">

                    <td style="color: dodgerblue"><a style="color: dodgerblue" href="/T/AllReplayShow?username=${username}&question_id=${ question.question_id}&theme=全部&user_id=${question.user_id }&username=${username}">${question.title }</a></td>

                    <td>问题咨询</td>

                    <td>
                    
                    
                        <div class="d-flex flex-column">
                            <span style="color: #999999"> ${user_answer.answer }</span>
                        </div>
                        
                       
                       
                    </td>
                    <td>
                  
                        <div class="d-flex flex-column">
                            <span style="color: #999999">${user_answer.release_time}</span>
                        </div>
                      
                    </td>
                </tr>
                </tbody>
              </c:if>
                </c:forEach>
                <c:forEach items="${answer }" var="answer">
                  <c:if test="${answer.question_id eq  question.question_id}">
                 <c:forEach items="${user_replay }" var="user_replay">
                <c:if test="${user_replay.answer_id eq  answer.answer_id}">
                
                 <tbody>
                <tr class="text-center">

                    <td style="color: dodgerblue"><a style="color: dodgerblue" href="/T/AllReplayShow?username=${username}&question_id=${ question.question_id}&theme=全部&user_id=${question.user_id }&username=${username}">${question.title }</a></td>

                    <td>问题咨询</td>

                    <td>
                    
                    
                        <div class="d-flex flex-column">
                            <span style="color: #999999"> ${user_replay.content }</span>
                        </div>
                        
                       
                       
                    </td>
                    <td>
                  
                        <div class="d-flex flex-column">
                            <span style="color: #999999">${user_replay.time}</span>
                        </div>
                      
                    </td>
                </tr>
                </tbody>
                
                
                </c:if>
                </c:forEach>
                </c:if>
                </c:forEach>
                
                </c:forEach>
                  <c:forEach items="${allfood }" var="food">
                  <c:forEach items="${user_foodtalk }" var="user_foodtalk">
                <c:if test="${food.food_id eq  user_foodtalk.food_id}">
                <tbody>
                <tr class="text-center">

                    <td style="color: dodgerblue"><a style="color: dodgerblue" href="/T/FoodDetailServlet?food_id=${food.food_id}&introduce=${food.introduce}&img=${food.img_name}&publish_time=${food.release_time}&theme=${food.text}&num=${food.number}&fabulous=${food.fabulous}&username=${username}">${food.introduce }</a></td>

                    <td>美食分享</td>

                    <td>
                    
                    
                        <div class="d-flex flex-column">
                            <span style="color: #999999"> ${user_foodtalk.content }</span>
                        </div>
                        
                    </td>
                    <td>
                    
                      
                        <div class="d-flex flex-column">
                            <span style="color: #999999">${user_foodtalk.time }</span>
                        </div>
                       
                        
                        
                    </td>
                </tr>
                </tbody>
              </c:if>
              </c:forEach>
                </c:forEach>
            </table>
        </div>
        <div id="info" class="container tab-pane fade"><br>
        <c:forEach items="${food }" var="food">
            <c:forEach items="${foodtalk }" var="foodtalk">
           <c:if test="${foodtalk.food_id eq food.food_id }">
           <c:choose>
            <c:when test="${ foodtalk.username  eq username }">
             </c:when>
             <c:otherwise>
            <div class="d-flex flex-row">
               <c:forEach items="${userall }" var="user">
              <c:if test="${foodtalk.username eq user.name }">
                <div style="margin-right: 20px;"><img alt="头像" src="imgs/${user.image }" class="img-fluid" style="height: 70px;width: 70px"></div>
               </c:if>
               </c:forEach>
                <div class="d-flex flex-column">
                    <span style="color: #999999;">${foodtalk.time }</span>
                    <span class="d-flex flex-row">
                        <a href="#" style="color: #34A0EB">${foodtalk.username }</a>
                        &emsp;
                        <span class="small">回复了您的帖子</span>
                        &emsp;
                       
                        <a href="/T/FoodDetailServlet?food_id=${food.food_id}&introduce=${food.introduce}&img=${food.img_name}&publish_time=${food.release_time}&theme=${food.text}&num=${food.number}&fabulous=${food.fabulous}&username=${username}" style="color: #34A0EB">查看</a>
                    </span>
                    <span style="color: #999999">${foodtalk.content }</span>
                </div>
            </div>
            <hr style="border:1px dashed #987cb9" width="100%">
           </c:otherwise>
           </c:choose>
          </c:if>
            </c:forEach>
            </c:forEach>
            
             <c:forEach items="${ques }" var="question">
                    <c:forEach items="${answer }" var="answer" varStatus="status">
                    
                    <c:if test="${question.question_id eq answer.question_id }">
             <c:choose>
            <c:when test="${ answer.user_id  eq userid}">
             </c:when>
             <c:otherwise>                   

                    <c:forEach items="${replay }" var="replay" varStatus="status">
                        <c:if test="${replay.answer_id eq answer.answer_id }">
                         <c:choose>
            <c:when test="${ replay.username  eq username}">
             </c:when>
             <c:otherwise>    
                         <div class="d-flex flex-row">
               <c:forEach items="${userall }" var="user">
               
              <c:if test="${replay.username eq user.name }">
                <div style="margin-right: 20px;"><img alt="头像" src="imgs/${user.image }" class="img-fluid" style="height: 70px;width: 70px"></div>
               </c:if>
               </c:forEach>
                <div class="d-flex flex-column">
                    <span style="color: #999999;">${replay.time }</span>
                    <span class="d-flex flex-row">
                        <a href="#" style="color: #34A0EB">${replay.username }</a>
                        &emsp;
                        <span class="small">回复了您的帖子</span>
                        &emsp;
                       
                        <a href="/T/AllReplayShow?username=${username}&question_id=${ question.question_id}&theme=全部&user_id=${question.user_id }&username=${username}" style="color: #34A0EB">查看</a>
                    </span>
                    <span style="color: #999999">${replay.content }</span>
                </div>
            </div>
            <hr style="border:1px dashed #987cb9" width="100%">
                </c:otherwise>
                </c:choose>        
                       </c:if>
                       
                        </c:forEach>
                        </c:otherwise>
                        </c:choose>
                        
                          
                          
                          
           <c:choose>
            <c:when test="${ answer.user_id  eq userid}">
             </c:when>
             <c:otherwise>                   
                          
                     <div class="d-flex flex-row">
                    
               <c:forEach items="${userall }" var="user">
               
              <c:if test="${answer.user_id eq user.id }">
                <div style="margin-right: 20px;"><img alt="头像" src="imgs/${user.image }" class="img-fluid" style="height: 70px;width: 70px"></div>
               </c:if>
               </c:forEach>
                <div class="d-flex flex-column">
                    <span style="color: #999999;">${answer.release_time }</span>
                    <span class="d-flex flex-row">
                    <c:forEach items="${answeruser }" var="answeruser">
                     <c:if test="${answer.answer_id eq answeruser.answer_id }">
                     
                        <a href="#" style="color: #34A0EB">${answeruser.name }</a>
                        
                        </c:if>
                        </c:forEach>
                        &emsp;
                        <span class="small">回复了您的帖子</span>
                        &emsp;
                       
                        <a href="/T/AllReplayShow?username=${username}&question_id=${ question.question_id}&theme=全部&user_id=${question.user_id }&username=${username}" style="color: #34A0EB">查看</a>
                    </span>
                    <span style="color: #999999">${answer.answer }</span>
                </div>
            </div>
            <hr style="border:1px dashed #987cb9" width="100%">
            </c:otherwise>
            </c:choose>
           </c:if>
              
              </c:forEach>
              </c:forEach>      
                        
                        
                        
        </div>
    </div>
</div>

</body>
</html>