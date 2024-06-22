package com.sunbeam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomePageController {
	public HomePageController() {
		System.out.println("inside the HomePageController");
		// TODO Auto-generated constructor stub
	}
	//host:port/spring_boot/
	@GetMapping("/")
	public String HomePage() {
		System.out.println("render index page");
		return "/index";
	}
}
