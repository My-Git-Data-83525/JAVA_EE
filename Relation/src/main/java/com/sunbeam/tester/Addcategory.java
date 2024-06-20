package com.sunbeam.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.BlogPostDao;
import com.sunbeam.dao.BlogPostDaoImpl;
import com.sunbeam.dao.CategoryDao;
import com.sunbeam.dao.CategoryDaoImpl;
import com.sunbeam.entities.BlogPost;
import com.sunbeam.entities.Category;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

public class Addcategory {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			CategoryDao catDao=new CategoryDaoImpl();
			System.out.println("Eneter name and description :");
			Category category = new Category(sc.next(), sc.nextLine());
			catDao.addcategory(category);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
