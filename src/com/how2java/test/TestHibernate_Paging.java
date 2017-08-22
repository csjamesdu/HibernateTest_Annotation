package com.how2java.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.how2java.pojo.Product;

public class TestHibernate_Paging {
	public static void main(String[] args){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		String name = "iphone";
		
		Criteria cr = s.createCriteria(Product.class);
		cr.add(Restrictions.like("name", "%"+name+"%"));
		cr.setFirstResult(2);
		cr.setMaxResults(5);
		
		List<Product> ps = cr.list();
		for(Product p:ps){
			System.out.println(p.getName());
		}
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	
	}
	
	
}
