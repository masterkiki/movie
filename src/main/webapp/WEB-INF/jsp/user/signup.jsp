<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>
	<div id=wrap class="justify-content-center">
		<div class="d-flex justify-content-center">
			<section class="d-flex justify-content-center align-items-center">
				<div class="signup-box">
					<h1 class="text-center display-4 font-weight-bold">Movie</h1>
					<div class="mt-4">
						<label>아이디</label>
						<div class="d-flex">
							<input type="text" class="form-control mr-2" id="loginIdInput">
							<button type="button" class="btn btn-dark">중복확인</button>
						</div>
					</div>
					<label  class="mt-3">비밀번호</label>
					<input type="text" class="form-control" id="passwordInput">
					<label class="mt-3">비밀번호 확인</label>
					<input type="text" class="form-control" id="passwordConfirmInput">
					<label class="mt-3">닉네임</label>
					<input type="text" class="form-control" id="nicknameInput">
					<label class="mt-3">이메일</label>
					<input type="text" class="form-control" id="emailInput">
					<button class="btn btn-dark mt-3 btn-block" id="signupBtn">가입하기</button>
				</div>
			</section>
		</div>
		
		<footer class="text-center">
			<div><a class="font-weight-bold text-dark">Movie</a> <a class="small text-secondary">Copyright© Movie All Rights Reserved.</a></div>
		</footer>
		
	</div>

	<script>
		$(document).ready(function(){
			$("#signupBtn").on("click",function(){
				
				alert("버튼작동");
			});
			
			
		});
	
	</script>


</body>
</html>