package com.kba.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.kba.dao.impl.AnchorInfoDao;
import com.kba.entity.AnchorInfo;
import com.kba.entity.AnchorLevel;
import com.kba.service.IAnchorInfoService;
import com.kba.util.KBaException;

/**
 *  后台主播信息业务
 *  @author 赵科
 *  创建时间：2019-1-23
 *  修改时间：
 */
public class BackStageAnchorInfoService implements IAnchorInfoService{

	private AnchorInfoDao anchorInfoDao;
	
    public BackStageAnchorInfoService() {
		this.anchorInfoDao=AnchorInfoDao.getInstance();
	}
	
    /**
	 * 查询所有主播
	 */
	@Override
	public List<AnchorInfo> selectAllAnchorInfo(AnchorInfo anchorInfo) throws KBaException {
		List<AnchorInfo> anchorInfos=null;
		try {
			anchorInfos=anchorInfoDao.queryAll(anchorInfo);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return anchorInfos;
	}
    
	/**
	 * 查询主播通过用户id
	 */
	@Override
	public AnchorInfo selectAnchorInfoByUserId(AnchorInfo anchorInfo) throws KBaException {
		try {
			return anchorInfoDao.querySingleByUserId(anchorInfo);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
	}

	/**
	 * 通过主播编号查询主播信息
	 */
	@Override
	public AnchorInfo selectAnchorInfoByID(AnchorInfo anchorInfo) throws KBaException {
		try {
			return anchorInfoDao.querySingle(anchorInfo);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
	}
   
	/**
	 * 新增主播信息
	 */
	@Override
	public AnchorInfo insertAnchorInfo(AnchorInfo anchorInfo) throws KBaException {
		try {
			// 检查
			AnchorInfo anchorInfod=anchorInfoDao.querySingle(anchorInfo);
			if (anchorInfod == null) {// 没有，则保存
				int res = anchorInfoDao.insert(anchorInfo);
				if (res > 0) {// 成功
					return anchorInfoDao.querySingleByUserId(anchorInfo);
				}
			}
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return null;
	}

	/**
	 * 修改主播信息
	 */
	@Override
	public AnchorInfo updateAnchorInfo(AnchorInfo anchorInfo) throws KBaException {
		try {
			//更新
			int res=anchorInfoDao.update(anchorInfo);
			if(res>0){ //成功
				return anchorInfoDao.querySingle(anchorInfo);
			}
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return null;
	}

	/**
	 * 删除主播信息
	 */
	@Override
	public AnchorInfo deleteAnchorInfo(AnchorInfo anchorInfo) throws KBaException {
		try {
			int res=anchorInfoDao.delete(anchorInfo);
			if(res>0){
				return anchorInfo;
			}
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return null;
	}

}
