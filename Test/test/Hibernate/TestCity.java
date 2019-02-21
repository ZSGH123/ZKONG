package Hibernate;

import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCity {
    
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
	public void testLoadCity(){
		System.out.println("test");
	}
}
