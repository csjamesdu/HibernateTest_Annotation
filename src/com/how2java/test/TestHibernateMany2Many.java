package com.how2java.test;

import com.how2java.pojo.User;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.how2java.pojo.Product;

public class TestHibernateMany2Many {
	public static void main(String[] args){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session s = sf.openSession();
		s.beginTransaction();
		
		Set<User> users = new HashSet<User>();
		for(int i=0; i<3; i++){
			User u = new User();
			u.setName("user"+i);
			users.add(u);
			s.save(u);
		}
		
		Product p1 = (Product)s.get(Product.class,4);
		
		p1.setUsers(users);
		s.save(p1);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
