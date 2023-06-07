<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
	<div class = "container panel panel-info">
		<h3>주문하기</h3>
		<br/>
		<h4>주문정보</h4>
		<p>주문명 : <strong>${marketDetailDto.title}</strong></p>
		<p>주문내용 : <strong>${marketDetailDto.content}</strong></p>
		<p>주문가격 : <strong>${marketDetailDto.price}</strong></p>
        <c:if test="${marketDetailDto.division == '수업'}">
          <p>시간 : <strong>${marketDetailDto.appointment}</strong></p>
          <c:if test="${marketDetailDto.appointment == '시간등록'}">
          <p>시작날짜 : <strong>${marketDetailDto.startSchedule}</strong></p>
          <p>끝나는 날짜 : <strong>${marketDetailDto.endSchedule}</strong></p>
          <c:forEach var="time" items="${marketDetailDto.time}" varStatus="status">
          <p>요일 : <strong>${time.day}</strong></p>
          <p>시작 시간 : <strong>${time.starttime}</strong></p>
          <p>시작 시간 : <strong>${time.endtime}</strong></p>
          </c:forEach>
          </c:if>
          <p>방식 : ${marketDetailDto.proceed}</p>
          <c:if test="${marketDetailDto.proceed == '대면'}">
          <p>위치 : ${marketDetailDto.location}</p>
          </c:if>
        </c:if>
		<h4>결제금액</h4>
		<p>최종 결제금액 : <strong>${marketDetailDto.price}</strong></p>
		<div class="well">
		<strong>취소/환불은 어떻게 진행되나요?</strong>
		결제 직후 3시간 이내로 취소 시 전액 환불처리가 되며, 이후 주문취소가 불가하여 고수분과 환불을 위한 별도의 협의가 필요합니다.
		주문취소는 구매내역에서 가능하며, 고수가 서비스 취소를 진행할 경우에는 고객님이 결제하신 금액이 전액 환불됩니다.
		</div>
		<p class="text-right">
		<a href="javascript:history.back()" title="뒤로가기" class="btn btn-default">취소</a>
		<a href="${pageContext.request.contextPath}/marketBuy.crud?market_id=<%=request.getParameter("market_id")%>" title="구매하기" class="btn btn-info">구매하기</a>
		</p>
		

		
	</div>
<%@ include file="../inc/footer.jsp" %>