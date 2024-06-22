package com.sunbeam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/test")
public class TestController {

	public TestController() {
		System.out.println("Inside test Controller ::"+getClass());
		// TODO Auto-generated constructor stub
	}
//	add request handling method
	@RequestMapping("/multiply")// getmethod also 
	public static String multilication(Model modelMap,@RequestParam int num1,@RequestParam int num2) {
//		Request Param method argumnet level annotation it is for binding and parsing 
//		incoming request param --> method argument
//		int num1= Integer.parseInt(request.getParametr("num1"));
//		match request parameter name with arg  method
//		o.s.ui.Model ==>represents a holder of modle attribute
		System.out.println("render test multiplication" );//empty map
		modelMap.addAttribute("abc",num1*num2);
		return "/test/result";//WEB-INF/views/test/result.jsp
	}
}
