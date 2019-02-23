package Hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 * 模板方法设计模式
 * @author 钟强
 *
 */
public class HibernateHandler {

	public void handler(Session session, IHandle handler) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			handler.handler(session);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		session.close();
	}
	/**
	 * 分页查询
	 * @param session
	 * @param pageNo
	 * @param pageSize
	 * @param sql
	 * @return
	 */
	public  List handlerPage(Session session,int pageNo,int pageSize,String sql) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query=session.createQuery(sql);
			int firstPage=(pageNo-1)*pageSize;
			query.setFirstResult(firstPage);
			query.setMaxResults(pageSize);
			return query.list();	
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			transaction.commit();
			session.close();
		}
		return null;
	}
}
