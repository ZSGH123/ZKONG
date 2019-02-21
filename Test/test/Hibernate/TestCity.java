package Hibernate;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.City;
import entity.Street;

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
	
	public static void main(String[] args) {
		session=HibernateSessionFactory.getSession();
		new TestCity().testLoadCity();
	}
	
	@Test
	public void testLoadCity(){
		Transaction transaction=null;		
		try {
			transaction=session.beginTransaction();	
			City city=(City) session.load(City.class, new Integer(1));
			System.out.println(city.getcName());
			Set<Street> streets=city.getStreets();
			for (Street street : streets) {
				System.out.println(street.getsName());
			}
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		session.close();
	}
	
	@Test
	public void testAddCity(){
		Transaction transaction=null;		
		try {
			transaction=session.beginTransaction();	
			City city=new City();
			city.setcName("Œ‰∫∫");
			session.save(city);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		session.close();
	}
	
	@AfterClass
	public static void destory(){
		session.close();
	}
}
