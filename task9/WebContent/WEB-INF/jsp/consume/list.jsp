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
                        <label class="control-label col-md-2 col-lg-2">VIP编号：</label>
                        <div class="col-md-3 col-lg-3">
                            <input type="number" class="form-control" min="1" step="1"
                                   name="vipId"
                                   placeholder="VIP编号"/>
                        </div>
                        <label class="control-label col-md-2 col-lg-2 text-left">VIP姓名：</label>
                        <div class="col-md-3 col-lg-3">
                            <input type="text" class="form-control"
                                   name="name"
                                   placeholder="VIP姓名">
                        </div>
                        <div class="col-sm-2">
                            <a id="queryBtn" class="btn btn-info btn-sm right">查询</a>
                        </div>
                    </div>
                </form>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="text-muted bootstrap-admin-box-title">消费列表</div>
                    <a href="consume/add" class="right">购物登记</a>
                </div>
                <div class="bootstrap-admin-panel-content">
                    <table class="table bootstrap-admin-table-with-actions table-hover listTable">
                        <thead>
                        <tr>
                            <th class="col-lg-2 col-md-2">消费编号</th>
                            <th class="col-lg-2 col-md-2">VIP编号</th>
                            <th class="col-lg-2 col-md-2">姓名</th>
                            <th class="col-lg-2 col-md-2">商品名称</th>
                            <th class="col-lg-2 col-md-2">商品价格</th>
                            <th class="col-lg-2 col-md-2">实收金额</th>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                    <div class="col-lg-offset-4 col-md-offset-4 pagingDiv">
                        <ul class="pagination pagination-sm ">
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</div>
<s:debug/>
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
<script type="text/javascript" src="js/consume/query.js"></script>

