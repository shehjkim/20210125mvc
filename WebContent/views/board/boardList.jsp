<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
#tableMenu .row:hover {
	background-color: beige;
}
</style>
<body>
<jsp:include page="../common/menu.jsp" />
	<div align="center">
		<h1>게시글 목록</h1>
		<div>
			<table border="1" id="tableMenu">

				<tr>
					<th width="100">글번호</th>
					<th width="200">제 목</th>
					<th width="100">작성자</th>
					<th width="100">작성일</th>
				</tr>
				<c:forEach var="BoardVO" items="${list }">
					<tr class="row"
						onclick="location.href='/20210125mvc/BoarderRowSelect.do?row='+${BoardVO.boardNo }">
						<td align="center">${BoardVO.boardNo }</td>
						<td>&nbsp;${BoardVO.title }</td>
						<td align="center">${BoardVO.writer }</td>
						<td align="center">${BoardVO.creationDate }</td>
					</tr>
				</c:forEach>

			</table>
		</div>
		<div>
			<button type="button" onclick="location.href='views/board/boardInputform.jsp'">새글쓰기</button>
		</div>
	</div>
</body>
</html>