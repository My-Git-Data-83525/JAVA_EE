package com.sunbeam.beans;

import com.sunbeam.daos.CategoryDao;
import com.sunbeam.daos.CategoryDaoImpl;
import com.sunbeam.entities.Category;

public class CategoryBean {
	
	//data gone come from the pages
	private String name;
	private String description;
	
	//Dependencies-->
	private CategoryDao categoryDao;
	
	public CategoryBean() {
		categoryDao=new CategoryDaoImpl();
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
	public String addCategory() {
		Category category=new Category(name,description);
		return categoryDao.addCategory(category);
		
		
	}
	
	
}
