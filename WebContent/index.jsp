<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Data</title>
</head>
<style>
div.ex {
	text-align: right width:300px;
	padding: 10px;
	border: 5px solid grey;
	margin: 0px
}
.footer {
   position: fixed;
   left: 0;
   bottom: 0;
   width: 100%;
   background-color: #DE6E56;
   color: white;
   border: 5px solid grey;
   text-align: center;
}
</style>
<body>
	<h1>Employee Registration Form - Fineshift</h1>
	<div class="ex">
		<form action="registrationController" method="post">
			<table style="with: 50%">
				<tr>
					<td>Employee Name</td>
					<td><input type="text" name="fullname"/></td>
				</tr>
				<tr>
					<td>Employee Address</td>
					<td><input type="text" name="address"/></td>
				</tr>
				<tr>
					<td>Employee Age</td>
					<td><input type="text" name="age"/></td>
				</tr>
				<tr>
					<td>Employee Qualification</td>
					<td><input type="text" name="qual"/></td>
				</tr>
				<tr>
					<td>Employee Performance</td>
					<td><input type="text" name="percent"/></td>
				</tr>
				<tr>
					<td>Joining Date</td>
					<td><input type="text" name="yop"/></td>
				</tr>
			</table>
			<input type="submit" value="register"/>
		</form>
	</div>
	<div class="footer">
  	 	<p>Author: Jenkins CI/CD <br>
  		<a href="mailto:madhavmahamuni@fineshift.com">madhavmahamuni@fineshift.com</a>
		</p>
	</div>

</body>
</html>
