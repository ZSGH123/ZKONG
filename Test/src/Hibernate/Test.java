package Hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.UserInfo;


public class Test {

	public static void main(String[] args) {
          get("1000000053");

	}
	/**
	 * ≤È—Ø(∑«—”≥Ÿº”‘ÿ)
	 * @param id
	 */
	public static void get(String id) {
//		Session session1=HibernateSessionFactory.getSession();
		Configuration configuration=new Configuration().configure();
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=null;
		
		transaction=session.beginTransaction();
		UserInfo userInfo=(UserInfo) session.get(UserInfo.class, id);
		System.out.println(userInfo);
		transaction.commit();
		session.close();

	}
	

}
