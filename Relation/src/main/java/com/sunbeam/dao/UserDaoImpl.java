package com.sunbeam.dao;

import com.sunbeam.entities.User;
import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;

public class UserDaoImpl implements UserDao {

	@Override
	public String signUp(User user) {
		String mesg="user registration failed!!!!";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			Serializable userId = session.save(user);
			tx.commit();
			mesg="user registered successfully , with ID"+userId;
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public User getUserDetailsById(Long userId) {
		User user=null;
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			user=session.get(User.class, userId);
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return user;
	}
	

}
