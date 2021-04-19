$(function () {
    text_foled('.content', 80);
});

/**
 * jQuery 文本折叠展开特效
 * @param clas：存放文本的容器
 * @param num：要显示的字数
 */
function text_foled(clas, num) {
    var num = num;
    var a = $("<a></a>").on('click', showText).addClass('a-text').text("【展开】");
    var b = $("<a></a>").on('click', showText).addClass('a-text').text("【折叠】");
    var p = $("<p></p>").addClass('p2');
    var str = $(clas).text();
    $(clas).after(p);
    if (str.length > num) {
        var text = str.substring(0, num) + "...";
        $(clas).html(text).append(a);
    }
    $('.p2').html(str).append(b);
    function showText() {
        $(this).parent().hide().siblings().show();
    }
}