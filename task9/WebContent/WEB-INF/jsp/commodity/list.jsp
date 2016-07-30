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
                        <label class="control-label col-md-offset-1 col-lg-offset-1 col-md-2 col-lg-2 text-left">商品名称：</label>
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
                        <p class="form-control-static col-md-1 col-lg-1 text-center">至</p>
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
                            <a id="queryBtn" class="btn btn-info btn-sm">查询</a>
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
            <div class="col-lg-offset-4 col-md-offset-4 pagingDiv">
                <ul id="commodityPaging" class="pagination pagination-sm ">
                </ul>
            </div>
        </div>
    </div>
</div>
</div>
<%--<s:debug/>--%>
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
<script type="text/javascript" src="js/commodity/query.js"></script>


