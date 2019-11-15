/*
 * Created by Sajid Hussain
 */

package bb.java.developer.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bb.java.developer.test.model.Product;
import bb.java.developer.test.model.Products;
import bb.java.developer.test.service.ProductsService;

/**
 * The Class ProductService.
 */
class TestProductService {

	/** The product service. */
	private ProductsService productService = new ProductsService();

	/** The products. */
	private Products products;

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		Product product = new Product();
		product.setName("Some Product Name");
		product.setQuantity(10);
		product.setSaleAmount(20.0);

		List<Product> productList = new ArrayList<>();
		productList.add(product);

		products = new Products();
		products.setId("Some id");
		products.setTimestamp(System.currentTimeMillis() + "");
		products.setProducts(productList);
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		products = null;
	}

	/**
	 * Test put valid get valid products.
	 */
	@Test
	final void testPutValidGetValidProducts() {
		setUpProducts(1, "PutValid GetValid putProducts has failed");

		Response response = productService.getProducts(products.getId());
		assertTrue(response.getStatus() == 200, "PutValid GetValid getProducts has failed");

		Products gotProducts = (Products) response.getEntity();

		assertEquals(products.getId(), gotProducts.getId(), "Products ids are found to be different");
		assertEquals(products.getProducts().get(0).getId(), gotProducts.getProducts().get(0).getId(),
				"Product ids are found to be different");
	}

	/**
	 * Test put valid get invalid products.
	 */
	@Test
	final void testPutValidGetInvalidProducts() {
		setUpProducts(2, "PutValid GetInvalid putProducts has failed");
		int status = productService.getProducts("x").getStatus();
		assertTrue(status == 404, "PutValid GetInvalid getProducts' status is " + status);
	}

	/**
	 * Test put valid put valid products.
	 */
	@Test
	final void testPutValidPutValidProducts() {
		setUpProducts(3, "PutValid PutValid putProducts has failed");
		int status = productService.putProducts(products).getStatus();
		assertTrue(status == 409, "PutValid PutValid getProducts' status is " + status);
	}

	/**
	 * Sets the up products.
	 *
	 * @param id      the id
	 * @param message the message
	 */
	private void setUpProducts(long id, String message) {
		products.setId(id + "");
		products.getProducts().get(0).setId(id);

		Response response = productService.putProducts(products);
		assertTrue(response.getStatus() == 201, message);
	}

}
