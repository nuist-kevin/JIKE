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
                    <div class="text-muted bootstrap-admin-box-title">修改用户</div>
                </div>
                <div class="bootstrap-admin-panel-content">
                    <form method="post" action="user/doEdit/<s:property value="userDto.id"/>" class="form-horizontal">
                        <input type="hidden" name="user.role.id" value="<s:property value="userDto.roleId"/>">
                        <div class="form-group">
                            <label class="col-sm-4 control-label">用户名</label>
                            <div class="col-sm-4">
                                <input class="form-control" type="text" name="user.userName" placeholder="请输入用户名"
                                       value="<s:property value="userDto.userName"/>"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">密码</label>
                            <div class="col-sm-4">
                                <input class="form-control" type="password" name="user.password"
                                       value="<s:property value="userDto.password"/>"
                                       placeholder="请输入密码"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">真名</label>
                            <div class="col-sm-4">
                                <input class="form-control" type="text" name="user.realName" value="<s:property
                                value="userDto.realName"/>" placeholder="请输入真名"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">密码问题</label>
                            <div class="col-sm-4">
                                <input class="form-control" type="text" name="user.pwdQuestion" value="<s:property
                                value="userDto.pwdQuestion"/>"
                                       placeholder="请输入密码问题"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">密码问题答案</label>
                            <div class="col-sm-4">
                                <input class="form-control" type="text" name="user.pwdQuestionAnswer" value="<s:property
                                value="userDto.pwdQuestionAnswer"/>"
                                       placeholder="请输入密码问题答案"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">地址</label>
                            <div class="col-sm-4">
                                <input class="form-control" type="text" name="user.address" value="<s:property
                                value="userDto.address"/>" placeholder="请输入地址"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">email</label>
                            <div class="col-sm-4">
                                <input class="form-control" type="email" name="user.email" value="<s:property
                                value="userDto.email"/>" placeholder="请输入email"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">电话号码</label>
                            <div class="col-sm-4">
                                <input class="form-control" type="text" name="user.phoneNo" value="<s:property
                                value="userDto.phoneNo"/>" placeholder="请输入电话号码"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-5">
                                <button type="submit" class="btn btn-sm btn-primary">提交</button>
                                <a href="user/list" class="btn btn-sm btn-primary">返回</a>
                            </div>
                        </div>
                    </form>
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


