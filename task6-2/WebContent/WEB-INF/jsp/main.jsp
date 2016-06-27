<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="common/header.jsp"%>
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
<%@include file="common/footer.jsp"%>


