package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.BlogPost;
import com.sunbeam.entities.Category;

public interface BlogPostDao {
	//add a method to return list of blogpost by specified category
	public List<BlogPost> getBlogpostByCategory(String categoryName);
}
