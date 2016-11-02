<%@include file="/WEB-INF/jsp/common/header.jsp" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<div class="col-md-10">
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="text-muted bootstrap-admin-box-title">编辑</div>
                </div>
                <div class="bootstrap-admin-panel-content">
                    <s:form cssClass="form-horizontal"
                          action='goods/doAdd'
                          method="post">
                        <div class="form-group">
                            <label class="col-sm-4 control-label">商品名称</label>
                            <div class="col-sm-4">
                                <input required name="goodsDto.goodsName" class="form-control" type="text"
                                       placeholder="只能输入数字和字母"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">商品价格</label>
                            <div class="col-sm-4">
                                <input required class="form-control" type="text" name="goodsDto.price"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">商品目录</label>
                            <div class="col-sm-4">
                                <s:select cssClass="form-control" name="goodsDto.categoryId" list="categoryList"
                                          listKey="id" listValue="categoryName">
                                </s:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">商品图片</label>
                            <div class="col-sm-4">
                                <s:file id="file" name="goodsPic" accept="image/*"/>
                            </div>
                            <div class="col-sm-4">
                            <a id = "uploadBtn" class="btn btn-sm btn-info">上传</a>
                            </div>

                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label"></label>
                            <div class="col-sm-4">
                                <img src="" height="200" width="200">
                                <input type="hidden" name="goodsDto.imgUrl" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">商品描述</label>
                            <div class="col-sm-4">
                                <textarea rows="5" required class="form-control" name="goodsDto.description"
                                ></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-5 col-sm-offset-5 col-sm-4 col-md-4">
                                <button class="btn  btn-primary" type="submit">提交</button>
                            </div>
                        </div>
                        <s:debug/>
                    </s:form>
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
<script type="text/javascript" src="js/goods/ajaxfileupload.js"></script>

<script type="text/javascript">
    $("input[type='text']").blur(function () {
        var reg = /^[A-Za-z0-9]+$/;
        if (!($(this).val()).match(reg)) {
            $(this).val('');
        }
    });

    $("#uploadBtn").on("click", function() {
        $.ajaxFileUpload({
            url: 'upload',
            fileElementId: 'file',
            dataType: 'json',
            success: function(data, status) {
                $("img").attr("src", data.url);
                $("input[name='goodsDto.imgUrl']").val(data.url);
            }
        })
    });
</script>