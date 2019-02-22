package Hibernate;

import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    
    private static Session session;
	
	@BeforeClass
	public static void init(){
		try {
			session=HibernateSessionFactory.getSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testLoadStreet(){
		System.out.println("test");
	}
}
