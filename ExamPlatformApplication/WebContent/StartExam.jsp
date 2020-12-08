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
<title>Exam-Window</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="">
</head>
<body style="background: beige;">
	<%
		UserLogin name = new UserLogin();
		String nameOfUser = (String)session.getAttribute("username");

		QuestionsDAO quest = new QuestionsDAO();
		ResultSet rs = quest.displayQuestions();
		ResultSetMetaData metaData = rs.getMetaData();
	%>
	<%!String quesID = null;%>
	<h2 style="text-align: center; color: green;">Exam Page</h2>
	<div class="container">
	<form method="post" action="ProcessExamServlet">
	<input type="hidden" name="userSession" value="<%=nameOfUser%>">
		<table class="table table-striped table-hover" border="1" width="50%">
			<thead>
				<tr>
					<th scope="col">Question No</th>
					<th scope="col">Question</th>
					<th scope="col">Option A</th>
					<th scope="col">Option B</th>
					<th scope="col">Option C</th>
					<th scope="col">Option D</th>
				</tr>
			</thead>
			<tbody>
				<%
					while (rs.next()) {
				%>
				
				<tr>
					<td scope="row"><%=quesID = (String) rs.getString(1)%></td>
					<td scope="row"><%=rs.getString(2)%></td>
					
						<%
							for (int i = 3; i <= metaData.getColumnCount() ; i++) {
						%>


						<td>
							<div class="form-group">
								<label class="radio-inline"><input class="radio"
									type="radio" name="ans<%=quesID%>"
									value="<%=rs.getString(i)%>"><%=rs.getString(i)%>
								</label>

							</div>
						</td>
						<%
							}
						%>
					
				</tr>
				<%
					}
				%>

			</tbody>
		</table>
		<input type="submit" class="btn btn-success btn-block" value="Submit Exam">
		</form>

	</div>



</body>
</html>