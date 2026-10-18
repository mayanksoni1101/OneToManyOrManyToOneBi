package org.jsp.onetomanyormanytoonebi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindMerchantByPhoneAndPassword {
	public static void main(String[] args) {


		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		Query q = em.createQuery("select m from Merchant m where m.phone = ?1 and m.password = ?2");
		System.out.println("Enter Merchant Phone Number : ");
		q.setParameter(1, sc.nextLong());
		System.out.println("Enter Merchant Password : ");
		q.setParameter(2, sc.next());
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
