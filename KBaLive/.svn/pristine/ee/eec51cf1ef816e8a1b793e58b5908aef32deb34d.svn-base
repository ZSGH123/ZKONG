package com.kba.dao;

import java.sql.SQLException;

import com.kba.entity.UserInfo;

/**
 * 数据库用户表的方法
 * @author 赵科
 * 时间：2019-1-11
 * 修改人：钟强
 * 修改时间：2019-1-16
 */
public interface  IUserDao extends IBaseDao<UserInfo> {

	/**
	 * 通过用户名查找用户
	 * @param entity
	 * @return
	 * @throws SQLException
	 */
	public UserInfo querySingleByName(UserInfo entity) throws SQLException;
	/**
	 * 通过手机号查找用户
	 * @param entity
	 * @return
	 * @throws SQLException
	 */
	public UserInfo querySingleByPhone(UserInfo entity) throws SQLException;
	/**
	 * 通过手机号查找用户id
	 * 
	 * @param entity
	 * @return
	 * @throws SQLException
	 */
	public UserInfo querySingleByUserID(UserInfo entity) throws SQLException;
	
}
