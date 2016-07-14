<%@include file="/WEB-INF/jsp/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<div class="container">
	<div class="row">
		<div class="col-md-2 bootstrap-admin-col-left">
			<ul class="nav navbar-collapse collapse bootstrap-admin-navbar-side">
				<li class="active"><a href="user/list">用户管理</a></li>
			</ul>
		</div>

		<div class="col-md-10">
			<div class="row">
				<div class="col-lg-12">
					<div class="page-header">
						<s:fielderror />
						<s:form cssClass="form-inline" action="basicDoSearch">
							<div class="form-group">
								<s:select name="searchOption"
									list="#{'1':'登录名', '2':'真名', '3':'电话', '4':'地址'}"
									cssClass="form-control" />
								<s:textfield name="searchValue" size="30"
									cssClass="form-control" />
								<s:submit cssClass="btn btn-success" value="搜索" />
							</div>
						</s:form>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="text-muted bootstrap-admin-box-title">用户列表</div>
						</div>
						<div class="bootstrap-admin-panel-content">
							<form class="form-horizontal">
								<div class="form-group">
									<label  class="col-sm-4 control-label">用户名</label>
									<div class="col-sm-6">
										<p class="form-control-static">${user.username}</p>
									</div>
								</div>
								<div class="form-group">
									<label  class="col-sm-4 control-label">密码</label>
									<div class="col-sm-6">
										<p class="form-control-static">${user.password}</p>
									</div>
								</div>
								<div class="form-group">
									<label  class="col-sm-4 control-label">真名</label>
									<div class="col-sm-6">
										<p class="form-control-static">${user.realName}</p>
									</div>
								</div>
								<div class="form-group">
									<label  class="col-sm-4 control-label">年龄</label>
									<div class="col-sm-6">
										<p class="form-control-static">${user.age}</p>
									</div>
								</div>
								<div class="form-group">
									<label  class="col-sm-4 control-label">电话</label>
									<div class="col-sm-6">
										<p class="form-control-static">${user.phoneNum}</p>
									</div>
								</div>
								<div class="form-group">
									<label  class="col-sm-4 control-label">地址</label>
									<div class="col-sm-6">
										<p class="form-control-static">${user.address}</p>
									</div>
								</div>
							</form>
							<%--<div class="form-group">--%>
								<%--<label class="control-label">用户名</label>--%>
								<%--<input class="form-control" type="text" name="user.username" placeholder="请输入用户名">--%>
							<%--</div>--%>
							<%--<div class="form-group">--%>
								<%--<label class="control-label">密码</label>--%>
								<%--<input  class="form-control"  type="password" name="user.password" placeholder="请输入密码">--%>
							<%--</div>--%>
							<%--<div class="form-group">--%>
								<%--<label class="control-label">真名</label>--%>
								<%--<input  class="form-control"  type="text" name="user.realName" placeholder="请输入年龄">--%>
							<%--</div>--%>
							<%--<div class="form-group">--%>
								<%--<label class="control-label">年龄</label>--%>
								<%--<input  class="form-control"  type="text" name="user.age" placeholder="请输入年龄">--%>
							<%--</div>--%>
							<%--<div class="form-group">--%>
								<%--<label class="control-label">电话</label>--%>
								<%--<input  class="form-control"  type="text" name="user.phoneNum" placeholder="请输入电话">--%>
							<%--</div>--%>
							<%--<div class="form-group">--%>
								<%--<label class="control-label">地址</label>--%>
								<%--<input  class="form-control"  type="text" name="user.address" placeholder="请输入地址">--%>
							<%--</div>--%>


						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>
<%@include file="/WEB-INF/jsp/common/footer.jsp"%>
