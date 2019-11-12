/*
 * Created by Sajid Hussain
 */

package bb.java.developer.test.dao;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bb.java.developer.test.model.Products;

/**
 * The Class DaoCollection.
 */
public class DaoCollection {

	/** The dao collection. */
	private static DaoCollection daoCollection = new DaoCollection();

	/**
	 * Gets the collection.
	 *
	 * @return the collection
	 */
	public static DaoCollection getCollection() {
		return daoCollection;
	}

	/** The session factory. */
	private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	/** The dao map. */
	private Map<Class<?>, Dao<?>> daoMap = new HashMap<>();

	/**
	 * Instantiates a new dao collection.
	 */
	private DaoCollection() {
		daoMap.put(Products.class, new ProductsDao(sessionFactory));
	}

	/**
	 * Gets the dao.
	 *
	 * @param clazz the clazz
	 * @return the dao
	 */
	public Dao<?> getDao(Class<?> clazz) {
		return this.daoMap.get(clazz);
	}

}
