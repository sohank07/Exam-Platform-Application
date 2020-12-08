<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Insert title here</title>
</head>
<body>
	<section class="container-fluid bg">
		<section class="row justify-content-center">
			<section class="col-12 col-sm-6 col-md-3">
				<form class="form-container" action="update">
					<h2 style="text-align: center; font-weight: bold; font-size: 30px">Profile Update</h2>
					<div class="form-group">
						<label>ID</label> <input
							type="text" class="form-control" name="id"> 
					</div>
					<div class="form-group">
						<label>Username</label> <input
							type="text" class="form-control" name="username"> 
					</div>
					<div class="form-group">
						<label>Password</label> 
						<input type="password" class="form-control" name="password">
					</div>
					
					<div class="form-group">
						<label>Email</label> 
						<input type="text" class="form-control" name="email">
					</div>
					<button type="submit" class="btn btn-primary btn-block">Submit</button>
				</form>
				
			</section>
		
		</section>
	
	</section>
	
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
	
	
</body>
</html>