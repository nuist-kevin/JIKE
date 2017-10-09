/**
 * Created by caiwen on 2016/7/30.
 */
//商品列表页的填充数据方法
$.appendTrOfCommodity = function(data) {
    //循环添加数据到列表的table中
    for (var i = 0; i < data.goodsList.length; i++) {
        $(".listTable > tbody").append(
            "<tr>" +
            "" +
            "<td class='col-lg-2 col-md-2'>" + data.goodsList[i].id + "</td>" +
            "<td class='col-lg-3 col-md-3'>" + data.goodsList[i].goodsName + "</td>" +
            "<td class='col-lg-3 col-md-3'>" + data.goodsList[i].category.categoryName + "</td>" +
            "<td class='col-lg-2 col-md-2'>" + data.goodsList[i].price + " 元</td>" +
            "<td class='actions col-lg-2 col-md-2'>" +
            "<a href=\'" + "goods/view/" + data.goodsList[i].id + "\'  class='btn btn-sm btn-info'><i class='glyphicon glyphicon-eye-open'></i></a>" +
            "<a href=\'" + "goods/edit/" + data.goodsList[i].id + "\'  class='btn btn-sm btn-primary'><i class='glyphicon glyphicon-pencil'></i></a>" +
            "<a href=\'" + "goods/delete/" + data.goodsList[i].id + "\' class='btn btn-sm btn-danger'><i class='glyphicon glyphicon-trash'></i></a>" +
            "</td></tr>");
    }
}

//初始化页面时获取一次数据
$(function () {
    $(".pagination").remove();
    $.pagingQueryRequest("goods/list/", 5, 1,"", $.appendTrOfCommodity);
});

//点击查询时获取数据
$("#queryBtn").click(function () {
    //先做清空
    $("row").remove();
    $(".pagination").remove();
    $.pagingQueryRequest("goods/list/", 5, 1,"#queryOptionForm", $.appendTrOfCommodity);
});