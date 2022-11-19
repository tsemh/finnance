<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
    <form action="ServletHome" method="get">
        <label for="User">User</label>
        <input type="number" name="User" required oninvalid="this.setCustomValidity('Campo')">
        <label for="Account">Account</label>
        <input type="number" name="Account">
      	<input type="submit" value="login">   
    </form>
</body>
</html>
