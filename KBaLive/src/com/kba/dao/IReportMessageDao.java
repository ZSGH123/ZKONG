package com.kba.dao;

import java.sql.SQLException;
import java.util.List;

import com.kba.entity.ReportMessage;

/**
 * 举报消息dao
 * @author 赵科
 * 创建时间：2019-1-15
 * 修改时间：
 */
public interface IReportMessageDao extends IBaseDao<ReportMessage>{
	List<ReportMessage> queryAll(ReportMessage entity)throws SQLException;
	
	List<ReportMessage> queryByUserId(ReportMessage entity)throws SQLException;
}
