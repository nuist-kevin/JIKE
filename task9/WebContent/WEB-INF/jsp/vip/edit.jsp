<%@include file="/WEB-INF/jsp/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<div class="col-md-10">
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="text-muted bootstrap-admin-box-title">
                        <s:if test="vip != null">
                            编辑
                        </s:if>
                        <s:else>
                            新增
                        </s:else>
                    </div>
                </div>
                <div class="bootstrap-admin-panel-content">
                    <form class="form-horizontal" method="post"
                            <s:if test="vip != null">
                                action='vip/doEdit/${vip.id}'
                            </s:if>
                            <s:else>
                                action='vip/doAdd'
                            </s:else>>
                        <div class="form-group">
                            <label class="col-sm-5 control-label">姓名</label>
                            <div class="col-sm-4">
                                <input name="vip.name" class="form-control"
                                       type="text"
                                       value="<s:property value="vip.name"/>"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-5 control-label">年龄</label>
                            <div class="col-sm-4">
                                <input class="form-control" type="text"
                                       name="vip.age"
                                       value="<s:property value="vip.age"/>"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-5 control-label">成分</label>
                            <div class="col-sm-4">
                                <input class="form-control" type="text"
                                       name="vip.profession"
                                       value="<s:property value="vip.profession"/>"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-5 control-label">入会时间</label>

                            <div class="col-sm-4">
                                <input type="text"
                                       class="form-control datetimepicker"
                                       id="datepicker" name="vip.joinTime"
                                       value="<s:date name="vip.joinTime" format="yyyy-MM-dd"/>">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-5 col-sm-offset-5 col-sm-4 col-md-4">
                                <button class="btn  btn-primary" type="submit">
                                    提交
                                </button>
                                <a class="btn  btn-primary"
                                        <s:if test="vip == null">
                                            href="vip/list"
                                        </s:if>
                                        <s:else>
                                            href="vip/view/${vip.id}"
                                        </s:else>
                                >取消
                                </a>
                            </div>
                        </div>
                        <s:debug/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<%@include file="/WEB-INF/jsp/common/footer.jsp" %>
