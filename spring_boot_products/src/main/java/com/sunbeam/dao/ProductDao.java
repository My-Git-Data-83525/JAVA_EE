package com.sunbeam.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sunbeam.entities.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long>{
	public List<Product> findAll();
}
