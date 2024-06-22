package com.sunbeam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.BlogPostDao;
import com.sunbeam.entities.BlogPost;

@Service//Spring bean holding BL ,singleton eager
@Transactional//it manages transaction automatically
public class BlogPostServiceImpl implements BlogPostService{
	@Autowired//by type
	private BlogPostDao postDao;
	
	@Override
	public List<BlogPost> getPostByCategory(String catName) {
		System.out.println("inside service");

		//invoke daos method to get list of blog post
		return postDao.getBlogpostByCategory(catName);
				
	}

}
