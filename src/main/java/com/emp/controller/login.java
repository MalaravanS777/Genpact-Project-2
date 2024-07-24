package com.emp.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emp.DAO.adminDao;
import com.emp.DAO.associateDao;
import com.emp.DAO.employeeDao;
import com.emp.Model.admin;
import com.emp.Model.associate;
import com.emp.Model.employee;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String role=request.getParameter("role");
		String uname=request.getParameter("uname");
		HttpSession session=request.getSession();
		if(role.equals("admin")){
		String pass=request.getParameter("pass");
		admin ad=new admin();
		ad.setUname(uname);
		ad.setPass(pass);
		
		adminDao adao=new adminDao();
		try {
			ResultSet rs=adao.adminVerify(ad);
			if(rs!=null && rs.next()) {
				response.sendRedirect("admin.jsp");
			}
			else{
				response.sendRedirect("login.jsp");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else if(role.equals("Associate")) {
			int pass=Integer.parseInt(request.getParameter("pass"));
			associate asso=new associate();
			asso.setUname(uname);
			asso.setPass(pass);
			associateDao assdao=new associateDao();
			try {
				ResultSet rs=assdao.assoVerify(asso);
				if(rs!=null && rs.next()) {
					session.setAttribute("as_id", uname);
					session.setAttribute("role", role);
					response.sendRedirect("associate.jsp");
				}
				else {
					response.sendRedirect("login.jsp");
				}
			}
			catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			int pass=Integer.parseInt(request.getParameter("pass"));
			employee emp=new employee();
			emp.setUname(uname);
			emp.setPass(pass);
			employeeDao edao=new employeeDao();
			
			try {
				ResultSet rs=edao.assoVerify(emp);
				if(rs!=null && rs.next()) {
					session.setAttribute("em_id", uname);
					session.setAttribute("role", role);
					session.setAttribute("name",rs.getString(3));
					session.setAttribute("my_as", rs.getString(4));
					System.out.print(uname);
					System.out.println(role);
					System.out.println(rs.getString(3));
					System.out.println(rs.getString(4));
					response.sendRedirect("employee.jsp");
				}
				else {
					response.sendRedirect("login.jsp");
				}
			}
			catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
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
