<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
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
    <link rel="stylesheet" media="screen" href="css/bootstrap-datetimepicker.min.css">

    <!-- Bootstrap Admin Theme -->
    <link rel="stylesheet" media="screen"
          href="css/bootstrap-admin-theme.css">

</head>
<body>
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
                            <a class="dropdown-toggle" data-hover="dropdown">
                                <s:property value="#session.username"/>
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="logout">退出</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-md-2 bootstrap-admin-col-left">
            <ul class="nav navbar-collapse collapse bootstrap-admin-navbar-side">
                <li><a href="category/list">目录管理</a></li>
                <li><a href="goods/list">商品管理</a></li>
                <li><a href="user/list">用户管理</a></li>
                <li><a href="order/list">订单管理</a></li>
            </ul>
        </div>