package Hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.City;
import entity.Street;

public class TestStreet {
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
	
	public static void main(String[] args) {
		session=HibernateSessionFactory.getSession();
		new TestStreet().testAddStreet();
	}
	
	@Test
	public void testAddStreet(){
		Transaction transaction=null;		
		try {
			transaction=session.beginTransaction();	
			Street street=new Street();
			street.setsName("³þâùÂ·");
			City city=(City) session.load(City.class, new Integer(4));
			street.setCity(city);
			session.save(street);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		session.close();
	}
	

}
