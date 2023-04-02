<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>movie 회원가입</title>
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
					<div class="mt-4">
						<label>아이디</label>
						<div class="d-flex">
							<input type="text" class="form-control mr-2" id="loginIdInput">
							<button type="button" class="btn btn-dark" id="isduplicateBtn">중복확인</button>
						</div>
						<div class="d-none small text-success" id="availableId">사용 가능한 아이디 입니다.</div>
						<div class="d-none small text-danger" id="duplicateId">중복된 아이디 입니다.</div>
					</div>
					<label  class="mt-3">비밀번호</label>
					<input type="password" class="form-control" id="passwordInput">
					<label class="mt-3">비밀번호 확인</label>
					<input type="password" class="form-control" id="passwordConfirmInput">
					<label class="mt-3">닉네임</label>
					<input type="text" class="form-control" id="nicknameInput">
					<label class="mt-3">이메일</label>
					<input type="text" class="form-control" id="emailInput">
					<button class="btn btn-dark mt-3 btn-block" id="signupBtn">가입하기</button>
				</div>
			</section>
		</div>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp"/>
		
	</div>

	<script>
		$(document).ready(function(){
			
			var isDuplicateCheck = false; // 회원가입 중복체크 눌렀을때 중복체 했는지 안했느지 확인
			var isDuplicateId = true; // 아이디 중복 여부
			
			$("#isduplicateBtn").on("click",function(){
				let id = $("#loginIdInput").val();
				
 				if(id == ""){
					alert("아이디를 입력 하세요.");
					return;
				} 
				
 				$.ajax({
					type:"get"
					, url: "/user/duplicate_id"
					, data:{"loginId":id}
					, success:function(data){
						isDuplicateCheck = true;
						if(data.is_duplicate){ // 중복됐을때
							isDuplicateId = true;
				 			$("#duplicateId").removeClass("d-none");
							$("#availableId").addClass("d-none"); 
						} else{
							isDuplicateId = false;
							$("#duplicateId").addClass("d-none");
							$("#availableId").removeClass("d-none"); 
						}
					}
					, error:function(){
						alert("중복확인 에러");
					}
				}); 
			});
			
			
			
			
			
			
			$("#signupBtn").on("click",function(){
				
				let id = $("#loginIdInput").val();
				let password = $("#passwordInput").val();
				let passwordConfirm = $("#passwordConfirmInput").val();
				let nickname = $("#nicknameInput").val();
				let email = $("#emailInput").val();
				
				if(id == ""){
					alert("아이디를 입력해주세요");
					return;
				}
				
				if(!isDuplicateCheck){
					alert("아이디 중복확인을 해주세요");
					return;
				}
				
				if(isDuplicateId){
					alert("중복된 아이디 입니다");
					return;
				}
				
				if(password ==""){
					alert("비밀번호를 입력해주세요");
					return;
				}
				if(passwordConfirm == ""){
					alert("비밀번호 확인을 입력해주세요")
					return;
				}
				if(password != passwordConfirm){
					alert("비밀번호가 일치하지 않습니다.");
					return;
				}
				if(nickname == ""){
					alert("닉네임을 입력해주세요")
					return;
				}
				
				if(email == ""){
					alert("이메일을 입력해주세요")
					return;
				}
				
				$.ajax({
					type:"post"
					, url : "/user/signup"
					, data :{"loginId":id, "password":password,"nickname":nickname, "email":email}
					, success:function(data){
						if(data.result == "success"){
							location.href = "/user/signin/view";
						} else{
							alert("회원가입 실패");
						}
						
					}
					, error:function(){
						alert("회원가입 에러");
					}
				});
			
				
				
				
			});
			
			
		});
	
	</script>


</body>
</html>