<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
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
        $(document).ready(function() {

            $("#food_love a").click(function() {
                var food_id=$(this).attr("data-food_id");
                $.ajax({
                    url: 'EditFoodService',
                    type: 'post',
                    data: {
                        food_id:food_id,
                        username:"${username}",
                        th:"点赞"
                    },
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
<c:forEach items="${ques }" var="question">
    <div>
        <table>
            <tr>
                <td rowspan="2"><img  src="imgs/${image }" style="width:100px;height:100px;border-radius:50%"></td>
                <td>${username}</td>

            </tr>
            <tr>

                <td>${question.release_time}&nbsp;${qustion.category}</td>

            </tr>
            <tr>
                <td>${question.title}</td>
            </tr>
            <tr>
                <td>${question.content}</td>
            </tr>
            <tr>

                <td><a href="/T/ShowComment?username=${username }&question_id=${question.question_id}&user_id=${question.user_id}&image=${image }"><img  class="img-fluid" src="img/ic/comment-outline.png">&nbsp;查看留言</a></td>
            </tr>
        </table>
    </div>
</c:forEach>

<c:forEach items="${food }" var="food">
    <div>
        <table>
            <tr>
                <td rowspan="2"><img  src="imgs/${image }" style="width:100px;height:100px;border-radius:50%"></td>
                <td>${username}</td>

            </tr>
            <tr>

                <td>${food.release_time}&nbsp;${food.text}</td>

            </tr>
            <tr>
                <td>${food.introduce}</td>
            </tr>
            <tr>
                <td rowspan="2" colspan="3"><img  class="img-fluid" src="img/img/food/${food.img_name}" style="width:100px;height:100px;"></td>
            </tr>
            <tr>
                <td id="food_love"><a href="" data-food_id="${food.food_id }">&nbsp;${food.fabulous}</a></td>
                <td ><a href="/T/ShowFoodTalk?food_id=${food.food_id }&username=${username}&image=${image}&food_img=${food.img_name }&food_fabulous=${food.fabulous}&theme=${food.text}&introduce=${food.introduce}&publish_time=${food.release_time}&num=${food.number}&th=评论"  ><img  class="img-fluid" src="img/img/ic/comment-outline.png">&nbsp;${food.number}</a></td>
            </tr>
        </table>
    </div>
</c:forEach>
</body>
</html>
