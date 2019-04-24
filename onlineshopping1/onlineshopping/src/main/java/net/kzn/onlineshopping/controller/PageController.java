package net.kzn.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.shoppingbackend.dao.CategoryDao;
import net.kzn.shoppingbackend.dto.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDao categoryDao;

	@RequestMapping(value = { "/", "/home" })
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "Home");

		// passing the list of categories
		mav.addObject("categories", categoryDao.list());

		mav.addObject("userClickHome", true);

		return mav;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mav = new ModelAndView("page");
		// passing the list of categories
		mav.addObject("title", "About Us");
		mav.addObject("userClickAbout", true);

		return mav;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mav = new ModelAndView("page");
		// passing the list of categories
		mav.addObject("title", "Contact Us");
		mav.addObject("userClickContact", true);

		return mav;
	}
	
	
	
	/*
	 * To display all products and based on categories 
	 * 
	 */
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mav = new ModelAndView("page");
		// passing the list of categories
		mav.addObject("title", "All Products");
		mav.addObject("categories", categoryDao.list());
		mav.addObject("userClickAllProducts", true);

		return mav;
	}
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("page");
		
		// categoryDao to fetch single category
		Category category = null;
		category = categoryDao.get(id);
		
		
		// passing the list of categories
		mav.addObject("title", category.getName());
		mav.addObject("categories", categoryDao.list());
		
		//passing the single category
		mav.addObject("category", category);
		mav.addObject("userClickCategoryProducts", true);

		return mav;
	}
	
}
