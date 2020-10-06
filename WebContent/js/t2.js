var text = "<div class=\"ci card\">\n" +
    "                <div class=\"card-header\">我的关注</div>\n" +
    "                <div class=\"card-body\">\n" +
    "                    <span class=\"d-flex flex-row\">\n" +
    "                        <img src=\"img/head_img/river__easyiconnet.png\" class=\"head-img\">\n" +
    "                        <a href=\"#\">疯狂的鱼</a>\n" +
    "                    </span>\n" +
    "                    <p><h3>雨后才会有彩虹</h3></p>\n" +
    "                    <img class=\"card-imgs\" src=\"http://c4-q.mafengwo.net/s9/M00/DC/D4/wKgBs1b2Ae-AY8IFAADgaN8KJ5415.jpeg?imageView2%2F2%2Fw%2F600%2Fh%2F600%2Fq%2F90\">\n" +
    "                </div>\n" +
    "                <div class=\"card-footer d-flex flex-row\">\n" +
    "                    <button class=\"btn btn-default btn-block border-right\"><img class=\"icon\" src=\"img/icon/dianzan.png\"></button>\n" +
    "                    <button class=\"btn btn-default btn-block border-right\"><img class=\"icon\" src=\"img/icon/zhuanfa.png\"></button>\n" +
    "                    <button class=\"btn btn-default btn-block\"><img class=\"icon\" src=\"img/icon/pinglun.png\"></button>\n" +
    "                </div>\n" +
    "            </div>";
$(document).ready(function () {
    $("#sure-send").click(function () {
        alert("发表成功");
        $(".card-info").append(text);

    });


});