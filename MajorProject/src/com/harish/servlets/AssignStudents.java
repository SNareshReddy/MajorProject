package com.harish.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harish.beans.CounsellorBean;
import com.harish.beans.StudentBean;
import com.harish.dao.CounsellorDao;
import com.harish.dao.StudentDao;

/**
 * Servlet implementation class AssignStudents
 */
@WebServlet("/AssignStudents")
public class AssignStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>ViewCounsellor</title>");
		out.println("<link rel='stylesheet' href='bootstrap/css/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='bootstrap/css/nare.css'>");
		out.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navadmin.html").include(request, response);
		out.println("<div class='container table-responsive'>");
		 
		List<StudentBean> list=StudentDao.view();
		List<CounsellorBean> listc=CounsellorDao.view();
		out.println("<center>");
		out.println("<form action='' method='get'>");
		out.println("<table class='table table-bordered table-striped' style='width:50%'>");
		out.println("<tr style='background-color:#a77d35'><th>Assign</th><th>Id</th><th>Name</th><th>Email</th></tr>");
		for(StudentBean bean:list){
			out.println("<tr><td><input type='checkbox' name='' value=''></td><td>"+bean.getId()+"</td><td>"+bean.getName()+"</td><td>"+bean.getEmail()+"</td></tr>");
		}
		
	
			out.println("<tr>");
			out.println("<td colspan='2'><select id='Select' class='form-control' name='counsellor-name'>");
			for(CounsellorBean beanc:listc){
			out.println("<option>"+beanc.getName()+"</option>");
		}
			out.println("</select></td>");
		
		out.println("<td colspan='2'><input type='submit' class='btn btn-primary' value='Assign'></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</center>");
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
