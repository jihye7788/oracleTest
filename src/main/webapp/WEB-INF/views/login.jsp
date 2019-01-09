<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="loginUser" method="post">
		ID : <input type="text" name="id" value="${user.id}"><font color="red">${warning}</font><br>
		PW : <input type="text" name="pw" value="${user.pw}"><br>
		<button>login</button>
	</form>
	<form action="goHome" method="post">
		<button>Home</button>
	</form>
</body>
</html>