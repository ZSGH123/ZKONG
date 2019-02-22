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
			City city=(City) session.get(City.class, new Integer(4));
			System.out.println(city.getcName());
			Set<Street> streets=city.getStreets();
			for (Street street : streets) {
				System.out.println(street.getsName());
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
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
			city.setcName("��ɳ");
			session.save(city);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		session.close();
	}
	/**
	 * �������ºͱ��棺����־û�һ�����󣬻��Զ��־û����������
	 */
	@Test
	public void testAddCityAndStreet(){
		Transaction transaction=null;		
		try {
			transaction=session.beginTransaction();	
			
			City city=new City();
			city.setcName("��̶");
			Street street1=new Street();
			street1.setsName("ӣ��·");
			Street street2=new Street();
			street2.setsName("��֪·");
			city.getStreets().add(street1);
			city.getStreets().add(street2);
			street1.setCity(city);
			street2.setCity(city);
			
			session.save(city);
//			session.save(street1);
//			session.save(street2);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		session.close();
	}
	
	
}
