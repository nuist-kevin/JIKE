$("#addConfirm").on("click", function () {
    if ($("input[name='categoryName']").val().length > 0) {
        $.post("category/add", "category.categoryName=" + $("input[name='categoryName']").val(), function () {
            $(".pagination").remove();
            $.pagingQueryRequest("category/list/", 5, 1, "", $.appendTrForCategories);
            $("input[name='categoryName']").val('');
        });
    } else {
        alert("请输入目录名称");
    }
});


//列表页的填充数据方法
$.appendTrForCategories = function (data) {
    //循环添加数据到列表的table中
    for (var i = 0; i < data.categories.length; i++) {
        $(".listTable > tbody").append(
            "<tr>" +
            "<td class='col-lg-5 col-md-5'>" + data.categories[i].id + "</td>" +
            "<td class='col-lg-5 col-md-5'>" + data.categories[i].categoryName + "</td>" +
            "<td class='actions col-lg-2 col-md-2'>" +
            "<a href=\'" + "category/edit/" + data.categories[i].id + "\'  class='btn btn-sm btn-primary'><i class='glyphicon glyphicon-pencil'></i></a>" +
            "<a href=\'" + "category/delete/" + data.categories[i].id + "\' class='btn btn-sm btn-danger'><i class='glyphicon glyphicon-trash'></i></a>" +
            "</td></tr>"
        );
    }
    $('.btn-danger').on("click", function (event) {
        confirm("确定删除？");
        event.preventDefault();
        $.post($(this).attr("href"), function () {
            $(".pagination").remove();
            $.pagingQueryRequest("category/list/",5 , 1, "", $.appendTrForCategories);
        });
    });
}

//初始化页面时获取一次数据
$(function () {
    $(".pagination").remove();
    $.pagingQueryRequest("category/list/", 5, 1, "", $.appendTrForCategories);
});

