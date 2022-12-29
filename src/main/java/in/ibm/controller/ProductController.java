package in.ibm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.ibm.entity.Product;
import in.ibm.service.ProductService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class ProductController {

	private static final Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@PostMapping(value = "/products/{userID}/{CategoryTypeID}")

	public ResponseEntity<Product> saveProduct(@PathVariable String userID, @PathVariable int CategoryTypeID,
			@RequestBody Product Product) {
		return ResponseEntity.ok().body(productService.saveProduct(userID, CategoryTypeID, Product));
	}

	@GetMapping("/products")
	public ResponseEntity<Iterable<Product>> getproducts() {
		return ResponseEntity.ok().body(productService.getProducts());
	}

	@GetMapping("/products/{ProductID}")
	public ResponseEntity<Product> getProduct(@PathVariable Long ProductID) {
		return ResponseEntity.ok().body(productService.getProduct(ProductID));
	}

	@GetMapping("/searchproducts")
	public ResponseEntity<Iterable<Product>> search(@RequestParam("str") String str) {
		return ResponseEntity.ok().body(productService.search(str));
	}

	@GetMapping("/searchbycategory/{id}")
	public ResponseEntity<List<Product>> findByCategoryID(@PathVariable Integer id) {
		return ResponseEntity.ok().body(productService.getProductByCategory(id));
	}

}
