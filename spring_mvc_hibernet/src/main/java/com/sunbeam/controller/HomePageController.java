package com.sunbeam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
	public HomePageController() {
		// TODO Auto-generated constructor stub
		System.out.println("inside the Homepage Controller :"+getClass());
	}
//	Handler --> dispatcher Servlet
//	DS-->V.R-->ANV(WEB-INF/views/index.jsp)
	@RequestMapping("/")
	public static String HomePage() {
	 {
	System.out.println("inside render home page");
	return "/index";		
		}
	}
	
	

}
