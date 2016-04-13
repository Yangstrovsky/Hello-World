<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.object.User"%>
<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>
</head>
<body>

	<%
		if (request.getAttribute("flag").equals("0")) {
	%>
	<h1>${request.getAttribute("info")}</h1>
	<%
		}
		else {
			List<User> list = (List<User>) request.getAttribute("result");
			Iterator<User> iter = list.iterator();
	%>
	<table >
	<tr>
		<td>ID</td>
		<td>NAME</td>
		<td>PHONE NUMBER</td>
		<td>ADDRESS</td>
	</tr>
		<%
			while (iter.hasNext()) {
				User user=iter.next();
				System.out.println("user.getId()="+user.getId());
				System.out.println("user.getName()="+user.getName());
				System.out.println("user.getPhone()="+user.getPhone());
				System.out.println("user.getAddress()="+user.getAddress());
				System.out.println("准备输出表格！");
		%>
		<tr>
		<td><%=user.getId() %></td>
		<td><%=user.getName() %></td>
		<td><%=user.getPhone() %></td>
		<td><%=user.getAddress() %></td>
		</tr>
		<%
			}
		%>

	</table>
	<%
		}
	%>
</body>
</html>