<%@include file="/WEB-INF/jsp/common/header.jsp" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
                            <label class="col-sm-5 control-label">商品名称</label>
                            <div class="col-sm-4">
                                <p  class="form-control-static"/><s:property value="goodsDto.goodsName"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-5 control-label">商品价格</label>
                            <div class="col-sm-4">
                                <p class="form-control-static"/><s:property value="goodsDto.price"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-5 control-label">商品目录</label>
                            <div class="col-sm-4">
                                <p class="form-control-static"/><s:property value="goodsDto.categoryName"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-5 control-label">商品图片</label>
                            <div class="col-sm-3">
                                <img src="<s:property value="goodsDto.imgUrl"/>" height="200" width="200">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-5 control-label">商品描述</label>
                            <div class="col-sm-4">
                                <p class="form-control-static"/><s:property value="goodsDto.description"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-5 col-sm-offset-5 col-sm-4 col-md-4">
                                <a href="goods/edit/<s:property value="goodsDto.id"/>" class="btn  btn-primary">编辑</a>
                                <a href="goods/list" class="btn  btn-primary">返回</a>
                            </div>
                        </div>
                        <s:debug/>
                    </form>
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