package in.ibm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.ibm.entity.Product;


@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {
	@Query
	public Iterable<Product> findByNameContaining(String str);
	
	List<Product> findByCategoryId(Integer id);

}
