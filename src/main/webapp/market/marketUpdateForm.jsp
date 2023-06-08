<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../inc/header.jsp" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<div class="container tmpt">
  <h3 class="text-center">Market 생성</h3>
  <form action="<%=request.getContextPath()%>/marketUpdate.crud?market_id=${marketDetailDto.market_id}" method="post" id="form" enctype="multipart/form-data">
    <fieldset>
      <legend>UPDATE</legend>
      <div class="form-group">
        <%
          request.setCharacterEncoding("UTF-8");
          response.setContentType("text/html; charset=UTF-8");
        %>
        <label for="mDivision">구분</label>
        <input type="text" id="mDivision" name="mDivision" class="form-control" value="${marketDetailDto.division}" readonly />
      </div>
      <div class="form-group">
        <label for="mTitle">제목</label>
        <input type="text" id="mTitle" name="mTitle" class="form-control" value="${marketDetailDto.title}" />
      </div>
      <div class="form-group">
        <label for="mContent">내용</label>
        <textarea rows="6" cols="50" id="mContent" name="mContent" class="form-control"
          placeholder="내용을 입력하십시오.">${marketDetailDto.content}</textarea>
      </div>
      <div class="form-group">
        <label for="mPrice">가격</label>
        <input type="text" id="mPrice" name="mPrice" class="form-control" value="${marketDetailDto.price}" />
      </div>
      <div class="form-group">
        <label for="mRefund">환불규정</label>
        <textarea rows="6" cols="50" id="mRefund" name="mRefund" class="form-control"
          placeholder="내용을 입력하십시오.">${marketDetailDto.refund}</textarea>
      </div>
      <div class="form-group">
        <label for="category1_id">카테고리1id</label>
        <input type="text" id="category1_id" name="category1_name" class="form-control" value="${marketDetailDto.category1_name}" readonly />
      </div>
      <div class="form-group">
        <label for="category2_id">카테고리2id</label>
        <input type="text" id="category2_id" name="category2_name" class="form-control" value="${marketDetailDto.category2_name}" readonly />
      </div>
      <input type="hidden" name="category1_id" value="${marketDetailDto.category1_id}" />
		<input type="hidden" name="category2_id" value="${marketDetailDto.category2_id}" />

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
      
      <c:if test = "${marketDetailDto.division == '수업'}">
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
		    <!-- 동적으로 생성되는 요일별 시간표가 추가될 컨테이너 -->
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
      </c:if>
      

      <div class="form-group text-right">
        <input type="submit" name="submit" id="formSubmitButton" title="상품생성을 진행합니다." class="btn btn-danger" value="수정"  style="color:white;"/>
        <input type="reset" name="reset" title="취소를 진행합니다." class="btn btn-default" value="취소"  />
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
