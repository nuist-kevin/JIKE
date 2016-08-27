<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html class="bootstrap-admin-vertical-centered">
<head>
    <title>title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" media="screen" href="<%=path%>/css/bootstrap.min.css">
    <link rel="stylesheet" media="screen" href="<%=path%>/css/bootstrap-theme.min.css">
    <link rel="stylesheet" media="screen" href="<%=path%>/css/bootstrap-admin-theme.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <form method="post" action="doRegister" class="bootstrap-admin-login-form">
                <div class="form-group">
                    <input class="form-control" type="text" name="userDto.userName" placeholder="请输入用户名"/>
                </div>
                <div class="form-group">
                    <input class="form-control" type="password" name="userDto.password" placeholder="请输入密码"/>
                </div>
                <div class="form-group">
                    <input class="form-control" type="text" name="userDto.realName" placeholder="请输入真名"/>
                </div>
                <div class="form-group">
                    <input class="form-control" type="text" name="userDto.pwdQuestion" placeholder="请输入密码问题"/>
                </div>
                <div class="form-group">
                    <input class="form-control" type="text" name="userDto.pwdQuestionAnswer" placeholder="请输入密码问题答案"/>
                </div>
                <div class="form-group">
                    <input class="form-control" type="text" name="userDto.address" placeholder="请输入地址"/>
                </div>
                <div class="form-group">
                    <input class="form-control" type="email" name="userDto.email" placeholder="请输入email"/>
                </div>
                <div class="form-group">
                    <input class="form-control" type="text" name="userDto.phoneNo" placeholder="请输入电话号码"/>
                </div>
                <div class="form-group">
                    <button type="doRegister" class="btn btn-sm btn-primary">注册</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script type="text/javascript" src="<%=path%>/js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/bootstrap.min.js"></script>
</body>
</html>