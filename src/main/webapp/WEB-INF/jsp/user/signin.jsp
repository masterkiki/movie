<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>movie 로그인</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>
		<div id=wrap class="justify-content-center">
		<div class="d-flex justify-content-center">
			<section class="sign d-flex justify-content-center align-items-center">
				<div class="signup-box">
					<h1 class="text-center display-4 font-weight-bold">Movie</h1>
					
					<div class="login-range d-flex justify-content-center align-items-center mt-4">
						<form id="loginForm" class="login-box">
							<div class="mt-4">
								<label>아이디</label>
								<div class="d-flex">
									<input type="text" class="form-control mr-2" id="loginIdInput">
								</div>
							</div>
							<label  class="mt-3">비밀번호</label>
							<input type="password" class="form-control" id="passwordInput">
							<button class="btn btn-dark mt-4 btn-block" id="signinBtn">로그인</button>
						</form>
					
					</div>
					<div class="text-center small mt-2">
						<a href="#" class="text-secondary">아이디 찾기</a> | <a href="#" class="text-secondary">비밀번호 찾기</a> | <a href="/user/signup/view" class="text-secondary">회원가입</a>
					</div>
					
					
				</div>
			</section>
		</div>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp"/>

		<script>
			$(document).ready(function(){
				$("#loginForm").on("submit", function(e){
					//$("#signinBtn").on("click", function(){
						
					// 해당 이벤트의 기능을 모두 취소한다
					e.preventDefault();
					
					let loginId = $("#loginIdInput").val();
					let password = $("#passwordInput").val();
					
					if(loginId == ""){
						alert("아이디를 입력하세요");
						return;
					} 
					
					if(password == ""){
						alert("비밀번호를 입력하세요");
						return;
					}
					
					
					$.ajax({
						type:"post"
						, url:"/user/signin"
						, data:{"loginId":loginId, "password":password}
						, success:function(data){
							if(data.result == "success"){
								location.href = "/movie/home/view";
							} else{
								alert("아이디 비밀번호를 확인해주세요");
							}
							
						}
						, error:function(){
							alert("로그인 에러");
						}
						
						
					
					});
					
				});
					
			});
		</script>



</body>
</html>