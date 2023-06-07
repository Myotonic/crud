<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../inc/header.jsp"%>
<link rel="stylesheet" type="text/css" href="css/mycss.css">
<link rel="stylesheet" type="text/css" href="css/bBoard.css">
<div class="container panel">
	<h3 class="panel-heading">커뮤니티</h3>
	<div class="bBoardBody">
		<a href="#" class="bBoardlife">숨고생활</a> <a href="#"
			class="bBoardStory">고수의 이야기</a>
	</div>
	<hr />
	<form action="#" method="post" id="eProfileForm">
		<img src="#" alt="프로필 이미지" />
		<div class="eCount">
			<span>${eHit }</span> <span>${eReview }</span>
		</div>

		<hr />

		<div class="eProfile">
			<div class="eName">
				<span>이름</span> <input type="submit" value="수정" id="eName" />
				<p>${eName.name }</p>
			</div>

			<hr />

			<!-- 대표서비스 -->

			<div class="eIntro">
				<span>한줄소개</span> <input type="submit" value="수정" id="eIntro" />
			</div>

			<hr />

			<div class="eCity">
				<span>활동지역</span> <input type="submit" value="수정" id="eCity" />
			</div>

			<hr />

			<div class="eArea">
				<span>이동가능거리</span> <input type="submit" value="수정" id="eArea" />
			</div>
			
			<hr/>
			
			<div class="eEdu">
				<span>자격증 및 기타 서류등록</span> 
				<input type="file" value="자격증 및 기타 서류등록" id="eEdu"/>
			</div>

			<hr />
			
			<div class="eCategory">
				<span>서비스</span> 
				<select>
					<option value="">서비스 선택</option>
					<option value="Category1">1</option>
					<option value="Category2">2</option>
					<option value="Category3">3</option>
					<option value="Category4">4</option>
				</select>
			</div>
			<hr />
		</div>
	</form>
</div>

<script>
	
</script>

<%@include file="../inc/footer.jsp"%>