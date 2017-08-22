package com.how2java.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.how2java.pojo.Product;

public class TestHibernateInsert {
	public static void main(String[] args){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session s = sf.openSession();
		s.beginTransaction();
		
		for(int i=0;i<10;i++){
			Product p = new Product();
			p.setName("iphone"+i);
			p.setPrice(i*1000);
			s.save(p);
		}
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
