package com.kba.dao;

import java.sql.SQLException;
import java.util.List;

import com.kba.entity.GiftInfo;

/**
 * 直播信息dao
 * @author 赵科
 * 创建时间：2019-1-15
 * 修改时间：
 */
public interface IGiftInfoDao extends IBaseDao<GiftInfo>{
	
	List<GiftInfo> queryAll(GiftInfo entity)throws SQLException;
	
	GiftInfo querySingleByName(GiftInfo entity)throws SQLException;
}
