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
	//�������ºͱ��棺����־û�һ�����󣬻��Զ��־û����������
	@Test
	public void testAddProject(){
		Transaction transaction=null;		
		try {
			transaction=session.beginTransaction();	
			Project project=new Project();
			project.setpName("���޿�ջϵͳ");
			Employee employee1=new Employee();
			employee1.seteName("zkong");
			Employee employee2=new Employee();
			employee2.seteName("ð�۱�");
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
	
	//�������ºͱ��棺����־û�һ�����󣬻��Զ��־û����������
		@Test
		public void testAddProject1(){
			Transaction transaction=null;		
			try {
				transaction=session.beginTransaction();	
				Project project=new Project();
				project.setpName("���޿�ջϵͳ");
				Employee employee1=new Employee();
				employee1.seteName("zkong");
				Employee employee2=new Employee();
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
		public void testUpdateProject(){
			Transaction transaction=null;		
			try {
				transaction=session.beginTransaction();	
				Project project=(Project) session.get(Project.class, 2);
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
		public void testUpdateProject1(){
			Transaction transaction=null;		
			try {
				transaction=session.beginTransaction();	
				Project project=(Project) session.get(Project.class, 2);
				project.setpName("���޿�ջϵͳ");
				Employee employee=project.getEmployees().iterator().next();
				employee.seteName("zq");
				
				transaction.commit();
			} catch (HibernateException e) {
				transaction.rollback();
				e.printStackTrace();
			}
			session.close();
		}
		//�¶�ɾ��:������ǵĶ���͹����Ķ�������ϵ��ϣ���Զ�ɾ�����ٹ����Ķ���
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
		//����ɾ��:
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
