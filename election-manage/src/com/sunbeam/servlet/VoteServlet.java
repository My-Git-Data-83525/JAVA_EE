package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class VoteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			processRequest(req, resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
//		String candidateId = req.getParameter("candidate");
//		int id = Integer.parseInt(candidateId);
//		System.out.println(id);
//		try (CandidateDao canDao = new CandidateDaoImpl()) {
//			canDao.incrementVote(id);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new ServletException(e);
//		}
		HttpSession session=req.getSession();
		User user=(User) session.getAttribute("curr");
		int userId=user.getId();
		System.out.println(userId);
		String message="";
		
		if(user.getStatus()==0) {
			String candidateId=req.getParameter("candidate");
			int id=Integer.parseInt(candidateId);
			try(CandidateDao canDao=new CandidateDaoImpl()){
				
				canDao.incrementVote(id);
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException();
			}
			message="Your vote is successfully.<br/><br/>";
			try(UserDao userDao=new UserDaoImpl()){
				userDao.updateStatus(userId, true);
			}
			catch(Exception e){
			e.printStackTrace();
			throw new ServletException();
			}
			
		}
		else {
			message="You Have already Voted!!";
		}
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Voted</title>");
		out.println("</head>");
		out.println("<body>");
		String username="";
		Cookie[] arr=req.getCookies();
		for (Cookie c : arr) {
			if(c.getName().equals("uname")) {
				username=c.getValue();
			}
		}
		
		out.printf("Hello, %s<br/><br/>\n",username);
		out.println(message);
		out.println("Your Vote is Registred Successfuly");
		out.println("<a href='logout'>Sign Out</a>");
		out.println("</body>");
		out.println("<html>");
	}
}
