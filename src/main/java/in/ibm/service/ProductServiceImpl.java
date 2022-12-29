package in.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ibm.dao.CategoryDAO;
import in.ibm.dao.ProductDAO;
import in.ibm.dao.UserDAO;
import in.ibm.entity.Category;
import in.ibm.entity.Product;
import in.ibm.entity.User;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDao;

	@Autowired
	private CategoryDAO categoryDao;
	
	@Autowired 
	private UserDAO userDao;
	

	@Override
	public Product saveProduct(String userID, Integer productTypeID, Product product) {
		Category categoryType = categoryDao.findById(productTypeID).get();
		product.setCategory(categoryType);

		//getting and setting the useremail
		User user = userDao.findByEmail(userID);
		 product.setUser(user);

		// saving the property
		return productDao.save(product);
	}

	@Override
	public Iterable<Product> getProducts() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
	public Product getProduct(Long productID) {
		// TODO Auto-generated method stub
		return productDao.findById(productID).get();
	}

	@Override
	public Iterable<Product> search(String str) {
		// TODO Auto-generated method stub
		return productDao.findByNameContaining(str);
	}

	@Override
	public List<Product> getProductByCategory(Integer id) {
		// TODO Auto-generated method stub
		return productDao.findByCategoryId(id);
	}

	

	
}
