package com.sunbeam.dao;

import com.sunbeam.entities.Comment;

public interface CommentsDao {
	public String newCommnet(Comment comment,Long postId,Long bloggerId); 
}
