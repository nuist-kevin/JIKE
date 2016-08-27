<%@include file="/WEB-INF/jsp/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<div class="col-md-10">
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="text-muted bootstrap-admin-box-title">编辑</div>
                </div>
                <div class="bootstrap-admin-panel-content">
                    <form class="form-horizontal"
                          <s:if test="goodsDto.goodsName!= null">action='goods/doEdit/${goods.id}'</s:if>
                          <s:else>action='goods/doAdd'</s:else>
                          method="post">
                        <div class="form-group">
                            <label class="col-sm-5 control-label">商品名称</label>
                            <div class="col-sm-4">
                                <input required name="goods.username" class="form-control" type="text"
                                       placeholder="只能输入数字和字母"
                                       <s:if test="goods != null">disabled
                                       value="${goods.goodsName}"</s:if>  />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-5 control-label">密码</label>
                            <div class="col-sm-4">
                                <input required class="form-control" type="text" name="user.password"
                                       value="${user.password}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-5 control-label">权限</label>
                            <label class="checkbox-inline ">
                                <input  type="radio" name="user.authority" value="1"
                                        <s:if test="user.authority.equals(1)">checked</s:if> />管理员
                            </label>
                            <label class="checkbox-inline">
                                <input type="radio" name="user.authority" value="2"
                                       <s:if test="user.authority.equals(2)">checked</s:if>/>普通
                            </label>
                            <label class="checkbox-inline">
                                <input type="radio" name="user.authority" value="0"
                                       <s:if test="user.authority.equals(0)">checked</s:if> />无权限
                            </label>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-5 col-sm-offset-5 col-sm-4 col-md-4">
                                <button class="btn  btn-primary" type="submit">提交</button>
                                <a class="btn  btn-primary"
                                   <s:if test="user == null">href="user/maintain"</s:if>
                                   <s:else>href="user/view/${user.username}"</s:else>
                                >取消</a>
                            </div>
                        </div>
                        <%--<s:debug/>--%>
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
<script type="text/javascript">
    $("input[type='text']").blur(function() {
        var reg = /^[A-Za-z0-9]+$/;
        if (!($(this).val()).match(reg)) {
            $(this).val('');
        }
    });
</script>
