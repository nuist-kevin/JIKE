<%@include file="/WEB-INF/jsp/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<div class="col-md-10">
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="text-muted bootstrap-admin-box-title">帮助</div>
                </div>
                <div class="bootstrap-admin-panel-content">
                    <ul>
                        <li>
                            系统管理模块入口仅开放给管理员用户，由管理员用户管理系统用户的增删改查，因此无用户注册页面;
                        </li>
                        <li>
                            用户权限分为三种，管理员、普通、无权限，无权限用户无法登录。
                        </li>
                        <li>
                            VIP信息模块，提供VIP的增删改查功能，支持列表中多条件查询，其中VIP编号为精确查询，姓名和成分为模糊查询，年龄和入会时间为区间查询
                        </li>
                        <li>
                            商品信息模块，仅提供添加和查询功能，不能修改和删除，支持列表中多条件查询，其中商品编号为精确查询，商品名称为模糊查询，价格和折扣为区间查询
                        </li>
                        <li>
                            购物信息模块，仅提供添加和查询功能，不能修改和删除，支持列表中多条件查询，其中VIP编号为精确查询，VIP姓名为模糊查询
                        </li>
                    </ul>
                    <s:debug/>
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
<%@include file="/WEB-INF/jsp/common/footer.jsp"%>
