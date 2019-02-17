package com.kba.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.kba.dao.IInvestRecordDao;
import com.kba.dao.IReportMessageDao;
import com.kba.dao.impl.InvestRecordDao;
import com.kba.dao.impl.ReportMessageDao;
import com.kba.entity.InvestRecord;
import com.kba.entity.ReportMessage;
import com.kba.service.IBackStageReportMessageService;
import com.kba.util.KBaException;
/**
 * 后台查询举报记录
 * @author 单杰
 * 时间：2019-1-23
 */
public class BackStageReportMessageService implements IBackStageReportMessageService{

	private IReportMessageDao reportMessageDao;
	public BackStageReportMessageService() {
		reportMessageDao=ReportMessageDao.getInstance();
	}
	/**
	 *查询所有记录
	 */
	@Override
	public List<ReportMessage> selectAllRecord(ReportMessage record) throws KBaException {
		List<ReportMessage> reportMessage = null;
		try {
			reportMessage = reportMessageDao.queryAll(record);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return reportMessage;
	}
	/**
	 * 按照用户id查询
	 */
	@Override
	public List<ReportMessage> selectByUserId(ReportMessage record) throws KBaException {
		List<ReportMessage> reportMessage = null;
		try {
			reportMessage = reportMessageDao.queryByUserId(record);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return reportMessage;
	}

	
}
