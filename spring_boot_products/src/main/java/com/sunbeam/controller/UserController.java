package com.sunbeam.controller;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbeam.entities.User;
import com.sunbeam.services.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
	
	//create dependency
	@Autowired
	private UserService userService;
	
	public UserController() {
		System.out.println("inside User Controller!");
		// TODO Auto-generated constructor stub
	}

	// add method for login
	@PostMapping("/login")
	public String Login(@RequestParam String email,@RequestParam String password,Model map,HttpSession session) {
		Optional<User> user=userService.Login(email,password);
		session.setAttribute("user", user);
		if(user.isPresent()) {
			return "redirect:/products/list"; //AVN--> /WEB-INF/views/products/list.jsp	
		}
		else {
			return "user/login";
		}
	}
	
	//render Login page
	@GetMapping("/login")
	public String RenderLogin() {
		return "/user/login";
	}
}
