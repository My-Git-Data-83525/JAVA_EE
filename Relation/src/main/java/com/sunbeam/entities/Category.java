package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
	@Column(name = "name")
	private String name;
	private String description;
	public Category(String name, String desc) {
		super();
		this.name = name;
		this.setDescription(desc);
	}

	@Override
	public String toString() {
		return "Category [name=" + name + ", description=" + getDescription() +  "]";
	}

	@OneToMany(mappedBy = "category",orphanRemoval = true,cascade = CascadeType.ALL)
	private List<BlogPost> post =new ArrayList<BlogPost>();

	public List<BlogPost> getPost() {
		return post;
	}

	public void setPost(List<BlogPost> post) {
		this.post = post;
	}

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public void addBlogPost(BlogPost post) {
		this.post.add(post);
		post.setCategory(this);
	}
	public void deletePost(BlogPost post) {
		this.post.remove(post);
		post.setCategory(null);
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
}
