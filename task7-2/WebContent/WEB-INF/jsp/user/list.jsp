<%@include file="/WEB-INF/jsp/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<div class="container">
    <div class="row">
        <div class="col-md-2 bootstrap-admin-col-left">
            <ul class="nav navbar-collapse collapse bootstrap-admin-navbar-side">
                <li class="active"><a href="user/list">用户管理</a></li>
            </ul>
        </div>

        <div class="col-md-10">
            <div class="row">
                <div class="col-lg-12">
                    <div class="page-header">
                        <s:fielderror/>
                        <s:form cssClass="form-inline" action="basicDoSearch">
                            <div class="form-group">
                                <s:select name="searchOption"
                                          list="#{'1':'登录名', '2':'真名', '3':'电话', '4':'地址'}"
                                          cssClass="form-control"/>
                                <s:textfield name="searchValue" size="30"
                                             cssClass="form-control"/>
                                <s:submit cssClass="btn btn-success" value="搜索"/>
                            </div>
                        </s:form>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="text-muted bootstrap-admin-box-title">用户列表</div>
                        </div>
                        <div class="bootstrap-admin-panel-content">
                            <table
                                    class="table bootstrap-admin-table-with-actions table-hover">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>登录名</th>
                                    <th>真名</th>
                                    <th>年龄</th>
                                    <th>电话</th>
                                    <th>地址</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>${user.id}</td>
                                    <td>${user.username}</td>
                                    <td>${user.realName}</td>
                                    <td>${user.age}</td>
                                    <td>${user.phoneNum}</td>
                                    <td>${user.address}</td>
                                    <td class="actions">
                                        <button class="btn btn-sm btn-info">
                                            <i class="glyphicon glyphicon-eye-open"></i>
                                        </button>
                                        <button class="btn btn-sm btn-primary">
                                            <i class="glyphicon glyphicon-pencil"></i>
                                        </button>
                                        <button class="btn btn-sm btn-danger">
                                            <i class="glyphicon glyphicon-trash"></i>
                                        </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>Jacob</td>
                                    <td>Thornton</td>
                                    <td>@fat</td>
                                    <td>18094200522</td>
                                    <td>南京</td>

                                    <td class="actions">
                                        <a href="#">
                                            <button class="btn btn-sm btn-info">
                                                <i class="glyphicon glyphicon-eye-open"></i>
                                            </button>
                                        </a>
                                        <a href="#">
                                            <button class="btn btn-sm btn-primary">
                                                <i class="glyphicon glyphicon-pencil"></i>
                                            </button>
                                        </a> <a href="#">
                                        <button class="btn btn-sm btn-danger">
                                            <i class="glyphicon glyphicon-trash"></i>
                                        </button>
                                    </a></td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>Larry</td>
                                    <td>the Bird</td>
                                    <td>@twitter</td>
                                    <td>18094200522</td>
                                    <td>南京是短发短发啊士大夫温柔啊速度发啊啊时代发生的</td>
                                    <td class="actions">
                                        <a href="#">
                                            <button class="btn btn-sm btn-info">
                                                <i class="glyphicon glyphicon-eye-open"></i>
                                            </button>
                                        </a>
                                        <a href="#">
                                            <button class="btn btn-sm btn-primary">
                                                <i class="glyphicon glyphicon-pencil"></i>
                                            </button>
                                        </a>
                                        <a href="#">
                                            <button class="btn btn-sm btn-danger">
                                                <i class="glyphicon glyphicon-trash"></i>
                                            </button>
                                        </a>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<%@include file="/WEB-INF/jsp/common/footer.jsp" %>
