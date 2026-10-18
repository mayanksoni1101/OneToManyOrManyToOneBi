package org.jsp.onetomanyormanytoonebi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class FindProdcutsBetweenPriceRange {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		TypedQuery<Product> q = em.createQuery("select p from Product p where p.price >= ?1 and  p.price <= ?2", Product.class);
		System.out.println("Enter Product Lowest Price Range : ");
		q.setParameter(1, sc.nextDouble());
		System.out.println("Enter Product Highest Price Range : ");
		q.setParameter(2, sc.nextDouble());
		List<Product> plist = q.getResultList();
		if(!plist.isEmpty()) {
			plist.forEach(System.out::println);
		}
		else {
			System.err.println("No Record Found !!!");
		}
		try {}
		finally {
			sc.close();
		}
	
	
	
	}
}
