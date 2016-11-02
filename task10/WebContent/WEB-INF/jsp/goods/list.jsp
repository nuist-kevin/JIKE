<%@include file="/WEB-INF/jsp/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<div class="col-md-10">
    <div class="row">
        <div class="col-lg-12">
            <div class="page-header">
                <form id="queryOptionForm" class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label col-md-2 col-lg-2 text-left">商品名称：</label>
                        <div class="col-md-4 col-lg-4">
                            <input type="text" class="form-control"
                                   name="conditions.goodsName"
                                   placeholder="商品名称">
                        </div>
                        <label class="control-label col-md-2 col-lg-2">商品目录：</label>
                        <div class="col-md-2 col-lg-2">
                            <input type="text" class="form-control"
                                   name="conditions.categoryName"
                                   placeholder="商品目录"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-2 col-lg-2">商品价格：</label>
                        <div class="col-md-2 col-lg-2">
                            <input type="number" class="form-control" name="conditions.lowPrice" min="0.01" step="0.01"
                                   placeholder="价格下限">
                        </div>
                        <p class="form-control-static col-md-1 col-lg-1 text-center">至</p>
                        <div class="col-md-2 col-lg-2">
                            <input type="number" class="form-control" name="conditions.upPrice" min="0.01" step="0.01"
                                   placeholder="价格上限">
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
                    <a href="goods/add" class="right" data-toggle="modal">添加商品</a>
                </div>
                <div class="bootstrap-admin-panel-content">
                    <table class="table bootstrap-admin-table-with-actions table-hover listTable">
                        <thead>
                        <tr>
                            <th>商品编号</th>
                            <th>商品名称</th>
                            <th>商品目录</th>
                            <th>商品价格</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
                <div class="col-lg-offset-4 col-md-offset-4 pagingDiv">
                    <ul class="pagination pagination-sm">
                    </ul>
                </div>
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
<script type="text/javascript" src="js/goods/query.js"></script>


