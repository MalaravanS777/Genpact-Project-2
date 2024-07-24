package com.emp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class insert
 */
@WebServlet("/insertPage")
public class insertPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String em_id=request.getParameter("em_id");
		String role=request.getParameter("role");
		String name=request.getParameter("name");
		String my_as=request.getParameter("my_as");
		request.setAttribute("em_id", em_id);
		request.setAttribute("role", role);
		request.setAttribute("name", name);
		request.setAttribute("my_as",my_as);
		System.out.print(em_id);
		System.out.println(role);
		System.out.println(name);
		System.out.println(my_as);
		RequestDispatcher rd=request.getRequestDispatcher("insert.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
