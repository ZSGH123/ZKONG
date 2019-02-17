package com.kba.service;

import java.util.List;

import com.kba.entity.TransformRecord;
import com.kba.util.KBaException;
/**
 * 后台查询收益兑换记录
 * @author 单杰
 * 时间：2019-1-24
 */
public interface IBackStageTransformRecordService {

	public List<TransformRecord> selectAll(TransformRecord record)throws KBaException;

}
