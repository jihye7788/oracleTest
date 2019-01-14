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
	<form action="goBoardWrite" method="post">
		<button>BoardWrite</button>	
	</form>
	
	<table>
	<tr>
	<td>title</td><td>writer</td><td>hitcount</td><td>date</td>
	</tr>
	
	<c:forEach var="board" items="${bList}">
	<tr>
	<td><a href="boardDetail?boardseq=${board.boardseq}">${board.boardtitle}</a></td>
	<td>${board.id}</td>
	<td>${board.hitcount}</td>
	<td>${board.indate}</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>