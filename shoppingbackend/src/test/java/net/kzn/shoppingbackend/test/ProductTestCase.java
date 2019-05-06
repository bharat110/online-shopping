package net.kzn.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;

	private static ProductDAO productDAO;

	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	/*
	 * @Test public void testCRUDProduct() {
	 * 
	 * // add product product = new Product();
	 * 
	 * product.setName("redme note 5"); product.setBrand("Redmi");
	 * product.setDescription("This is best selling and less price phone..");
	 * product.setUnitPrice(15000); product.setActive(true);
	 * product.setCategoryId(3); product.setSupplierId(3);
	 * 
	 * assertEquals("Something went wrong to add a product..",
	 * true,productDAO.add(product));
	 * 
	 * 
	 * 
	 * // reading and updating product product = productDAO.get(2);
	 * product.setName("Samsung Galaxy A7");
	 * assertEquals("Something went wrong to update a product..",
	 * true,productDAO.update(product));
	 * 
	 * // delete product assertEquals("Something went wrong to delete a product..",
	 * true,productDAO.delete(product));
	 * 
	 * // list
	 * assertEquals("Something went wrong while fetching list of product ..",4,
	 * productDAO.getAllProduct().size()); }
	 */

	/******************* Bussiness Method test Cases *************************/

	@Test
	public void testListActiveProducts() {
		assertEquals("Something went wrong while fetching list of active product ..", 3,
				productDAO.listActiveProduct().size());
	}

	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Something went wrong while fetching list of active product by category ..", 2,
				productDAO.listActiveProductByCategory(3).size());
	}

	@Test
	public void testGetLatestActiveProduct() {
		assertEquals("Something went wrong while fetching list of active product by category ..", 2,
				productDAO.getLatestActiveProduct(2).size());
	}

}
