package Hibernate;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import entity.UserInfo;


public class Test {

	public static void main(String[] args) {
          load("1000000053");
		//get("1000000053");
//		UserInfo userInfo=new UserInfo();
//		userInfo.setUserName("诗韵新");
//		userInfo.setUserPassword("Zq123456");
//		save(userInfo);
//		UserInfo userInfo=new UserInfo();
//		userInfo.setUserName("诗韵新");
//		userInfo.setUserPassword("Zq123456");
//		userInfo.setUserId("1000000055");
//		delete(userInfo);
	}
	/**
	 * 查询(非延迟加载)
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
		//查询所有
		//1.使用HQL语言（后面会详细介绍），HQL语言是面向对象的
		//封装HQL语句的对象。

//        Query对象返回一个对象的方法 query.uniqueResult();
//        分页相关
//        query.setFirstResult(index):从第几个取
//        query.setMaxResults(count):指定取几行记录

        Query query=session.createQuery("from UserInfo");
        //2 Criteria c=session.createCriteria(UserInfo.class);
        //List<User> l=c.list();
        //3.SQLQuery query=session.createSQLQuery("select * from USER_INFO");
        //List l=query.list();
        List<UserInfo> l=query.list();
        for (UserInfo userInfo2 : l) {
        	System.out.println(userInfo2);
		}
		
		
		transaction.commit();
		session.close();
	}
	
//	Session对象：   
//    代表程序和数据库的会话。Session提供了操作数据库的各种方法。是轻量级对象。 
//
//       获取Session对象 
//       factory.openSession(): 获取新的Session实例。
//       factory.getCurrentSession():采用该方法创建的Session会取出当前线程中的Session，底层使用ThreadLocal进行存取 
//	load()和get()的区别
//    我们使用get查询时发现控制台会立马打出查询语句。
//    使用load查询时控制台不会打印查询语句。
//    get方法被调用时立刻发送sql语句到数据库进行查询。
//    load方法被调用时并没有查询数据库，当我们需要使用查询的对象时，才去查询，所以当我们打印对象时，才会在控制台打印sql语句。
//
//get（）的原理 
//  程序调用get方法，Hibernate发送sql语句到数据库
//  数据库返回结果，Hibernate将结果封装成对象，返回对象到程序。
//
//load（）的原理
//  程序调用load方法，Hibernate使用代理技术，创建一个代理对象，属性只有ID值。
//  然后返回代理对象给程序，我们使用对象时，代理对象调用Hibernate查询数据库，初始化其他属性。 
//
//load方法，返回一个代理对象，获取其属性时，会查询数据库，每次访问属性都会查询数据库么？
//答：不是。代理对象中有一个标识是否被初始化的boolean类型变量，记录是否被初始化。
	public static void load(String id) {
		//配置文件来映射
		//Configuration configuration=new Configuration().configure();
		//注解来映射
		AnnotationConfiguration configuration=new AnnotationConfiguration().configure();
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=null;
//		Transaction封装了事务的操作。我们做增删改查等操作时，必须开启事务.
//      因为session是线程不安全的，这样主要是为了线程安全。保证数据的正确性。
//     开启事务： Transaction ts=session.beginTransaction();
//提交事务：ts.commit();
//回滚事务：ts.rollback();
//当通过getCurrentSession获取当前线程绑定的Session时，事务关闭时，会自动把Session关闭并删除。
		transaction=session.beginTransaction();
		UserInfo userInfo=(UserInfo) session.load(UserInfo.class, id);
		System.out.println(userInfo);
		transaction.commit();
		session.close();
	}
	
	public static void save(UserInfo userInfo) {
		Configuration configuration=new Configuration().configure();
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=null;		
		transaction=session.beginTransaction();	
		session.save(userInfo);
		transaction.commit();
		session.close();
	}
	
	public static void delete(UserInfo userInfo) {
		Configuration configuration=new Configuration().configure();
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=null;		
		transaction=session.beginTransaction();	
		session.delete(userInfo);
		transaction.commit();
		session.close();
	}
	
}
