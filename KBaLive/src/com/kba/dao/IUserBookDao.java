package com.kba.dao;

import java.sql.SQLException;
import java.util.List;

import com.kba.entity.UserBook;

/**
 * 用户订阅dao
 * @author 赵科
 * 创建时间：2019-1-15
 * 修改时间：
 */
public interface IUserBookDao extends IBaseDao<UserBook>{
	/**
	 * 查询所有订阅
	 * 作者：单杰
	 * 时间：2019-1-23
	 */
	List<UserBook> queryAll (UserBook entity)throws SQLException;
	
	/**
	 * 按用户id查询订阅
	 * 作者：单杰
	 * 时间：2019-1-23
	 */
	List<UserBook> queryByUserId (UserBook entity)throws SQLException;
	
}
