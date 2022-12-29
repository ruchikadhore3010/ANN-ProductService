package in.ibm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ibm.entity.Category;
import in.ibm.entity.Product;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Integer> {
	

}
