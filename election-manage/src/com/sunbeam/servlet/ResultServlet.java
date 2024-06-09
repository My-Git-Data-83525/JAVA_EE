package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<Candidate> candlist=new ArrayList<Candidate>();
		try(CandidateDao candidateDao=new CandidateDaoImpl()){
				candlist=candidateDao.findAll();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<head>");
		out.println("<title>Candidate Result</title>");
		out.println("</head>");
		out.println("<body>");
		//out.println("<br/><a href='announcement.html'>announcement</a>");
		out.println("<table border=1>");
		out.println("<thead>");
		out.println("<tr>");
		out.printf("<th>Id</th>");
		out.printf("<th>Name</th>");
		out.printf("<th>Paty</th>");
		out.printf("<th>Vote</th>");
		out.printf("<th>Action</th>");
		out.println("<tr>");
		out.println("</thead>");
		out.printf("<tbody>");
		for (Candidate c : candlist) {
			out.println("<tr>");
			out.printf("<td>%d</td>",c.getId());
			out.printf("<td>%s</td>",c.getName());
			out.printf("<td>%s</td>",c.getParty());
			out.printf("<td>%d</td>",c.getVotes());
			out.printf("<td><a href='delcand?id=%d'><img width='24' height='24' src='Image/delete.png'></a><a href='edit?id=%d'><img width='24' height='24' src='Image/edit.jpeg'></a></td>",c.getId(),c.getId());
			out.println("<tr>");
		}
		out.printf("</tbody>");
		out.printf("</table>");
		String message=(String)req.getAttribute("message");
		if(message!=null)
		out.printf(message);
		out.println("</body>");
		out.println("</html>");
	}
}
