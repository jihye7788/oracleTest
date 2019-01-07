<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<form action="insertUser" method="post">
	ID : <input type ="text" name = "id"><br><!-- name을 vo와 맞춰주면 좋다.  -->
	PW : <input type="text" name = "pw"><br>
	<input type="submit" value="JOIN"> 
	</form>
</body>
</html>
