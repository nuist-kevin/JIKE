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
                    <div class="text-muted bootstrap-admin-box-title">目录</div>
                    <a href="#categoryModal" class="right" data-toggle="modal">添加目录</a>
                </div>
                <div class="bootstrap-admin-panel-content">
                    <table class="table bootstrap-admin-table-with-actions table-hover listTable">
                        <thead>
                        <tr>
                            <th>目录编号</th>
                            <th>目录名称</th>
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
                <div id="categoryModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="vipModalTitle"
                     aria-hidden="true" style="display: none;">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-body">
                                <from id="vipQueryForm" class="form-horizontal">
                                    <div class="form-group">
                                        <label class="control-label col-md4 col-lg-4 small">目录名称：</label>
                                        <div class="col-md-6 col-lg-6">
                                            <input type="text" required class="form-control input-sm"
                                                   name="categoryName"
                                                   placeholder="目录名称"/>
                                        </div>
                                    </div>
                                </from>
                            </div>
                            <div class="modal-footer">
                                <button id="addConfirm" type="button" class="btn btn-default btn-sm btn-"
                                        data-dismiss="modal"
                                        aria-hidden="true">确定
                                </button>
                            </div>
                        </div>
                    </div>
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
<script type="text/javascript" src="js/category/list.js"></script>


