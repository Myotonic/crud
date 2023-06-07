<%@page import="com.company.dto.bWriterDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../inc/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" type="text/css" href="css/mycss.css">
<link rel="stylesheet" type="text/css" href="css/bBoard.css">
<div class="container panel panel-info">
	<h3 class="panel-heading"></h3>

<form action="${pageContext.request.contextPath }/bWriter.crud" id="bBWr">
   <input type = "submit" class="btn btn-info" id="bBWriteBtn" value="글쓰기"/>
      <select id="mySelect" name="bBreak_point">
      <option value="1">1</option>

      <option value="2">2</option>
   </select>

		<div class="select-group">
			<select id="bService" name="bCate">
				<option value="bService">서비스 선택</option>
				<c:forEach var="item" items="${bList.cate1}" varStatus="status">
					<option value="${item.category1_name}">${item.category1_name}</option>
				</c:forEach>
			</select> 
			<select id="bArea" name="bArea">
				<option value="bArea">지역 선택</option>
				<c:forEach var="item" items="${bList.bArea}" varStatus="status">
					<option value="${item.area_name}">${item.area_name}</option>
				</c:forEach>
			</select>
		</div>

	</form>
	<div class="category_group">
		<label for="board_category1"></label> <a href="bBoardList.jsp"
			class="btn btn-info" id="board_category1">전체</a> <label
			for="board_category2"></label> <a href="#" class="btn btn-info"
			id="board_category2">자유게시판</a> <label for="board_category3"></label>
		<a href="#" class="btn btn-info" id="board_category3">고수광장</a> <label
			for="board_category4"></label> <a href="#" class="btn btn-info"
			id="board_category4">고수찾아요</a> <label for="board_category5"></label>
		<a href="#" class="btn btn-info" id="board_category5">고수 소식</a>

				<div class="notice-group">
					<input type="text" class="btn btn-info" value="공지사항" id="boardNotice" /> 
					<input type="text" class="btn btn-info" value="공지사항" id="boardNotice" />
					<input type="text" class="btn btn-info" value="공지사항" id="boardNotice" />
				</div>

				<div class="bBoardHitList">
					<label for="bBoardHit1"></label>
					<a href="#" id="bBoardHit1">${bTitle }#####</a> 
					<label for="bBoardHit2"></label>
					<a href="#"id="bBoardHit2">${bBoardHitList2}#####</a> 
					<label for="bBoardHit3"></label>
					<a href="#"id="bBoardHit3">${bBoardHitList3}#####</a>
				</div>
		</div>
	</div>
	
<%@include file="../inc/footer.jsp" %>