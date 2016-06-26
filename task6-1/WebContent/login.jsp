<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html class="bootstrap-admin-vertical-centered">
<head>
    <title>登录</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" media="screen" href="<%=path%>/css/bootstrap.min.css">
    <link rel="stylesheet" media="screen" href="<%=path%>/css/bootstrap-theme.min.css">
    <link rel="stylesheet" media="screen" href="<%=path%>/css/bootstrap-admin-theme.css">
</head>
<body class="bootstrap-admin-without-padding">
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <s:form namespace="/" method="post" action="login" class="bootstrap-admin-login-form">
                <h1>登录</h1>
                <div class="form-group">
                    <s:textfield class="form-control" name="user.username" placeholder="请输入用户名"></s:textfield>
                </div>
                <div class="form-group">
                    <s:password class="form-control" name="user.password" placeholder="请输入密码"></s:password>
                </div>
                <s:submit class="btn btn-lg btn-primary" value="提交"></s:submit>
            </s:form>
        </div>
    </div>
</div>
<script type="text/javascript" src="<%=path%>/js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(function () {
        $('input[name="user.username"]').focus();
    });
</script>
</body>

</html>