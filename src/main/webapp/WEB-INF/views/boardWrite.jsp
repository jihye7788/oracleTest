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
	<c:if test="${board == null}">
		<form action="insertBoard" method="post">
	</c:if>
	
	<c:if test="${board != null}">
		<form action="updateBoard" method="post">
		<input type="hidden" value="${board.boardseq}" name="seq">
	</c:if>
	
	<h3>[ BoardTitle ] <input type="text" name="boardtitle" value="${board.boardtitle }"></h3>
	  [ BoardContent ]<br><br>
	  <textarea name ="BoardContent" rows="30" cols="50"></textarea><br>
	  <button>Write</button>	
	</form>
</body>
</html>