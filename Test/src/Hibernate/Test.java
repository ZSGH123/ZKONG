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
//		userInfo.setUserName("ʫ����");
//		userInfo.setUserPassword("Zq123456");
//		save(userInfo);
//		UserInfo userInfo=new UserInfo();
//		userInfo.setUserName("ʫ����");
//		userInfo.setUserPassword("Zq123456");
//		userInfo.setUserId("1000000055");
//		delete(userInfo);
	}
	/**
	 * ��ѯ(���ӳټ���)
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
		//��ѯ����
		//1.ʹ��HQL���ԣ��������ϸ���ܣ���HQL��������������
		//��װHQL���Ķ���

//        Query���󷵻�һ������ķ��� query.uniqueResult();
//        ��ҳ���
//        query.setFirstResult(index):�ӵڼ���ȡ
//        query.setMaxResults(count):ָ��ȡ���м�¼

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
	
//	Session����   
//    �����������ݿ�ĻỰ��Session�ṩ�˲������ݿ�ĸ��ַ����������������� 
//
//       ��ȡSession���� 
//       factory.openSession(): ��ȡ�µ�Sessionʵ����
//       factory.getCurrentSession():���ø÷���������Session��ȡ����ǰ�߳��е�Session���ײ�ʹ��ThreadLocal���д�ȡ 
//	load()��get()������
//    ����ʹ��get��ѯʱ���ֿ���̨����������ѯ��䡣
//    ʹ��load��ѯʱ����̨�����ӡ��ѯ��䡣
//    get����������ʱ���̷���sql��䵽���ݿ���в�ѯ��
//    load����������ʱ��û�в�ѯ���ݿ⣬��������Ҫʹ�ò�ѯ�Ķ���ʱ����ȥ��ѯ�����Ե����Ǵ�ӡ����ʱ���Ż��ڿ���̨��ӡsql��䡣
//
//get������ԭ�� 
//  �������get������Hibernate����sql��䵽���ݿ�
//  ���ݿⷵ�ؽ����Hibernate�������װ�ɶ��󣬷��ض��󵽳���
//
//load������ԭ��
//  �������load������Hibernateʹ�ô�����������һ�������������ֻ��IDֵ��
//  Ȼ�󷵻ش���������������ʹ�ö���ʱ������������Hibernate��ѯ���ݿ⣬��ʼ���������ԡ� 
//
//load����������һ��������󣬻�ȡ������ʱ�����ѯ���ݿ⣬ÿ�η������Զ����ѯ���ݿ�ô��
//�𣺲��ǡ������������һ����ʶ�Ƿ񱻳�ʼ����boolean���ͱ�������¼�Ƿ񱻳�ʼ����
	public static void load(String id) {
		//�����ļ���ӳ��
		//Configuration configuration=new Configuration().configure();
		//ע����ӳ��
		AnnotationConfiguration configuration=new AnnotationConfiguration().configure();
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=null;
//		Transaction��װ������Ĳ�������������ɾ�Ĳ�Ȳ���ʱ�����뿪������.
//      ��Ϊsession���̲߳���ȫ�ģ�������Ҫ��Ϊ���̰߳�ȫ����֤���ݵ���ȷ�ԡ�
//     �������� Transaction ts=session.beginTransaction();
//�ύ����ts.commit();
//�ع�����ts.rollback();
//��ͨ��getCurrentSession��ȡ��ǰ�̰߳󶨵�Sessionʱ������ر�ʱ�����Զ���Session�رղ�ɾ����
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
