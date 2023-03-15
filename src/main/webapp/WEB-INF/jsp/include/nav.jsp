<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="d-flex">
	<nav class="main-menu bg-dark">
		<ul class="nav flex-column mt-4">
			<li class="nav-items bg-secondary"><a href="/movie/home/view" class="nav-link text-white font-weight-bold text-center">영화 홈</a></li>
			<li class="nav-items bg-secondary"><a href="#" class="nav-link text-white font-weight-bold text-center">영화 랭킹</a></li>
			<li class="nav-items bg-secondary"><a href="#" class="nav-link text-white font-weight-bold text-center">평점</a></li>
			<li class="nav-items bg-secondary"><a href="#" class="nav-link text-white font-weight-bold text-center">영화분류</a></li>
			<li class=" nav-items bg-secondary"><a href="#" class="nav-link text-white font-weight-bold text-center" id="admin-menu">관리자 메뉴</a>
				<ul class="d-none adminmenu nav flex-column">
					<li class="nav-items bg-secondary"><a href="/movie/admin/upload/view" class="nav-link text-white font-weight-bold text-center">영화 등록</a></li>
					<li class="nav-items bg-secondary"><a href="/movie/admin/movielist/view" class="nav-link text-white font-weight-bold text-center">영화 관리</a></li>
					<li class="nav-items bg-secondary"><a href="#" class="nav-link text-white font-weight-bold text-center">평점 관리</a></li>
					<li class="nav-items bg-secondary"><a href="#" class="nav-link text-white font-weight-bold text-center">명대사 관리</a></li>
				</ul>
			</li>
		</ul>
	</nav>
	
</div>

<script>
	$(document).ready(function(){
		$("#admin-menu").on("click",function(){
			
			$(this).next("ul").toggleClass("d-none");
				
		});
		
	});

</script>