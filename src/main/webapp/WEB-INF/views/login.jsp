<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
		ID : <input type="text" name="id"><font color="red">${warning}</font><br>
		PW : <input type="text" name="pw"><br>
		<button>login</button>
	</form>
	<form action="goHome" method="post">
		<button>Home</button>
	</form>
</body>
</html>