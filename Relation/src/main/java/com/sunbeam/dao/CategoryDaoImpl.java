package com.sunbeam.dao;

import org.hibernate.Session;
import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import com.sunbeam.entities.Category;

public class CategoryDaoImpl implements CategoryDao{

	@Override
	public void addcategory(Category category) {
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			session.save(category);
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		
	}

}
