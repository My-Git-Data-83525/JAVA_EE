package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.entities.Product;

public interface ProductDao {
	public String addProduct(Product product,Long categoryId);
	public List<Product> getAllProduct();
	public String purchesProduct(long productId,long quantity);
}
