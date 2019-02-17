package com.kba.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.kba.dao.IInvestRecordDao;
import com.kba.dao.impl.InvestRecordDao;
import com.kba.entity.InvestRecord;
import com.kba.service.IInvestRecordService;
import com.kba.util.KBaException;

/**
 * 充值记录查询
 * @author 单杰
 * 时间：2019-1-22
 */

public class InvestRecordService implements IInvestRecordService {
	
	private IInvestRecordDao investRecordDao;
	public InvestRecordService() {
		investRecordDao=InvestRecordDao.getInstance();
	}
	
	/**
	 * 查询所有充值记录
	 */
	@Override
	public List<InvestRecord> selectAllRecord(InvestRecord record) throws KBaException {
		List<InvestRecord> investRecord = null;
		try {
			investRecord = investRecordDao.queryAll(record);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return investRecord;
	}
	
	/**
	 * 通过用户编号查询充值记录
	 */
	@Override
	public List<InvestRecord> selectRecordByUserId(InvestRecord record) throws KBaException {
		List<InvestRecord> investRecord = null;
		try {
			investRecord = investRecordDao.queryRecordByUserId(record);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return investRecord;
	}

}
