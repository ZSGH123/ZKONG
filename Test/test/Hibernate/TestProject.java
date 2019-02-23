package Hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.City;
import entity.Employee;
import entity.Project;
import entity.Street;
import entity.UserInfo;

public class TestProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static Session session;

	@BeforeClass
	public static void init() {
		try {
			session = HibernateSessionFactory.getSession();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testLoad() {
		System.out.println("test");
	}

	// �������ºͱ��棺����־û�һ�����󣬻��Զ��־û����������
	@Test
	public void testAddProject() {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Project project = new Project();
			project.setpName("���޿�ջϵͳ");
			Employee employee1 = new Employee();
			employee1.seteName("zkong");
			Employee employee2 = new Employee();
			employee2.seteName("ð�۱�");
			project.getEmployees().add(employee1);
			project.getEmployees().add(employee2);
			// employee1.getProjects().add(project);
			// employee2.getProjects().add(project);
			session.save(project);

			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		session.close();
	}

	// �������ºͱ��棺����־û�һ�����󣬻��Զ��־û����������
	@Test
	public void testAddProject1() {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Project project = new Project();
			project.setpName("���޿�ջϵͳ");
			Employee employee1 = new Employee();
			employee1.seteName("zkong");
			Employee employee2 = new Employee();
			employee2.seteName("ð�۱�");
			project.getEmployees().add(employee1);
			project.getEmployees().add(employee2);
			session.save(project);

			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		session.close();
	}

	@Test
	public void testUpdateProject() {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Project project = (Project) session.get(Project.class, 2);
			project.setpName("���޿�ջϵͳ");

			session.update(project);

			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		session.close();
	}

	@Test
	public void testUpdateProject1() {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Project project = (Project) session.get(Project.class, 2);
			project.setpName("���޿�ջϵͳ");
			Employee employee = project.getEmployees().iterator().next();
			employee.seteName("zq");

			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		session.close();
	}

	// �¶�ɾ��:������ǵĶ���͹����Ķ�������ϵ��ϣ���Զ�ɾ�����ٹ����Ķ���
	@Test
	public void testDeleteProject() {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Project project = (Project) session.get(Project.class, 2);
			Employee employee = project.getEmployees().iterator().next();
			project.getEmployees().remove(employee);

			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		session.close();
	}

	// ����ɾ��:
	@Test
	public void testDeleteProject1() {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Project project = (Project) session.get(Project.class, 2);
			session.delete(project);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		session.close();
	}

	@Test
	public void testSearchProject1() {
		HibernateHandler hibernateHandler = new HibernateHandler();
		hibernateHandler.handler(session, new IHandle() {
			@Override
			public void handler(Session session) {
				String hql = "from UserInfo";
				Query query = session.createQuery(hql);
				List<UserInfo> userInfos = query.list();
				for (UserInfo userInfo2 : userInfos) {
					System.out.println(userInfo2);
				}

			}
		});

	}

	@Test
	public void testSearchProject() {
		HibernateHandler hibernateHandler = new HibernateHandler();
		hibernateHandler.handler(session, new IHandle() {
			@Override
			public void handler(Session session) {
				String hql = "select us.userName,us.userPassword from UserInfo us";
				Query query = session.createQuery(hql);
				List userInfos = query.list();
				Iterator iterator = userInfos.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					System.out.println(objects[0] + ":" + objects[1]);
				}
			}
		});

	}

	@Test
	public void testSearchProject2() {
		HibernateHandler hibernateHandler = new HibernateHandler();
		hibernateHandler.handler(session, new IHandle() {
			@Override
			public void handler(Session session) {
				String hql = "select new UserInfo(us.userName,us.userPassword) from UserInfo us";
				Query query = session.createQuery(hql);
				List<UserInfo> userInfos = query.list();
				Iterator<UserInfo> iterator = userInfos.iterator();
				while (iterator.hasNext()) {
					UserInfo userInfo = iterator.next();
					System.out.println(userInfo.getUserName() + ":" + userInfo.getUserPassword());
				}
			}
		});

	}

	// ��������
	@Test
	public void testSearchProject3() {
		HibernateHandler hibernateHandler = new HibernateHandler();
		hibernateHandler.handler(session, new IHandle() {
			@Override
			public void handler(Session session) {
				String hql = "select new UserInfo(us.userName,us.userPassword) from UserInfo us where us.userName like ?";
				Query query = session.createQuery(hql);
				query.setString(0, "%��%");
				List<UserInfo> userInfos = query.list();
				Iterator<UserInfo> iterator = userInfos.iterator();
				while (iterator.hasNext()) {
					UserInfo userInfo = iterator.next();
					System.out.println(userInfo.getUserName() + ":" + userInfo.getUserPassword());
				}
			}
		});

	}

	// ��������
	@Test
	public void testSearchProject4() {
		HibernateHandler hibernateHandler = new HibernateHandler();
		hibernateHandler.handler(session, new IHandle() {
			@Override
			public void handler(Session session) {
				String hql = "select new UserInfo(us.userName,us.userPassword) from UserInfo us where us.userName like :word";
				Query query = session.createQuery(hql);
				query.setString("word", "%��%");
				List<UserInfo> userInfos = query.list();
				Iterator<UserInfo> iterator = userInfos.iterator();
				while (iterator.hasNext()) {
					UserInfo userInfo = iterator.next();
					System.out.println(userInfo.getUserName() + ":" + userInfo.getUserPassword());
				}
			}
		});

	}

	// ��ҳ��ѯ
	@Test
	public void testSearchProject5() {
		HibernateHandler hibernateHandler = new HibernateHandler();
		String hql = "from UserInfo us order by us.userPhoneNumber";
		List<UserInfo> userInfos = hibernateHandler.handlerPage(session, 3, 5, hql);
		Iterator<UserInfo> iterator = userInfos.iterator();
		while (iterator.hasNext()) {
			UserInfo userInfo = iterator.next();
			System.out.println(userInfo.getUserName() + ":" + userInfo.getUserPassword());
		}
	}

	// ��������fetch
	@Test
	public void testSearchProject6() {
		HibernateHandler hibernateHandler = new HibernateHandler();
		hibernateHandler.handler(session, new IHandle() {
			@Override
			public void handler(Session session) {
				String hql = " from City c left join fetch c.streets";
				Query query = session.createQuery(hql);
				List<City> userInfos = query.list();
				Iterator<City> iterator = userInfos.iterator();
				while (iterator.hasNext()) {
					City city = iterator.next();
					System.out.print(city.getcName());
					Iterator<Street> iterator1 = city.getStreets().iterator();
					while (iterator1.hasNext()) {
						Street street = iterator1.next();
						System.out.print(":" + street.getsName());
					}
					System.out.println("");
				}
			}
		});
	}

	// ������
	@Test
	public void testSearchProject7() {
		HibernateHandler hibernateHandler = new HibernateHandler();
		hibernateHandler.handler(session, new IHandle() {
			@Override
			public void handler(Session session) {
				String hql = "select new City(c.cId,c.cName) from City c left join c.streets";
				Query query = session.createQuery(hql);
				List<City> userInfos = query.list();
				Iterator<City> iterator = userInfos.iterator();
				while (iterator.hasNext()) {
					City city = iterator.next();
					System.out.print(city.getcName());
					Iterator<Street> iterator1 = city.getStreets().iterator();
					while (iterator1.hasNext()) {
						Street street = iterator1.next();
						System.out.print(":" + street.getsName());
					}
					System.out.println("");
				}
			}
		});
	}
	
	/**
	 * ���ԣ�get��load��ʹ�ö�������
	 */
	@Test
	public void testDeleteProject8() {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			//get��û�м�¼���򷵻�null��loadû�м�¼������ObjectNotFountdException�쳣
			//Project project = (Project) session.get(Project.class, 1);
			Project project = (Project) session.load(Project.class, 1);
			System.out.print(project.getpName());
			transaction.commit();
			session.close();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		Transaction transaction1 = null;
		session = HibernateSessionFactory.getSession();
		try {
			transaction1 = session.beginTransaction();
			Project project = (Project) session.get(Project.class, 1);
			System.out.print(project.getpName());
			transaction1.commit();
			session.close();
		} catch (HibernateException e) {
			transaction1.rollback();
			e.printStackTrace();
		}	
	}

	/**
	 * ���ԣ�listʹ�ö�������
	 * listĬ�ϻ������������д�����ݣ���ͨ��list����Ľ�������������档
	 * ����list�����ѯʱ����ʹ�ö������档 List���������������棬ȴ����ʹ�ö�������
	 */
	@Test
	public void testListProject() {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			String hql = "from UserInfo";
			Query query = session.createQuery(hql);
			List<UserInfo> userInfos = query.list();
			for (UserInfo userInfo2 : userInfos) {
				System.out.println(userInfo2);
			}
			session.close();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		Transaction transaction1 = null;
		session = HibernateSessionFactory.getSession();
		try {
			transaction1 = session.beginTransaction();
			String hql = "from UserInfo";
			Query query = session.createQuery(hql);
			List<UserInfo> userInfos = query.list();
			for (UserInfo userInfo2 : userInfos) {
				System.out.println(userInfo2);
			}
			session.close();
		} catch (HibernateException e) {
			transaction1.rollback();
			e.printStackTrace();
		}	
	}
	
	/**
	 * ���ԣ�Iterator���Զ��������棬����һ����ѯ��䣬
	 * �����ȴ����ݿ����ҵ����з��������ļ�¼��ID����ͨ��IDȥ�����ң�
	 * ���ڻ�����û�еļ�¼���ٹ������������в�����ڻ�����û�����еĻ���Ч�ʺܵ�
	 */
	@Test
	public void testIterateProject() {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			String hql = "from UserInfo";
			Query query = session.createQuery(hql);
			List<UserInfo> userInfos = query.list();
			for (UserInfo userInfo2 : userInfos) {
				System.out.println(userInfo2);
			}
			session.close();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		Transaction transaction1 = null;
		session = HibernateSessionFactory.getSession();
		try {
			transaction1 = session.beginTransaction();
			String hql = "from UserInfo";
			Query query = session.createQuery(hql);
			Iterator<UserInfo> userInfos = query.iterate();
			while (userInfos.hasNext()) {
				UserInfo userInfo=userInfos.next();
				System.out.println(userInfo);
			}
			session.close();
		} catch (HibernateException e) {
			transaction1.rollback();
			e.printStackTrace();
		}	
	}
	/**
	 * ��Ӧ������ʱ���޸�ʱʹ��list,ƽʱ��ʹ��iterator
	 */
	@Test
	public void testIterateProject1() {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			String hql = "from UserInfo";
			Query query = session.createQuery(hql);
			Iterator<UserInfo> userInfos = query.iterate();
			while (userInfos.hasNext()) {
				UserInfo userInfo=userInfos.next();
				System.out.println(userInfo);
			}
			session.close();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		Transaction transaction1 = null;
		session = HibernateSessionFactory.getSession();
		try {
			transaction1 = session.beginTransaction();
			String hql = "from UserInfo";
			Query query = session.createQuery(hql);
			Iterator<UserInfo> userInfos = query.iterate();
			while (userInfos.hasNext()) {
				UserInfo userInfo=userInfos.next();
				System.out.println(userInfo);
			}
			session.close();
		} catch (HibernateException e) {
			transaction1.rollback();
			e.printStackTrace();
		}	
	}
}
