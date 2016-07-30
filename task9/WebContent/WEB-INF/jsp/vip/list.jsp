<%@include file="/WEB-INF/jsp/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<div class="col-md-10">
    <div class="row">
        <div class="col-lg-12">
            <div class="page-header">
                <form id="queryOptionForm" class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label col-md-2 col-lg-2">VIP编号：</label>
                        <div class="col-md-4 col-lg-4">
                            <input type="number" class="form-control" min="1" step="1"
                                   name="id"
                                   placeholder="VIP编号"/>
                        </div>
                        <label class="control-label col-md-2 col-lg-2 text-left">姓名：</label>
                        <div class="col-md-4 col-lg-4">
                            <input type="text" class="form-control"
                                   name="name"
                                   placeholder="VIP姓名">
                        </div>
                        </div>
                        <div class="form-group">
                        <label class="control-label col-md-2 col-lg-2 text-left">成分：</label>
                        <div class="col-md-4 col-lg-4">
                            <input type="text" class="form-control"
                                   name="profession"
                                   placeholder="VIP成分">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-2 col-lg-2">年龄：</label>
                        <div class="col-md-2 col-lg-2">
                            <input type="number" class="form-control" name="fromAge" min="1" step="1" max="150"
                                   placeholder="年龄下限">
                        </div>
                        <p class="form-control-static col-md-1 col-lg-1 text-center">至</p>
                        <div class="col-md-2 col-lg-2">
                            <input type="number" class="form-control" name="toAge" min="1" step="1" max="150"
                                   placeholder="年龄上限">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-2 col-lg-2">入会时间：</label>
                        <div class="col-md-2 col-lg-2">
                            <input type="text" class="form-control datetimepicker" name="fromDate" placeholder=" 日期下限">
                        </div>
                        <p class="form-control-static col-md-1 text-center">至</p>
                        <div class="col-md-2 col-lg-2">
                            <input type="text" class="form-control datetimepicker" name="toDate" placeholder=" 日期上限">
                        </div>
                        <div class="col-md-offset-11 col-lg-offset-11">
                            <a id="queryBtn" class="btn btn-info btn-sm">查询</a>
                        </div>
                    </div>
                </form>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="text-muted bootstrap-admin-box-title">VIP列表
                    </div>
                    <a href="vip/add" class="right">添加VIP</a>
                </div>
                <div class="bootstrap-admin-panel-content">
                    <table class="table bootstrap-admin-table-with-actions table-hover listTable">
                        <thead>
                        <tr>
                            <th>VIP编号</th>
                            <th>姓名</th>
                            <th>年龄</th>
                            <th>成分</th>
                            <th>入会时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                    <%--分页按钮： 通过插件实现，详见页尾jqeury代码--%>
                    <div class="col-lg-offset-4 col-md-offset-4 pagingDiv">
                        <ul class="pagination pagination-sm ">
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<s:debug/>
</div>
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
<script type="text/javascript" src="js/vip/query.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript">
    $('.datetimepicker').datetimepicker({
        language: 'zh-CN',
        format: 'yyyy-mm-dd',//选择完日期后，input框里的时间值的格式
//            startDate: new Date(),//开始日期时间，在此之前的都不可选，同理也有endDate
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1,
        minView: 2,
    });
</script>
