<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../common/menu.jsp"></jsp:include>
	<div align="center">
		<div>
			<h1>게시글 상세보기</h1>
		</div>
		<div>
		<form id = "frm" name="frm" action="/20210125mvc/BoardUpdateSave.do" method="post">
			<table border="1">
				<tr>
					<th id="tdMenu" width="100">글번호</th>
					<td align="center" width="50">
					<input type="text" id="no" name="no" value="${vo.boardNo }" readonly></td>
					<th id="tdMenu" width="100">작성자</th>
					<td align="center" width="150">${vo.writer }</td>
					<th id="tdMenu" width="110">작성일자</th>
					<td width="110" width="150">${vo.creationDate }</td>
				</tr>
				<tr>
					<th id="tdMenu" width="100">제목</th>
					<td colspan="5"><input type="text" id="title" name="title" value="${vo.title }" size="95"></td>
				</tr>
				<tr>
					<th id="tdMenu" width="100">내용</th>
					<td colspan="5"><textarea rows="7" cols="90" id="content" name="content" size="85">${vo.content }</textarea></td>
				</tr>
			</table><br/>
				<input type="submit" value="수정">&nbsp;&nbsp;&nbsp;
				<input type="button" value="목록보기" onclick="location.href='/20210125mvc/BoardList.do'">
			</form>
		</div><br/>
	</div>
</body>
</html>