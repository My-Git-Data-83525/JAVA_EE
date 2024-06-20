package com.sunbeam.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import static com.sunbeam.utils.HibernateUtils.getFactory;
import com.sunbeam.entities.BlogPost;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.User;

public class BlogPostDaoImpl implements BlogPostDao{

	@Override
	public String NewPost(BlogPost post,Long categoryId,Long bloggerId) {
		String msg="Someting went Wrong!";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			User user=session.get(User.class, bloggerId);
			Category category=session.get(Category.class,categoryId);
			if(user!=null && category!=null) {
				category.addBlogPost(post);
				post.setCategory(category);
				msg="post added successfully";
			}
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return null;
	}

}
