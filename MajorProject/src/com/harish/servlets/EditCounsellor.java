package com.harish.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harish.beans.CounsellorBean;
import com.harish.dao.CounsellorDao;


/**
 * Servlet implementation class EditCounsellor
 */
@WebServlet("/EditCounsellor")
public class EditCounsellor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Cache-Control", "no-store,no-cache,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires","0");
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String smobile=request.getParameter("mobile");
	
		CounsellorBean bean=new CounsellorBean(id,name, email, password, smobile);
		CounsellorDao.update(bean);
		response.sendRedirect("ViewCounsellor");
	}

}
