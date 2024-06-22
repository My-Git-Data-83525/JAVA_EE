package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbeam.service.BlogPostService;

@Controller
@RequestMapping("/post")
public class BlogPostController {
	//depednacy ==>autowired instance
	@Autowired
	private BlogPostService blogPostService;
	
	public BlogPostController() {
		System.out.println("in BlogPost Controller "+getClass());
		// TODO Auto-generated constructor stub
	}
	//URL=>http://host:port/post/views?categoryName=catgeory
	//http://localhost:8080/spring_mvc_template/post/view?categoryName=Book
	//Method-- Get
	@GetMapping("/view")
	public String getBlogPostByCategory(Model modelmap,@RequestParam String categoryName)//service method
	{
		System.out.println(categoryName);
		modelmap.addAttribute("blog", blogPostService.getPostByCategory(categoryName));	
		System.out.println("inside controller");
		return "/post/view";//AVM-->/WEB_INF/views/post/view.jsp
	}
}
