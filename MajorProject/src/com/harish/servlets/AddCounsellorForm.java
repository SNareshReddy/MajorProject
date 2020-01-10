package com.harish.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddCounsellorForm
 */
@WebServlet("/AddCounsellorForm")
public class AddCounsellorForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		/*if(session.getAttribute("name") == null) {
		 out.println("<div class='container'>");
		 out.println("<h1>please login again</h1>");
		 response.sendRedirect("adminLogin.html");
		 out.println("</div>");
	}*/
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Add Counsellor</title>");
		out.println("<link rel='stylesheet' href='bootstrap/css/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='bootstrap/css/nare.css'>");
		out.println("<link rel='stylesheet' href='bootstrap/css/mybck.css'>");
		out.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>");
		out.println("<script src='bootstrap/js/angularjs.min.js'></script>");
		out.println("</head>");
		out.println("<body>");
		
		request.getRequestDispatcher("navadmin.html").include(request, response);
		out.println("<div ng-app='main' ng-controller='formCtrl' class='container'>");
		request.getRequestDispatcher("addCounsellor.html").include(request, response);
		out.println("</div>");
		
		out.println("<script src='bootstrap/js/jquery.min.js'></script>");
		out.println("<script src='bootstrap/js/bootstrap.min.js'></script>");
		out.println("<script src='bootstrap/js/myjquery.js'></script>");
		out.println("</body>");
		out.print("</html>"); 
		out.close();
		}
	
}
