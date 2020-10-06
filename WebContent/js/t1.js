text = " <div class=\"node d-flex flex-row border-bottom\">\n" +
    "                    <img src=\"img/icon/jilu.png\" height=\"30\" width=\"30\">\n" +
    "                    <strong>[主题]</strong>\n" +
    "                    <a href=\"#\" class=\"mr-auto\">帖子标题123456</a>\n" +
    "                    <a href=\"#\" class=\"aut\">作者</a>\n" +
    "                    <a href=\"#\" class=\"rep\">回复</a>\n" +
    "                    <a href=\"#\" class=\"time\">时间</a>\n" +
    "                </div>";
$(document).ready(function () {
    $(".send-info-btn").click(function () {
        alert("发表成功");
        $(".nodes").append(text);

    });
});