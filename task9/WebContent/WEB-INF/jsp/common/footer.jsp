<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript"
        src="js/twitter-bootstrap-hover-dropdown.min.js"></script>
<script type="text/javascript" src="js/common/public.js"></script>
<script type="text/javascript">
    //菜单栏选中效果
    var menus = document.querySelectorAll(".bootstrap-admin-navbar-side > li > a");
    for (var i = 0, len = menus.length; i < len; i++) {
        var actionName = menus[i].getAttribute("href");
        var namespace = actionName.split('\/')[0]
        if (location.pathname.search(namespace) > 0) {
            menus[i].parentNode.classList.add("active");
        }
    }
</script>
</body>
</html>