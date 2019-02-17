package com.kba.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.kba.dao.IUserGiftRecordDao;
import com.kba.dao.impl.UserGiftRecordDao;
import com.kba.entity.UserGiftRecord;
import com.kba.service.IBackStageUserGiftRecordService;
import com.kba.util.KBaException;

/**
 * 用户赠礼记录的业务
 * @author 单杰
 * 创建时间：2019-1-23
 */
public class BackStageUserGiftRecordService implements IBackStageUserGiftRecordService{
	private UserGiftRecordDao userGiftRecordDao;
	public BackStageUserGiftRecordService() {
		userGiftRecordDao=UserGiftRecordDao.getInstance();
	}
	@Override
	public List<UserGiftRecord> selectAll(UserGiftRecord record) throws KBaException {
		List<UserGiftRecord> userGiftRecord = null;
		try {
			userGiftRecord = userGiftRecordDao.queryAll(record);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return userGiftRecord;
	}

}
