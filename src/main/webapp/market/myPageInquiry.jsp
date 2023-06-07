<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<div class="container">
  <h3>나의 문의 관리</h3>
  <br/>
  <br/>
  <hr/>
  <div class="ajaxInquiry">
    <c:forEach var="inquiry" items="${iList}" varStatus="status">
      <div>
        <p>
        <strong>문의 카테고리 : </strong> ${inquiry.category}
        <strong> 마켓 제목 : </strong>
        <a href="${pageContext.request.contextPath}/inquiryDetail.crud?inquiry_id=${inquiry.inquiry_id}">${inquiry.mTitle} </a>
      	</p>
      	<p>
      		<strong> 문의 제목 : </strong> ${inquiry.title}
      		<strong> 답변 유무 : </strong> ${inquiry.checkAnswer}
      	</p>
      </div>
      
    </c:forEach>
  </div>
  <div class="text-right">
    <input type="button" class="btn btn-info" id="addContent" value="더보기"/>
  </div>
</div>
<script>
  var plus = 0;
  $(function(){
    $("#addContent").on("click", function(){
      plus = plus + 5;
      $.ajax({
        url: "${pageContext.request.contextPath}/ajaxInquiryView.crud",
        type: "get",
        data: {
          inquiry_count: plus
        },
        dataType: "json",
        success: function(json){
          $.each(json, function(index, item){
            var icate = item.category
        	var ititle = item.title;
			var icheck = item.checkAnswer? "true":"false";
            var market_id = item.market_id;
            var mtitle = item.mTitle;
            var mtitle = $("<a>").attr("href", "${pageContext.request.contextPath}/inquiryDetail.crud?inquiry_id=" + item.inquiry_id).attr("title", mtitle).html(mtitle);
            icate = $("<strong>").append(" 문의 카테고리 : ").append(icate);
            mtitle = $("<strong>").append(" 마켓 제목 : ").append(mtitle);
            ititle = $("<strong>").append(" 문의 제목 : ").append(ititle);
            icheck = $("<strong>").append(" 답변 여부 : ").append(icheck);
            $(".ajaxInquiry").append($("<div>").append(icate).append(mtitle).append($("<p>").append(ititle).append(icheck)));
          });
        },
        error: function(xhr, textStatus, errorThrown){
          // AJAX 요청 실패 처리
        }
      });
    });
  });
</script>

<%@ include file="../inc/footer.jsp" %>
