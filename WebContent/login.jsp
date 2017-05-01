<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login-Hunt The Wumpus</title>
	
	<!-- ===========================
    STYLESHEETS
    =========================== --> 
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/responsive.css">
    <link rel="stylesheet" href="css/animate.css">
    
    <!-- ===========================
    FONTS
    =========================== -->
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,900,600|Pacifico' rel='stylesheet' type='text/css'>
</head>
<body>
<div id="products" class="container">
	
	<!--SECTIONHEAD START-->
    <div class="sectionhead text-center">
        <h2>Login</h2>
        <hr>
    </div><!--SECTIONHEAD END-->
	
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<form name="login" method="post" action="Login" enctype="multipart/form-data">
				<div class="form-group">
					<label for="uname">User Name</label>
					<input type="text" class="form-control" id="uname" name="uname" autofocus>
				</div>
				<div class="form-group">
					<label for="">Password</label>
					<input type="password" class="form-control" id="password" name="password"/>
				</div>
				<input type="submit" class="btn btn-default" value="Login"/>
				<input type="submit" class="btn btn-default" value="Not a User Yet?"/>
			</form>
		</div>
	</div>
</div>
</body>
</html>