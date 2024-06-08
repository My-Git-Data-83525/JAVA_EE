package com.sunbeam.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;

public class RegisterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	protected void processRequest(HttpServletRequest req,HttpServletResponse resp) throws ServletException {
		String firstName=req.getParameter("first_name");
		String lastName=req.getParameter("last_name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String role=req.getParameter("role");
		String DOB=req.getParameter("dob");
		Date dob= Date.valueOf(DOB);
		System.out.println(dob);
		System.out.println(first);
		try(UserDao userDao=new UserDaoImpl()){
			User user=userDao.save()
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
