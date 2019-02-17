package com.kba.service;

import java.util.List;

import com.kba.entity.InvestRecord;
import com.kba.util.KBaException;

/**
 * 用户充值查询业务层接口
 * @author 单杰
 * 时间：2019-1-22
 */
public interface IInvestRecordService {

	/**
	 * 查询所有充值记录
	 */
	public List<InvestRecord> selectAllRecord(InvestRecord record)throws KBaException;
	
	/**
	 * 通过用户编号查询充值记录
	 */
	public List<InvestRecord> selectRecordByUserId(InvestRecord record)throws KBaException;
	


}
