package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
//		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req, resp);

	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String email = req.getParameter("email");
		String passwd = req.getParameter("passwd");
		try (UserDao userDao = new UserDaoImpl()) {
			User user = userDao.findByEmail(email);
			Cookie ck=new Cookie("uname",user.getFirstName());
			resp.addCookie(ck);
			HttpSession session=req.getSession();
			session.setAttribute("curr", user);
			if (user != null && user.getPassword().equals(passwd)) {
				System.out.println("Login Successful :" + user);
				if (user.getRole().equals("voter")) {
					resp.sendRedirect("candlist");
				} else if (user.getRole().equals("admin")) {
					resp.sendRedirect("result");

				}
			} 
			else {
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Login Failed</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("Invalid email and password. <br/><br/>");
				out.println("<a href='index.html'>Login Again</a>");
				out.println("</body>");
				out.println("</html>");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
