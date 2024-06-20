package com.sunbeam.beans;

import java.util.List;

import com.sunbeam.daos.ProductDao;
import com.sunbeam.daos.ProductDaoImpl;
import com.sunbeam.entities.Product;

public class ProductBean {
	//add request parameter to java beans props 
	private long productId;
	private String name;
	private double price;
	private long quantity;
	private long categoryId;
	//dependancies--->dao layer interface
	private ProductDao productDao;
	public ProductBean() {
		productDao=new ProductDaoImpl();
		System.out.println("product is created");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	
	//add BL method to add new product
	public String addNewProduct() {
		System.out.println(categoryId);
		//create tansient product
		Product product=new Product(name, price, quantity);
		//invokr dao's method for saving product details in db
		
		return productDao.addProduct(product, categoryId);
	} 
	//list the products
	public List<Product> showList(){
		return productDao.getAllProduct();
	}
	//purches method by productId
	public String purches() {
		System.out.println(quantity);
		return productDao.purchesProduct(productId, quantity);
	}
	public long getProductId() {
		return productId;
	}
}
