package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.products;
import com.sunbeam.utils.dbutils;
	

public class tester{
public static void main(String[] args) {
	try (SessionFactory sf = dbutils.getFactory(); 
			Scanner sc = new Scanner(System.in)) {
		
		ProductDao dao = new ProductDaoImpl();
		
		System.out.println("Enter Product name, price, availableQuantity, Category category");
		products product=new products(sc.next(),sc.nextDouble(),sc.nextLong(),Category.valueOf(sc.next()));
		int i=dao.save(product);
		if(i>0) {
		System.out.println("data is inserted successfully!");
		}
		else {
			System.out.println("insertion failed!!");
		}
	} // JVM : sc.close() , sf.close() -> DBCP will be cleaned up !
	catch (Exception e) {
		e.printStackTrace();
	}
}	

}
