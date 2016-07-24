<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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

<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript"
        src="js/twitter-bootstrap-hover-dropdown.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="js/jquery.paging.min.js"></script>
<%--<script src="js/jquery.easy-paging.js"></script>--%>
<script src="js/vip/vip.js"></script>


<script type="text/javascript">

    var menus = document.querySelectorAll(".bootstrap-admin-navbar-side > li > a");
    for (var i = 0, len = menus.length; i < len; i++) {
        var actionName = menus[i].getAttribute("href");
        var namespace = actionName.split('\/')[0]
        if (location.pathname.search(namespace) > 0) {
            menus[i].parentNode.classList.add("active");
        }
    }


</script>
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
//            maxViewMode: 0
        });
</script>
</body>
</html>