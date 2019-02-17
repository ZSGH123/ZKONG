package com.kba.dao.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.kba.util.KBaException;
import com.kba.util.ParseConfig;

/**
 * 创建本地连接对象
 * 企业性（软件周期：后期维护（升级）可扩展性）稳定性，，
 * 商业性：体验性（视觉，性能） 
 * 
 * 原生构建：快，好 
 * @author zk
 * 时间：2019-1-15
 */
public class DbConnector extends AbstractDataSource {

	// 日志对象（文件流输出）
	private static Logger logger = Logger.getLogger(DbConnector.class);
	// 连接信息
	private static ConnectionInfo connInfo;

	// 静态代码块方式加载驱动类
	static {

			try {
				connInfo = ParseConfig.getInstance().parseDbInfo();
				// 反射
				Class<?> clz=Class.forName(connInfo.driverClass);
				//驱动器
				Driver driver=(Driver)clz.newInstance();
				//注册
				DriverManager.registerDriver(driver);
				logger.info("驱动类加载成功！");
			} catch (KBaException | ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
				logger.error(connInfo.driverClass + "驱动类加载失败！");
				logger.error(e.getMessage());				
			}
			
		 
		
	}
	

	@Override
	public Connection getConnection() throws SQLException {
		// ����������
		Connection connection = DriverManager.getConnection(connInfo.url, connInfo.uname, connInfo.upwd);
		return connection;
	}

	/**
	 * 
	 * @author YW
	 *
	 */
	public static class ConnectionInfo {
		public String driverClass;
		public String url;
		public String uname;
		public String upwd;
	}
}
