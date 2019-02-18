package com.harish.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harish.beans.StudentBean;
import com.harish.dao.StudentDao;

/**
 * Servlet implementation class ViewStudents
 */
@WebServlet("/ViewStudents")
public class ViewStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>ViewStudents</title>");
		out.println("<link rel='stylesheet' href='bootstrap/css/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='bootstrap/css/nare.css'>");
		out.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navstudent.html").include(request, response);
		out.println("<div class='container table-responsive role=main'>");
		out.println("<div class='row'>");
		out.println("<div class='col-sm-8'>");
		out.println("<div class='row'>");
		out.println("<div class='col-sm-4'>");
		out.println("<div class='row'></div>"); 
		out.println("<img src='images/download.jpg' class='img-responsive'>"); 
		out.println("<img src='images/download.jpg' class='img-responsive'>");
		out.println("<img src='images/download.jpg' class='img-responsive'>");
		out.println("<img src='images/download.jpg' class='img-responsive'>");
		out.println("<img src='images/download.jpg' class='img-responsive'>");
		out.println("<div class='row'></div>");
		out.println("<div class='row'></div>");
		out.println("</div>");
		out.println("<div class='col-sm-6'>");
		List<StudentBean> list=StudentDao.view();
		out.println("<table class='table table-bordered table-striped' style='width:80%'>");
		

		
		
		out.println("<tr style='background-color:#8e00ff'><th>Id</th><th>Name</th><th>Email</th><th>Counsellor</th></tr>");
		for(StudentBean bean:list){
			out.println("<tr><td>"+bean.getId()+"</td><td>"+bean.getName()+"</td><td>"+bean.getEmail()+"</td><th></th></tr>");
		}
		out.println("</table>");
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
		out.println("<div class='col-sm-4' style='text-align:left'>");
		out.println("<div class='row'></div>"); 
		out.println("<img src='images/aside.jpg' class='img-responsive'>"); 
		out.println("<img src='images/aside.jpg' class='img-responsive'>");
		out.println("<div class='row'></div>");
		out.println("<div class='row'></div>");
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}


}
