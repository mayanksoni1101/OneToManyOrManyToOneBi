package org.jsp.onetomanyormanytoonebi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindMerchantByProductId {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		Query q = em.createQuery("select p.m from Product p where p.id = ?1");
		System.out.println("Enter Product Id : ");
		q.setParameter(1, sc.nextInt());
		try {
			Merchant m = (Merchant) q.getSingleResult();
			System.out.println(m);
		}
		catch(NoResultException e) {
			System.err.println("No Record Found !!!");
		}
		finally {
			sc.close();
		}
	
	
	
	}
}
