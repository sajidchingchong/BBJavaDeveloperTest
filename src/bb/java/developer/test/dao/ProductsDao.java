/*
 * Created by Sajid Hussain
 */

package bb.java.developer.test.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bb.java.developer.test.model.Products;

/**
 * The Class EmailDao.
 */
public class ProductsDao implements Dao<Products> {

	/** The session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Instantiates a new email dao.
	 *
	 * @param sessionFactory the session factory
	 */
	public ProductsDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Gets the.
	 *
	 * @param id the id
	 * @return the email
	 */
	@Override
	public Products get(String id) {
		Session session = this.sessionFactory.openSession();
		Products products = session.get(Products.class, id);
		session.close();
		return products;
	}

	/**
	 * Save.
	 *
	 * @param products the products
	 */
	@Override
	public void save(Products products) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.save(products);
		session.getTransaction().commit();
	}

}
