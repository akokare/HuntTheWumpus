<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Sign Up-Hunt The Wumpus</title>
	
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
        <h2>Register</h2>
       	<hr>
    	</div><!--SECTIONHEAD END-->
    	<div class="row">
    		<div class="col-md-6 col-md-offset-3">
    			<form name="signup" method="post" action="SignUp">
    				<div class="form-group">
						<label for="fname">First Name</label>
						<input type="text" class="form-control" id="fname" name="fname" autofocus/>
					</div>
					<div class="form-group">
						<label for="lname">Last Name</label>
						<input type="text" class="form-control" id="lname" name="lname" />
					</div>
    				<div class="form-group">
						<label for="username">User Name</label>
						<input type="text" class="form-control" id="username" name="username"/>
					</div>
					<div class="form-group">
						<label for="email">Email</label>
						<input type="text" class="form-control" id="email" name="email"/>
					</div>
					<div class="form-group">
						<label for="password">Create Password</label>
						<input type="password" class="form-control" id="createPassword" name="createPassword"/>
					</div>
					
					<input type="submit" class="btn btn-default" value="Register"/>
					<button type="submit" class="btn btn-default pull-right">Reset</button>
    			</form>
    		</div>
    	</div>
	</div>
</body>
</html>