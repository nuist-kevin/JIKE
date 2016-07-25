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
                        "<td class='col-lg-1 col-md-1'><input id='select-" + i + "' type='radio'/></td>" +
                        "<td class='col-lg-1 col-md-1'>" + vips[i].id + "</td>" +
                        "<td class='col-lg-2 col-md-2'>" + vips[i].name + "</td>" +
                        "<td class='col-lg-2 col-md-2'>" + vips[i].age + "</td>" +
                        "<td class='col-lg-2 col-md-2'>" + vips[i].profession + "</td>" +
                        "<td class='col-lg-2 col-md-2'>" + vips[i].joinTime + "</td>" +
                        "</tr>");
                }
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

                    case 'fill':
                        if (this.active) {
                            return "...";
                        }
                }
            }
        });
        $("input[type='radio']").each(function () {
            $(this).on('click', function () {
                console.log('clicked')
                var thisId = $(this).attr("id");
                $("td > input").each(function () {
                    var thisEl = $(this);
                    if ($(thisEl).attr("id") != thisId) {
                        $(thisEl).removeAttr("checked");
                    }
                })
            })
        });
    });
});



