package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class CandidateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException{
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
		out.println("<title>Candidate List</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Online Voting</h2>");
		String username="";
		Cookie[] arr=req.getCookies();
		for (Cookie c : arr) {
			if(c.getName().equals("uname")) {
				username=c.getValue();
			}
		}
		out.printf("<h3>Hello, %s</h3>",username);
		ServletContext cxt= this.getServletContext();
		String msg=(String) cxt.getAttribute("anno");
		//if(msg!=null)
			//out.printf("Announcement : %s<br/><br/>\n",msg);
		out.println("<form method='post' action='vote'>");
		for (Candidate candi :candlist ) {
			out.printf("<input type='radio' name='candidate' value='%d'/> %s (%s)<br/>\n",candi.getId(),candi.getName(),candi.getParty());
			//System.out.println(candi.toString());
		}
		out.println("<input type='submit' value='vote'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
}
