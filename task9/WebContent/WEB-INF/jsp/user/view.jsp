<%@include file="/WEB-INF/jsp/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<div class="container">
	<div class="row">
		<div class="col-md-2 bootstrap-admin-col-left">
			<ul class="nav navbar-collapse collapse bootstrap-admin-navbar-side">
				<li><a href="user/maintain">用户管理</a></li>
			</ul>
		</div>
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
									<label  class="col-sm-4 control-label">用户名</label>
									<div class="col-sm-6">
										<s:set var="thisuser" value="user"/>
										<p class="form-control-static"><s:property value="user.username"/> </p>
									</div>
								</div>
								<div class="form-group">
									<label  class="col-sm-4 control-label">密码</label>
									<div class="col-sm-6">
										<p class="form-control-static">${user.password}</p>
									</div>
								</div>
								<div class="form-group">
									<label  class="col-sm-4 control-label">权限</label>
									<div class="col-sm-6">
										<p class="form-control-static">
										<s:if test="user.authority == 0">无权限</s:if>
                                            <s:elseif test="user.authority == 1">管理员</s:elseif>
                                            <s:else>普通</s:else>
										</p>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-offset-4 col-sm-offset-4 col-sm-4 col-md-4">
										<a class="btn btn-primary" href="user/edit/${user.username}">编辑</a>
									</div>
								</div>
							</form>
							<s:debug/>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>
<%@include file="/WEB-INF/jsp/common/footer.jsp"%>
