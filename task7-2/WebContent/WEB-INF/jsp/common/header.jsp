<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=request.getContextPath()%>/">
    <title><%=request.getContextPath()%>
    </title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Bootstrap -->
    <link rel="stylesheet" media="screen" href="css/bootstrap.min.css">
    <link rel="stylesheet" media="screen" href="css/bootstrap-theme.min.css">

    <!-- Bootstrap Admin Theme -->
    <link rel="stylesheet" media="screen"
          href="css/bootstrap-admin-theme.css">

</head>
<body>
<!-- main / large navbar class="bootstrap-admin-with-small-navbar" bootstrap-admin-navbar-under-small-->
<nav class="navbar navbar-default navbar-fixed-top bootstrap-admin-navbar " role="navigation">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="navbar-header">
                    <a class="navbar-brand">欢迎</a>
                </div>
                <div class="collapse navbar-collapse main-navbar-collapse">
                    <ul class="nav navbar-right navbar-nav ">
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-hover="dropdown"><s:property value="#session.userName"/> <b
                                    class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <%--<li role="presentation" class="dropdown-header">Dropdown header</li>--%>
                                <li><a href="logout">退出</a></li>
                                <%--<li role="presentation" class="divider"></li>--%>
                                <%--<li><a href="#">One more</a></li>--%>
                            </ul>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div>
        </div>
    </div><!-- /.container -->
</nav>