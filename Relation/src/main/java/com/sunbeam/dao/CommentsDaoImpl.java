package com.sunbeam.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import static com.sunbeam.utils.HibernateUtils.getFactory;
import com.sunbeam.entities.BlogPost;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.Comment;
import com.sunbeam.entities.User;

public class CommentsDaoImpl implements CommentsDao{
	
	@Override
	public String newCommnet(Comment comment, Long postId, Long bloggerId) {
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			User user=session.get(User.class, bloggerId);
			BlogPost post2=session.get(BlogPost.class, postId);
			if(user!=null && post2!=null) {
				comment.setPost(post2);
				comment.setUser(user);
				session.persist(comment);
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
