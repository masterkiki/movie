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

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">

<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body class="background">

	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/nav.jsp"></c:import>
		<div class="d-flex">
			<div>
				<c:import url="/WEB-INF/jsp/include/header.jsp"></c:import>
				<section class="movieupload d-flex justify-content-center align-items-center bg-white">
					<div>
						<h4>영화 등록</h4>
						<div class="d-flex align-items-center mt-4">
							<label class="col-3">영화 제목</label>
							<input type="text" class="form-control col-3" id="titleInput">
							
							<label class="col-2 text-center">장르</label>
							<select class="form-control" style="width:120px;font-size:14px;" id="genreSelector">
								<option selected>-장르 선택-</option>
								<option>공포</option>
								<option>스릴러</option>
								<option>코미디</option>
								<option>다큐</option>
								<option>판타지</option>
								<option>드라마</option>
								<option>액션</option>
								<option>범죄</option>
							</select>
							
						</div>
						<div class="d-flex align-items-center mt-4">
							<label class="col-3 text-center ">개봉일</label>
							<input type="text" class="form-control col-3" id="releasedateInput">
	
							<label class="col-2 text-center">국가</label>
							<select class="form-control"  style="width:120px;font-size:14px;" id="countrySelector">
								<option selected>-국가 선택-</option>
								<option>한국</option>
								<option>미국</option>
								<option>중국</option>
								<option>독일</option>
								<option>프랑스</option>
								<option>일본</option>
							</select>
							
		
						</div>
						
						<div class="d-flex align-items-center mt-4">
							<label class="col-3 text-center">감독</label>
							<input type="text" class="form-control col-3" id="directorInput">
							
							
							<label class="col-3 ml-1">포스터 등록</label>
								<div class="image-upload">
		   						 	<label for="posterInput">
		        						<div class="upload-icon" id="posteruploadBtn"><i class="bi bi-image"></i></div>
		    						</label>
		    						<input id="posterInput" type="file" style="display: none;"/>
								</div>						
						</div>
						
						<div>
							<label class="col-2 text-center">줄거리</label>
							<textarea class="ml-4 form-control" style="width:95%;" id="storyInput"></textarea>
						</div>
						<div>
							<button class="mt-3 btn btn-primary" style="float:right;" id="nextBtn">등록</button>
						</div>
					</div>
				</section>
			</div>	
		</div>
		<c:import url="/WEB-INF/jsp/include/footer.jsp"/>
	</div>

	<script>
		$(document).ready(function(){
			$("#nextBtn").on("click",function(){
				let title = $("#titleInput").val();
				let genre = $("#genreSelector").val();
				let releasedate = $("#releasedateInput").val();
				let country = $("#countrySelector").val();
				let director = $("#directorInput").val();
				let poster = $("#posteruploadBtn").val();
				let story = $("#storyInput").val();
				
				if(title == ""){
					alert("제목을 입력하세요");
					return;
				}
				if(genre == ""){
					alert("장르를 선택하세요");
					return;
				}
				if(releasedate == ""){
					alert("개봉일을 입력하세요");
					return;
				}
				if(country == ""){
					alert("국가를 선택하세요");
					return;
				}
				if(director == ""){
					alert("감독을 입력하세요");
					return;
				}
				
				var formData = new FormData();
				formData.append("movietitle", title);
				formData.append("genre", genre);
				formData.append("country", country);
				formData.append("releasedate", releasedate);
				formData.append("director", director);
				formData.append("file", $("#posterInput")[0].files[0]);
				formData.append("story", story);
				
				$.ajax({
					type:"post"
					, url:"/movie/upload"
					, data:formData
					, enctype:"multipart/form-data"
					, processData:false
					, contentType:false
					, success:function(data){
						
						if(data.result == "success"){
							location.reload();
						} else{
							alert("영화 등록 실패");
						}
						
					}
					, error:function(){
						alert("영화 등록 에러");
					}
					
				});
				
				
				
			});
			
		});
			
		
	</script>
</body>
</html>