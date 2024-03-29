/*
 * Created by Sajid Hussain
 */

package bb.java.developer.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * The Class Product.
 */
@Entity
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Product {

	/** The id. */
	@Id
	private long id;

	/** The name. */
	@Column(nullable = false)
	private String name;

	/** The quantity. */
	@Column(nullable = false)
	private Integer quantity;

	/** The sale amount. */
	@Column(nullable = false, name = "sale_amount")
	private Double saleAmount;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * Gets the sale amount.
	 *
	 * @return the sale amount
	 */
	public Double getSaleAmount() {
		return saleAmount;
	}

	/**
	 * Sets the sale amount.
	 *
	 * @param saleAmount the new sale amount
	 */
	public void setSaleAmount(Double saleAmount) {
		this.saleAmount = saleAmount;
	}

	/**
	 * Nullify.
	 */
	public void nullify() {
		this.name = null;
		this.quantity = null;
		this.saleAmount = null;
	}

}
