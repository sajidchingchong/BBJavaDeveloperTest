/*
 * Created by Sajid Hussain
 */

package bb.java.developer.test.dao;

/**
 * The Interface Dao.
 *
 * @param <T> the generic type
 */
public interface Dao<T> {

	/**
	 * Gets the.
	 *
	 * @param id the id
	 * @return the t
	 */
	public T get(String id);

	/**
	 * Save.
	 *
	 * @param t the t
	 */
	public void save(T t);

}
