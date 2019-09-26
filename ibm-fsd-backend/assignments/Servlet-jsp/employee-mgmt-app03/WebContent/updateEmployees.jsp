<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee</title>
</head>
<body>
	<!-- http://localhost:8080/employee-mgmt-app03/updateEmployee.do -->
	<form action="updateEmployee.do" method="post">
		<label>Id </label> <input type= "number" name="id" /> <br>
		<label>Name: </label> <input name="name" /> <br>
		<label>Age: </label> <input name="age" /> <br>
		<label>Designation: </label> <input name="designation" /> <br>
		<label>Department: </label> <input name="department" /> <br>
		<label>Country: </label> <input name="country" /> <br>
		
		<button type="submit">Change</button> &nbsp; <button type="reset">Reset</button>
	</form>
</body>
</html >