package com.sunbeam.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("ann")
public class AnnounvementServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProcessRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	ProcessRequest(req, resp);
	
	}
	protected void ProcessRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String msg=req.getParameter("ann");
	ServletContext cxt=this.getServletContext();
	cxt.setAttribute("anno",msg);
	resp.sendRedirect("result");
	}
}
