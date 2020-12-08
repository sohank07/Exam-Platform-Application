<%@page import="com.vwits.DAO.ResultDAO"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="com.vwits.DAO.QuestionsDAO"%>
<%@page import="com.vwits.DAO.UserLogin"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="">
</head>
<body style="background: beige">
	<%
		UserLogin name = new UserLogin();
		String nameOfUser = (String)session.getAttribute("username");

		ResultDAO rd = new ResultDAO();
		ResultSet rs = rd.displayResult();
	%>
	<%!String quesID = null;%>
	<h2 style="text-align: center; color: green;">Result</h2>
	<div class="container" style="top: 5vh;">
		<form method="post" action="teacherhome.jsp">
			<input type="hidden" name="userSession" value="<%=nameOfUser%>">
			<table class="table table-striped table-dark table-hover"
				style="top: 5vh;" border="1" width="50%">
				<thead>
					<tr>
						<td scope="col" align="center">CANDIDATES</td>
						<td scope="col" align="center">MARKS OBTAINED</td>
					</tr>
				</thead>
				<tbody>
					<%
						while (rs.next()) {
					%>

					<tr>
						<td scope="row" align="center"><%=rs.getString(1)%></td>
						<td scope="row" align="center"><%=rs.getString(2)%></td>
					</tr>
					<%
						}
					%>

				</tbody>
			</table>
			<input type="submit" class="btn btn-success btn-block"
				value="Home Page">
		</form>

	</div>



</body>
</html>