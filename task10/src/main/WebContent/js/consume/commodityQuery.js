//商品列表页的填充数据方法
$.appendTrOfCommodity = function (data) {
    //循环添加数据到列表的table中
    for (var i = 0; i < data.dataList.length; i++) {
        $("#commodityTable > tbody").append(
            "<tr>" +
            "<td class='col-lg-1 col-md-1'><div class='iradio'><input type='radio'/></div></td>" +
            "<td class='commodityId'>" + data.dataList[i].id + "</td>" +
            "<td class='commodityName'>" + data.dataList[i].name + "</td>" +
            "<td class='commodityPrice'>" + data.dataList[i].price + "</td>" +
            "<td class='col-lg-2 col-md-2'>" + data.dataList[i].agio + "</td>" +
            "</tr>"
        );
    }
    $("td input").click(function () {
        $("td input").iCheck("uncheck");
        $("tr").removeClass("choosed");
        $(this).iCheck("check");
        $(this).parents("tr").addClass("choosed");
        commodityId = $(".choosed > .commodityId").text();
        commodityName = $(".choosed > .commodityName").text();
        commodityPrice = $(".choosed > .commodityPrice").text();
    });
    $("input[type='radio']").on('ifChecked', function () {
        $(this).addClass("radioChecked");
    });
    $("input[type='radio']").on('ifUnchecked', function () {
        $(this).removeClass("radioChecked");
    });
    $("#commodityComfirmBtn").click(function () {
        $("input[name='consume.commodity.commodityId']").val(commodityId);
        $("input[name='consume.commodity.commodityName']").val(commodityName);
        $("input[name='consume.commodity.price']").val(commodityPrice);
    });

}

//点击【选择商品】时获取数据
$("a[href='#commodityModal']").on('click', function () {
    $("#commodityTable > tbody > tr").remove();
    $(".pagination").remove();
    $.pagingQueryRequest("commodity/list/", 1, "#commodityQueryForm > div > div > input", $.appendTrOfCommodity);
});

//点击查询时获取数据
$("#commoditySearch").on('click', function () {
    $("#commodityTable > tbody > tr").remove();
    $(".pagination").remove();
    $.pagingQueryRequest("commodity/list/", 1,"#commodityQueryForm > div > div > input", $.appendTrOfCommodity);
});

