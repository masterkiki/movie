<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
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

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">

<link rel="stylesheet" href="/static/css/style.css" type="text/css">
<body class="background">
	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/nav.jsp"></c:import>
		
		<div class="d-flex">
		<div>
			<c:import url="/WEB-INF/jsp/include/header.jsp"/>
					<div class="contents1 bg-white">
						<div class="movie-info pb-4">
							<div class="d-flex justify-content-center">
								<div class="movie-info-box d-flex justify-content-center">
									<div class="d-flex w-50">
										<div class="w-100">
											<div class="display-4 font-weight-bold">${movie.movietitle }</div>
											<hr>
											<div>평점  ★★★★★ 10 </div> 
											<div>내평점 ☆☆☆☆☆  작성하러가기></div>
											<hr>
											<div><b class="mr-2">장르</b>${movie.genre }</div>
											<div><b class="mr-2">국가</b>${movie.country }</div>
											<div> 120분 | ${movie.releasedate } | ${movie.audience}명</div>
											<div><b class="mr-2">감독</b>${movie.director }</div>
											<div><b class="mr-2">출연</b>
											<c:forEach var="actorname" items="${actorList}">
												<span class="small"><a href="${actorname.imagePath }">${actorname.actor}</a></span>
											</c:forEach>
											</div>
										</div>
									</div>
									<div class="movie-poster ">
										<a href="${movie.imagePath }"><img src="${movie.imagePath }" class="w-100 h-100 "></a>
									</div>
								</div>
							</div>
						</div>
						<div class="detail-menu d-flex justify-content-center">
							<ul class="nav ml-3 bg-dark id="menu">
								<li class="nav-items"><a href="/movie/detail/view?movieId=${movie.id }&val=1" name="submenu" class="nav-link text-white" id="1">주요정보</a></li>
								<li class="nav-items"><a href="#" name="submenu" class="nav-link text-white" id="2">배우/제작진</a></li>
								<li class="nav-items"><a href="/movie/detail/view?movieId=${movie.id }&val=3" name="submenu" class="nav-link text-white" id="3">평점</a></li>
								<li class="nav-items"><a href="/movie/detail/view?movieId=${movie.id }&val=4" name="submenu" class="nav-link text-white" id="4">명대사</a></li>
							</ul>
						</div>
						<c:if test="${param.val eq '1' }">
						<div class="ml-3 mt-4 d-flex justify-content-center">
							<div class="main-info">
								<div class="d-flex">
									<div class="movie-story">
									<div class="container mt-2">
										<h4><b>줄거리</b></h4>
										<div class="mt-3">
											${movie.story }
										</div>
									</div>
									</div>
								</div>
								
								<div class="famous-line mt-5">
									<div class="container mt-2">
									<hr>
										<div class="d-flex align-items-center">
											<div class="d-flex align-items-center">
												<h4><b>명대사</b></h4>
											</div>
											<div class="ml-3">
												<button type="button" class="btn btn-white" onclick="location.href='/movie/detail/view?movieId=${movie.id }&val=4'">명대사 쓰기</button>
											</div>
										</div>
											<c:forEach var="moviedetail" items="${famouslineDetailList }" begin="0" end="2" step="1" varStatus="status">
											<!-- 위는 반복문 갯수를 몇개까지 나타낼지 나타내는 사용법 -->
													<div class="actor-famousline d-flex">
														<div class="d-flex left-box align-items-center">
															<div class="actor-image-box bg-secondary"><img src="${moviedetail.imagePath }" class="w-100 h-100"></div>
															<div class="ml-3">
																<div>
																	<b>${moviedetail.famousline }</b>
																</div>
																<div>
																	<span class="text-danger">${moviedetail.charactername }</span>
																	<span class="small">｜${moviedetail.actor } </span>
																	<span class="text-secondary small">｜${moviedetail.explain }</span>
																</div>
															</div>
														</div>
														<div class="right-box">
															<div class="d-flex justify-content-end">
																<div class="d-flex align-items-center">
																	<span class="small">${moviedetail.nickname }</span>
																</div>
																<button type="button" class="likeBtn btn btn-sm btn-secondary ml-2" data-division-id="1" data-row-id="${moviedetail.id }">추천</button>
																<div class="d-flex align-items-center ml-2 text-danger">
																	<span>${moviedetail.likeCount }</span>
																</div>
															</div>
														</div>
													</div>
											</c:forEach>
									<hr>
									</div>
								</div>
								
								<div  class="movie-review">
									<div class="container mt-5">
									<hr>
										<h4><b>평점</b></h4>
									</div>
								</div>
							</div>
						</div>
						</c:if>
						
						
						<!------------------------------------------------------------------------->
						<!------------------------------평점 메뉴----------------------------------->
						<!------------------------------------------------------------------------->
						<c:if test="${param.val == '3'}">
						
						<div class="famousline-page pt-4">
							<div class="d-flex justify-content-center">
								<div>
									<div>
										<h4><b>평점</b></h4>
									</div>

									<br><br>
									
									<div class="d-flex justify-content-between">
										<span>관람객 평점 <b>${fn:length(famouslineList) }</b>건</span>
										<button type="button" class="review-btn btn btn-sm btn-dark" data-toggle="modal" data-target="#moreMenuModal" data-review-id="${movie.id }">내 평점 등록</button>
									</div>
									<hr>
									<c:forEach var="moviedetail" items="${famouslineDetailList }">
									<div class="actor-famousline d-flex">
										<div class="d-flex left-box align-items-center">
											<div class="actor-image-box bg-secondary"><img src="${moviedetail.imagePath }" class="w-100 h-100"></div>
											<div class="ml-3">
												<div>
													<b>${moviedetail.famousline }</b>
												</div>
												<div>
													<span class="text-danger">${moviedetail.charactername }</span>
													<span class="small">｜${moviedetail.actor } </span>
													<span class="text-secondary small">｜${moviedetail.explain }</span>
												</div>
											</div>
										</div>
										<div class="right-box">
											<div class="d-flex justify-content-end">
												<div class="d-flex align-items-center">
													<span class="small">${moviedetail.nickname }</span>
												</div>
												<button type="button" class="likeBtn btn btn-sm btn-secondary ml-2" data-division-id="1" data-row-id="${moviedetail.id }">추천</button>
												<div class="d-flex align-items-center ml-2 text-danger">
													<span>${moviedetail.likeCount }</span>
												</div>
											</div>
											<div class="text-right">
												<span style="font-size:3px;"><fmt:formatDate value="${moviedetail.createdAt }" pattern="yyyy-MM-dd"/></span>
											</div>
										</div>
									</div>
									</c:forEach>
								</div>
							</div>
						</div>
						</c:if>
						
						<!------------------------------------------------------------------------->
						<!------------------------------/평점 메뉴---------------------------------->
						<!------------------------------------------------------------------------->
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						<!------------------------------------------------------------------------->
						<!------------------------------명대사 메뉴----------------------------------->
						<!------------------------------------------------------------------------->
						<c:if test="${param.val == '4'}">
						
						<div class="famousline-page pt-4">
							<div class="d-flex justify-content-center">
								<div>
									<div>
										<h4><b>명대사</b></h4>
									</div>
									<form class="famouslineInput-form">
										<div class="famousline-box d-flex">
											<div class="col-10">
												<select class="form-control" id="actorSelect">
														<option selected value="" value1="">-배우를 선택하세요-</option>
												<c:forEach var="actor" items="${actorDetail}">
														<option value="${actor.castingId }" value1="${actor.id }">${actor.actor }(${actor.charactername })</option>
												</c:forEach>		
												</select>
												
												<input type="text" class="form-control" placeholder="명대사를 입력하세요" id="famouslineInput">
												<input type="text" class="form-control" placeholder="상세 설명을 입력하세요" id="explainInput">
											</div>
											<div class="col-2">
												<input type="button" class="btn btn-dark w-100 h-100" id="famouslineAddBtn" value="등록"></input>
											</div>
										</div>
									</form>
									<br><br>
									
									<div class="d-flex justify-content-between">
										<span>총 <b>${fn:length(famouslineList) }</b>건</span>
										<select>
											<option selected>등록순</option>
											<option>인기순</option>
										</select>
									</div>
									<hr>
									<c:forEach var="moviedetail" items="${famouslineDetailList }">
									<div class="actor-famousline d-flex">
										<div class="d-flex left-box align-items-center">
											<div class="actor-image-box bg-secondary"><img src="${moviedetail.imagePath }" class="w-100 h-100"></div>
											<div class="ml-3">
												<div>
													<b>${moviedetail.famousline }</b>
												</div>
												<div>
													<span class="text-danger">${moviedetail.charactername }</span>
													<span class="small">｜${moviedetail.actor } </span>
													<span class="text-secondary small">｜${moviedetail.explain }</span>
												</div>
											</div>
										</div>
										<div class="right-box">
											<div class="d-flex justify-content-end">
												<div class="d-flex align-items-center">
													<span class="small">${moviedetail.nickname }</span>
												</div>
												<button type="button" class="likeBtn btn btn-sm btn-secondary ml-2" data-division-id="1" data-row-id="${moviedetail.id }">추천</button>
												<div class="d-flex align-items-center ml-2 text-danger">
													<span>${moviedetail.likeCount }</span>
												</div>
											</div>
											<div class="text-right">
												<span style="font-size:3px;"><fmt:formatDate value="${moviedetail.createdAt }" pattern="yyyy-MM-dd"/></span>
											</div>
										</div>
									</div>
									</c:forEach>
								</div>
							</div>
						</div>
						</c:if>
						
						<!------------------------------------------------------------------------->
						<!------------------------------/명대사 메뉴---------------------------------->
						<!------------------------------------------------------------------------->
					</div>
				</div>
			</div>
						<c:import url="/WEB-INF/jsp/include/footer.jsp"/>
		</div>
	
	
	<!-- Modal -->
	<div class="modal fade" id="moreMenuModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered" role="document">
	    <div class="modal-content">
	        	<div class="modal-head bg-dark text-white d-flex pl-3 align-items-center">
		        	<b>
			        	내 평점등록
	        		</b>
	        	</div>
	      <div class="modal-body">
	      
	      	
				<span class="star">
				  ★★★★★
				  <span>★★★★★</span>
				  <input type="range" oninput="drawStar(this)" value="1" step="1" min="0" max="10">
				</span>
	      
	      </div>
	    </div>
	  </div>
	</div>
	
	
	<script>
	
	
	
	function work(){
		var result = confirm("로그인 후 가능합니다. \n로그인창으로 이동하시겠습니까?");
		
		if(result == true){
			location.href="/user/signin/view";
		} else{
			
		}
	}
	
		$(document).ready(function(){
			
			$(document).on("click", function(){
				let reviewId = $(this).data("review-id");
			});
			
			
			$(".likeBtn").on("click",function(){
				let divisionId = $(this).data("division-id");
				let rowId = $(this).data("row-id");
				
				$.ajax({
					data:"get"
					, url:"/like/like"
					, data:{"rowId":rowId , "divisionId":divisionId}
				 	, success:function(data){
				 		if(data.result == "success"){
							location.reload();
				 		} else{
				 			alert("좋아요 실패");
				 		}
				 	}
				 	, error:function(){
				 		work();
				 	}
				});
			
			});
			
			
			$("a[name='submenu']").on("click",function(){
				var getId = $(this).attr("id");
				
				if(getId == 4){
					$(".main-info").addClass("d-none");
					$(".famousline-page").removeClass("d-none");
				}
				
			});
			
			
			
			$("#famousLineBtn").on("click",function(){
				$(".main-info").addClass("d-none");
				$(".famousline-page").removeClass("d-none");
			});
			
			$("#maininfoBtn").on("click",function(){
				$(".famousline-page").addClass("d-none");
				$(".main-info").removeClass("d-none");
			});
			
			
			$(".famouslineInput-form").on("click",function(){
				
				
				
				$.ajax({
					type:"post"
					, url:"/famousline/confirm/signin"
					, data:{}
					, success:function(data){
						if(data.login == "fail"){
							work();
						}
					}
					, error:function(){
						alert("에러");
					}
				});
				
			});
			
			
			
			$("#famouslineAddBtn").on("click",function(){
				let actorIdselect = $("#actorSelect option:selected").attr("value1");
				let castingIdselect = $("#actorSelect option:selected").attr("value");
				let famousline = $("#famouslineInput").val();
				let explain = $("#explainInput").val();
			
				
   				if(actorIdselect == ""){
					alert("배우를 선택해주세요");
					return;
				}
				
				if(famousline == ""){
					alert("명대사를 입력해주세요");
					return;
				}
				if(explain == ""){
					alert("상세 설명을 입력해주세요");
					return;
				}  
				
				 $.ajax({
					type:"post"
					, url:"/famousline/add"
					, data:{"movieId":${movie.id} , "actorId":actorIdselect ,"castingId":castingIdselect, "famousline":famousline, "explain":explain}
				 	, success:function(data){
							if(data.result == "success"){
								location.reload();
							} else{
								alert("명대사 등록 실패");
							}
					}
					, error:function(){
						alert("명대사 등록 에러");
					}
					
				});  
				
			});
			
			
			
		});
	
	</script>
	
</body>
</html>