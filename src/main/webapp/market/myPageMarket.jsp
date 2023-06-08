<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<div class="container">
  <h3>나의 상품 관리</h3>
  <br/>
  <br/>
  <div class="btn-group btn-group-lg">
    <input type="button" class="btn btn-info division" value="상품" style="color:white;"/>
    <input type="button" class="btn btn-info division" value="수업" style="color:white;"/>
  </div>
	<c:if test="${sessionScope.memberValue == 'expert'}">
	<div class="text-right">
	  <div class="dropdown dropright">
	    <button class="btn btn-info dropdown-toggle" style="color:white;" type="button" id="categoryDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	      상품 / 수업 생성
	    </button>
		<div class="dropdown-menu dropdown-menu-right" aria-labelledby="categoryDropdown">
		  <a class="dropdown-item" href="${pageContext.request.contextPath}/marketCreateForm.crud?mDivision=상품">상품</a>
		  <a class="dropdown-item" href="${pageContext.request.contextPath}/marketCreateForm.crud?mDivision=수업">수업</a>
		</div>
	  </div>
	</div>
	  </c:if>
  <hr/>
  <div class="ajaxMarket">
    <c:forEach var="dto" items="${myPageMarket}" varStatus="status">
      <div>
        <a href="${pageContext.request.contextPath}/marketDetail.crud?market_id=${dto.market_id}">
          <img src="/images/${dto.images[0]}" alt="대표이미지" class="img-thumbnail" style="width: 300px; height: 200px;"/>
        </a>
        <strong> 카테고리 : ${dto.category2_name} </strong>
        <strong> 제목 : </strong>
        <a href="${pageContext.request.contextPath}/marketDetail.crud?market_id=${dto.market_id}">${dto.title} </a>
        <strong> 가격 : ${dto.price} </strong>
      </div>
    </c:forEach>
  </div>
  <div class="text-right">
    <input type="button" class="btn btn-info" id="addContent" value="더보기" style="color:white;"/>
  </div>
</div>
<script>
  var division = "상품";
  var plus = 0;
  $(function(){
    $(".division").on("click", function(){
      division = $(this).val(); // division 값을 변경
      plus = 0;
      $.ajax({
        url: "${pageContext.request.contextPath}/ajaxmyPageMarket.crud?mDivision=" + division,
        type: "get",
        dataType: "json",
        success: function(json){
          $(".ajaxMarket").empty();
          $.each(json, function(index, item){
            var image = item.images[0];
            var category2_name = item.category2_name;
            var title = item.title;
            var price = item.price;
            var market_id = item.market_id;
            var mimage = $("<a>").attr("href", "${pageContext.request.contextPath}/marketDetail.crud?market_id=" + market_id).html($("<img>").attr("src", "/images/" + image).attr("class","img-thumbnail").attr("alt","대표이미지").attr("style","width: 300px; height: 200px;"));
            var mtitle = $("<a>").attr("href", "${pageContext.request.contextPath}/marketDetail.crud?market_id=" + market_id).attr("title", title).html(title);

            var mcategory2_name = $("<strong>").append("카테고리 :  ").append(category2_name);
            mtitle = $("<strong>").append("제목 :  ").append(mtitle);
            var mprice = $("<strong>").append("가격 :  ").append(price);

            $(".ajaxMarket").append($("<div>").append(mimage).append(mcategory2_name).append(mtitle).append(mprice));
          });
        },
        error: function(xhr, textStatus, errorThrown){
          // AJAX 요청 실패 처리
        }
      });
    });

    $("#addContent").on("click", function(){
      plus = plus + 5;
      $.ajax({
        url: "${pageContext.request.contextPath}/ajaxmyPageMarket.crud",
        type: "get",
        data: {
          mDivision: division,
          market_count: plus
        },
        dataType: "json",
        success: function(json){
          $.each(json, function(index, item){
            var image = item.images[0];
            var category2_name = item.category2_name;
            var title = item.title;
            var price = item.price;
            var market_id = item.market_id;
            var mimage = $("<a>").attr("href", "${pageContext.request.contextPath}/marketDetail.crud?market_id=" + market_id).html($("<img>").attr("src", "/images/" + image).attr("class","img-thumbnail").attr("alt","대표이미지").attr("style","width: 300px; height: 200px;"));
            var mtitle = $("<a>").attr("href", "${pageContext.request.contextPath}/marketDetail.crud?market_id=" + market_id).attr("title", title).html(title);

            var mcategory2_name = $("<strong>").append("카테고리 :  ").append(category2_name);
            mtitle = $("<strong>").append("제목 :  ").append(mtitle);
            var mprice = $("<strong>").append("가격 :  ").append(price);

            $(".ajaxMarket").append($("<div>").append(mimage).append(mcategory2_name).append(mtitle).append(mprice));
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
