package com.how2java.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.how2java.pojo.Product;

public class TestHibernate_OptimisticLock {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s1 = sf.openSession();
		Session s2 = sf.openSession();
		
		s1.beginTransaction();
		s2.beginTransaction();
		
		Product p1 = (Product)s1.get(Product.class,4);
		System.out.println("The price of product is:"+p1.getPrice());
		p1.setPrice(p1.getPrice()+1000);
		
		Product p2 = (Product)s2.get(Product.class, 4);
		p2.setPrice(p2.getPrice()+1000);
		
		s1.update(p1);
		s2.update(p2);
		
		s1.getTransaction().commit();
		s2.getTransaction().commit();
		
		Product p = (Product)s1.get(Product.class, 4);
		
		System.out.println("The price of product after alteration is:"+p.getPrice());
		
		s1.close();
		s2.close();
		sf.close();
	}

}
