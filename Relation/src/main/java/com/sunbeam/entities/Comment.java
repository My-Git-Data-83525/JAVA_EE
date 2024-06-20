package com.sunbeam.entities;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {
	@Column(name = "comment_text")
	private String commentText;
	private int rating;
	@ManyToOne
	@JoinColumn(name = "post_id",nullable = false)
	private BlogPost post;
	@ManyToOne
	@JoinColumn(name="commenter_id",nullable = false)
	private User user;
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public BlogPost getPost() {
		return post;
	}
	public void setPost(BlogPost post) {
		this.post = post;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Comment [commentText=" + commentText + ", rating=" + rating + ", post=" + post + ", user=" + user + "]";
	}
	public Comment(String comment, int i) {
		super();
		this.commentText=comment;
		this.rating=i;
		}
	
}
