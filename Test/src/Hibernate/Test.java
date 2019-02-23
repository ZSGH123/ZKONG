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

	//--------------------二级缓存---------------------//
//  get会使用二级级缓存。Load会使用二级缓存
//	注意：load和get的主要区别回顾：搜索不到符合条件的记录，get返回一个null，load会抛出一个ObjectNotFountdException
//	Load有懒加载。Get直接获得数据对象
//	iterate也会使用二级缓存。
//	list默认会往二级缓存中存放数据，即通过list查出的结果会放入二级缓存。但是list本身查询时不会使用二级缓存。 
//	List仅仅会填充二级缓存，却不能使用二级缓存Iterator可以读二级缓存，对于一条查询语句，它会先从数据库中找到所有符合条件的记录的ID，
//	再通过ID去缓存找，对于缓存中没有的记录，再构造语句从数据中查出，在缓存中没有命中的话，效率很低。
//	在应用启动时和修改时使用list,平时则使用iterator
	//-----------------------------------------//
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
//三种状态转换
//1）临时状态转换持久化状态
//-Session的save（）方法会将临时状态转换成持久状态。
//    把要保存的对象放入Session缓存中，使它进入持久化状态。使用映射文件指定的主键生成策略，为持久化对象分配唯一OID。
//    save方法只是为对象分配UID。我们可以在save方法处打断点。
//    当我们的主键生成策略为native时，由于我们使用mysql数据库，主键自增，所以执行完save方法后，打印insert语句，mysql数据库为我们对象自增OID 
//
//    当我们的主键生成策略为incrementt时，increment是由Hibernate维护，先去表中查最大ID然后+1，我们执行完save方法之后，发现打印select查找最大id的语句，执行commit时才打印插入语句
//
//
//2)临时状态转换成游离状态
//-将临时状态的对象OID设置为数据库中对应的记录.
//User user=new User();
//user.setId(1);
//
//3)持久化状态转换成临时状态
//第一种：
//    User  user=(User)session.get(User.class,1);//获取持久化对象 持久状态
//    session.close(); //游离状态
//    user.setId(null);//临时状态 
//第二种：
//    User  user=(User)session.get(User.class,1);//获取持久化对象 持久状态
//    session.evict(user); //游离状态,此方法会将session缓存中清除持久化对象，使其变为游离状态
//    user.setId(null);//临时状态  
//
//4)持久化状态转换成游离状态
//第一：调用session的close方法，持久化状态变为游离状态
//第二: 调用session的evict（）方法方法，将持久状态转变为游离状态
//
//
//5)游离状态转换成临时状态
//只需要将游离状态的对象OID变为null。
//
//6)游离状态转换成持久状态
//Session的update()方法使游离状态转换成持久状态。
//    User  user=(User)session.get(User.class,1);//获取持久化对象 持久状态
//    session.evict(user); //游离状态,此方法会将session缓存中清除持久化对象，使其变为游离状态
//    session.update(user);

//-Session的save()和persist()方法
//两个方法都是用来保存对象，能把临时状态转变为持久化状态。 
//
//两个方法的区别在于：
//save方法持久化对象时，会返回持久化对象的OID。所以程序执行save时会立刻执行insert语句，来返回数据库生成的OID。 
//
//persist方法持久化对象时，不会保证立即为持久化对象的OID赋值，不会立即生成insert语句，而是有可能在Session清理缓存时才为OID赋值。
//
//
//--Session的clear()方法
//清空一级缓存 
//
//--Session的update方法
//            update()方法可以将游离对象转变为持久化对象。用来执行修改操作。
//            update()方法完成以下操作
//            -把游离对象加入到当前缓存中，变为持久化对象
//            -然后计划执行update语句
//
//            只要通过update使游离对象转变为持久化对象，即使没有修改任何属性，在清理缓存时还是会执行update语句。
//            如果希望Session仅当修改了属性时才执行update语句，可以在映射文件中的<class>元素中设置select-before-update="true",默认为false
//            这样当Session清理缓存时，会先发送一条查询语句，然后判断缓存中的对象和记录是否一致，不一致才执行update语句。
//
//            当update()方法将游离对象转变为持久化对象时，如果Session缓存中已经存在相同的OID持久化对象，那么会抛出异常。
//            例如：
//                Transaction ts=session.beginTransaction();
//                User user1=session.get(User.class, 5);
//                session.evict(user1);
//                User user2=session.get(User.class, 5);
//                session.update(user1);
//                ts.commit();
//
//                因为Session的缓存是一个Map结构，OID为key，对象为value。
//                当执行session的update方法时，由于缓存中已经存在了OID为5的持久化对象，因此会抛出异常。 
//
//-Session的saveOrUpdate()方法 
//
//    Session的saveOrUpdate()方法同时包含了save()和update()方法的功能
//    如果传入的参数是临时对象(OID为null)，就调用save方法。
//    如果传入的参数是游离对象(OID不为null)，就执行update方法。

