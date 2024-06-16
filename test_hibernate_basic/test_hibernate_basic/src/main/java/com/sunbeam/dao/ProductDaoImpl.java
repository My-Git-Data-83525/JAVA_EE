package com.sunbeam.dao;

import static com.sunbeam.utils.dbutils.getFactory;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entities.products;

public class ProductDaoImpl implements ProductDao{

	@Override
	public int save(products product) {
		Serializable cnt;
		int i=0;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			cnt = session.save(product);
			tx.commit();
			i++;
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		if(i==0) {
			return 0;
		}
		else
			return i;

	}

	@Override
	public products getProductById(Long id) {
		products product=null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			product = session.get(products.class,id);
			tx.commit();
			} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return product;
		
	}
}
