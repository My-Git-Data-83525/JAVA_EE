package com.sunbeam.entities;

import javax.persistence.Entity;
import javax.persistence.*;


@Entity
@Table(name="products")
public class Product extends BaseEntity {
	
	@Column(unique = true,length=20)
	private String name;
	@Column()
	private double price;
	@Column(name="available_quantity")
	private Long availableQuantity;
	@ManyToOne //Mandatory otherwise(MappingException) it will create one another table to mapping
	@JoinColumn(name="category_id",nullable = false)
	private Category productCategory;
	public Product() {
		
	}
	
	public Product( String name, double price, Long availableQuantity) {
		
		this.name = name;
		this.price = price;
		this.availableQuantity = availableQuantity;
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
	public Long getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(Long availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	@Override
	public String toString() {
		return "Product "+getId()+" [name" + name + ", price=" + price
				+ ", availableQuantity=" + availableQuantity + "]";
	}

	public Category getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}
}
