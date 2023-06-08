<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file='../inc/header.jsp' %>
	<div class="container">
		<h3 class="text-center">요청서 상세</h3>
		<hr/>
		<div class="form-group col-md-3" style="padding:10px 10px; float:none; margin:0 auto; color: inherit; background-color:#eee;">
		<div class="form-group r1">
		</div>
			<p class="text-center"><button class="btn btn-info text-center" id="nextbtn">다음</button></p>
		</div>
	</div>
	
	<script>
		$(function() {
			var content = "";
			var price = "";
			
			$.ajax({
				url : "ajax/estimate.txt" ,
				type : "get" ,
				dataType : "text" ,
				success : function(text) {
					$(".r1").html(text);
					$("#content").on("change", function() {
						content = $("#content").val();
					});
				} ,
				error : function(xhr, textStatus, errorThrown) {
					console.log(textStatus + "(http-" + xhr.status + " / " + errorThrown);
				}
			});
					
			$("#nextbtn").on("click", function() {
				if(price == "") {
					$.ajax({
						url : "ajax/estimate2.txt" ,
						type : "get" ,
						dataType : "text" ,
						success : function(text) {
							$(".r1").html(text);
							$("#price").on("change", function(){
								price = $("#price").val();
								console.log(price);
							});
						} ,
						error : function(xhr, textStatus, errorThrown) {
							console.log(textStatus + "(http-" + xhr.status + " / " + errorThrown);
						}
					});
				} else {
					$.ajax({
						url : "${pageContext.request.contextPath}/create.estimate" ,
						type : "get" ,
						data : { "content" : content , "price" : price , "request_id" : ${param.request_id}} ,
						success : function(msg) {
							alert(msg);
							location.href='${pageContext.request.contextPath}/list.estimate';
						} ,
						error : function(xhr, textStatus, errorThrown) {
							console.log(textStatus + "(http-" + xhr.status + " / " + errorThrown);
						}
					});
				}
			});
		})
	</script>
	
<%@ include file='../inc/footer.jsp' %>