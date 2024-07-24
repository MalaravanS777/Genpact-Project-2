<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.emp.DAO.employeeDao" %>
    <%@page import="java.util.List" %>
    <%@page import="com.emp.Model.employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
	<form action="insertPage" method="post">
	<%String em_id=(String)session.getAttribute("em_id"); 
	String role=(String)session.getAttribute("role");
	String name=(String)session.getAttribute("name");
	String my_as=(String)session.getAttribute("my_as");%>
	<button type="submit">Add Task</button>
	</form>
	</div>
	<div>
	<button onclick="window.print()">print</button>
		<table>
			<thead>
				<tr>
					<th>Role</th>
					<th>Employee Id</th>
					<th>Name</th>
					<th>Date</th>
					<th>My Associate</th>
					<th>Task</th>
					<th>Start Time</th>
					<th>End Time</th>
					<th>Total Time</th>
				</tr>
			</thead>
			<tbody>
				<%
					employeeDao edao=new employeeDao();
					List<employee> task=null;
					employee emp=new employee();
					if(task==null){
						task=edao.getAllCustomers(emp);
					}
					int i=1;
					for(employee t:task){
						
				%>
				
					<tr>
						<td><%= i++ %></td>
						<td><%= t.getRole()%></td>
						<td><%= t.getEmpid() %></td>
						<td><%= t.getName() %></td>
						<td><%= t.getDate() %></td>
						<td><%= t.getMy_associate() %></td>
						<td><%= t.getTask() %></td>
						<td><%= t.getStart_time() %></td>
						<td><%= t.getEnd_time() %></td>
						<td><%= t.getTotal_time() %></td>
						
						
					</tr>
				
				<%
					}
				%>
			</tbody>
		</table>
	</div>
</body>

</html>