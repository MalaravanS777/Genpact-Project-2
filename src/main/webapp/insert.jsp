<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>

<form action="insert" method="post">
<input type="hidden"  name="em_id" value=${em_id} />
	<input type="hidden"  name="role" value=${role} />
	<input type="hidden"  name="name" value=${name} />
	<input type="hidden"  name="my_as" value=${my_as} />
<table>
	
	
	<tr>
	<td><label for="task">Task</label></td>
	<td><input type="text" id="task" name="task" /></td>
	</tr>
	
	<tr>
	<td><label for="date">Date</label></td>
	<td><input type="date" id="date" name="date" /></td>
	</tr>
	
	<tr>
	<td><label for="st">Start Time</label></td>
	<td><input type="time" id="st" name="st" /></td>
	</tr>
	
	<tr>
	<td><label for="en">End Time</label></td>
	<td><input type="time" id="en" name="en" /></td>
	</tr>
	
	<tr>
	<td colspan=2 align="center"><button type="submit">Add</button></td>
	</tr>
</table>
</form>

</div>

</body>
</html>