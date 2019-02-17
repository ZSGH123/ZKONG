

package com.kba.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.kba.dao.IGagInfoDao;
import com.kba.dao.impl.GagInfoDao;
import com.kba.entity.GagInfo;
import com.kba.service.IBackStageGagInfoService;
import com.kba.util.KBaException;
/**
 * 后台查询主播禁言信息
 * @author 单杰
 * 时间：2019-1-23
 */
public class BackStageGagInfoService implements IBackStageGagInfoService{
	private IGagInfoDao gagInfoDao;
	public BackStageGagInfoService() {
		gagInfoDao=GagInfoDao.getInstance();
	}
	
	@Override
	public List<GagInfo> selectAll(GagInfo record) throws KBaException {
		List<GagInfo> gagInfo = null;
		try {
			gagInfo = gagInfoDao.queryAll(record);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return gagInfo;	
		}
	@Override
	public List<GagInfo> selectByAnchorId(GagInfo record) throws KBaException {
		List<GagInfo> gagInfo = null;
		try {
			gagInfo = gagInfoDao.queryByAnchorId(record);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return gagInfo;	
		}
	}

