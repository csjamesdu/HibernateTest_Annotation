package com.how2java.test;

import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.how2java.pojo.Category;
import com.how2java.pojo.Product;

public class TestHibernateOne2Many {
	public static void main(String[] args){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session s = sf.openSession();
		s.beginTransaction();
		
		Category c = (Category)s.get(Category.class, 3);
		Set<Product> ps = c.getProducts();
		for(Product p : ps){
			System.out.println(p.getName());
		}
		
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
