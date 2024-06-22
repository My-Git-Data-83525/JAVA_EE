package com.sunbeam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class HelloServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("inside init()");
		super.init();
	}
	@Override
	public void destroy() {
		System.out.println("inside destroy()");
		super.destroy();
	}
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("inside Service()");
			super.doGet(req, resp);
		}
}
