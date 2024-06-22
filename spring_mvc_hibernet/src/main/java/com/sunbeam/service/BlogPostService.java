package com.sunbeam.service;

import java.util.List;

import com.sunbeam.entities.BlogPost;

public interface BlogPostService {
	//add a method to list by category
	List<BlogPost> getPostByCategory(String catName);
	
}
