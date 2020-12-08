<%@page import="com.vwits.DAO.UserLogin"%>
<%@page import="javax.websocket.SendResult"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teacher Home Page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
</head>
<style>
</style>
<body style="background: beige">
	<%! HttpSession session; %>

	<%
	session = request.getSession(false); //Do not create new session
	String msg = (String) session.getAttribute("username");
	String msg2 = (String) session.getAttribute("message");
	if(msg != null){
		out.println("<h3 style='text-align: center'>Welcome " + msg +"</h3>");
	}else if(msg == null){
		response.sendRedirect("index.jsp");
	}
	
	if(msg2 != null){
		out.println(msg2);
	}

%>

	<section class="container-fluid bg">
		<section class="row justify-content-center">
			<section class="col-12 col-sm-6 col-md-3">

				<form class="form-container">
					<h2 style="text-align: center; font-weight: bold; font-size: 30px">Teacher Home Page
					</h2>
					<div class="form-group">
						<input type="submit" class="btn btn-primary btn-block"
							value="Add Question" name="updateexam">
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary btn-block"
							value="Edit Question" name="editexam">
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary btn-block"
							value="Show Result" name="result"><br>
					</div>
					<div class="form-group">
						<p style="text-align: center">
							<a href="LogoutServlet">Logout</a>
						</p>
					</div>
			
					<div class="form-group">
						<p style="text-align: center">
							<%
									String buttonClicked = request.getParameter("updateexam");
									if(buttonClicked != null){
										request.setAttribute("user", session.getAttribute("username"));
										request.setAttribute("id", session.getId());
										RequestDispatcher rd = request.getRequestDispatcher("Question.jsp");
										rd.forward(request, response); 
										 
									}						
									%>
			
							<%
									String res = request.getParameter("result");
									if(res != null){
										request.setAttribute("user", session.getAttribute("username"));
										request.setAttribute("id", session.getId());
										RequestDispatcher rd = request.getRequestDispatcher("ResultForTeacher");
										rd.forward(request, response); 
										 
									}
							%>
							
							<%
									String buttonClicked1 = request.getParameter("editexam");
									if(buttonClicked1 != null){
										request.setAttribute("user", session.getAttribute("username"));
										request.setAttribute("id", session.getId());
										RequestDispatcher rd = request.getRequestDispatcher("QuestionEdit.jsp");
										rd.forward(request, response);  
									}						
									%>
						
					</div>
				</form>
			</section>
		</section>
	</section>	

</body>
</html>
