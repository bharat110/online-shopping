package net.kzn.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	List<Category> ct = new ArrayList<>();

	/*
	 * Getting single category based on id
	 */
	@Override
	public Category get(int id) {
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	/*
	 * This is for add Category
	 */
	@Override
	public boolean add(Category category) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	/*
	 * This is for list Category
	 */
	@Override
	public List<Category> list() {

		System.out.println("---------- in list() method -----------------");
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Category.class);
		System.out.println("---------- in list() method 2222222-----------------");
		return criteria.list();
		
	
	}

	/*
	 * This is for update Category
	 */
	@Override
	public boolean update(Category category) {
		category.setActive(false);

		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * This is for delete Category
	 */
	@Override
	public boolean delete(Category category) {
		try {
			category.setName("Television");

			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
