package com.emp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.DAO.employeeDao;
import com.emp.Model.employee;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Servlet implementation class insert
 */
@WebServlet("/insert")
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	    public String total_time(String Start_time,String End_time) {
	        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
	        LocalTime startTime = LocalTime.parse(Start_time, timeFormatter);
	        LocalTime endTime = LocalTime.parse(End_time, timeFormatter);

	        // Calculate the duration between the two times
	        Duration duration = Duration.between(startTime, endTime);

	        // Extract hours and minutes from the duration
	        long hours = duration.toHours();
	        long minutes = duration.toMinutes() % 60;

	        // Print the result
	       return (hours+":"+minutes);
	    }
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String em_id=request.getParameter("em_id");
		String role=request.getParameter("role");
		String name=request.getParameter("name");
		String my_as=request.getParameter("my_as");
		String date=request.getParameter("date");
		String task=request.getParameter("task");
		String start_time=request.getParameter("st");
		String end_time=request.getParameter("en");
		String total_time=total_time(start_time,end_time);
		
		employee emp=new employee();
		emp.setEmpid(em_id);
		emp.setRole(role);
		emp.setName(name);
		emp.setMy_associate(my_as);
		emp.setDate(date);
		emp.setTask(task);
		emp.setStart_time(start_time);
		emp.setEnd_time(end_time);
		emp.setTotal_time(total_time);
		
		employeeDao edao=new employeeDao();
		try {
			int rs=edao.addTask(emp);
			if(rs>0) {
				request.setAttribute("em_id",em_id);
				request.setAttribute("role", role);
				request.setAttribute("name", name);
				request.setAttribute("my_as", my_as);
				RequestDispatcher rd=request.getRequestDispatcher("employee.jsp");
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
