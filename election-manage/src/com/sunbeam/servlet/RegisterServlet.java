package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class RegisterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req,HttpServletResponse resp) throws ServletException {
		String firstName=req.getParameter("first_name");
		String lastName=req.getParameter("last_name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String role="voter";
		int status=0;
		String DOB=req.getParameter("dob");
		Date dob= Date.valueOf(DOB);
//		System.out.println(dob);
//		System.out.println(firstName);
		try(UserDao userDao=new UserDaoImpl()){
			User u=new User(firstName,lastName,email,password,dob,status,role);
			int res=userDao.save(u);
			if(res<=1) {
			PrintWriter out= resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Login Failed</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("User registred Successfully!<br/><br/>");
			out.println("<a href='index.html'>Login Again</a>");
			out.println("</body>");
			out.println("</html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
