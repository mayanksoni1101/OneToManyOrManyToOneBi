package org.jsp.onetomanyormanytoonebi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindProductBiId {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Prodcut Id : ");
		Product p = em.find(Product.class, sc.nextInt());
		if(p!=null) {
			System.out.println(p);
		}
		else {
			System.err.println("No Record Found");
		}
		try {}
		finally {
			sc.close();
		}
	
	}
}
