package com.kba.dao;

import java.sql.SQLException;
import java.util.List;

import com.kba.entity.LiveRecord;

/**
 * 直播记录dao接口
 * @author 钟强
 * 修改时间：
 * 创建时间：2019-1-15
 */
public interface ILiveRecordDao extends IBaseDao<LiveRecord> {
	/**
	 * 查询全部直播记录
	 * 作者：单杰
	 */
	List<LiveRecord> queryAll(LiveRecord entity)throws SQLException;
	/**
	 * 按照用户名查询直播记录
	 * @param entity
	 * @return
	 * @throws SQLException
	 * 作者：单杰
	 */
	List<LiveRecord> queryByUserId(LiveRecord entity)throws SQLException;

}
