<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화디테일</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<link rel="stylesheet" href="/static/css/style.css" type="text/css">
<body>
	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/header.jsp"/>
		<div class="d-flex">
			<c:import url="/WEB-INF/jsp/include/nav.jsp"></c:import>
			<div>
				<div class="movie-info d-flex">
					<div class="movie-poster d-felx text-center">
						<img src="${movie.imagePath }" class="w-75 h-75 mt-3">
					</div>
					<div class="d-flex align-items-center">
						<div class="info-detail">
							<div><b>${movie.movietitle }</b></div>
							<div>평점  ★★★★★ 10     내평점 ☆☆☆☆☆  작성하러가기></div>
							<div>${movie.genre } | ${movie.country } | 120분 | ${movie.releasedate } | ${movie.audience}명</div>
							<div class="d-flex">
								<div><b class="mr-2">감독</b>${movie.director }</div>
								<div class="ml-3"><b class="mr-2">배우</b>${actor.actor }</div>
							</div>
						</div>
					</div>
				</div>
				<hr class="ml-3">
				<div class="ml-3">
					<div class="d-flex">
						<div class="movie-story">
						<div class="container mt-2">
							<h2><b>줄거리</b></h1>
							<div class="mt-3">
								${movie.story }
							</div>
						</div>
						</div>
						<div class="famous-line">
							<div class="container mt-2">
									<h2><b>명대사</b></h2>
							</div>
						</div>
					</div>
					
					<div  class="movie-review">
						<div class="container mt-4">
							<h2><b>평점</b></h2>
						</div>
					</div>
				</div>
				
			</div>
		</div>
		<c:import url="/WEB-INF/jsp/include/footer.jsp"/>
	</div>
	
</body>
</html>