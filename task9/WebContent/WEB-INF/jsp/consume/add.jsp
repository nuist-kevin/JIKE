<%@include file="/WEB-INF/jsp/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<div class="col-md-10">
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="text-muted bootstrap-admin-box-title">添加</div>
                </div>
                <div class="bootstrap-admin-panel-content">
                    <form class="form-horizontal" action='consume/doAdd' method="post">
                        <div class="form-group">
                            <label class="col-sm-4 control-label">VIP编号</label>
                            <div class="col-sm-4">
                                <input required name="consume.vip.vipId" class="form-control" type="text"
                                       readonly="readonly"/>
                            </div>
                            <div class="col-sm-3">
                                <a href="#vipModal" id='vipList' class="btn btn-primary btn-sm" data-toggle="modal">选择VIP</a>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">姓名</label>
                            <div class="col-sm-4">
                                <input required name="consume.vip.name" class="form-control" type="text"
                                       readonly="readonly"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">商品编号</label>
                            <div class="col-sm-4">
                                <input class="form-control" type="text" name="consume.commodity.commodityId"
                                       readonly="readonly"/>
                            </div>
                            <div class="col-sm-3">
                                <a href="#commodityModal" class="btn btn-primary btn-sm" data-toggle="modal">选择商品</a>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">商品名称</label>
                            <div class="col-sm-4">
                                <input required class="form-control" type="text" name="consume.commodity.commodityName"
                                       readonly="readonly"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">商品价格</label>
                            <div class="col-sm-8">
                                <div class="input-group col-sm-6">
                                    <input required class="form-control" type="text" name="consume.commodity.price"
                                           readonly="readonly"/>
                                    <span class="input-group-addon">元</span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">实收金额</label>
                            <div class="col-sm-8">
                                <div class="input-group col-sm-6">
                                    <input required class="form-control" type="number" step="0.01"
                                           name="consume.practicePrice" required/>
                                    <span class="input-group-addon">元</span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-5 col-sm-offset-5 col-sm-4 col-md-4">
                                <button class="btn  btn-primary" type="submit">提交</button>
                                <a class="btn  btn-primary" href="consume/list">取消</a>
                            </div>
                        </div>
                        <%--<s:debug/>--%>
                    </form>
                    <div id="vipModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="vipModalTitle"
                         aria-hidden="true" style="display: none;">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
                                    </button>
                                    <h4 id="vipModalTitle" class="modal-title">VIP列表</h4>
                                </div>
                                <div class="modal-body">
                                    <from id="vipQueryForm" class="form-horizontal">
                                        <div class="form-group">
                                            <label class="control-label col-md-2 col-lg-2 small">VIP编号：</label>
                                            <div class="col-md-4 col-lg-4">
                                                <input type="number" class="form-control input-sm" min="1" step="1"
                                                       name="id"
                                                       placeholder="VIP编号"/>
                                            </div>
                                            <label class="control-label col-md-2 col-lg-2 small">姓名：</label>
                                            <div class="col-md-4 col-lg-4">
                                                <input type="text" class="form-control input-sm"
                                                       name="name"
                                                       placeholder="VIP姓名">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-2 col-lg-2 small">成分：</label>
                                            <div class="col-md-4 col-lg-4">
                                                <input type="text" class="form-control input-sm"
                                                       name="profession"
                                                       placeholder="VIP成分">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-2 col-lg-2 small">年龄：</label>
                                            <div class="col-md-3 col-lg-3">
                                                <input type="number" class="form-control input-sm" name="fromAge"
                                                       min="1" step="1" max="150"
                                                       placeholder="年龄下限">
                                            </div>
                                            <p class="form-control-static col-md-1 col-lg-1 text-center small">至</p>
                                            <div class="col-md-3 col-lg-3">
                                                <input type="number" class="form-control input-sm" name="toAge" min="1"
                                                       step="1" max="150"
                                                       placeholder="年龄上限">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-2 col-lg-2 small">入会时间：</label>
                                            <div class="col-md-3 col-lg-3">
                                                <input type="text" class="form-control datetimepicker input-sm"
                                                       name="fromDate" placeholder=" 日期下限">
                                            </div>
                                            <p class="form-control-static col-md-1 text-center small">至</p>
                                            <div class="col-md-3 col-lg-3">
                                                <input type="text" class="form-control datetimepicker input-sm"
                                                       name="toDate" placeholder=" 日期上限">
                                            </div>
                                            <div class="col-md-3 col-lg-3">
                                                <a id="vipSearch" class="btn btn-info btn-sm right">搜索</a>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                        </div>
                                    </from>
                                    <table id="vipTable"
                                           class="table bootstrap-admin-table-with-actions table-hover table-bordered listTable">
                                        <thead>
                                        <tr>
                                            <th class='col-lg-1 col-md-1'>选择</th>
                                            <th class='col-lg-1 col-md-1'>编号</th>
                                            <th class='col-lg-2 col-md-2'>姓名</th>
                                            <th class='col-lg-1 col-md-1'>年龄</th>
                                            <th class='col-lg-3 col-md-3'>成分</th>
                                            <th class='col-lg-2 col-md-2'>入会时间</th>
                                        </tr>
                                        </thead>
                                        <tbody>

                                        </tbody>
                                    </table>
                                    <div class="pagingDiv col-sm-offset-3">
                                        <ul class="pagination pagination-sm "></ul>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button id="vipComfirmBtn" type="button" class="btn btn-default btn-sm btn-"
                                            data-dismiss="modal"
                                            aria-hidden="true">确定
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="commodityModal" class="modal fade" tabindex="-1" role="dialog"
                         aria-labelledby="commodityModalTitle"
                         aria-hidden="true" style="display: none;">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
                                    </button>
                                    <h4 id="commodityModalTitle" class="modal-title">商品列表</h4>
                                </div>
                                <div class="modal-body">
                                    <from id="commodityQueryForm" class="form-horizontal">
                                        <div class="form-group">
                                            <label class="control-label col-md-2 col-lg-2 small">商品编号：</label>
                                            <div class="col-md-4 col-lg-4">
                                                <input type="number" class="form-control input-sm" min="1" step="1"
                                                       name="id"
                                                       placeholder="商品编号"/>
                                            </div>
                                            <label class="control-label col-md-2 col-lg-2 small">商品名称：</label>
                                            <div class="col-md-4 col-lg-4">
                                                <input type="text" class="form-control input-sm"
                                                       name="name"
                                                       placeholder="商品名称">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-2 col-lg-2 small">商品价格：</label>
                                            <div class="col-md-3 col-lg-3">
                                                <input type="number" class="form-control input-sm" name="lowPrice"
                                                       min="1" step="1" max="150"
                                                       placeholder="价格下限">
                                            </div>
                                            <p class="form-control-static col-md-1 col-lg-1 text-center small">至</p>
                                            <div class="col-md-3 col-lg-3">
                                                <input type="number" class="form-control input-sm" name="upPrice"
                                                       min="1" step="1" max="150"
                                                       placeholder="价格上限">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-2 col-lg-2 small">商品折扣：</label>
                                            <div class="col-md-3 col-lg-3">
                                                <input type="text" class="form-control input-sm" name="lowAgio"
                                                       placeholder=" 折扣下限">
                                            </div>
                                            <p class="form-control-static col-md-1 text-center small">至</p>
                                            <div class="col-md-3 col-lg-3">
                                                <input type="text" class="form-control input-sm" name="upAgio"
                                                       placeholder=" 折扣上限">
                                            </div>
                                            <div class="col-md-3 col-lg-3">
                                                <a id="commoditySearch" class="btn btn-info btn-sm right">搜索</a>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                        </div>
                                    </from>

                                    <table id="commodityTable"
                                           class="table bootstrap-admin-table-with-actions table-hover table-bordered listTable">
                                        <thead>
                                        <tr>
                                            <th class='col-lg-1 col-md-1'></th>
                                            <th>编号</th>
                                            <th>商品名称</th>
                                            <th>商品价格</th>
                                            <th>商品折扣</th>
                                        </tr>
                                        </thead>
                                        <tbody>

                                        </tbody>
                                    </table>
                                    <div class="pagingDiv col-sm-offset-3">
                                        <ul class="pagination pagination-sm "></ul>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button id="commodityComfirmBtn" type="button" class="btn btn-primary"
                                            data-dismiss="modal"
                                            aria-hidden="true">确定
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
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
<script type="text/javascript" src="js/icheck.min.js"></script>
<script type="text/javascript" src="js/consume/vipQuery.js"></script>
<script type="text/javascript" src="js/consume/commodityQuery.js"></script>

