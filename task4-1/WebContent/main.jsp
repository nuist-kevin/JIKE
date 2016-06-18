<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/header.jsp"%>
<%@page import="java.util.List"%>

<div class="container">
	<!-- left, vertical navbar & content -->
	<div class="row">
		<!-- content -->
		<div class="col-md-12">
			<div class="row">
				<div class="col-lg-6">
					<div class="page-header">
						<form class="form-inline" role="form">
							<div class="form-group">
								<select id="searchOption" name="seachOption" class="form-control">
									<option value="1">作者</option>
									<option value="2">诗名</option>
									<option value="3">名句</option>
								</select> <input size="30" type="text" id="searchValue" required class="form-control"
									name="searchValue" placeholder="">
							</div>
							<button id="searchBtn" class="btn btn-success">搜索</button>
						</form>
					</div>

				</div>

			</div>

			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">

						<div class="bootstrap-admin-panel-content text-muted"
							style="padding: 60px 0; text-align: center">
							请根据选项进行搜索
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- footer -->
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

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-3.0.0.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/twitter-bootstrap-hover-dropdown.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/bootstrap-admin-theme-change-size.js"></script>
	<script src="<%=request.getContextPath()%>/js/main.js"></script>
</body>
</html>
