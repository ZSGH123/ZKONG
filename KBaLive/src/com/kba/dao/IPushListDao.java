package com.kba.dao;

import java.sql.SQLException;
import java.util.List;

import com.kba.entity.PushList;
import com.kba.entity.PushType;

/**
 * 推送列表dao
 * @author 赵科
 * 创建时间：2019-1-15
 * 修改时间：2019-1-23
 */
public interface IPushListDao extends IBaseDao<PushList>{
	/**
	 * 根据指定推送类型查询所有正在推送的直播间
	 * 
	 * @param entity
	 * @return
	 * @throws SQLException
	 */
	public List<PushList> queryByPushTypeID(PushType entity) throws SQLException;
	
	/**
	 * 查询所有在有效期正在推送的直播间
	 * 
	 * @param entity
	 * @return
	 * @throws SQLException
	 */
	public List<PushList> queryValidePushList() throws SQLException;
	
}
