package com.sunbeam.entities;

import javax.persistence.Entity;
import javax.persistence.*;


@Entity
@Table(name="products")
public class products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private Category category;
	@Column(unique = true,length=20)
	private String name;
	@Column()
	private double price;
	@Column(name="available_quantity")
	private Long availableQuantity;
	public products() {
		
	}
	
	public products( String name, double price, Long availableQuantity, Category category) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.availableQuantity = availableQuantity;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
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
		return "products [id=" + id + ", category=" + category + ", name=" + name + ", price=" + price
				+ ", availableQuantity=" + availableQuantity + "]";
	}
}
