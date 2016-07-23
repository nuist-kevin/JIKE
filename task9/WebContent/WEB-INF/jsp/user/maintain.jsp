<%@include file="/WEB-INF/jsp/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<div class="container">
    <div class="row">
        <div class="col-md-2 bootstrap-admin-col-left">
            <ul class="nav navbar-collapse collapse bootstrap-admin-navbar-side">
                <li
                        class="active"><a href="user/maintain">系统维护</a></li>
            </ul>
        </div>
        <div class="col-md-10">
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="text-muted bootstrap-admin-box-title">用户列表</div>
                            <a href="user/add" class="right">添加用户</a>
                        </div>
                        <div class="bootstrap-admin-panel-content">
                            <table
                                    class="table bootstrap-admin-table-with-actions table-hover">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>登录名</th>
                                    <th>密码</th>
                                    <th>权限</th>
                                    <th class="text-center">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <s:iterator value="users" status="userStatus">
                                    <tr>
                                        <td class="col-lg-1 col-md-1"><s:property
                                                value="#userStatus.index + 1"/></td>
                                        <td class="col-lg-3 col-md-3"><s:property
                                                value="username"/></td>
                                        <td class="col-lg-3 col-md-3"><s:property
                                                value="password"/></td>
                                        <td class="col-lg-2 col-md-2">
                                            <s:if test="authority == 0">
                                                无权限
                                            </s:if> <s:elseif test="authority == 1">管理员</s:elseif>
                                        <s:else>普通</s:else></td>

                                        <td class="actions col-lg-2 col-md-2 ">
                                            <a href="user/view/<s:property value="username"/>"
                                               class="btn btn-sm btn-info ">
                                                <i class="glyphicon glyphicon-eye-open"></i>
                                            </a>
                                            <a href="user/edit/<s:property value="username"/>"
                                               class="btn btn-sm btn-primary">
                                                <i class="glyphicon glyphicon-pencil"></i>
                                            </a>
                                            <a href="user/delete/<s:property value="username"/>"
                                               class="btn btn-sm btn-danger">
                                                <i class="glyphicon glyphicon-trash"></i>
                                            </a>
                                        </td>
                                    </tr>
                                </s:iterator>
                                </tbody>
                            </table>
                            <%--分页按钮--%>
                            <s:if test="pageNum > 1">
                                <div class="col-sm-4 col-sm-offset-4 col-md-4 col-md-offset-4">
                                    <div class="pagination-container">
                                        <ul class="pagination pagination-sm">
                                            <s:iterator value="indexList" status="st">
                                                <s:set var="aii" value="#st.index+1"/>
                                                <li <s:if
                                                        test="#aii == page"> class="active"</s:if> >
                                                    <a href="user/list/<s:property/>"><s:property/></a>
                                                </li>
                                            </s:iterator>
                                        </ul>
                                    </div>
                                </div>
                            </s:if>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <s:debug/>

    </div>
</div>
<%@include file="/WEB-INF/jsp/common/footer.jsp" %>
