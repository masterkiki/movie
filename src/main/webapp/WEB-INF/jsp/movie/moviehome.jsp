<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비 홈</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>
	<div id="wrap" class>
	
		<c:import url="/WEB-INF/jsp/include/header.jsp"/>
		
		<div class="d-flex">
			<nav class="main-menu bg-dark">
				<ul class="nav flex-column mt-4">
					<li class="nav-items bg-danger"><a href="#" class="nav-link text-white font-weight-bold text-center">영화 홈</a></li>
					<li class="nav-items bg-secondary"><a href="#" class="nav-link text-white font-weight-bold text-center">영화 랭킹</a></li>
					<li class="nav-items bg-secondary"><a href="#" class="nav-link text-white font-weight-bold text-center">평점</a></li>
					<li class="nav-items bg-secondary"><a href="#" class="nav-link text-white font-weight-bold text-center">영화분류</a></li>
					<li class="nav-items bg-secondary"><a href="#" class="nav-link text-white font-weight-bold text-center">관리자 메뉴</a></li>
				</ul>
			</nav>
			
			<section class="contents">
				<div class="movie-list bg-dark">
					<div class="d-flex justify-content-center pt-2">
						<ul class="nav">
							<li class="nav-items "><a href="#" class="nav-link text-white font-weight-bold text-center">평점순</a></li>
							<li class="nav-items "><a href="#" class="nav-link text-white font-weight-bold text-center">리뷰순 </a></li>
							<li class="nav-items "><a href="#" class="nav-link text-white font-weight-bold text-center">관객수순</a></li>
						</ul>
					</div>
					<div class="poster-box">
						<div class="top-list  align-items-center justify-content-center">
							<div class="frame d-flex justify-content-between flex-wrap">
								
								<c:forEach var="movie" items="${movieList }">
								<div class="poster bg-secondary ml-4 mb-5">
									<img src="${movie.imagePath }" class="w-100 h-100">
								</div>

								</c:forEach>
							</div>
						</div>
					</div>
				</div>
				<div class="movie-review">
					<h4 class="mt-3 ml-4 font-weight-bold">최근 등록된 평점</h4>
					<hr class="mt-3 ml-4">
					
				</div>
			</section>
		</div>
		
			
		<div>
			<c:import url="/WEB-INF/jsp/include/footer.jsp"/>
		</div>
	</div>

</body>
</html>