<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="login" method="post">
<table>
<tr>
		<td><label for="uname">User Name</label></td>
		<td><input type="text" id="uname" name="uname" required/>
</tr>
<tr>
		<td><label for="pass">Password</label>
		<td><input type="text" id="pass" name="pass" required/></td>
</tr>
<tr>
		<td><label for="role">Role</label></td>
		<td><select name="role" required="required">
				<option value="">Select an option</option>
				<option value="Admin">Admin</option>
				<option value="Associate">Associate</option>
				<option value="Employee">Employee</option>
		</select>
		</td>
</tr>
<tr>
		<td colspan=2 align="center"><button type="submit">Verify</button></td>
</tr>
</table>
</form>
</body>
</html>