package com.how2java.test.cascades;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Category;

public class TestDelete {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		Category c = (Category)s.get(Category.class, 4);
		s.delete(c);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}

}
