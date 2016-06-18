$(function() {
	$("#searchBtn").click(
			function(event) {
				event.preventDefault();
				$.post("/task4-1/PoetrySearch", {
					searchOption : $("#searchOption").val(),
					searchValue : $("#searchValue").val()
				}, function(data) {
					$(".bootstrap-admin-panel-content").text("");
					if($("#searchOption").val() == '1'){
						for (var i = 0; i < data.titleList.length; i++) {
							$(".bootstrap-admin-panel-content").append(
								"<<" + data.titleList[i] + ">>" + "<br>");
						}
					} else {
						var poets = data.poetList;
						for (var i = 0; i < poets.length; i++) {
							$(".bootstrap-admin-panel-content").append(poets[i].title + "<br>" + poets[i].poet.name + "<br>");
							var poet = poets[i].content.split("。");
							for(var index = 0; index < poet.length; index++) {
								$(".bootstrap-admin-panel-content").append(
										poet[index]+ "<br>");
							}
						}
									
					}
					
				}, "json");
			});
});