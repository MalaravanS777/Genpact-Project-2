<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.emp.DAO.adminDao" %>
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
		<button onclick="window.print()">print</button>
		<table>
			<thead>
				<tr>
					<th>Role</th>
					<th>Employee Id</th>
					<th>Name</th>
					<th>Date</th>
					<th>Task</th>
					<th>My Associate</th>
					<th>Start Time</th>
					<th>End Time</th>
					<th>Total Time</th>
				</tr>
			</thead>
			<tbody>
				<%
					adminDao adao=new adminDao();
					List<employee> task=null;
					if(task==null){
						task=adao.getAllCustomers();
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
						<td><%= t.getTask() %></td>
						<td><%= t.getMy_associate() %></td>
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