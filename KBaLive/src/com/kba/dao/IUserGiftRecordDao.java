package com.kba.dao;

import java.sql.SQLException;
import java.util.List;

import com.kba.entity.UserGiftRecord;

/**
 * 用户赠礼记录dao
 * @author 赵科
 * 创建时间：2019-1-15
 * 修改时间：
 */
public interface IUserGiftRecordDao extends IBaseDao<UserGiftRecord>{

	/**
	 * 查询用户赠礼记录
	 * @param entity
	 * @return
	 * @throws SQLException
	 */
	List<UserGiftRecord> querySinglebyid(UserGiftRecord entity) throws SQLException;
	
	List<UserGiftRecord> queryByUserId(UserGiftRecord entity)throws SQLException;
	
	List<UserGiftRecord> queryAll(UserGiftRecord entity) throws SQLException;
}
