<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
<body class="background">
	<div id="wrap">
		<div class="d-flex">	
			<c:import url="/WEB-INF/jsp/include/nav.jsp"/>
			<div>
				<c:import url="/WEB-INF/jsp/include/header.jsp"/>
				<div class="d-flex justify-content-center bg-white">
					<section class="contents">
						<div class="movie-list bg-dark">
							<div class="d-flex justify-content-center pt-2">
								<ul class="nav">
									<li class="nav-items "><a href="#" class="nav-link text-white font-weight-bold text-center">평점순</a></li>
									<li class="nav-items "><a href="#" class="nav-link text-white font-weight-bold text-center">리뷰순 </a></li>
									<li class="nav-items "><a href="#" class="nav-link text-white font-weight-bold text-center">관객수순</a></li>
								</ul>
							</div>
							<div class="poster-box pl-5">
								<div class="top-list  align-items-center justify-content-center">
									<div class="frame d-flex flex-wrap">
										
										<c:forEach var="movie" items="${movieList }"  begin="0" end="9" step="1" varStatus="status">
										<div class="poster bg-secondary ml-4 mb-5">
											<a href="/movie/detail/view?movieId=${movie.id }&val=1"><img src="${movie.imagePath }" class="w-100 h-100"> </a>
										</div>
		
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
						<div class="d-flex justify-content-center">
							<div class="movie-review">
								<h4 class="mt-3 ml-4 font-weight-bold">최근 등록된 평점</h4>
								<hr class="mt-3">
								<c:forEach var="reviewhome" items="${reviewHomeList }">
										<div class="actor-famousline1 d-flex mt-2">
											<div class=" left-box align-items-center"> 
												<div class="d-flex">
													<div class="movie-image-box"><img src="${reviewhome.imagePath }" class="w-100 h-100"></div>
													<div class="ml-3">
														<div>
															<span style="font-size:20px;" class="text-info"><b>${reviewhome.movietitle }</b></span>
														</div>
														<div>
															<c:choose> 
															    <c:when test="${reviewhome.point eq 5}">
																		<span class="text-danger">★★★★★</span><span class="text-secondary"></span>
															    </c:when>
															    <c:when test="${reviewhome.point eq 4}">
																		<span class="text-danger">★★★★</span><span class="text-secondary">★</span>
															    </c:when>
															    <c:when test="${reviewhome.point eq 3}">
																		<span class="text-danger">★★★</span><span class="text-secondary">★★</span>
															    </c:when>
															    <c:when test="${reviewhome.point eq 2}">
																		<span class="text-danger">★★</span><span class="text-secondary">★★★</span>
															    </c:when>
															    <c:otherwise>
															        <span class="text-danger">★</span><span class="text-secondary">★★★★</span>
															    </c:otherwise> 
															</c:choose>
														</div>
														<div>
															<span>${reviewhome.review }</span>
														</div>
														<div>
															<span style="font-size:13px;" class="text-secondary">${reviewhome.nickname }</span>
															<span style="font-size:13px;" class="text-secondary ml-2"><fmt:formatDate value="${reviewhome.createdAt }" pattern="yyyy. MM. dd HH:mm "/></span>
														</div>
													</div>
												</div>
											</div>
										</div>
								</c:forEach>
							</div>
						</div>
						<div>
						</div>
					</section>
				</div>
			</div>
		</div>
							<c:import url="/WEB-INF/jsp/include/footer.jsp"/>
		
			
	</div>

</body>
</html>