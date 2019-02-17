package com.kba.dao.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.kba.util.KBaException;
import com.kba.util.ParseConfig;

/**
 * 数据源工厂
 * 
 * @author zk
 * 时间：2019-1-15
 */
public class DataSourceFactory {
    
	private static Logger logger=Logger.getLogger(DataSourceFactory.class);
	/**
	 * 工厂方法：得到数据源 1、本地数据源 2、连接池对象
	 * 
	 * @return
	 */
	public static DataSource getDataSource() {
		DataSource dataSource = null;
		try {
			String type = ParseConfig.getInstance().getDsType();
			if ("local".equals(type)) {
				dataSource = new DbConnector();
			} else if ("tomcat".equals(type)) {
				dataSource = getDsByTomcat();
			    logger.info("获取tomcat数据源成功");
			}
		} catch (KBaException e) {
			e.printStackTrace();
		}
		return dataSource;
	}

	/**
	 * tomcat获得数据源:
	 */
	public static DataSource getDsByTomcat() {
		DataSource ds = null;
		// JDNI API
		try {
			// JNDI 上下文对象
			Context context = new InitialContext();
			// 发布者
			Context envContext = (Context) context.lookup("java:/comp/env");
			// 资源
			ds = (DataSource) envContext.lookup("jdbc/kba");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return ds;
	}
}
