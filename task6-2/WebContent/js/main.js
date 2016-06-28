$(function () {
    $("#searchBtn").click(
        function (event) {
            event.preventDefault();
            var url = "ajaxDoSearch";
            $.post(url, {
                searchOption: $("#searchOption").val(),
                searchValue: $("#searchValue").val()
            }, function (data) {
                var poets = data.poetryList;
                if (poets.length > 0) {
                    $(".bootstrap-admin-panel-content").text("");
                    if ($("#searchOption").val() == '1') {
                        for (var i = 0; i < poets.length; i++) {
                            $(".bootstrap-admin-panel-content").append(
                                "<<" + poets[i].title + ">>" + "<br>");
                        }
                    } else {
                        for (var i = 0; i < poets.length; i++) {
                            $(".bootstrap-admin-panel-content").append(
                                poets[i].title + "<br>"
                                + poets[i].poet.name + "<br>");
                            var poet = poets[i].content.split("。");
                            for (var index = 0; index < poet.length; index++) {
                                $(".bootstrap-admin-panel-content").append(
                                    poet[index] + "<br>");
                            }
                        }

                    }
                }

            }, "json");
        });
});