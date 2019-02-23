package Hibernate;


import java.util.List;

import org.hibernate.HibernateException;
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

	//--------------------��������---------------------//
//  get��ʹ�ö��������档Load��ʹ�ö�������
//	ע�⣺load��get����Ҫ����عˣ������������������ļ�¼��get����һ��null��load���׳�һ��ObjectNotFountdException
//	Load�������ء�Getֱ�ӻ�����ݶ���
//	iterateҲ��ʹ�ö������档
//	listĬ�ϻ������������д�����ݣ���ͨ��list����Ľ�������������档����list�����ѯʱ����ʹ�ö������档 
//	List���������������棬ȴ����ʹ�ö�������Iterator���Զ��������棬����һ����ѯ��䣬�����ȴ����ݿ����ҵ����з��������ļ�¼��ID��
//	��ͨ��IDȥ�����ң����ڻ�����û�еļ�¼���ٹ������������в�����ڻ�����û�����еĻ���Ч�ʺܵ͡�
//	��Ӧ������ʱ���޸�ʱʹ��list,ƽʱ��ʹ��iterator
	//-----------------------------------------//
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
		try {	
			transaction=session.beginTransaction();	
			session.save(userInfo);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
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
//����״̬ת��
//1����ʱ״̬ת���־û�״̬
//-Session��save���������Ὣ��ʱ״̬ת���ɳ־�״̬��
//    ��Ҫ����Ķ������Session�����У�ʹ������־û�״̬��ʹ��ӳ���ļ�ָ�����������ɲ��ԣ�Ϊ�־û��������ΨһOID��
//    save����ֻ��Ϊ�������UID�����ǿ�����save��������ϵ㡣
//    �����ǵ��������ɲ���Ϊnativeʱ����������ʹ��mysql���ݿ⣬��������������ִ����save�����󣬴�ӡinsert��䣬mysql���ݿ�Ϊ���Ƕ�������OID 
//
//    �����ǵ��������ɲ���Ϊincrementtʱ��increment����Hibernateά������ȥ���в����IDȻ��+1������ִ����save����֮�󣬷��ִ�ӡselect�������id����䣬ִ��commitʱ�Ŵ�ӡ�������
//
//
//2)��ʱ״̬ת��������״̬
//-����ʱ״̬�Ķ���OID����Ϊ���ݿ��ж�Ӧ�ļ�¼.
//User user=new User();
//user.setId(1);
//
//3)�־û�״̬ת������ʱ״̬
//��һ�֣�
//    User  user=(User)session.get(User.class,1);//��ȡ�־û����� �־�״̬
//    session.close(); //����״̬
//    user.setId(null);//��ʱ״̬ 
//�ڶ��֣�
//    User  user=(User)session.get(User.class,1);//��ȡ�־û����� �־�״̬
//    session.evict(user); //����״̬,�˷����Ὣsession����������־û�����ʹ���Ϊ����״̬
//    user.setId(null);//��ʱ״̬  
//
//4)�־û�״̬ת��������״̬
//��һ������session��close�������־û�״̬��Ϊ����״̬
//�ڶ�: ����session��evict�����������������־�״̬ת��Ϊ����״̬
//
//
//5)����״̬ת������ʱ״̬
//ֻ��Ҫ������״̬�Ķ���OID��Ϊnull��
//
//6)����״̬ת���ɳ־�״̬
//Session��update()����ʹ����״̬ת���ɳ־�״̬��
//    User  user=(User)session.get(User.class,1);//��ȡ�־û����� �־�״̬
//    session.evict(user); //����״̬,�˷����Ὣsession����������־û�����ʹ���Ϊ����״̬
//    session.update(user);

//-Session��save()��persist()����
//������������������������ܰ���ʱ״̬ת��Ϊ�־û�״̬�� 
//
//�����������������ڣ�
//save�����־û�����ʱ���᷵�س־û������OID�����Գ���ִ��saveʱ������ִ��insert��䣬���������ݿ����ɵ�OID�� 
//
//persist�����־û�����ʱ�����ᱣ֤����Ϊ�־û������OID��ֵ��������������insert��䣬�����п�����Session������ʱ��ΪOID��ֵ��
//
//
//--Session��clear()����
//���һ������ 
//
//--Session��update����
//            update()�������Խ��������ת��Ϊ�־û���������ִ���޸Ĳ�����
//            update()����������²���
//            -�����������뵽��ǰ�����У���Ϊ�־û�����
//            -Ȼ��ƻ�ִ��update���
//
//            ֻҪͨ��updateʹ�������ת��Ϊ�־û����󣬼�ʹû���޸��κ����ԣ���������ʱ���ǻ�ִ��update��䡣
//            ���ϣ��Session�����޸�������ʱ��ִ��update��䣬������ӳ���ļ��е�<class>Ԫ��������select-before-update="true",Ĭ��Ϊfalse
//            ������Session������ʱ�����ȷ���һ����ѯ��䣬Ȼ���жϻ����еĶ���ͼ�¼�Ƿ�һ�£���һ�²�ִ��update��䡣
//
//            ��update()�������������ת��Ϊ�־û�����ʱ�����Session�������Ѿ�������ͬ��OID�־û�������ô���׳��쳣��
//            ���磺
//                Transaction ts=session.beginTransaction();
//                User user1=session.get(User.class, 5);
//                session.evict(user1);
//                User user2=session.get(User.class, 5);
//                session.update(user1);
//                ts.commit();
//
//                ��ΪSession�Ļ�����һ��Map�ṹ��OIDΪkey������Ϊvalue��
//                ��ִ��session��update����ʱ�����ڻ������Ѿ�������OIDΪ5�ĳ־û�������˻��׳��쳣�� 
//
//-Session��saveOrUpdate()���� 
//
//    Session��saveOrUpdate()����ͬʱ������save()��update()�����Ĺ���
//    �������Ĳ�������ʱ����(OIDΪnull)���͵���save������
//    �������Ĳ������������(OID��Ϊnull)����ִ��update������

