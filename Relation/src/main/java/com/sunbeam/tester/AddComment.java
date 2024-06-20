package com.sunbeam.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.BlogPostDao;
import com.sunbeam.dao.BlogPostDaoImpl;
import com.sunbeam.dao.CategoryDao;
import com.sunbeam.dao.CategoryDaoImpl;
import com.sunbeam.dao.CommentsDao;
import com.sunbeam.dao.CommentsDaoImpl;
import com.sunbeam.entities.BlogPost;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.Comment;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

public class AddComment {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			CommentsDao commentDao=new CommentsDaoImpl();
			System.out.println("Eneter coment and rating in 1-5  and postId and UserId:");
			Comment comment=new Comment(sc.nextLine(),sc.nextInt());
			commentDao.newCommnet(comment,sc.nextLong(),sc.nextLong());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
