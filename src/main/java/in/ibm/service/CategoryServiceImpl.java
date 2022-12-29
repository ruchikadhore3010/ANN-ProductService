package in.ibm.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ibm.dao.CategoryDAO;
import in.ibm.entity.Category;
import in.ibm.entity.Product;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	
	private static final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);


	@Autowired
	private CategoryDAO categoryDao;
	
	@Override
	public Category saveCategory(Category category) {
		
		log.info("type  :"+category.getType());
		return categoryDao.save(category);
	}

	@Override
	public Iterable<Category> getCategories() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}

	


}
