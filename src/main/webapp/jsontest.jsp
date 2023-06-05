<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container panel panel-info">
   <h3 class="panel-heading">test</h3>
 
 <input type="button" id="b" value="json"/>
 
 <table class="table table-info result r1">
 <thead>
 <tr>
 <th>name</th><th>email</th><th>id</th>
 </tr>
 </thead>
 <tbody>
 
 </tbody>
 
 
 </table>
 
 
 
 
 
 
 
 
 
</div>

<script>

$(function() {
	$("#b").on("click", function() {
		$.ajax({
			
			url :"${pageContext.request.contextPath}/a.test",
			type :"get",
			dataType : "json",
			
			success : function(json) {
				
				console.log(json);
				
				$(".r1 tbody").empty();
				
				for(i in json){
					
					
					var name = json[i].user_name;
					var id = json[i].user_id;
					var email = json[i].user_email;
					
					
					console.log(name);
					console.log(id);
					console.log(email);
					
					
					var tr = $("<tr>");
					
					var td1 = $("<td>").html(name);
					var td3 = $("<td>").html(id);
					var td2 = $("<td>").html(email);
					
					
					tr.append(td1).append(td2).append(td3);
					
					$(".r1 tbody").append(tr);
					
				}
			
				
			},
			
			error : function() {
				
			}
			
			
			
		});
		
		
		
		
	});
	
	
	
});


</script>

</body>
</html>