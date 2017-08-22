package com.how2java.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.how2java.pojo.Category;
import com.how2java.pojo.Product;


public class TestHibernate_Lazyload {
	public static void main(String[] args){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session s = sf.openSession();
		s.beginTransaction();
		
		Category c = (Category)s.get(Category.class, 1);//if product's lazy==false, query everything at this line;
														//else, just query category at this line;
		
		System.out.println("------------------->");
		System.out.println(c.getProducts());//if product's lazy=true, query product at this line; else, query up there;
		System.out.println("<-------------------");
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
