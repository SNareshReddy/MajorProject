package com.harish.servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.harish.beans.StudentBean;
import com.harish.dao.StudentDao;



/**
 * Servlet implementation class StudentRegister
 */
@WebServlet("/StudentRegister")
@MultipartConfig(fileSizeThreshold=1024*1024*10,maxFileSize=1024*1024, maxRequestSize=1024*1024*100)
public class StudentRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>StudentRegister</title>");
		out.println("<link rel='stylesheet' href='bootstrap/css/bootstrap.min.cs'>");
		out.println("<link rel='stylesheet' href='bootstrap/css/nare.css'>");
		out.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>");
		out.println("</head>");
		out.println("<body>");
		
		try
		{
			
		String sid=request.getParameter("SID");
		int id=Integer.parseInt(sid);
		String sname=request.getParameter("sname");
		String sfname=request.getParameter("sfname");
		String smname=request.getParameter("smname");
		String address=request.getParameter("address");
		String smobile=request.getParameter("mobile");
		long mobile=Long.parseLong(smobile);
		String whatsappno=request.getParameter("whatsappno");
		long wnumber=Long.parseLong(whatsappno);
		String fm=request.getParameter("sfmobile");
		long fmobile=Long.parseLong(fm);
		String smm=request.getParameter("smmobile");
		long mmobile=Long.parseLong(smm);
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String adhar=request.getParameter("aadhar");
		long aadhar=Long.parseLong(adhar);
		String cgpa=request.getParameter("CGPA");
		String category=request.getParameter("category");
		String branch=request.getParameter("branch");
		String section=request.getParameter("section");
	
		StudentBean bean=new StudentBean(id,sname, sfname, smname, address, mobile, wnumber, fmobile,mmobile, email, password,aadhar,cgpa,category,branch,section);
		StudentDao.save(bean);
		out.print("<h4>Student Registered Successfully</h4>");
		out.print("<h4><a href='studentlogin.html'>Click here</a>to Login</h4>");
		
		
		
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
		}
		
		catch(Exception e){
			System.out.println(e);
		}
		
	
	}
	
}
