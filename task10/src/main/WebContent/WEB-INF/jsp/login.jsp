<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html class="bootstrap-admin-vertical-centered">
<head>
    <base href="<%=request.getContextPath()%>/">
    <title>登录</title>
    <base href="/task7-2/">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" media="screen" href="css/bootstrap.min.css">
    <link rel="stylesheet" media="screen" href="css/bootstrap-theme.min.css">
    <link rel="stylesheet" media="screen" href="css/bootstrap-admin-theme.css">
</head>
<s:debug/>
<%--class="bootstrap-admin-without-padding"--%>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <form method="post" action="login" class="bootstrap-admin-login-form">
                <div class="form-group">
                    <%--如果有错误信息，显示错误信息块--%>
                    <s:if test="fieldErrors.size > 0">
                        <div class="alert alert-danger">
                            <a class="close" data-dismiss="alert" onclick="$(function () {
                            remove($('.alert-danger'));
                        });">×</a>
                            <s:property value="fieldErrors.username"/>
                        </div>
                    </s:if>
                    <input class="form-control" type="text" required name="userDto.userName" placeholder="请输入用户名"/>
                </div>
                <div class="form-group">
                    <input class="form-control" type="password" required name="userDto.password" placeholder="请输入密码"/>
                </div>
                <div class="form-inline">
                    <a href="register" class="right">注册</a>
                    <a href="register" class="right">注册</a>

                    <button type="submit" class="btn btn-link ">登录</button>

                </div>
                <div class="form-group">
                    <label>管理员使用caiwen=123456登录</label>
                </div>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(function () {
        $('input[name="user.username"]').focus();
    });
</script>
</body>
</html>