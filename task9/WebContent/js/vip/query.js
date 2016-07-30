//商品列表页的填充数据方法
$.appendTrOfVip = function (data) {
    //循环添加数据到列表的table中
    for (var i = 0; i < data.dataList.length; i++) {
        $(".listTable > tbody").append(
            "<tr>" +
            "<td class='col-lg-1 col-md-1'>" + data.dataList[i].id + "</td>" +
            "<td class='col-lg-2 col-md-2'>" + data.dataList[i].name + "</td>" +
            "<td class='col-lg-2 col-md-2'>" + data.dataList[i].age + "</td>" +
            "<td class='col-lg-2 col-md-2'>" + data.dataList[i].profession + "</td>" +
            "<td class='col-lg-2 col-md-2'>" + data.dataList[i].joinTime + "</td>" +
            "<td class='actions col-lg-2 col-md-2'>" +
            "<a href=\'" + "vip/view/" + data.dataList[i].id + "\' class='btn btn-sm btn-info'><i class='glyphicon glyphicon-eye-open'></i></a>" +
            "<a href=\'" + "vip/edit/" + data.dataList[i].id + "\' class='btn btn-sm btn-primary'><i class='glyphicon glyphicon-pencil'></i></a>" +
            "<a href=\'" + "vip/delete/" + data.dataList[i].id + "\' class='btn btn-sm btn-danger'><i class='glyphicon glyphicon-trash'></i></a>" +
            "</td></tr>"
        );
    }

}

//初始化页面时获取一次数据
$(function () {
    $(".pagination").remove();
    $.pagingQueryRequest("vip/list/", 1,"#queryOptionForm", $.appendTrOfVip);
});

//点击查询时获取数据
$("#queryBtn").click(function () {
    //先做清空
    $(".listTable > tbody > tr").remove();
    $(".pagination").remove();
    $.pagingQueryRequest("vip/list/", 1,"#queryOptionForm", $.appendTrOfVip);
});