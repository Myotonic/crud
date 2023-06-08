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
		  <label for="category1_id">카테고리1</label>
		  <select id="category1_id" name="category1_id" class="form-control">
		    <option value="1">레슨</option>
		    <option value="2">홈/리빙</option>
		    <option value="3">디자인/개발</option>
		    <option value="4">기타</option>
		  </select>
		</div>
		
		<div class="form-group">
		  <label for="category2_id">카테고리2</label>
		  <select id="category2_id" name="category2_id" class="form-control">
		    <option value="2" data-category1="1">댄스</option>
		    <option value="3" data-category1="1">피아노</option>
		    <option value="4" data-category1="1">기타</option>
		    <option value="5" data-category1="1">드럼</option>
		    <option value="6" data-category1="1">요리</option>
		    <option value="7" data-category1="1">그림</option>
		    <option value="8" data-category1="1">국어</option>
		    <option value="9" data-category1="1">영어</option>
		    <option value="10" data-category1="1">수학</option>
		    <option value="11" data-category1="1">PT</option>
		    <option value="12" data-category1="2">이사</option>
		    <option value="13" data-category1="2">청소</option>
		    <option value="14" data-category1="2">반려동물 홈시티</option>
		    <option value="15" data-category1="2">펫미용</option>
		    <option value="16" data-category1="3">영상 / 편집</option>
		    <option value="17" data-category1="3">웹, 앱 디자인</option>
		    <option value="18" data-category1="3">웹, 앱 개발</option>
		    <option value="19" data-category1="3">퍼블리싱</option>
		    <option value="20" data-category1="3">게임 개발</option>
		    <option value="21" data-category1="3">썸네일 제작</option>
		    <option value="22" data-category1="4">가구 / 목공예 제작</option>
		    <option value="23" data-category1="4">플라워 제작</option>
		    <option value="24" data-category1="4">장소 / 대관</option>
		  </select>
		</div>

      <div class="form-group">
        <label for="faqContainer">자주하는 질문</label>
        <div id="faqContainer">
          <div class="faq">
            <input type="text" name="fTitle[]" class="form-control" placeholder="제목을 입력하십시오.">
            <input type="text" name="fContent[]" class="form-control" placeholder="내용을 입력하십시오.">
       		 <button type="button" id="addFaqButton" class="btn btn-primary" style="color:white;">질문 추가</button>
          </div>
        </div>
      </div>
      <div class="form-group">
        <label for="fileContainer">파일</label>
        <div id="fileContainer">
          <input type="file" name="file1" class="form-control">
        </div>
        <button type="button" id="addFileButton" class="btn btn-primary" style="color:white;">파일 추가</button>
      </div>

      <div class="form-group text-right">
        <input type="submit" name="submit" id="formSubmitButton" title="상품생성을 진행합니다." class="btn btn-danger" value="글쓰기"  style="color:white;"/>
        <input type="reset" name="reset" title="취소를 진행합니다." class="btn btn-default"  value="취소" />
        <a href="<%=request.getContextPath() %>/marketView.crud" class="btn btn-primary" style="color:white;"
          title="메인으로 돌아갑니다.">목록보기</a>
      </div>
    </fieldset>
  </form>
  <script>
  var imgcnt = 2;
  $(document).ready(function() {
   	  // category1 select element
	  var category1Select = document.getElementById("category1_id");

	  // category2 select element
	  var category2Select = document.getElementById("category2_id");

	  // event listener for category1 change
	  category1Select.addEventListener("change", function() {
	    var selectedCategory1 = category1Select.value;

	    // hide all category2 options
	    $(category2Select).find("option").hide();

	    // show category2 options with matching data-category1 value
	    $(category2Select).find("option[data-category1='" + selectedCategory1 + "'], option[data-category1='']").show();

	    // reset category2 selection
	    category2Select.selectedIndex = -1;
	  });
	  
	  
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
	        <button type="button" class="removeFaqButton btn btn-danger" style="color:white;">질문 제거</button>
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
          var fTitles = $("input[name='fTitle[]']");
          for (var i = 0; i < fTitles.length; i++) {
            if ($(fTitles[i]).val() == "") {
              alert("제목을 입력해야합니다.");
              $(fTitles[i]).focus();
              return false;
            }
          }
          
          var fContents = $("input[name='fContent[]']");
          for (var i = 0; i < fContents.length; i++) {
            if ($(fContents[i]).val() == "") {
              alert("내용을 입력해야합니다.");
              $(fContents[i]).focus();
              return false;
            }
          }
            var fileInput = $("input[type='file']");
            if (fileInput.get(0).files.length === 0) {
              alert("파일을 선택해야합니다.");
              fileInput.focus();
              return false;
            }
	  });
	});
  </script>
</div>
<%@ include file="../inc/footer.jsp" %>
