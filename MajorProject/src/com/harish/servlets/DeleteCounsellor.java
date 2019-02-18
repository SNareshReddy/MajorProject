package com.harish.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harish.dao.CounsellorDao;


/**
 * Servlet implementation class DeleteCounsellor
 */
@WebServlet("/DeleteCounsellor")
public class DeleteCounsellor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String sid=request.getParameter("id");
			int id=Integer.parseInt(sid);
			CounsellorDao.delete(id);
			response.sendRedirect("ViewCounsellor");
		}
	}

