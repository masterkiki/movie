<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 등록</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>

	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/header.jsp"></c:import>
		<div class="d-flex">
			<c:import url="/WEB-INF/jsp/include/nav.jsp"></c:import>
			
			<section class="movielist">
				<div class="container">
					<h4>영화 관리</h4>
					<div>
						<table class="table text-center">
							<thead>
								<tr>
									<th>No.</th>
									<th>영화명</th>
									<th>관객수</th>
									<th>배우</th>
									<th>수정</th>
									<th>삭제</th>
								<tr>
							</thead>
							<tbody>
								<c:forEach var="movie" items="${movieList }">
								<tr>
									<td>${movie.id }</td>
									<td class="col-4">${movie.movietitle }</td>
									<td>
										<input type="text" style="width:50%;" >
										<button class="ml-1 btn btn-secondary btn-sm">갱신</button>
									</td>
									<td>
										<input type="text" style="width:50%;" id="actorInput">
										<button class="ml-1 btn btn-secondary btn-sm" id="actoruploadBtn" data-movie-id="${movie.id }" >등록</button>
									</td>
									<td><button class="btn btn-secondary btn-sm">수정</button></td>
									<td><button class="btn btn-danger btn-sm">삭제</button></td>
								</tr>
								</c:forEach>
							</tbody>
						
						</table>
						
					</div>
				</div>
			</section>
		</div>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp"></c:import>
	</div>
	
	<script>
		$(document).ready(function(){
			$("#actoruploadBtn").on("click",function(){
				let actor = $("#actorInput").val();
				let movieId = $(this).data("movie-id");
				
				if(actor == ""){
					alert("배우 이름을 입력해주세요");
					return;
				}
				
				$.ajax({
					type:"post"
					, url:"/add/actor"
					, data:{"movieId":movieId, "actor":actor}
					, success:function(data){
						if(data.result == "success"){
							location.reload();
						} else{
							alert("배우 등록 실패");
						}
					
					}
					, error:function(){
						alert("배우 등록 에러");
					}
				});

			
			});
		});
	
	</script>

</body>
</html>