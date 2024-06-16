package com.sunbeam.tester;

import java.util.Scanner;
import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.products;
import com.sunbeam.utils.dbutils;
	

public class getproduct{
public static void main(String[] args) {
	try (SessionFactory sf = dbutils.getFactory(); 
		Scanner sc = new Scanner(System.in)) {	
		ProductDao dao = new ProductDaoImpl();	
		System.out.println("Enter Product Id");
		products i=dao.getProductById(sc.nextLong());
		products i1=dao.getProductById(sc.nextLong());
		products i3=dao.getProductById(sc.nextLong());
		System.out.println(i.toString());
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
}	

}
