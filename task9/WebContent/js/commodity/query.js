/**
 * Created by caiwen on 2016/7/30.
 */
//商品列表页的填充数据方法
$.appendTrOfCommodity = function(data) {
    //循环添加数据到列表的table中
    for (var i = 0; i < data.dataList.length; i++) {
        $(".listTable > tbody").append(
            "<tr>" +
            "" +
            "<td class='col-lg-3 col-md-3'>" + data.dataList[i].id + "</td>" +
            "<td class='col-lg-3 col-md-3'>" + data.dataList[i].name + "</td>" +
            "<td class='col-lg-3 col-md-3'>" + data.dataList[i].price + " 元</td>" +
            "<td class='col-lg-3 col-md-3'>" + data.dataList[i].agio + " 折</td>" +
            "</tr>");
    }
}

//初始化页面时获取一次数据
$(function () {
    $(".pagination").remove();
    $.pagingQueryRequest("commodity/list/", 1,"#queryOptionForm", $.appendTrOfCommodity);
});

//点击查询时获取数据
$("#queryBtn").click(function () {
    //先做清空
    $(".listTable > tbody > tr").remove();
    $(".pagination").remove();
    $.pagingQueryRequest("commodity/list/", 1,"#queryOptionForm", $.appendTrOfCommodity);
});