package com.sunbeam.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.BlogPost;
@Repository //to tell SC following class is a spring bean(Singleton And Eager)
public class BlogPostDaoImpl implements BlogPostDao {
	@Autowired//it will provide the factory
	private SessionFactory factory;

	@Override
	public List<BlogPost> getBlogpostByCategory(String category) {
		String JPQl="select b from BlogPost b where b.selectedCategory.categoryName='Book'";
	System.out.println("inside jpql");
		return factory.getCurrentSession()
				.createQuery(JPQl,BlogPost.class).getResultList();
//				.setParameter("category",category)
				
	}

}
