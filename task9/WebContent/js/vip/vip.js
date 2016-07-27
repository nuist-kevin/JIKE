/**
 * Created by caiwen on 2016/7/24.
 */
$("a[href='#vipList']").on('click', function () {
    $.post("vip/jsonVips", function (data) {
        var vips = data;
        $("#vipPaging").paging(vips.length, {
            format: "[< nncnn >]",
            onSelect: function (page) {
                $("#vipTable > tbody > tr").remove();
                for (var i = this.slice[0]; i < this.slice[1]; i++) {
                    $("#vipTable > tbody").append(
                        "<tr>" +
                        "<td><div class='iradio'><input type='radio'/></div></td>" +
                        "<td>" + vips[i].id + "</td>" +
                        "<td>" + vips[i].name + "</td>" +
                        "<td>" + vips[i].age + "</td>" +
                        "<td>" + vips[i].profession + "</td>" +
                        "<td>" + vips[i].joinTime + "</td>" +
                        "</tr>");
                }
                $("td input").click(function () {
                    $("td input").iCheck("uncheck");
                    $(this).iCheck("check");
                    var theNext = $(this).parent().parent().next('td');
                    vipId = $(theNext).text();
                    vipName = $(theNext).next('td').text();
                });
                $("input[type='radio']").on('ifChecked', function () {
                    $(this).addClass("radioChecked");
                });
                $("input[type='radio']").on('ifUnchecked', function () {
                    $(this).removeClass("radioChecked");
                });
                $("#chooseBtn").click(function () {
                    $("input[name='consume.vip.vipId']").val(vipId);
                    $("input[name='consume.vip.name']").val(vipName);
                });
            },
            onFormat: function (type) {
                switch (type) {
                    case 'block':
                        if (!this.active)
                            return '<li class="active"><a>' + this.value + '</a></li>';
                        else if (this.value != this.page)
                            return '<li><a href="#' + this.value + '">' + this.value + '</a></li>';
                        return '<li  class="active"><a>' + this.value + '</a></li>';
                    case 'next':
                        if (this.active) {
                            return '<li><a href="#' + this.value + '" class="next">下一页</a></li>';
                        }
                        return '<li class="disabled"><a >下一页</a></li>';
                    case 'prev':
                        if (this.active) {
                            return '<li><a href="#' + this.value + '" class="prev">上一页</a></li>';
                        }
                        return '<li class="disabled"><a>上一页</a></li>';
                    case 'first':
                        if (this.active) {
                            return '<li><a href="#' + this.value + '" class="first">首页</a></li>';
                        }
                        return '<li class="disabled"><a >首页</a></li>';
                    case 'last':
                        if (this.active) {
                            return '<li><a href="#' + this.value + '" class="prev">末页</a></li>';
                        }
                        return '<li  class="disabled"><a>末页</a></li>';
                }
            }
        });
    });
});




