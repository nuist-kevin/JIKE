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
    <div class="col-md-12">
        <div class="row">
            <div class="col-lg-12">
                <div class="page-header">
                    <form id="queryOptionForm" class="form-horizontal">
                        <input type="hidden" name="recordPerPage" value="20"/>
                        <div class="form-group">
                            <label class="control-label col-md-2 col-lg-2 text-left">商品名称：</label>
                            <div class="col-md-4 col-lg-4">
                                <input type="text" class="form-control"
                                       name="conditions.goodsName"
                                       placeholder="商品名称">
                            </div>
                            <label class="control-label col-md-2 col-lg-2">商品目录：</label>
                            <div class="col-md-2 col-lg-2">
                                <s:select cssClass="form-control" name="conditions.categoryId" list="categoryList"
                                          listKey="id" listValue="categoryName">
                                </s:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-2 col-lg-2">商品价格：</label>
                            <div class="col-md-2 col-lg-2">
                                <input type="number" class="form-control" name="conditions.fromPrice" min="0.01"
                                       step="0.01"
                                       placeholder="价格下限">
                            </div>
                            <p class="form-control-static col-md-1 col-lg-1 text-center">至</p>
                            <div class="col-md-2 col-lg-2">
                                <input type="number" class="form-control" name="conditions.toPrice" min="0.01"
                                       step="0.01"
                                       placeholder="价格上限">
                            </div>
                            <div class="col-md-offset-11 col-lg-offset-11">
                                <a id="queryBtn" class="btn btn-info btn-sm">查询</a>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="text-muted bootstrap-admin-box-title">商品一览</div>
                        <div class="pull-right"><span class="badge"></span></div>
                    </div>
                    <div class="bootstrap-admin-panel-content">
                        <div class="row bootstrap-admin-light-padding-bottom ">
                            <div class="col-md-3">
                                <a href="#" class="thumbnail">
                                    <img data-src="holder.js/200x180" alt="200x180" style="width: 200px; height: 180px;"
                                         src="">
                                </a>
                                <p style="text-align: center">iPhone 6 64G 土豪金</p>
                                <p style="text-align: center">5888.00元</p>
                            </div>
                            <div class="col-md-3">
                                <a href="#" class="thumbnail">
                                    <img data-src="holder.js/200x180" alt="200x180" style="width: 200px; height: 180px;"
                                         src="">
                                </a>
                                <p style="text-align: center">iPhone 6 64G 土豪金</p>
                                <p style="text-align: center">5888.00元</p>
                            </div>
                            <div class="col-md-3">
                                <a href="#" class="thumbnail">
                                    <img data-src="holder.js/200x180" alt="200x180" style="width: 200px; height: 180px;"
                                         src="">
                                </a>
                                <p style="text-align: center">iPhone 6 64G 土豪金</p>
                                <p style="text-align: center">5888.00元</p>
                            </div>
                            <div class="col-md-3">
                                <a href="#" class="thumbnail">
                                    <img data-src="holder.js/200x180" alt="200x180" style="width: 200px; height: 180px;"
                                         src="">
                                </a>
                                <p style="text-align: center">iPhone 6 64G 土豪金</p>
                                <p style="text-align: center">5888.00元</p>
                            </div>
                        </div>
                        <%--<div class="row bootstrap-admin-light-padding-bottom">--%>
                            <%--<div class="col-md-3 form-group">--%>
                                <%--&lt;%&ndash;<div class="col-md-6 col-lg-6">&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<p class="form-control-static align-center">商品名称： 100</p>&ndash;%&gt;--%>

                                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <div class="row">
                            <div class="col-md-3">
                                <a href="#" class="thumbnail">
                                    <img data-src="holder.js/200x180" alt="200x180" style="width: 200px; height: 180px;"
                                         src="">
                                </a>
                                <p style="text-align: center">iPhone 6 64G 土豪金</p>
                                <p style="text-align: center">5888.00元</p>
                            </div>
                            <div class="col-md-3">
                                <a href="#" class="thumbnail">
                                    <img data-src="holder.js/200x180" alt="200x180" style="width: 200px; height: 180px;"
                                         src="">
                                </a>
                                <p style="text-align: center">iPhone 6 64G 土豪金</p>
                                <p style="text-align: center">5888.00元</p>
                            </div>
                            <div class="col-md-3">
                                <a href="#" class="thumbnail">
                                    <img data-src="holder.js/200x180" alt="200x180" style="width: 200px; height: 180px;"
                                         src="">
                                </a>
                                <p style="text-align: center">iPhone 6 64G 土豪金</p>
                                <p style="text-align: center">5888.00元</p>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="col-lg-offset-4 col-md-offset-4 pagingDiv">
                    <ul class="pagination pagination-sm">
                    </ul>
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
<script type="text/javascript" src="js/jqPaginator.min.js"></script>
<script type="text/javascript" src="js/shopping/query.js"></script>



