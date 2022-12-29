package in.ibm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.ibm.entity.Category;
import in.ibm.entity.Product;
import in.ibm.service.CategoryService;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class CategoryController {

	
	private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

	
	@Autowired
	private CategoryService categoryService;
	
	
	@PostMapping("/category")
	public ResponseEntity<Category> saveCategory(@RequestBody Category category){
		log.info("request body : "+ category.getType());
		return ResponseEntity.ok().body(categoryService.saveCategory(category));
		
	}
	
	
	@GetMapping("/categories")
	public ResponseEntity<Iterable<Category>> getproducts() {
		return ResponseEntity.ok().body(categoryService.getCategories());
	}
	
	
}
