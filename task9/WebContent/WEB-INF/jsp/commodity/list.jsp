<%@include file="/WEB-INF/jsp/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<div class="col-md-10">
    <div class="row">
        <div class="col-lg-12">
            <div class="page-header">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label col-md-2 col-lg-2">商品编号：</label>
                        <div class="col-md-2 col-lg-2">
                            <input type="number" class="form-control" min="1" step="1"
                                   name="id"
                                   placeholder="商品编号"/>
                        </div>
                        <label class="control-label col-md-2 col-lg-2">商品名称：</label>
                        <div class="col-md-4 col-lg-4">
                            <input type="text" class="form-control"
                                   name="name"
                                   placeholder="商品名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-2 col-lg-2">商品价格：</label>
                        <div class="col-md-2 col-lg-2">
                            <input type="number" class="form-control" name="lowPrice" min="0.01" step="0.01"
                                   placeholder="价格下限">
                        </div>
                        <p class="form-control-static col-md-1 text-center">至</p>
                        <div class="col-md-2 col-lg-2">
                            <input type="number" class="form-control" name="upPrice" min="0.01" step="0.01"
                                   placeholder="价格上限">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-2 col-lg-2">商品折扣：</label>
                        <div class="col-md-2 col-lg-2">
                            <input type="number" class="form-control" name="lowAgio" min="0.001" max="9.999"
                                   step="0.001"
                                   placeholder="折扣下限">
                        </div>
                        <p class="form-control-static col-md-1 text-center">至</p>
                        <div class="col-md-2 col-lg-2">
                            <input type="number" class="form-control" name="upAgio" min="0.001" max="9.999" step="0.001"
                                   placeholder="折扣上限">
                        </div>
                        <div class="col-md-offset-11 col-lg-offset-11">
                            <a class="btn btn-info btn-sm">查询</a>
                        </div>
                    </div>
                </form>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="text-muted bootstrap-admin-box-title">商品列表</div>
                    <a href="commodity/add" class="right btn btn-info btn-sm">商品信息录入</a>
                </div>
                <div class="bootstrap-admin-panel-content">
                    <table id="commodityTable" class="table bootstrap-admin-table-with-actions table-hover">
                        <thead>
                        <tr>
                            <th>商品编号</th>
                            <th>商品名称</th>
                            <th>商品价格</th>
                            <th>商品折扣</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%--表格数据通过jquery异步填充--%>
                        </tbody>
                    </table>
                </div>

            </div>
            <%--分页按钮： 通过插件实现，详见页尾jqeury代码--%>
            <div class="col-lg-offset-4 col-md-offset-4">
                <ul id="commodityPaging" class="pagination pagination-sm ">
                </ul>
            </div>
        </div>
    </div>
</div>
</div>
<s:debug/>
</div>
<div class="navbar navbar-footer">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <footer role="contentinfo">
                    <p class="right">&copy; 2016 by 蔡文</p>
                </footer>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/jsp/common/footer.jsp" %>
<script type="text/javascript" src="js/jqPaginator.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#commodityPaging").jqPaginator({
            totalPages: <s:property value="totalPages"/>, //总页数，通过CommodityAction的totalPages返回
            pageSize: 5, //每页记录数量，与CommodityService.listByPage中设置的数量一致
            currentPage: 1, //初始化时的当前页码
            visiblePages: 5, //最多显示几个页码
            //各个按钮的html格式
            first: '<li class="first"><a href="javascript:void(0);">首页<\/a><\/li>',
            prev: '<li class="prev"><a href="javascript:void(0);">上一页<\/a><\/li>',
            next: '<li class="next"><a href="javascript:void(0);">下一页<\/a><\/li>',
            last: '<li class="last"><a href="javascript:void(0);">末页<\/a><\/li>',
            page: '<li class="page"><a href="javascript:void(0);">{{page}}<\/a><\/li>',
            activeClass: 'active',  //当前页码的样式
            disableClass: 'disabled', //禁用的样式
            //页码发生变更时的回调函数，参数值为当前页码值
            onPageChange: function (n) {
                //先去除原先显示的数据
                $("#commodityTable > tbody > tr").remove();
                //发送异步请求，获取指定页码的商品列表数据，json格式为{'commodityList',[……]}
                $.post("commodity/list/" + n,
                        {
                            "id": $("input[name = 'id']").val(),
                            "name": $("input[name = 'name']").val(),
                            "lowPrice": $("input[name = 'lowPrice']").val(),
                            "upPrice": $("input[name = 'upPrice']").val(),
                            "lowAgio": $("input[name = 'lowAgio']").val(),
                            "upAgio": $("input[name = 'upAgio']").val()
                        }, function (data) {
                            //循环添加到商品的table中
                            for (var i = 0; i < data.commodityList.length; i++) {
                                $("#commodityTable > tbody").append(
                                        "<tr>" +
                                        "" +
                                        "<td class='col-lg-3 col-md-3'>" + data.commodityList[i].id + "</td>" +
                                        "<td class='col-lg-3 col-md-3'>" + data.commodityList[i].name + "</td>" +
                                        "<td class='col-lg-3 col-md-3'>" + data.commodityList[i].price + "</td>" +
                                        "<td class='col-lg-3 col-md-3'>" + data.commodityList[i].agio + "</td>" +
                                        "</tr>");
                            }
                        });
            }
        });
    });
</script>


