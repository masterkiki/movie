<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="d-flex">
	<div class="login-menu d-flex align-items-center justify-content-end">
		<div class="login-bar d-flex align-items-center">
				<c:if test="${not empty userId }">
					<div class="mr-3">${nickName }</div>
					<button class="btn btn-sm btn-dark"  onclick="location.href='/user/signout/view'">로그아웃</button>
				</c:if>
				<c:if test="${empty userId }">
					<button class="btn btn-sm btn-secondary" onclick="location.href='/user/signin/view'"><b>로그인</b></button>
				</c:if>
		</div>
			<div class="input-group ml-5 col-3">
						<input type="text" class="form-control">
					 <button class="btn btn-outline-secondary bg-secondary text-white" type="button">검색</button>
			</div>
	</div>
</header>