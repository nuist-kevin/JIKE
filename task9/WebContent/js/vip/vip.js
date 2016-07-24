/**
 * Created by caiwen on 2016/7/24.
 */
$("a[href='#vipList']").on('click', function () {
    $("#vipPaging").paging(100, {
        format: "[< nncnn >]",
        onSelect: function(page) {
            alert(page);
        },
        onFormat: function(type) {

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
        },
    });

});

