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
			
			<section class="contents d-flex bg-info justify-content-center align-items-center ">
				<div class="bg-warning">
					<h4>영화 등록</h4>
					<div class="d-flex align-items-center mt-4">
						<label class="col-2">영화 제목</label>
						<input type="text" class="form-control col-3">
						
						<label class="col-2 text-center">장르</label>
						<input type="text" class="form-control col-3">
						
						<label class="col-2 text-center ">국가</label>
						<input type="text" class="form-control col-3">
					</div>
					<div class="d-flex align-items-center mt-4">
						
						<label class="col-2 text-center ">개봉일</label>
						<input type="text" class="form-control col-3">
	
						<label class="col-2 text-center">감독</label>
						<input type="text" class="form-control col-3">
						
						<label class="col-2 text-center">출연</label>
						<input type="text" class="form-control col-3">
					</div>
					
					<div class="d-flex align-items-center mt-4">
						
						<label class="col-3 ml-2">포스터 등록</label>
						<input type="text" class="form-control col-3">									
					</div>
					
					<div>
						<label class="col-2 text-center">줄거리</label>
						<textarea rows="13" class="ml-4 form-control"></textarea>
					</div>
					<div>
						<button class="mt-3 btn btn-primary">다음</button>
					</div>
				</div>
			</section>
		</div>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp"></c:import>
	</div>

</body>
</html>