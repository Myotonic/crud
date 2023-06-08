<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file='../inc/header.jsp' %>

	<div class="container">
		<h3 class="">견적서 상세</h3>
		<div class="form-group" style="padding:10px 10px; margin: 10px; color: inherit; background-color:#eee;" >
		<h4>${estimateDetailDto.user_name}</h4>
		<p>리뷰 수 : ${estimateDetailDto.review}   |    지역 : ${estimateDetailDto.city_name}   |    경력 : ${estimateDetailDto.career_entry}</p>
		<br>
		<h4>견적 내용</h4>
		<p>${estimateDetailDto.content}</p>
		<h4>예상금액</h4>
		<p>${estimateDetailDto.price} 원</p>
		<button class="btn btn-info" id="btbtn" style="color:white;">채택하기</button>
		</div>
		<input type="hidden" id="yun" />
		<script>
		
		$("#btbtn").on("click", function() {
			var yun = prompt("고수와 연락가능한 연락처를 적어주세요!");

			var url = '${pageContext.request.contextPath}/EmailSendRequest?estimate_id=${estimate_id}&request_id=${request_id}&yun=' + yun;
			console.log(url);
			
			location.href = url;
			
		});
		
		</script>
		
	</div>
<%@ include file='../inc/footer.jsp' %>