package com.kba.dao.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 打破现在逻辑
 * 
 * @author zk
 *
 */
public final class DbUtils {

	/**
	 * 关闭连接
	 * 
	 * @param conn
	 * @throws SQLException
	 */
	public static void close(Connection conn) throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}

	/**
	 * 不可预料的异常
	 * 
	 * @param conn
	 */
	public static void closeQuietly(Connection conn) {
		try {
			close(conn);
		} catch (SQLException e) { // NOPMD
			// quiet
		}
	}

	public static void close(ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
	}

	public static void close(Statement stmt) throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
	}

	public static void closeQuietly(ResultSet rs) {
		try {
			close(rs);
		} catch (SQLException e) { // NOPMD
			// quiet
		}
	}

	public static void closeQuietly(Statement stmt) {
		try {
			close(stmt);
		} catch (SQLException e) { // NOPMD
			// quiet
		}
	}

	/**
	 * 关闭
	 * 
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public static void closeQuietly(Connection conn, Statement stmt, ResultSet rs) {
		try {
			closeQuietly(rs);
		} finally {
			try {
				closeQuietly(stmt);
			} finally {
				closeQuietly(conn);
			}
		}
	}
}
