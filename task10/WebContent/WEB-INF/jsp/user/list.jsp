<%@include file="/WEB-INF/jsp/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<div class="col-md-10">
    <div class="row">
        <div class="col-lg-12">
            <div class="page-header">
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="text-muted bootstrap-admin-box-title">用户列表</div>
                    <a href="user/add" class="right" data-toggle="modal">添加用户</a>
                </div>
                <div class="bootstrap-admin-panel-content">
                    <table class="table bootstrap-admin-table-with-actions table-hover listTable">
                        <thead>
                        <tr>
                            <th>编号</th>
                            <th>用户名</th>
                            <th>真名</th>
                            <th>email</th>
                            <th>电话</th>
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
<%@include file="/WEB-INF/jsp/common/footer.jsp"%>
<script type="text/javascript" src="js/jqPaginator.min.js"></script>
<script type="text/javascript" src="js/user/list.js"></script>


