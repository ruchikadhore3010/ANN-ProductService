package in.ibm.service;

import java.util.List;

import in.ibm.entity.Product;

public interface ProductService {

	public Product saveProduct(String userID,Integer productTypeID,Product product);
	
	public Iterable<Product> getProducts();
	
	public Product getProduct(Long productID);
	
	public Iterable<Product> search(String str);
	
//	public Iterable<Product> filterProperty(String city, Double price,Integer TypeID);
	public List<Product> getProductByCategory(Integer id);
	
}
