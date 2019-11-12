/*
 * Created by Sajid Hussain
 */

package bb.java.developer.test.service;

import javax.persistence.PersistenceException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import bb.java.developer.test.dao.DaoCollection;
import bb.java.developer.test.dao.ProductsDao;
import bb.java.developer.test.model.Products;

/**
 * The Class ProductsService.
 */
@Path("/products")
public class ProductsService {

	/**
	 * Gets the status.
	 *
	 * @param id the id
	 * @return the status
	 */
	@Path("/{id}")
	@GET
	@Produces("application/json")
	public Response getProducts(@PathParam("id") String id) {
		Products products = (Products) DaoCollection.getCollection().getDao(Products.class).get(id);
		if (products == null)
			return Response.status(404).build();
		return Response.status(200).entity(products.nullify()).build();
	}

	/**
	 * Retry.
	 *
	 * @param products the products
	 * @return the response
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response putProducts(Products products) {
		Response response = null;
		try {
			((ProductsDao) DaoCollection.getCollection().getDao(Products.class)).save(products);
			response = Response.status(201).build();
		} catch (PersistenceException e) {
			response = Response.status(409).build();
		}
		return response;
	}

}
