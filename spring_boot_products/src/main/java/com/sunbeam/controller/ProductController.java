package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunbeam.services.ProductServices;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	//add dependency
	@Autowired
	private ProductServices productService;
	
	public ProductController() {
		System.out.println("inside ProductController!");
		// TODO Auto-generated constructor stub
	}
	
	//add method to show the list of products
	@GetMapping("/list")
	public String ShowAllProducts() {
		return "/products/list";
	}

}
