package com.kba.dao.impl;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.kba.dao.util.DataSourceFactory;
import com.kba.dao.util.ParseSqlStatement;
import com.kba.dao.util.QueryRunner;
import com.kba.util.KBaException;

/**
 * 抽象方法：把查询器和解析器封装到数据源。
 * @author  赵科
 * 时间：2019-1-11
 */
public abstract class AbstractBaseDao {
	// 日志对象
	protected Logger logger = Logger.getLogger(UserDao.class);
	// 查询器
	protected QueryRunner queryRunner;
	 //解析器
	protected ParseSqlStatement parseSqlStatement;

	public AbstractBaseDao() {
		try {
			// 通过工厂方法得到数据源
			DataSource dataSource = DataSourceFactory.getDataSource();
			this.queryRunner = new QueryRunner(dataSource);
			this.parseSqlStatement = ParseSqlStatement.getInstance();
		} catch (KBaException e) {
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
}
