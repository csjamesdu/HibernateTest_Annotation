package com.how2java.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.how2java.pojo.Product;

public class TestHibernate1 {
	public static void main(String[] args){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session s = sf.openSession();
		s.beginTransaction();
		
		Product p = new Product();
		p.setName("Iphone8");
		p.setPrice(8000);
		s.save(p);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
