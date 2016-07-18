<%@include file="/WEB-INF/jsp/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<div class="container">
    <div class="row">
        <div class="col-md-2 bootstrap-admin-col-left">
            <ul class="nav navbar-collapse collapse bootstrap-admin-navbar-side">
                <li><a href="ajaxShowSearch">异步版搜索</a></li>
                <li class="active"><a href="basicShowSearch">同步版搜索</a></li>
            </ul>
        </div>

        <div class="col-md-10">
            <div class="row">
                <div class="page-header">
                    <s:fielderror/>
                    <s:form cssClass="form-inline" action="basicDoSearch">
                        <div class="form-group" >
                            <s:select name="searchOption" list="#{'1':'作者', '2':'诗名', '3':'名句'}"
                                      cssClass="form-control"/>
                            <s:textfield name="searchValue" size="30"  cssClass="form-control"/>
                            <s:submit cssClass="btn btn-success" value="搜索"/>
                        </div>
                    </s:form>
                </div>
            </div>
            <div class="row">
                <div class="panel panel-default">
                    <div class="bootstrap-admin-panel-content text-muted"
                         style="padding: 60px 0; text-align: center; white-space:pre-line">
                        <s:if test="poetryList.size > 0">
                            <s:iterator value="poetryList">
                                    <<<s:property value="title"/>>>
                                    <s:if test="searchOption != 1">
                                        <s:property value="poet.name"/>
                                        <s:property value="content"/>
                                    </s:if>
                            </s:iterator>
                        </s:if>
                        <s:else>
                            无匹配的搜索结果
                        </s:else>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<%@include file="/WEB-INF/jsp/common/footer.jsp" %>
