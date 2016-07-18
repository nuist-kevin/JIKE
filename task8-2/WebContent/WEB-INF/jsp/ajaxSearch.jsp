<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/common/header.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-md-2 bootstrap-admin-col-left">
            <ul class="nav navbar-collapse collapse bootstrap-admin-navbar-side">
                <li class="active"><a href="ajaxShowSearch">异步版搜索</a></li>
                <li><a href="basicShowSearch">同步版搜索</a></li>
            </ul>
        </div>
        <div class="col-md-10">
            <div class="row">
                <div class="page-header">
                    <form class="form-inline" role="form">
                        <div class="form-group">
                            <select id="searchOption" name="seachOption" class="form-control">
                                <option value="1">作者</option>
                                <option value="2">诗名</option>
                                <option value="3">名句</option>
                            </select> <input size="30" type="text" id="searchValue" class="form-control"
                                             name="searchValue" placeholder="">
                        </div>
                        <button id="searchBtn" class="btn btn-success">搜索</button>
                    </form>
                </div>
            </div>

            <div class="row">
                <div class="panel panel-default">
                    <div class="bootstrap-admin-panel-content text-muted"
                         style="padding: 60px 0; text-align: center">
                        无匹配的搜索结果
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/jsp/common/footer.jsp" %>
<script src="js/main.js"></script>



