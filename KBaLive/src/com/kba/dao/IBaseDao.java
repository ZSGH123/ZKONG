package com.kba.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * 数据层，接口规范：数据层公有的操作方法
 * @author 赵科
 * 时间：2019-1-11
 * @param <T>
 */
public interface IBaseDao<T> {
	/**
	 * 查询
	 */
	public List<T> queryAll(T entity) throws SQLException;

	/**
	 * 单个查询
	 */
	public T querySingle(T entity) throws SQLException;

	/**
	 * 添加
	 */
	public int insert(T entity) throws SQLException;

	/**
	 * 更新
	 */
	public int update(T entity) throws SQLException;

	/**
	 * 删除
	 */
	public int delete(T entity) throws SQLException;

}
