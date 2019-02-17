package com.kba.dao;

import java.sql.SQLException;
import java.util.List;

import com.kba.entity.LiveContent;

/**
 * 直播内容dao接口
 * @author 钟强
 * 修改时间：
 * 创建时间：2019-1-15
 */
public interface ILiveContentDao extends IBaseDao<LiveContent> {
	/**
	 * 通过直播类型查找直播内容
	 * @param entity
	 * @return
	 * @throws SQLException
	 */
	public List<LiveContent> querySingleByLiveTypeId(LiveContent entity) throws SQLException;
}
