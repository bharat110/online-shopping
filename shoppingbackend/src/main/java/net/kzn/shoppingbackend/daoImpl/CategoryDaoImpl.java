package net.kzn.shoppingbackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.kzn.shoppingbackend.dao.CategoryDao;
import net.kzn.shoppingbackend.dto.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	private static List<Category> categories = new ArrayList<>();

	static {

		Category category1 = new Category();
		category1.setId(1);
		category1.setName("Television");
		category1.setDescription("This is some desctirption of television..");
		category1.setImageUrl("CAT_1.png");

		Category category2 = new Category();
		category2.setId(2);
		category2.setName("Mobile");
		category2.setDescription("This is some desctirption of mobile..");
		category2.setImageUrl("CAT_2.png");

		Category category3 = new Category();
		category3.setId(3);
		category3.setName("Laptop");
		category3.setDescription("This is some desctirption of Laptop..");
		category3.setImageUrl("CAT_3.png");

		categories.add(category1);
		categories.add(category2);
		categories.add(category3);
	}

	// to get all products
	@Override
	public List<Category> list() {
		return categories;
	}

	// to get specific product
	@Override
	public Category get(int id) {
		// enhanced for loop
		for (Category category : categories) {
			if (category.getId() == id) {
				return category;
			}
		}
		return null;
	}

}
