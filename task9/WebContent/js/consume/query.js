/**
 * Created by caiwen on 2016/7/30.
 */
$.appendTrOfConsume = function(data) {
    //循环添加数据到列表的table中
    for (var i = 0; i < data.dataList.length; i++) {
        $(".listTable > tbody").append(
            "<tr>" +
            "<td>" + data.dataList[i].id + "</td>" +
            "<td>" + data.dataList[i].vip.vipId + "</td>" +
            "<td>" + data.dataList[i].vip.name + "</td>" +
            "<td>" + data.dataList[i].commodity.commodityName + "</td>" +
            "<td>" + data.dataList[i].commodity.price + " 元</td>" +
            "<td>" + data.dataList[i].practicePrice + " 元</td>" +
            "</tr>");
    }
}

//初始化页面时获取一次数据
$(function () {
    $(".pagination").remove();
    $.pagingQueryRequest("consume/list/", 1,"#queryOptionForm", $.appendTrOfConsume);
});

//点击查询时获取数据
$("#queryBtn").click(function () {
    //先做清空
    $(".listTable > tbody > tr").remove();
    $(".pagination").remove();
    $.pagingQueryRequest("consume/list/", 1,"#queryOptionForm", $.appendTrOfConsume);
});