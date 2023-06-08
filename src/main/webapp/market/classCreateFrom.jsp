<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../inc/header.jsp" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<div class="container tmpt">
  <h3 class="text-center">Class 생성</h3>
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
          <input type="hidden" name="fileCheck">
        </div>
        <button type="button" id="addFileButton" class="btn btn-primary" style="color:white;" >파일 추가</button>
      </div>



		<div class="form-group">
		  <label for="time">시간</label>
		  <select class="form-control" id="time" name="mAppointment">
		    <option value="0">시간협의</option>
		    <option value="1">시간결정</option>
		  </select>
		</div>
		
		<div class="form-group" id="dateRange" style="display: none;">
		  <label for="startDate">시작 날짜</label>
		  <input type="text" id="startDate" name="mStartSchedule" class="form-control" placeholder="시작 날짜를 입력하세요.">
		  <label for="endDate">끝나는 날짜</label>
		  <input type="text" id="endDate" name="mEndSchedule" class="form-control" placeholder="끝나는 날짜를 입력하세요.">
		</div>
		
		<div class="form-group" id="weekdaySchedule" style="display: none;">
		  <label for="scheduleContainer">요일별 시간표</label>
		  <div id="scheduleContainer">
			   <div class="schedule">
	        <label for="mDay">요일</label>
	        <select class="form-control" name="mDay[]" id = "mDay">
	          <option value="월요일">월요일</option>
	          <option value="화요일">화요일</option>
	          <option value="수요일">수요일</option>
	          <option value="목요일">목요일</option>
	          <option value="금요일">금요일</option>
	          <option value="토요일">토요일</option>
	          <option value="일요일">일요일</option>
	        </select>
	        <label for="mStartTime">시작 시간</label>
	        <input type="text" name="mStartTime[]" id="mStartTime" class="form-control" placeholder="시작 시간을 입력하세요.">
	        <label for="mEndTime">끝나는 시간</label>
	        <input type="text" name="mEndTime[]" id="mEndTime" class="form-control" placeholder="끝나는 시간을 입력하세요.">
	        <button type="button" class="btn btn-danger remove-schedule" style="color:white;">시간 제거</button>
	      </div>
		  </div>
		  <button type="button" id="addScheduleButton" class="btn btn-primary" style="color:white;">시간 추가</button>
		</div>
		
		<div class="form-group">
		  <label for="meetingType">대면/비대면</label>
		  <select class="form-control" id="meetingType" onchange="toggleMeetingOption()" name = "mProceed">
		    <option value="0">대면</option>
		    <option value="1">비대면</option>
		  </select>
		</div>
		
		<div class="form-group" id="location" >
		  <label for="locationInput">위치</label>
		  <input type="text" id="locationInput" name="mLocation" class="form-control" placeholder="위치를 입력하세요.">
		</div>

      <div class="form-group text-right">
        <input type="submit" name="submit" id="formSubmitButton" title="상품생성을 진행합니다." class="btn btn-danger" style="color:white;" value="글쓰기" />
        <input type="reset" name="reset" title="취소를 진행합니다." class="btn btn-default"   value="취소" />
        <a href="<%=request.getContextPath() %>/marketView.crud" class="btn btn-default" 
          title="메인으로 돌아갑니다.">목록보기</a>
      </div>
    </fieldset>
  </form>
 <script>
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
        var fileField = '<input type="file" name="file[]" class="form-control">';
        $("#fileContainer").append(fileField);
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
        }else if ($("#mContent").val() == "") {
          alert("내용를 입력해야합니다.");
          $("#mContent").focus();
          return false;
        }else if ($("#mPrice").val() == "") {
          alert("가격을 입력해야합니다.");
          $("#mPrice").focus();
          return false;
        }else if ($("#mRefund").val() == "") {
            alert("환불규정을 입력해야합니다.");
            $("#mRefund").focus();
            return false;
        }else  if ($("#category1_id").val() == "") {
          alert("카테고리아이디를 입력해야합니다.");
          $("#category1_id").focus();
          return false;
        }else if ($("#category2_id").val() == "") {
          alert("카테고리아이디를 입력해야합니다.");
          $("#category2_id").focus();
          return false;
        }else if($("#file1").files.length!=0){
            alert("파일을 추가해야합니다.");
            $("#file1").focus();
            return false;
        }else if ($("#locationInput").val() == "") {
            alert("위치를 설정해야합니다.");
            $("#locationInput").focus();
            return false;
         }
        
        /* else if ($("#fTitle").val() == "") {
          alert("제목을 입력해야합니다.");
          $("#fTitle[]").focus();
          return false;
        }else if ($("#fContent").val() == "") {
          alert("내용을 입력해야합니다.");
          $("#fContent[]").focus();
          return false;
        } */
        
      });

      // 시간 옵션 변경 이벤트 핸들러
      $("#time").change(function() {
        var selectedOption = $(this).val();

        // 선택한 옵션에 따라 필요한 정보를 보이거나 숨깁니다.
        if (selectedOption === "1") {
          $("#dateRange").show();
          $("#weekdaySchedule").show();
        } else {
          $("#dateRange").hide();
          $("#weekdaySchedule").hide();
        }
      });

      // 요일별 시간 추가 버튼 클릭 이벤트 핸들러
      $("#addScheduleButton").click(function() {
        var scheduleField = `
          <div class="schedule">
            <label for="mDay">요일</label>
            <select class="form-control" name="mDay[]" id="mDay">
              <option value="월요일">월요일</option>
              <option value="화요일">화요일</option>
              <option value="수요일">수요일</option>
              <option value="목요일">목요일</option>
              <option value="금요일">금요일</option>
              <option value="토요일">토요일</option>
              <option value="일요일">일요일</option>
            </select>
            <label for="mStartTime">시작 시간</label>
            <input
              type="text"
              name="mStartTime[]"
              id="mStartTime"
              class="form-control"
              placeholder="시작 시간을 입력하세요."
            >
            <label for="mEndTime">끝나는 시간</label>
            <input
              type="text"
              name="mEndTime[]"
              id="mEndTime"
              class="form-control"
              placeholder="끝나는 시간을 입력하세요."
            >
            <button type="button" class="btn btn-danger remove-schedule" style="color:white;">시간 제거</button>
          </div>
        `;

        $("#scheduleContainer").append(scheduleField);
      });

      // 동적으로 생성된 요일별 시간표의 시간 제거 버튼 클릭 이벤트 핸들러 (이벤트 위임)
      $("#scheduleContainer").on("click", ".remove-schedule", function() {
        $(this).closest(".schedule").remove();
      });

      // 대면/비대면 옵션 변경 이벤트 핸들러
      $("#meetingType").change(function() {
        toggleMeetingOption();
      });

      function toggleMeetingOption() {
        var meetingType = $("#meetingType").val();
        var location = $("#location");

        // 대면/비대면 옵션에 따라 해당 정보를 보이거나 숨김
        if (meetingType === "0") {
          location.show();
        } else {
          location.hide();
        }
      }
    });
  </script>
</div>
<%@ include file="../inc/footer.jsp" %>
