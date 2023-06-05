<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../inc/header.jsp" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<div class="container tmpt">
  <h3 class="text-center">Market 생성</h3>
  <form action="<%=request.getContextPath()%>/marketCreate.crud" method="post" id="form" enctype="multipart/form-data">
    <fieldset>
      <legend>CREATE</legend>
      <div class="form-group">
        <%
          request.setCharacterEncoding("UTF-8");
          response.setContentType("text/html; charset=UTF-8");
          request.getSession().setAttribute("expert_id", 1);
        %>
        <label for="mDivision">구분</label>
        <input type="text" id="mDivision" name="mDivision" class="form-control" value="${division}" readonly />
      </div>
      <div class="form-group">
        <label for="mTitle">제목</label>
        <input type="text" id="mTitle" name="mTitle" class="form-control" placeholder="제목을 입력하시오." />
      </div>
      <div class="form-group">
        <label for="mContent">내용</label>
        <textarea rows="6" cols="50" id="mContent" name="mContent" class="form-control"
          placeholder="내용을 입력하십시오."></textarea>
      </div>
      <div class="form-group">
        <label for="mPrice">가격</label>
        <input type="text" id="mPrice" name="mPrice" class="form-control" placeholder="가격을 입력하십시오." />
      </div>
      <div class="form-group">
        <label for="mRefund">환불규정</label>
        <textarea rows="6" cols="50" id="mRefund" name="mRefund" class="form-control"
          placeholder="내용을 입력하십시오."></textarea>
      </div>
      <div class="form-group">
        <label for="category1_id">카테고리1id</label>
        <input type="text" id="category1_id" name="category1_id" class="form-control" placeholder="카테고리1id을 입력하십시오." />
      </div>
      <div class="form-group">
        <label for="category2_id">카테고리2id</label>
        <input type="text" id="category2_id" name="category2_id" class="form-control" placeholder="카테고리2id을 입력하십시오." />
      </div>

      <div class="form-group">
        <label for="faqContainer">자주하는 질문</label>
        <div id="faqContainer">
          <div class="faq">
            <input type="text" name="fTitle[]" class="form-control" placeholder="제목을 입력하십시오.">
            <input type="text" name="fContent[]" class="form-control" placeholder="내용을 입력하십시오.">
       		 <button type="button" id="addFaqButton" class="btn btn-primary">질문 추가</button>
          </div>
        </div>
      </div>
      <div class="form-group">
        <label for="fileContainer">파일</label>
        <div id="fileContainer">
          <input type="file" name="file1" class="form-control">
        </div>
        <button type="button" id="addFileButton" class="btn btn-primary">파일 추가</button>
      </div>

      <div class="form-group text-right">
        <input type="submit" name="submit" id="formSubmitButton" title="상품생성을 진행합니다." class="btn btn-danger" value="글쓰기" />
        <input type="reset" name="reset" title="취소를 진행합니다." class="btn btn-default" value="취소" />
        <a href="<%=request.getContextPath() %>/marketView.crud" class="btn btn-default"
          title="메인으로 돌아갑니다.">목록보기</a>
      </div>
    </fieldset>
  </form>
  <script>
  var imgcnt = 2;
  $(document).ready(function() {
    // 파일 추가 버튼 클릭 시 파일 필드를 동적으로 추가
    $("#addFileButton").click(function() {
      var fileField = '<input type="file" name="file' + imgcnt + '" class="form-control">';
      $("#fileContainer").prepend(fileField);
      imgcnt = imgcnt + 1;
    });


	  // 질문 추가 버튼 클릭 시 질문 필드를 동적으로 추가
	  $("#addFaqButton").click(function() {
	    var faqField = `
	      <div class="faq">
	        <input type="text" name="fTitle[]" class="form-control" placeholder="제목을 입력하십시오.">
	        <input type="text" name="fContent[]" class="form-control" placeholder="내용을 입력하십시오.">
	        <button type="button" class="removeFaqButton btn btn-danger">질문 제거</button>
	      </div>
	    `;
	    $("#faqContainer").append(faqField);
	  });

	  // 질문 제거 버튼 클릭 시 해당 질문 필드를 제거
	  $(document).on("click", ".removeFaqButton", function() {
	    $(this).closest(".faq").remove();
	  });

	  // 글쓰기 버튼 클릭 이벤트 핸들러
	  $("#formSubmitButton").click(function() {
	    if ($("#mTitle").val() == "") {
	      alert("제목을 입력해야합니다.");
	      $("#mTitle").focus();
	      return false;
	    }
	    if ($("#mContent").val() == "") {
	      alert("내용를 입력해야합니다.");
	      $("#mContent").focus();
	      return false;
	    }
	    if ($("#mPrice").val() == "") {
	      alert("가격을 입력해야합니다.");
	      $("#mPrice").focus();
	      return false;
	    }
	    if ($("#category1_id").val() == "") {
	      alert("카테고리아이디를 입력해야합니다.");
	      $("#category1_id").focus();
	      return false;
	    }
	    if ($("#category2_id").val() == "") {
	      alert("카테고리아이디를 입력해야합니다.");
	      $("#category2_id").focus();
	      return false;
	    }
	    if ($("#fTitle").val() == "") {
	      alert("제목을 입력해야합니다.");
	      $("#fTitle").focus();
	      return false;
	    }
	    if ($("#fContent").val() == "") {
	      alert("제목을 입력해야합니다.");
	      $("#fContent").focus();
	      return false;
	    }
	  });
	});
  </script>
</div>
<%@ include file="../inc/footer.jsp" %>
