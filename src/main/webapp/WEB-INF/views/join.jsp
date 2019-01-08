<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<form action="insertUser" method="post">
	ID : <input type ="text" name = "id" value="${User.id}"><font color="red">${warning}</font><br><!-- name을 vo와 맞춰주면 좋다.  -->
	PW : <input type="password" name = "pw" value="${User.pw}"><br>
	NAME : <input type="text" name = "name" value="${User.name}"><br>
	PHONE : <input type="number" name = "phone" value="${User.phone}"><br>
	EMAIL : <input type="text" name = "email" value="${User.email}"><br>
	BIRTHDATE : <input type="text" name = "birthdate" value="${User.birthdate}"><br>	
	<input type="submit" value="JOIN"> 
	</form>
	
	<form action="goHome" method="post">
		<button>Home</button>
	</form>
</body>
</html>
