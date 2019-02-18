package com.harish.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class UploadVideos
 */
@WebServlet("/UploadVideos")
public class UploadVideos extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Add Counsellor</title>");
		out.println("<link rel='stylesheet' href='bootstrap/css/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='bootstrap/css/nare.css'>");
		out.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>");
		out.println("</head>");
		out.println("<body>");    
		MultipartRequest m=new MultipartRequest(request,"d:/new");  
		request.getRequestDispatcher("navcounsellor.html").include(request, response);
		out.print("<h3>successfully uploaded</h3>");

		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
