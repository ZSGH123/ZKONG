package com.kba.dao;

import java.sql.SQLException;
import java.util.List;

import com.kba.entity.GagInfo;

/**
 * 禁言信息dao
 * @author 赵科
 * 创建时间：2019-1-15
 * 修改时间：
 */
public interface IGagInfoDao extends IBaseDao<GagInfo>{
	/**
	 * 查询所有禁言信息
	 * @param entity
	 * @return
	 * 作者：单杰
	 * @throws SQLException
	 */
	List<GagInfo> queryAll(GagInfo entity)throws SQLException;
	/**
	 * 通过主播id查询禁言信息
	 * @param entity
	 * @return
	 * @throws SQLException
	 * 作者：单杰
	 */
	List<GagInfo> queryByAnchorId(GagInfo entity)throws SQLException;
}
