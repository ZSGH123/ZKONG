package Hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.Employee;
import entity.Project;

public class TestProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    
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
	public void testLoad(){
		System.out.println("test");
	}
	//级联更新和保存：如果持久化一个对象，会自动持久化相关联对象
	@Test
	public void testAddProject(){
		Transaction transaction=null;		
		try {
			transaction=session.beginTransaction();	
			Project project=new Project();
			project.setpName("民宿客栈系统");
			Employee employee1=new Employee();
			employee1.seteName("zkong");
			Employee employee2=new Employee();
			employee2.seteName("冒雄斌");
			project.getEmployees().add(employee1);
			project.getEmployees().add(employee2);
//			employee1.getProjects().add(project);
//			employee2.getProjects().add(project);
			session.save(project);
			
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		session.close();
	}
	
	//级联更新和保存：如果持久化一个对象，会自动持久化相关联对象
		@Test
		public void testAddProject1(){
			Transaction transaction=null;		
			try {
				transaction=session.beginTransaction();	
				Project project=new Project();
				project.setpName("民宿客栈系统");
				Employee employee1=new Employee();
				employee1.seteName("zkong");
				Employee employee2=new Employee();
				employee2.seteName("冒雄斌");
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
		public void testUpdateProject(){
			Transaction transaction=null;		
			try {
				transaction=session.beginTransaction();	
				Project project=(Project) session.get(Project.class, 2);
				project.setpName("民宿客栈系统");
				
				session.update(project);
				
				transaction.commit();
			} catch (HibernateException e) {
				transaction.rollback();
				e.printStackTrace();
			}
			session.close();
		}
		
		@Test
		public void testUpdateProject1(){
			Transaction transaction=null;		
			try {
				transaction=session.beginTransaction();	
				Project project=(Project) session.get(Project.class, 2);
				project.setpName("民宿客栈系统");
				Employee employee=project.getEmployees().iterator().next();
				employee.seteName("zq");
				
				transaction.commit();
			} catch (HibernateException e) {
				transaction.rollback();
				e.printStackTrace();
			}
			session.close();
		}
		//孤儿删除:如果我们的对象和关联的对象解除关系后，希望自动删除不再关联的对象
		@Test
		public void testDeleteProject(){
			Transaction transaction=null;		
			try {
				transaction=session.beginTransaction();	
				Project project=(Project) session.get(Project.class, 2);
				Employee employee=project.getEmployees().iterator().next();
				project.getEmployees().remove(employee);
				
				transaction.commit();
			} catch (HibernateException e) {
				transaction.rollback();
				e.printStackTrace();
			}
			session.close();
		}
		//级联删除:
		@Test
		public void testDeleteProject1(){
			Transaction transaction=null;		
			try {
				transaction=session.beginTransaction();	
				Project project=(Project) session.get(Project.class, 2);
                session.delete(project);
				transaction.commit();
			} catch (HibernateException e) {
				transaction.rollback();
				e.printStackTrace();
			}
			session.close();
		}
}
