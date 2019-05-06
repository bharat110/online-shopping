package net.kzn.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory factory;
	
	/*
	 * to get single product
	 */
	@Override
	public Product get(int productId) {
		try {
			return factory
					.getCurrentSession()
						.get(Product.class, Integer.valueOf(productId));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/*
	 * List of Product
	 */
	@Override
	public List<Product> getAllProduct() {
		try {
			return factory
				.getCurrentSession()
					.createQuery("FROM Product", Product.class)
						.getResultList();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * to add Product
	 */
	@Override
	public boolean add(Product product) {
		try {
			factory
				.getCurrentSession()
					.persist(product);
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/*
	 * to delete the product
	 */
	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(false);
			return this.update(product);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	/*
	 * to update the product
	 */
	@Override
	public boolean update(Product product) {
		try {
			factory
				.getCurrentSession()
					.update(product);
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	/*********************** Bussiness Methods  **********************************/
	
	
	
	
	/*
	 * get list of active producs
	 */
	@Override
	public List<Product> listActiveProduct() {
		String selectActiveProducts = "FROM Product WHERE active = :active";
		return factory
					.getCurrentSession()
						.createQuery(selectActiveProducts,Product.class)
							.setParameter("active", true)
								.getResultList();
	}

	
	/*
	 * get list of active producs by category id
	 */
	@Override
	public List<Product> listActiveProductByCategory(int categoryId) {
		String selectActiveProductsByCategoryId = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		return factory
					.getCurrentSession()
						.createQuery(selectActiveProductsByCategoryId,Product.class)
							.setParameter("active", true)
							.setParameter("categoryId", categoryId)
								.getResultList();
	}

	
	
	/*
	 * get latest active product
	 */
	@Override
	public List<Product> getLatestActiveProduct(int count) {
		return factory
				.getCurrentSession()
					.createQuery("FROM Product WHERE active =:active ORDER BY id",Product.class)
						.setParameter("active", true)
							.setFirstResult(0)
							.setMaxResults(count)
								.getResultList();
	}

}
