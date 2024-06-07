package haha;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class Hello extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("hiiiii");
		System.out.println("Inside init method");
	}

	@Override
	public void destroy() {
		System.out.println("Inside destroy method");
	}
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	System.out.println("inside the doGet method");	
	resp.setContentType("text/html");
	PrintWriter out =resp.getWriter();
	out.println("<html>");
	out.println("<head>");	
	out.print("<title>Hiii</title>");
	out.println("</head>");
	out.println("<body>");
	out.println("<h1>helloooooooooooo</h1>");
	out.println("</body>");
	out.println("</html>");	
}
 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("inside the doPost method");	
	ProcessRequest(req, resp);
	}
 	protected void ProcessRequest(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
 		resp.setContentType("text/html");
 		PrintWriter out=resp.getWriter();
 		out.println("<html>");
 		out.println("<head>");	
 		out.print("<title>Hiii</title>");
 		out.println("</head>");
 		out.println("<body>");
 		out.println("<h1>helloooooooooooo</h1>");
// 		Date now= new Date();
// 		out.println(now.toString());
 		out.println("</body>");
 		out.println("</html>");	
 		
 	}
}
