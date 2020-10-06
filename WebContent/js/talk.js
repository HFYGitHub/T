text="img/ic/like.png";
text2="img/ic/like-outline.png";

$(document).ready(function () {

    $(".zan-img").click(function () {
        let t = $(this).attr("src");
        if(t.toString() === text2){
            $(this).attr("src",text);
        }else {
            $(this).attr("src",text2);
        }


    });
});