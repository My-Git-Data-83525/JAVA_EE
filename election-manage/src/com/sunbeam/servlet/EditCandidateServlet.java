package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

@WebServlet("/edit")
public class EditCandidateServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idstr=req.getParameter("id");
		int id=Integer.parseInt(idstr);
		Candidate c=new Candidate();
		try(CandidateDao canDao=new CandidateDaoImpl()){
		 c=canDao.findById(id);
		 System.out.println(c.toString());
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Candidate List</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Online Voting</h2>");
		out.println("<form method='post' action='edit'>");
		out.printf("Id:<input type='text' name='id' value='%d' readonly>",c.getId());
		out.printf("Name:<input type='text' name='name' value='%s'>",c.getName());
		out.printf("Party:<input type='text' name='party' value='%s'>",c.getParty());
		out.printf("Votes:<input type='text' name='votes' value='%d' readonly>",c.getVotes());
		out.println("<input type='submit' value='Update'>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
}
