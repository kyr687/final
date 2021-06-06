<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="proj.vo.Subject" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% ArrayList<Subject> list = (ArrayList<Subject>) request.getAttribute("list");
	if(!list.isEmpty()){ %>
		<table border="1">
			<tr><th>과목번호</th><th>과목명</th><th>최대인원</th><th>수강인원</th></tr>
		
		<% for(int i=0;i<list.size();i++){
			Subject subject = list.get(i); %>
			
		<tr><td><%= subject.getId() %></td>
			<td><%= subject.getName() %></td>
			<td><%= subject.getCount() %></td>
		</tr>			
	<% }
	}else{
		out.print("<h4>등록된 회원정보가 없습니다.</h4>");
		}
		%>
	</table>
	<%@ include file="home.jsp"%>

</body>
</html>