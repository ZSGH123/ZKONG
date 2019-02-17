package com.kba.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.kba.dao.ILiveRecordDao;
import com.kba.dao.impl.LiveRecordDao;
import com.kba.entity.LiveRecord;
import com.kba.service.IBackStageLiveRecordService;
import com.kba.util.KBaException;

/**
 * 后台主播直播记录查询
 * @author 单杰
 * 时间：2019-1-23
 */
public class BackStageLiveRecordService implements IBackStageLiveRecordService {
	private ILiveRecordDao liveRecordDao;
	public BackStageLiveRecordService() {
		liveRecordDao=LiveRecordDao.getInstance();
	}
	/**
	 * 查询全部直播记录
	 */
	@Override
	public List<LiveRecord> selectAllRecord(LiveRecord record) throws KBaException {
		List<LiveRecord> liveRecord = null;
		try {
			liveRecord = liveRecordDao.queryAll(record);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return liveRecord;	}
	
	/**
	 * 通过用户id查询直播记录
	 */
	@Override
	public List<LiveRecord> selectByUserId(LiveRecord record) throws KBaException {
		List<LiveRecord> liveRecord = null;
			try {
				liveRecord = liveRecordDao.queryByUserId(record);
			} catch (SQLException e) {
				throw new KBaException(e);
			}
			return liveRecord;
	}

}
