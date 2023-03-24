<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="d-flex">
	<div class="logo bg-dark d-flex justify-content-center align-items-center pt-3">
		<h1 class="display-5 text-white font-weight-bold">Movie</h1>
	</div>
	<div class="login-menu d-flex align-items-center justify-content-end">
		<div class="login-bar d-flex">
				<c:if test="${not empty userId }">
					<div class="mr-3">${nickName }</div>
					<button class="btn btn-dark"  onclick="location.href='/user/signout/view'">로그아웃</button>
				</c:if>
				<c:if test="${empty userId }">
					<button class="btn btn-sm btn-secondary" onclick="location.href='/user/signin/view'">로그인</button>
				</c:if>
		</div>
			<div class="input-group ml-5 col-3">
						<input type="text" class="form-control">
					 <button class="btn btn-outline-secondary" type="button">검색</button>
			</div>
	</div>
</header>