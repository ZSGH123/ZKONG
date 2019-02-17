package com.kba.service;

import java.util.List;

import com.kba.entity.LiveRecord;
import com.kba.util.KBaException;

/**
 * 后台查询主播直播记录
 * @author 单杰
 * 时间：2019-1-23
 */
public interface IBackStageLiveRecordService {
	
	public List<LiveRecord> selectAllRecord(LiveRecord record)throws KBaException;
	public List<LiveRecord> selectByUserId(LiveRecord record)throws KBaException;
}
