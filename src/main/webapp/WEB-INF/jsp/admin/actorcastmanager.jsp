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
<body class="background">

	<div id="wrap">
			<c:import url="/WEB-INF/jsp/include/nav.jsp"></c:import>
		<div class="d-flex">
		<div>
			<c:import url="/WEB-INF/jsp/include/header.jsp"></c:import>
				
				<section class="actorcastadd bg-white">
					
						<h4>배우 및 배역 등록</h4>
						<hr>
						
						<div class="">
							<table class="table text-center">
								<thead>
									<tr>
										<th>영화제목</th>
										<th>배우명</th>
										<th>배역이름</th>
									</tr>
									
								</thead>
							
								<tbody>
									<tr>
										<td>
											<select id="selectMovieId" class="movieList text-center form-control">
												<option value="">-영화를 선택해주세요-</option>
												<c:forEach var="movie" items="${movieList}">
													<option  value="${movie.id }">${movie.movietitle }</option>
												</c:forEach>
											
											</select>
										</td>
										<td>
											<select class="actorlist text-center form-control">
												<option value="">-배우를 선택해주세여요-</option>
											</select>
										</td>
										
										<td class="d-flex">
											<input id ="characternameInput" class="form-control" type="text">
											<button class="btn btn-dark" id="castaddBtn">등록</button>
										</td>
										
										
									</tr>
									
								</tbody>
								
							</table>						
								
							<div>
							
							<label>영화 선택</label>
							<select onchange="if(this.value)location.href=(this.value);">
								<option value="view?movieId=0">-영화를 선택해주세요</option>
								<c:forEach var="movie" items="${movieList }">
								<option value="view?movieId=${movie.id }">${movie.movietitle }</option>
								</c:forEach>
							</select>
								<table class="table text-center">
									<thead>
										<tr>
											<th>배우명</th>
											<th>배역이름</th>
										</tr>
									</thead>
								
									<tbody>								
											<c:forEach var="actor" items="${actorDetailList}">
											<tr>
												<td>${actor.actor}</td>
												<td>${actor.charactername }</td>
											</tr>
											</c:forEach>
									</tbody>
								</table>
							</div>	
						</div>
				</section>
			</div>
		</div>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp"></c:import>
	</div>
	
	<script>
		$(document).ready(function(){
			
			$("#castaddBtn").on("click",function(){
				let movieId = $("#selectMovieId option:selected").val();
				let actorId = $(".actorlist option:selected").val();
				let charactername = $("#characternameInput").val();
				
 				$.ajax({
					type:"post"
					, url:"/castname/add"
					, data:{"movieId":movieId, "actorId":actorId, "charactername":charactername}
					, success:function(data){
						if(data.result == "success"){
							location.reload();
						} else {
							alert("배역이름 저장 실패");
						} 
						
					}
					, error:function(){
						alert("배역이름 저장 에러");
					}
					
				});
				 
			});
			
			
			$(".movieList").on("click",function(){
				var movieId = $(this).val();
				

				$.ajax({
					type:"get"
					, url:"/actorlist"
					, data:{"movieId":movieId}
					, success:function(data){
						$(".actorlist").empty();
						var defaultoption = "<option>-배우를선택해주세요-</option>"
						$(".actorlist").append(defaultoption);
						for(var i = 0; i < data.length; i++){
						
						var option = "<option value='"+ data[i].id +"'>" + data[i].actor + "</option>";
						
						$(".actorlist").append(option);
						}
						
					}
					
				}); 
			});
			
			
		}); 
	</script>

</body>
</html>