package com.sunbeam.dao;

import com.sunbeam.entities.products;

public interface ProductDao {
	public int save(products product);
	public products getProductById(Long id);
}
