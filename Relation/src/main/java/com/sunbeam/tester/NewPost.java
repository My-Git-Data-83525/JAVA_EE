package com.sunbeam.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.BlogPostDao;
import com.sunbeam.dao.BlogPostDaoImpl;
import com.sunbeam.entities.BlogPost;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

public class NewPost {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			BlogPostDao bolgDao=new BlogPostDaoImpl();
			System.out.println("Eneter content ,descripbtion , title ,category Id and blogger id:");
			BlogPost post = new BlogPost(sc.next(), sc.next(),sc.next());// transient - exists only in heap , not yet
			bolgDao.NewPost(post,sc.nextLong(),sc.nextLong());
		} // JVM : sc.close() , sf.close() -> DBCP will be cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
