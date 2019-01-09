<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${sessionScope.loginId!=null}">
	<h2>${sessionScope.loginId}님 환영합니다;)</h2>
			<form action="logout" method="get">
			<button>logout</button>
	</form>
	</c:if>
	
	<c:if test="${sessionScope.loginId==null}">
		<form action="goLogin" method="post">
			<button>login</button>
		</form>
	</c:if>
	
	<form action="goBoard" method="post">
		<button>Board</button>
	</form>
	
	<form action="goJoin" method="post">
		<button>Join</button>
	</form>
	
</body>
</html>