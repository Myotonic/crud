<%@page import="com.company.dto.bWriterDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../inc/header.jsp"%>
<div class="container panel panel-info">
	<h3 class="panel-heading"></h3>
	<form action="${pageContext.request.contextPath }/bBoardCreate.crud?board_break_point=${board_break_point}" method="post" id="bWriteForm" enctype="multipart/form-data">
	
	
		<select>
			<option value="">주제선택</option>
			<option value="bBoardC1">자유게시판</option>
			<option value="bBoardC2">고수광장</option>
			<option value="bBoardC3">고수찾아요</option>
			<option value="bBoardC4">고수소식</option>
		</select>
		<div class="form-submit">
			<input type="submit" value="등록" class="btn btn-success" id="boardCommit"/>
		</div>
		
		<div class="form-group">
			<label for="boardUpload">파일 업로드</label>
			<input type="file"  id="boadUpload" name="boardUpload">
		</div>
		
		<div class="form-group">
			<label for="boardTitle">제목</label>
			<input type="text" class="form-control" id="boardTitle" name="board_title" placeholder="제목을 입력하세요">
		</div>

		<div class="bOption col-sm-10">
			<div class="service-group col-sm-2">
				<label for="sel1">서비스</label> <select id="bService" name="bCate">
				<option value="bService">서비스 선택</option>
				<c:forEach var="item" items="${bList.cate1}" varStatus="status">
					<option value="${item.category1_name}">${item.category1_name}</option>
				</c:forEach>
			</select> 

			</div>
			<div class="area-group col-sm-2">
				<label for="sel2">지역</label> <select id="bArea" name="bArea">
					<option value="bArea">지역 선택</option>
					<c:forEach var="item" items="${bList.bArea}" varStatus="status">
						<option value="${item.area_name}">${item.area_name}</option>
					</c:forEach>
				</select>
			</div>
		</div>

		<div class="content-group">
			<label for="bBoardContent">내용</label>
			<textarea class="form-control bTextCon" rows ="6" cols="50" name="board_content" id="bBoardContent" placeholder="내용을 입력하세요."></textarea>
		</div>
	</form>
</div>
<script>
$(function() {
	  $('#boardCommit').click(function() {.
	    var title = $('#board_title').val();
	    var content = $('#board_content').val();
	    

	    if (title.trim() === '') {
	      alert('제목을 입력해주세요.');
	      return false; 
	    }
	    
	    if (content.trim() === '') {
	      alert('내용을 입력해주세요.');
	      return false; 
	    }

	    $('#bWriteForm').submit();
	  });
	});
</script>

<%@include file="../inc/footer.jsp"%>