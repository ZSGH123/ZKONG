package com.kba.service;

import java.util.List;

import com.kba.entity.ReportMessage;
import com.kba.util.KBaException;

/**
 * 后台查询举报记录
 * @author 单杰
 * 时间：2019-1-23
 */
public interface IBackStageReportMessageService {

	public List<ReportMessage> selectAllRecord(ReportMessage record)throws KBaException;

	public List<ReportMessage> selectByUserId(ReportMessage record)throws KBaException;
}
