package com.kba.dao.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

/**
 * 查询模板方法 添加、更新、删除模板方法.
 * 
 * @author zk
 *
 */
public class QueryRunner {

	// 数据源
	private DataSource dataSource;

	/**
	 * 无参数
	 */
	public QueryRunner() {

	}

	/**
	 * 数据源
	 * 
	 * @param dataSource
	 */
	public QueryRunner(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * 1、连接内部提供 2、不带参数sql 3、处理结果集
	 * 
	 * @param sql
	 * @param rsh
	 * @return 一行数据==》对象
	 * @throws SQLException
	 */
	public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
		return this.<T> query(sql, rsh, (Object[]) null);
	}

	/**
	 * 功能： 1、连接内部提供 2、带参数sql Object..可变长参数
	 * 
	 * @param sql
	 * @param rsh
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public <T> T query(String sql, ResultSetHandler<T> rsh, Object... args) throws SQLException {
		return this.<T> query(null, sql, rsh, args);
	}

	public <T> T query(Connection connection, String sql, ResultSetHandler<T> rsh) throws SQLException {
		return this.<T> query(connection, sql, rsh, (Object[]) null);
	}

	/**
	 * 模板方法 预测 后知后
	 * 
	 * @param connection
	 * @param sql
	 * @param rsh
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public <T> T query(Connection connection, String sql, ResultSetHandler<T> rsh, Object... args) throws SQLException {
		// 建立连接
		if (connection == null)
			connection = this.dataSource.getConnection();
		if (sql == null)
			throw new SQLException("SQL语句不正确");
		// 预处理语句【预编译】 Statement CallableStatement(存储过程)
		PreparedStatement preStatement = connection.prepareStatement(sql);
		// SQL指定参数值
		fillStatement(preStatement, args);
		// 结果集
		ResultSet rs = preStatement.executeQuery();
		// 结果处理规范
		T result = rsh.handle(rs);
		this.close(connection, preStatement, rs);
		return result;
	}

	/**
	 * 带参数SQL （？，？）
	 * 
	 * @param preStatement
	 * @param args
	 * @throws SQLException
	 */
	private void fillStatement(PreparedStatement preStatement, Object... args) throws SQLException {
		if (args == null || args.length == 0)
			return;
		try {
			for (int i = 0; i < args.length; i++) {
				preStatement.setObject(i + 1, args[i]);
			}
		} catch (SQLException e) {
			throw e;
		}
	}

	/**
	 * 
	 * @param sql
	 * @param args
	 * @return
	 */
	public int update(String sql) throws SQLException {
		return this.update(sql, (Object[]) null);
	}

	public int update(String sql, Object... args) throws SQLException {
		return this.update(null, sql, args);
	}

	public int update(Connection connection, String sql) throws SQLException {
		return this.update(connection, sql, (Object[]) null);
	}

	/**
	 * 更新，删除，添加
	 * 
	 * @param connection
	 * @param sql
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public int update(Connection connection, String sql, Object... args) throws SQLException {
		if (connection == null)
			connection = this.dataSource.getConnection();
		if (sql == null)
			throw new SQLException("SQL语句不正确！");
		PreparedStatement preStatement = connection.prepareStatement(sql);
		fillStatement(preStatement, args);
        int result=preStatement.executeUpdate();
        this.close(connection, preStatement, null);
		return result;
	}

	/**
	 * 关闭
	 * 
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	private void close(Connection conn, Statement stmt, ResultSet rs) {
		DbUtils.closeQuietly(conn, stmt, rs);
	}
}
