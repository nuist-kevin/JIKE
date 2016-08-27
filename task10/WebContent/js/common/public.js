/**
 * Created by caiwen on 2016/7/30.
 */

/**
 * 异步获取分页列表数据并根据数据形成翻页按钮
 * @param url——请求路径
 * @param page——请求的页码，与url一起拼接成实际的请求request
 * @param formId——序列化的表单id
 * @param appendTrFun——添加数据到表格中的方法，由于每个页面的表格字段不同，所以留到每个页面各自编写添加表格数据的方法
 */
$.pagingQueryRequest = function(url, page , seletor, appendTrFun) {
    //发送异步请求，获取指定页码的列表数据，json格式为{'dataList':[……], totalPages: x}
    $.post(url + page, $(seletor).serialize(), function (data) {
        //查询到数据才做页面的更新
        if (data.totalPages > 0) {
            //填充表格数据
            appendTrFun(data);
            //形成翻页按钮，使用jqPaginator这个jquery插件
            $(".pagingDiv").append("<ul class='pagination pagination-sm'></ul>");
            $(".pagination").jqPaginator({
                totalPages: data.totalPages, //总页数，通过data的totalPages返回
                pageSize: 10, //每页记录数量，与CommodityService.listByPage中设置的数量一致
                visiblePages: 5, //最多显示几个页码
                //各个按钮的html格式
                first: "<li class='first'><a href='javascript:void(0);'>首页</a></li>",
                prev: "<li class='prev'><a href='javascript:void(0);'>上一页</a></li>",
                next: "<li class='next'><a href='javascript:void(0);'>下一页</a></li>",
                last: "<li class='last'><a href='javascript:void(0);'>末页</a></li>",
                page: "<li class='page'><a href='javascript:void(0);'>{{page}}</a></li>",
                activeClass: 'active',  //当前页码的样式
                disableClass: 'disabled', //禁用的样式
                // 页码发生变更时的回调函数，参数值为当前页码值
                onPageChange: function (n) {
                    //先去除原先显示的数据
                    $(".listTable > tbody > tr").remove();
                    //发送异步请求，获取指定页码的列表数据，json格式为{'dataList':[……], totalPages: x}
                    $.post( url + n, $(seletor).serialize(),function(data) {
                        //填充表格数据
                        appendTrFun(data);
                    });
                }
            });
        }
    });
}