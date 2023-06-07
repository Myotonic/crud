<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../inc/header.jsp"%>
<link rel="stylesheet" type="text/css" href="css/mycss.css">
<link rel="stylesheet" type="text/css" href="css/bBoard.css">
<div class="container panel">
	<h3 class="panel-heading">커뮤니티</h3>
	<div class="bBoardBody">
		<a href="#" class="bBoardlife">숨고생활</a>
		<a href="#" class="bBoardStory">고수의 이야기</a>
	</div>
	<hr/>
	<div class="submit-group">
		<a href="../Project/Community/bDetail.jsp" class="btn btn-info">글쓰기</a>
	</div>

	<div class="category_group">
		<label for="board_category1"></label> <a href="bBoardList.jsp"
			class="btn btn-info" id="board_category1">전체</a> <label
			for="board_category2"></label> <a href="#" class="btn btn-info"
			id="board_category2">자유게시판</a> <label for="board_category3"></label>
		<a href="#" class="btn btn-info" id="board_category3">고수광장</a> <label
			for="board_category4"></label> <a href="#" class="btn btn-info"
			id="board_category4">고수찾아요</a> <label for="board_category5"></label>
		<a href="#" class="btn btn-info" id="board_category5">고수 소식</a>

		<div class="bContent">
			<select id="bService">
				<option value="1">서비스</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
			</select> <select id="bArea">
				<option value="1">지역</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
			</select>

			<form action="#" method="get" id="bBoardContent">
				<div class="bBoardHitList">
					<label for="bBoardHit1"></label>
					<a href="#" id="bBoardHit1">${bBoardHitList1}#####</a> 
					<label for="bBoardHit2"></label>
					<a href="#"id="bBoardHit2">${bBoardHitList2}#####</a> 
					<label for="bBoardHit3"></label>
					<a href="#"id="bBoardHit3">${bBoardHitList3}#####</a>
				</div>
			</form>

		</div>
	</div>
</div>
<%@include file="../inc/footer.jsp"%>