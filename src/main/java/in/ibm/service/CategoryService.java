package in.ibm.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import in.ibm.entity.Category;
import in.ibm.entity.Product;

public interface CategoryService {
	
	public Category saveCategory(Category category);
	

	public Iterable<Category> getCategories();
	
	
}
