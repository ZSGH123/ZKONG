package com.kba.service;

import java.util.List;

import com.kba.entity.GagInfo;
import com.kba.util.KBaException;
/**
 * 后台查询主播禁言信息
 * @author 单杰
 * 时间：2019-1-23
 */
public interface IBackStageGagInfoService {

	public List<GagInfo> selectAll(GagInfo record)throws KBaException;
	
	public List<GagInfo> selectByAnchorId(GagInfo record)throws KBaException;
	
}
