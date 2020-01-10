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
		response.setHeader("Cache-Control", "no-store,no-cache,must-revalidate");
	//	response.addHeader("Cache-Control", "post-check=0,pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires","0");
		PrintWriter out=response.getWriter();
		 String email=request.getParameter("email");
		 HttpSession session =request.getSession();
		 System.out.println("Session flag---"+session.getAttribute("naresh"));
		 if(session.getAttribute("naresh") == null) {
			 out.println("<div class='container'>");
			 out.println("<h1>please login again</h1>");
			 response.sendRedirect("adminLogin.html");
			 out.println("</div>");
		}
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Admin Section</title>");
		out.println("<link rel='stylesheet' href='bootstrap/css/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='bootstrap/css/nare.css'>");
		out.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>");
		out.println("</head>");
		out.println("<body>");
	
		 String password=request.getParameter("password");
		 if(email.equals("naresh@gmail.com")&&password.equals("naresh123")){
				
				session.setAttribute("name",email);
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
