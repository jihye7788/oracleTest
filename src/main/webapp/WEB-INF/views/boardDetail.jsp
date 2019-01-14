<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
</head>
<body>	
	<c:if test="${sessionScope.loginIn==board.id}">
		<div style="width:100%;">
			
		<form action ="deleteBoard" method="post">
			<input type="hidden" name="boardseq" value="${board.boardseq}">
			<input type="submit" value="delete">
		</form>
		</div>
		
		<div style="width:500%;">	
		<form action ="updateBoard" method="post">
			<input type="hidden" name="boardSeq" value="${board.boardseq}">
			<input type="submit" value="update">
		</form>
		</div>
	</c:if>
	
	<form action="boardDetail" method="get">
		<table>
		<tr><td> title :</td><td> ${board.boardtitle}</td></tr>
		<tr><td> date :</td><td> ${board.indate}</td></tr>
		<tr><td> hitcount :</td><td>${board.hitcount}</td></tr>
		</table>
	<br><hr>
	<div>${board.boardcontent}</div>
	</form>
	
	<form action="insertComment" method="post">
		<input type="hidden" name = "boardseq" value="${board.boardseq}">
		<input type="text" name="comments">
		<button>Comments</button>
	</form>
	
	<form action="selectCommentList" method="get">
		<table>
		<c:forEach var="Comment" items="${cList}">
		<tr><td>${Comment.id}</td><td> ${Comment.comments}</td><td><${Comment.indate}</td></tr>
		</c:forEach>
		</table>
	</form>
	
	<form action="goBoard" method="post">
		<button>Board</button>
	</form>
	
	<form action="goHome" method="post">
		<button>Home</button>
	</form>
	
	
</body>
</html>
