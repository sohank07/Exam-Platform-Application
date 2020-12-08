<%@page import="com.vwits.DAO.ResultDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String nameOfUser = (String)session.getAttribute("username");

		ResultDAO rd = new ResultDAO();
		ResultSet rs = rd.getSingleResult(nameOfUser);
		ResultSetMetaData metaData = rs.getMetaData();
		
	%>
	
	<h2>Result Page</h2>
	<div class="container">
	<form method="post" action="studenthome.jsp">
	<input type="hidden" name="userSession" value="<%=nameOfUser%>">
		<table class="table" border="1" width="50%">
			<thead>
				<tr>
					<th>User</th>
					<th>Total Marks</th>
				</tr>
			</thead>
			<tbody>
				<%
					while (rs.next()) {
				%>
				
				<tr>
					<td><%=rs.getString(1)%></td>
					<td><%=rs.getString(2)%></td>
					
				</tr>
				<%
					}
				%>

			</tbody>
		</table>
		<input type="submit" class="btn btn-success btn-block" value="Done">
		</form>

	</div>
</body>
</html>