package com.kba.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.kba.dao.ITransformRecordDao;
import com.kba.dao.impl.TransformRecordDao;
import com.kba.entity.TransformRecord;
import com.kba.service.IBackStageTransformRecordService;
import com.kba.util.KBaException;
/**
 * 后台查询收益兑换记录
 * @author 单杰
 * 时间：2019-1-24
 */
public class BackStageTransformRecordService implements IBackStageTransformRecordService{

	private ITransformRecordDao transformRecordDao;
	public BackStageTransformRecordService() {
		transformRecordDao=TransformRecordDao.getInstance();
	}
	/**
	 * 查找所有兑换记录
	 */
	public List<TransformRecord> selectAll(TransformRecord record) throws KBaException {
		List<TransformRecord> transformRecord = null;
		try {
			transformRecord = transformRecordDao.queryAll(record);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return transformRecord;
	}
}
