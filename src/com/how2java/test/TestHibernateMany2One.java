package com.how2java.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.how2java.pojo.Category;
import com.how2java.pojo.Product;

public class TestHibernateMany2One {
	public static void main(String[] args){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session s = sf.openSession();
		s.beginTransaction();
		
		Category c = new Category();
		c.setName("c23456");
		s.save(c);
		
		Product p = (Product)s.get(Product.class, 4);
		p.setCategory(c);
		s.update(p);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
