<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../inc/header.jsp" %>
<style>
.carousel {
  max-width: 800px; /* 원하는 크기로 조정하세요 */
  margin: 0 auto; /* 가운데 정렬을 위해 필요한 부분입니다 */
  display: flex;
  align-items: center;
  justify-content: center;
}

.carousel-inner .item img {
  max-width: 100%;
  max-height: 100%;
  display: block;
  margin: 0 auto;
}
</style>

<div class="container">
  <div class="row">
    <div class="col-sm-8">
      <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
		<c:forEach var="i" begin="0" end="${empty marketDetailDto.images ? 0 : marketDetailDto.images.size() - 1}" varStatus="status">
            <c:if test="${marketDetailDto.images[i] ne 'no.img'}">
              <li data-target="#myCarousel" data-slide-to="${i}" <c:if test="${status.first}">class="active"</c:if>></li>
            </c:if>
          </c:forEach>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
          <c:forEach var="dto" items="${marketDetailDto.images}" varStatus="status">
            <c:if test="${dto ne 'no.img'}">
              <div class="item <c:if test="${status.first}">active</c:if>">
                <img src="/images/${dto}" alt="이미지">
              </div>
            </c:if>
          </c:forEach>
        </div>

        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
          <span class="glyphicon glyphicon-chevron-left"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
          <span class="glyphicon glyphicon-chevron-right"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>

      <div class="well">
        <p>${marketDetailDto.expert_name}</p>
        <c:if test="${marketDetailDto.division == '수업'}">
          <p>시간 : ${marketDetailDto.appointment}</p>
          <p>방식 : ${marketDetailDto.proceed}</p>
        </c:if>
        <h3>내용</h3>
        <p>${marketDetailDto.content}</p>
        <h3>FAQ</h3>
        <c:forEach var="faq" items="${marketDetailDto.faq}" varStatus="status">
          <h4>faq 제목</h4>
          <p>${faq.title}</p>
          <h4>faq 내용</h4>
          <p>${faq.content}</p>
        </c:forEach>
        <h3>취소 및 환불 규정</h3>
        <p>${marketDetailDto.refund}</p>
      </div>
    </div>

    <div class="col-sm-4" style="position: sticky; top: 50px;">
      <p>${marketDetailDto.category1_name} > ${marketDetailDto.category2_name}</p>
      <h3>${marketDetailDto.title}</h3>
      <c:if test="${memberValue ne null }">
        <!-- Trigger the modal with a button -->
        <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal" >문의</button>
      
        <a href="${pageContext.request.contextPath}/marketBuyForm.crud?market_id=${marketDetailDto.market_id}" title="구매페이지로" class="btn btn-info" style="color:white;">구매</a>
      </c:if>
    </div>
    <!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog" style="z-index: 9999;">
		  <div class="modal-dialog">
		    <!-- Modal content-->
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		        <h4 class="modal-title">문의</h4>
		        <p><strong>주의 ! 창 이외를 누르시면 나가집니다.</strong> </p>
		      </div>
		      <div class="modal-body">
		        <form action = "${pageContext.request.contextPath}/marketInquiry.crud?market_id=${marketDetailDto.market_id}" method="post" id="inquiryForm">
		          <div class="form-group">
		          	<label for = "iCategory">문의 유형</label>
					<select id = "iCategory" name="iCategory" class="form-control">
					<option value="상품">상품</option>
					<option value="환불">취소/환불</option>
					<option value="기타">기타</option>
					</select>
		          </div>
		          <div class="form-group">
		            <label for="iTitle">문의 제목</label>
		            <input type="text" class="form-control" id="iTitle" name = "iTitle">
		          </div>
		          <div class="form-group">
		            <label for="iContent">문의 내용</label>
		            <textarea class="form-control" rows="5" id="iContent" name="iContent"></textarea>
		          </div>
		        	<div class="form-group text-right">
		        	<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
		        	<button type="submit" class="btn btn-primary" style="color:white;">전송</button>
		        	</div>
		        </form>
		      </div>


		    </div>
		  </div>
		</div>
  </div>
  <c:if test="${sessionScope.expert_id == marketDetailDto.expert_id}">
  <a href="${pageContext.request.contextPath}/marketUpdateForm.crud?market_id=${marketDetailDto.market_id}" title="수정" class="btn btn-info" style="color:white;">수정</a>
  <a href="${pageContext.request.contextPath}/marketDelete.crud?market_id=${marketDetailDto.market_id}&mDivision=${marketDetailDto.division}" title="삭제" class="btn btn-danger" style="color:white;">삭제</a>
  </c:if>
</div>

<%@ include file="../inc/footer.jsp" %>
