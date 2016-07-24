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
                            <label class="col-sm-5 control-label">VIP编号</label>
                            <div class="col-sm-4">
                                <input name="consume.vip.vipId" class="form-control" type="text" disabled/>
                            </div>
                            <div class="col-sm-3">
                                <a href="#vipList" class="btn btn-primary btn-sm" data-toggle="modal">选择VIP</a>
                            </div>
                        </div>
                        <div id="vipList" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="vipListTitle"
                             aria-hidden="true" style="display: none;">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
                                        </button>
                                        <h4 id="vipListTitle" class="modal-title">VIP列表</h4>
                                    </div>
                                    <div class="modal-body">
                                        <table class="table bootstrap-admin-table-with-actions table-hover">
                                            <thead>
                                            <tr>
                                                <th></th>
                                                <th>VIP编号</th>
                                                <th>姓名</th>
                                                <th>年龄</th>
                                                <th>成分</th>
                                                <th>入会时间</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <s:iterator value="vips">
                                                <tr>
                                                    <td class="col-lg-1 col-md-1">
                                                        <input type="radio" />
                                                    </td>
                                                    <td class="col-lg-1 col-md-1">
                                                        <s:property value="id"/>a</td>
                                                    <td class="col-lg-2 col-md-2">
                                                        <s:property value="name"/>b</td>
                                                    <td class="col-lg-2 col-md-2">
                                                        <s:property value="age"/>c</td>
                                                    <td class="col-lg-2 col-md-2">
                                                        <s:property value="profession"/>d
                                                    </td>
                                                    <td class="col-lg-2 col-md-2">
                                                        <s:date format="yyyy-MM-dd" name="joinTime"/>e
                                                    </td>
                                                </tr>
                                            </s:iterator>
                                            </tbody>
                                        </table>
                                        <div class="col-lg-offset-2 col-md-offset-2">
                                            <ul id="vipPaging" class="pagination pagination-sm">
                                                <li>Prev</li>
                                                <li>#n</li>
                                                <li>#n</li>
                                                <li>#c</li>
                                                <li>#n</li>
                                                <li>#n</li>
                                                <li>Next</li>
                                            </ul>
                                        </div>
                                        <span id="output"/>
                                    </div>
                                    <div class="modal-footer">

                                        <button type="button" class="btn btn-primary" data-dismiss="modal"
                                                aria-hidden="true">确定
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-5 control-label">姓名</label>
                            <div class="col-sm-4">
                                <input name="consume.vip.name" class="form-control" type="text" disabled/>
                            </div>

                        </div>
                        <div class="form-group">
                            <label class="col-sm-5 control-label">商品编号</label>
                            <div class="col-sm-4">
                                <input class="form-control" type="text" name="consume.commodity.commodityId" disabled/>
                            </div>
                            <div class="col-sm-3">
                                <a href="#commodityList" class="btn btn-primary btn-sm" data-toggle="modal">选择商品</a>
                            </div>
                        </div>
                        <div id="commodityList" class="modal fade" tabindex="-1" role="dialog"
                             aria-labelledby="commodityListTitle"
                             aria-hidden="true" style="display: none;">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
                                        </button>
                                        <h4 id="commodityListTitle" class="modal-title">商品列表</h4>
                                    </div>
                                    <div class="modal-body">

                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-primary" data-dismiss="modal"
                                                aria-hidden="true">确定
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-5 control-label">商品名称</label>
                            <div class="col-sm-4">
                                <input class="form-control" type="text" name="consume.commodity.commodityName"
                                       disabled/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-5 control-label">商品价格</label>
                            <div class="col-sm-4">
                                <input class="form-control" type="text" name="consume.commodity.price" disabled/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-5 control-label">实收金额</label>
                            <div class="col-sm-4">
                                <input class="form-control" type="number" max="9.999" min="0.001"
                                       name="consume.practicePrice"/>
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
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/jsp/common/footer.jsp" %>
