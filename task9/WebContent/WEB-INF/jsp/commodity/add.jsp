<%@include file="/WEB-INF/jsp/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<div class="col-md-10">
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="text-muted bootstrap-admin-box-title">编辑</div>
                </div>
                <div class="bootstrap-admin-panel-content">
                    <form class="form-horizontal" action='commodity/doAdd' method="post">
                        <div class="form-group">
                            <label class="col-sm-5 control-label">品名</label>
                            <div class="col-sm-4">
                                <input name="commodity.name" class="form-control" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-5 control-label">价格</label>
                            <div class="col-sm-4">
                                <input class="form-control" type="text" name="commodity.price"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-5 control-label">折扣</label>
                            <div class="col-sm-4">
                                <input class="form-control" type="text" name="commodity.agio" placeholder="请输入10以内的正数"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-5 col-sm-offset-5 col-sm-4 col-md-4">
                                <button class="btn  btn-primary" type="submit">提交</button>
                                <a class="btn  btn-primary" href="commodity/list">取消</a>
                            </div>
                        </div>
                        <%--<s:debug/>--%>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
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
