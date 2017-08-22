package com.how2java.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.how2java.pojo.Product;

public class TestHibernateUpdate {
	public static void main(String[] args){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session s = sf.openSession();
		s.beginTransaction();
		
		Product p = (Product)s.get(Product.class, 8);
		
		System.out.println(p.getName());
		
		p.setName("Modified iphone");
		p.setPrice(80);
		s.update(p);
		
		Query q = s.createQuery("from Product p");
		List<Product> ls = q.list();
		for(Product pp : ls){
			System.out.println(pp.getName());
			System.out.println(pp.getPrice());
		}
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
