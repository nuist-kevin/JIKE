//商品列表页的填充数据方法
$.appendTrOfVip = function (data) {
    //循环添加数据到列表的table中
    for (var i = 0; i < data.dataList.length; i++) {
        $("#vipTable > tbody").append(
            "<tr>" +
            "<td ><div class='iradio'><input type='radio'/></div></td>" +
            "<td class='vipId'>" + data.dataList[i].id + "</td>" +
            "<td class='vipName'>" + data.dataList[i].name + "</td>" +
            "<td >" + data.dataList[i].age + "</td>" +
            "<td >" + data.dataList[i].profession + "</td>" +
            "<td >" + data.dataList[i].joinTime + "</td>" +
            "</tr>"
        );
    }
    $("td input").click(function () {
        $("td input").iCheck("uncheck");
        $("tr").removeClass("choosed");
        $(this).iCheck("check");
        $(this).parents("tr").addClass("choosed");
        vipId = $(".choosed > .vipId").text();
        vipName = $(".choosed > .vipName").text();
    });
    $("input[type='radio']").on('ifChecked', function () {
        $(this).addClass("radioChecked");
    });
    $("input[type='radio']").on('ifUnchecked', function () {
        $(this).removeClass("radioChecked");
    });
    $("#vipComfirmBtn").click(function () {
        $("input[name='consume.vip.vipId']").val(vipId);
        $("input[name='consume.vip.name']").val(vipName);
    });

}

//点击【选择VIP】时获取数据
$("#vipList").on('click', function () {
    $("#vipQueryForm > div > div > input").val("");
    $("#vipTable > tbody > tr").remove();
    $(".pagination").remove();
    $.pagingQueryRequest("vip/list/", 1,"#vipQueryForm > div > div > input", $.appendTrOfVip);
});

//点击查询时获取数据
$("#vipSearch").on('click', function () {
    $("#vipTable > tbody > tr").remove();
    $(".pagination").remove();
    $.pagingQueryRequest("vip/list/", 1,"#vipQueryForm > div > div > input", $.appendTrOfVip);
});
