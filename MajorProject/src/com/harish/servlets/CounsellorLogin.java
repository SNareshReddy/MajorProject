package com.harish.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harish.dao.CounsellorDao;




/**
 * Servlet implementation class CounsellorLogin
 */
@WebServlet("/CounsellorLogin")
public class CounsellorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-store,no-cache,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires","0");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Counsellor Section</title>");
		out.println("<link rel='stylesheet' href='bootstrap/css/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='bootstrap/css/nare.css'>");
		out.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>");
		out.println("</head>");
		out.println("<body>");
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		 
		if(CounsellorDao.authenticate(email, password)){
				HttpSession session=request.getSession();
				session.setAttribute("email",email);	
				request.getRequestDispatcher("navcounsellor.html").include(request, response);
				out.println("<center><h3>you successfully logged In</h3></center>");
				 
				
	}
	else{
			
			out.println("<div class='container'>");
			out.println("<h3>Username or password error</h3>");
			request.getRequestDispatcher("counsellorlogin.html").include(request, response);
			out.println("</div>");
		}
		
	
	
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}


}
