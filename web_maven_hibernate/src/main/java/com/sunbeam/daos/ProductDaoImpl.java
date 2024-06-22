package com.sunbeam.daos;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;
import static com.sunbeam.utils.HibernateUtils.getFactory;

public class ProductDaoImpl implements ProductDao {

	@Override
	public String addProduct(Product product, Long categoryId) {
		String msg = "Addin product failed!!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			// get category from id
			Category category = session.get(Category.class, categoryId);
			// check it is null or not
			if (category != null) {
				// valid category ---persistent
				category.addProduct(product);// state of the category persistent entity changed

			}
			tx.commit();
			// session.flush
			// dirty chceking --> new product entity added in l1 cache insert Record
			msg = "Added product sucsessfully";

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
		}

		return msg;
	}

	public List<Product> getAllProduct() {
		List<Product> products = null;
		String jpql = "select p from Product p";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			products = session.createQuery(jpql, Product.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		for (Product product : products) {
			System.out.println(product);
		}
		return products;
	}
	public String purchesProduct(long productId,long quantity) {
		System.out.println(productId+" "+quantity);
		String msg="We are not having that much quantity";
		Product product=new Product();
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			product=session.get(Product.class,productId);
			if(product!=null && product.getAvailableQuantity()>quantity) {
					product.setAvailableQuantity(product.getAvailableQuantity()-quantity);
					tx.commit();
					msg="product is purchesed!";
			}
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

}
