<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="proj.vo.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% ArrayList<Student> list = (ArrayList<Student>) request.getAttribute("list");
	if(!list.isEmpty()){ %>
		<table border="1">
			<tr><th>id</th><th>이름</th></tr>
		
		<% for(int i=0;i<list.size();i++){
			Student student = list.get(i); %>
			
		<tr><td><%= student.getId() %></td>
			<td><%= student.getName() %></td>
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