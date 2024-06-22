package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="categories")
public class Category extends BaseEntity {
	@Column(length=20,unique = true)
	private String name;
	private String description;
	//mandatory otherwise it gives Mapping exception
	@OneToMany(mappedBy = "productCategory",cascade = CascadeType.ALL)
	//mappedBy is map the two entites and create only one column
	//defacult value of the cascascad
	private List<Product> products=new ArrayList<>();
	//category 1--->* Product
	public Category() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	//add helper method to establish biDirectinal associateion between category and products
	public void addProduct(Product product) {
		//parent-->category
		//child -->product
		this.products.add(product);
		product.setProductCategory(this);
	}
	
	public Category(String name, String description) {
		this.name = name;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Category "+getId()+" [name=" + name + ", description=" + description + ", products=" + products + "]";
	}
}
