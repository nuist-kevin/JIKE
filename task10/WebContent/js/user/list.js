
//列表页的填充数据方法
$.appendTrForUsers = function (data) {
    //循环添加数据到列表的table中
    for (var i = 0; i < data.users.length; i++) {
        $(".listTable > tbody").append(
            "<tr>" +
            "<td class='col-lg-1 col-md-1'>" + data.users[i].id + "</td>" +
            "<td class='col-lg-2 col-md-2'>" + data.users[i].userName + "</td>" +
            "<td class='col-lg-2 col-md-2'>" + data.users[i].realName + "</td>" +
            "<td class='col-lg-3 col-md-3'>" + data.users[i].email + "</td>" +
            "<td class='col-lg-2 col-md-2'>" + data.users[i].phoneNo + "</td>" +
            "<td class='actions col-lg-2 col-md-2'>" +
            "<a href=\'" + "user/edit/" + data.users[i].id + "\'  class='btn btn-sm btn-primary'><i class='glyphicon glyphicon-pencil'></i></a>" +
            "<a href=\'" + "user/delete/" + data.users[i].id + "\' class='btn btn-sm btn-danger'><i class='glyphicon glyphicon-trash'></i></a>" +
            "</td></tr>"
        );
    }
    $('.btn-danger').on("click", function (event) {
        confirm("确定删除？");
        event.preventDefault();
        $.post($(this).attr("href"), function () {
            $(".pagination").remove();
            $.pagingQueryRequest("user/list/", 1, "", $.appendTrForUsers);
        });
    });
}

//初始化页面时获取一次数据
$(function () {
    $(".pagination").remove();
    $.pagingQueryRequest("user/list/", 1, "", $.appendTrForUsers);
});

