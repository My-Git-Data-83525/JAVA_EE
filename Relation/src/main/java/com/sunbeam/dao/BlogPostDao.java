package com.sunbeam.dao;

import com.sunbeam.entities.BlogPost;

public interface BlogPostDao {
	public String NewPost(BlogPost post,Long postId,Long bloggerId); 
}
