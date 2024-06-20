package com.sunbeam.entities;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "posts")
public class BlogPost extends BaseEntity {
	private String content;
	private String description;
	@Column(name = "title",unique = true,nullable=false,length = 30)
	private String title;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public BlogPost() {
	}
	@Override
	public String toString() {
		return "BlogPost [content=" + content + ", description=" + description + ", title=" + title + "]";
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public BlogPost(String content, String description, String title) {
		this.content = content;
		this.description = description;
		this.title = title;
	}
	
	
}
