/*
 * Created by Sajid Hussain
 */

package bb.java.developer.test.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * The Class Products.
 */
@Entity
public class Products {

	/** The id. */
	@Id
	@Column(name = "idd")
	private String id;

	/** The timestamp. */
	@Column(nullable = false)
	private String timestamp;

	/** The products. */
	@Column(nullable = false)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Product> products;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the timestamp.
	 *
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * Sets the timestamp.
	 *
	 * @param timestamp the new timestamp
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Gets the products.
	 *
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * Sets the products.
	 *
	 * @param products the new products
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	/**
	 * Nullify.
	 *
	 * @return the products
	 */
	public Products nullify() {
		this.products.forEach(product -> product.nullify());
		return this;
	}

}
