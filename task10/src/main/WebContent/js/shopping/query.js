/**
 * Created by caiwen on 2016/7/30.
 */
//商品列表页的填充数据方法
$.appendTrOfCommodity = function(data) {
    $(".bootstrap-admin-panel-content > .row").remove();
    //循环添加数据到列表的table中
    if (data.goodsList.length > 0) {
        var rowNum = 0;
        for (var i = 1; i <= data.goodsList.length; i++) {
            if (i % 4 == 1) {
                rowNum++;
                $(".bootstrap-admin-panel-content").append('<div class="row bootstrap-admin-light-padding-bottom' +
                    ' row-' + rowNum +'"></div>');
            }
            $(".row-" + rowNum ).append(
                    '<div class="col-md-3">' +
                        '<a href="shopping/edit/' + data.goodsList[i-1].id +'" class="thumbnail">' +
                            '<img data-src="holder.js/200x180" alt="200x180" style="width: 200px; height: 180px;"' +
                    ' src="' + data.goodsList[i-1].imgUrl + '">' +
                        '</a>' +
                        '<p style="text-align: center">品名：' + data.goodsList[i-1].goodsName + '</p>' +
                        '<p style="text-align: center">价格：' + data.goodsList[i-1].price + '</p>' +
                    '</div>');
        }
    }
}

//初始化页面时获取一次数据
$(function () {
    $(".pagination").remove();
    $.pagingQueryRequest("shopping/jsonResult/", 20, 1,"", $.appendTrOfCommodity);
});

//点击查询时获取数据
$("#queryBtn").click(function () {
    $(".bootstrap-admin-panel-content > .row").remove();
    $(".pagination").remove();
    $.pagingQueryRequest("shopping/jsonResult/", 20, 1,"#queryOptionForm", $.appendTrOfCommodity);
});/**
 * Created by caiwen on 2016/8/28.
 */
