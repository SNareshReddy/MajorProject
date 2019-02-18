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
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Admin Section</title>");
		out.println("<link rel='stylesheet' href='bootstrap/css/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='bootstrap/css/nare.css'>");
		out.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>");
		out.println("</head>");
		out.println("<body>");
		 String email=request.getParameter("email");
		 String password=request.getParameter("password");
		 if(email.equals("naresh@gmail.com")&&password.equals("naresh123")){
			 HttpSession session=request.getSession();
			 session.setAttribute("naresh", "true");
			 request.getRequestDispatcher("navadmin.html").include(request, response);
			 request.getRequestDispatcher("Carousel.html").include(request, response);

			
		 }
		 
		 else{
			 out.println("<div class='container'>");
			 out.println("<h1>Username or password error</h1>");
			 request.getRequestDispatcher("adminLogin.html").include(request, response);
			 out.println("</div>");
		 }
		 request.getRequestDispatcher("footer.html").include(request, response);
			out.close();
	}

}
