<%@include file="/WEB-INF/jsp/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<div class="col-md-10">
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="text-muted bootstrap-admin-box-title">详情</div>
                </div>
                <div class="bootstrap-admin-panel-content">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-5 control-label">姓名</label>
                            <div class="col-sm-6">
                                <p class="form-control-static"><s:property
                                        value="vip.name"/></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-5 control-label">年龄</label>
                            <div class="col-sm-6">
                                <p class="form-control-static">${vip.age}</p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-5 control-label">成分</label>
                            <div class="col-sm-6">
                                <p class="form-control-static">
                                    ${vip.profession}
                                </p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-5 control-label">入会时间</label>
                            <div class="col-sm-6">
                                <p class="form-control-static">
                                    <s:date name="vip.joinTime"
                                            format="yyyy-MM-dd"/>
                                </p>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-sm-offset-4 col-sm-4 col-md-4">
                                <a class="btn btn-primary"
                                   href="vip/edit/${vip.id}">编辑
                                </a>
                            </div>
                        </div>
                    </form>
                    <%--<s:debug/>--%>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/jsp/common/footer.jsp" %>
