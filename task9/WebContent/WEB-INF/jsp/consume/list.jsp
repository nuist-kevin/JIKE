<%@include file="/WEB-INF/jsp/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<div class="col-md-10">
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="text-muted bootstrap-admin-box-title">消费列表</div>
                    <a href="consume/add" class="right">购物登记</a>
                </div>
                <div class="bootstrap-admin-panel-content">
                    <table
                            class="table bootstrap-admin-table-with-actions table-hover">
                        <thead>
                        <tr>
                            <th>消费编号</th>
                            <th>VIP编号</th>
                            <th>姓名</th>
                            <th>商品名称</th>
                            <th>商品价格</th>
                            <th>实收金额</th>
                        <%--<th class="text-center">操作</th>--%>
                        </tr>
                        </thead>
                        <tbody>
                        <s:iterator value="consumes">
                            <tr>
                                <td class="col-lg-1 col-md-1">
                                    <s:property value="id"/>
                                </td>
                                <td class="col-lg-1 col-md-1">
                                    <s:property value="vip.id"/>
                                </td>
                                <td class="col-lg-1 col-md-1">
                                    <s:property value="vip.name"/>
                                </td>
                                <td class="col-lg-2 col-md-2">
                                    <s:property value="commodity.name"/>
                                </td>
                                <td class="col-lg-2 col-md-2">
                                    <s:property value="commodity.price"/>
                                </td>
                                <td class="col-lg-2 col-md-2">
                                    <s:property value="practicePrice"/>
                                </td>

                                    <%--<td class="actions col-lg-2 col-md-2 ">--%>
                                    <%--<a href="user/view/<s:property value="username"/>"--%>
                                    <%--class="btn btn-sm btn-info ">--%>
                                    <%--<i class="glyphicon glyphicon-eye-open"></i>--%>
                                    <%--</a>--%>
                                    <%--<a href="user/edit/<s:property value="username"/>"--%>
                                    <%--class="btn btn-sm btn-primary">--%>
                                    <%--<i class="glyphicon glyphicon-pencil"></i>--%>
                                    <%--</a>--%>
                                    <%--<a href="user/delete/<s:property value="username"/>"--%>
                                    <%--class="btn btn-sm btn-danger">--%>
                                    <%--<i class="glyphicon glyphicon-trash"></i>--%>
                                    <%--</a>--%>
                                    <%--</td>--%>
                            </tr>
                        </s:iterator>
                        </tbody>
                    </table>
                    <%--分页按钮--%>
                    <%--<s:if test="pageNum > 1">--%>
                    <%--<div class="col-sm-4 col-sm-offset-4 col-md-4 col-md-offset-4">--%>
                    <%--<div class="pagination-container">--%>
                    <%--<ul class="pagination pagination-sm">--%>
                    <%--<s:iterator value="indexList" status="st">--%>
                    <%--<s:set var="aii" value="#st.index+1"/>--%>
                    <%--<li <s:if--%>
                    <%--test="#aii == page"> class="active"</s:if> >--%>
                    <%--<a href="commodity/list/<s:property/>"><s:property/></a>--%>
                    <%--</li>--%>
                    <%--</s:iterator>--%>
                    <%--</ul>--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</s:if>--%>
                </div>
            </div>
        </div>
    </div>
</div>
<s:debug/>

<%@include file="/WEB-INF/jsp/common/footer.jsp" %>
