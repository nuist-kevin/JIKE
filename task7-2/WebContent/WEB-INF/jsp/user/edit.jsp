<%@include file="/WEB-INF/jsp/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<div class="container">
    <div class="row">
        <div class="col-md-2 bootstrap-admin-col-left">
            <ul class="nav navbar-collapse collapse bootstrap-admin-navbar-side">
                <li><a href="user/list">用户管理</a></li>
            </ul>
        </div>
        <div class="col-md-10">
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="text-muted bootstrap-admin-box-title">编辑</div>
                        </div>
                        <div class="bootstrap-admin-panel-content">
                            <form class="form-horizontal" action="user/doEdit/${user.id}" method="post">
                                <div class="form-group">
                                    <label class="col-sm-4 control-label">用户名</label>
                                    <div class="col-sm-6">
                                        <input class="form-control" type="text" name="user.username"
                                               value="${user.username}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-4 control-label">密码</label>
                                    <div class="col-sm-6">
                                        <input class="form-control" type="text" name="user.password"
                                               value="${user.password}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-4 control-label">真名</label>
                                    <div class="col-sm-6">
                                        <input class="form-control" type="text" name="user.realName"
                                               value="${user.realName}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-4 control-label">年龄</label>
                                    <div class="col-sm-6">
                                        <input class="form-control" type="text" name="user.age" value="${user.age}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-4 control-label">电话</label>
                                    <div class="col-sm-6">
                                        <input class="form-control" type="text" name="user.phoneNum"
                                               value="${user.phoneNum}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-4 control-label">地址</label>
                                    <div class="col-sm-6">
                                        <input class="form-control" type="text" name="user.address"
                                               value="${user.address}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-offset-4 col-sm-offset-4 col-sm-4 col-md-4">
                                        <button class="btn  btn-primary" type="submit">提交</button>
                                        <a class="btn  btn-primary" href="user/view/${user.id}">取消</a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<%@include file="/WEB-INF/jsp/common/footer.jsp" %>
