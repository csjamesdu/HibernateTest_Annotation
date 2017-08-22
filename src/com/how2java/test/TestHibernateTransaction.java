package com.how2java.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.how2java.pojo.Product;

public class TestHibernateTransaction {
	public static void main(String[] args){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session s = sf.openSession();
		s.beginTransaction();
		//task1
		Product p = (Product)s.get(Product.class, 7);
		s.delete(p);
		//task2
		Product p2 = (Product)s.get(Product.class, 2);
		p2.setName("长度超过30的字符串作为产品名称长度超过30的字符串作为产品名称长度超过30的字符串作为产品名称长度超过30的字符串作为产品名称");
		s.update(p2);
		//task2 cannot be conducted because name length exceeds maximum value, therefore,task1 cannot be conducted either;
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
