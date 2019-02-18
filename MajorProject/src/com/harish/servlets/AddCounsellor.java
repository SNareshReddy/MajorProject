package com.harish.servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harish.beans.CounsellorBean;
import com.harish.dao.CounsellorDao;



/**
 * Servlet implementation class AddCounsellor
 */
@WebServlet("/AddCounsellor")
public class AddCounsellor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Add Counsellor</title>");
		out.println("<link rel='stylesheet' href='bootstrap/css/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='bootstrap/css/nare.css'>");
		out.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>");
		out.println("</head>");
		out.println("<body>");
		
		request.getRequestDispatcher("navadmin.html").include(request, response);
		out.println("<div class='container'>");
		String cid=request.getParameter("ID");
		int id=Integer.parseInt(cid);
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String smobile=request.getParameter("mobile");
		long mobile=Long.parseLong(smobile);
		CounsellorBean bean=new CounsellorBean(id, name, email, password, mobile);
		try {
		if(CounsellorDao.save(bean) >0)
		out.print("<h4>Counsellor added successfully</h4>");
		request.getRequestDispatcher("addCounsellor.html").include(request, response);
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		out.close();
	}

}
