package com.sunbeam.daos;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;    
import com.sunbeam.entities.Category;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public void addCategory(Category category) {
		String msg = "Adding category failed!!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(category);;
			tx.commit();
			msg = "Added product sucsessfully";

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
		}

	}

}
