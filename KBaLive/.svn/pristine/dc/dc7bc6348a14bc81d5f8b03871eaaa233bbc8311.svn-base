package com.kba.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.kba.dao.impl.PushTypeDao;
import com.kba.entity.AnchorLevel;
import com.kba.entity.PushType;
import com.kba.service.IBackStagePushTypeService;
import com.kba.util.KBaException;
/**
 * 后台推送类型业务
 * @author 单杰
 * 创建时间：2019-1-25
 * 修改时间:
 */
public class BackStagePushTypeService implements IBackStagePushTypeService{
	private PushTypeDao pushTypeDao;
	
    public BackStagePushTypeService() {
		this.pushTypeDao=PushTypeDao.getInstance();
	}
	/**
	 * 查询所有推送类型
	 */
	public List<PushType> selectAllPushType(PushType pushType) throws KBaException {
		List<PushType> pushTypes=null;
		try {
			pushTypes=pushTypeDao.queryAll(pushType);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return pushTypes;
	}

	/**
	 * 查询推送类型通过类型名称
	 */
	public PushType selectPushTypeByName(PushType pushType) throws KBaException {
		try {
			return pushTypeDao.querySingleByName(pushType);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
	}

	/**
	 * 通过类型编号查询推送类型
	 */
	public PushType selectPushTypeByID(PushType pushType) throws KBaException {
		try {
			return pushTypeDao.querySingle(pushType);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
	}

	/**
	 * 新增推送类型
	 */
	public PushType insertPushType(PushType pushType) throws KBaException {
		try {
			// 检查
			PushType pushTyped=pushTypeDao.querySingleByName(pushType);
			if (pushTyped == null) {// 没有，则保存
				int res = pushTypeDao.insert(pushType);
				if (res > 0) {// 成功
					return pushTypeDao.querySingleByName(pushType);
				}
			}
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return null;
	}

	/**
	 * 修改推送类型
	 */
	public PushType updatePushType(PushType pushType) throws KBaException {
		try {
			//更新
			int res=pushTypeDao.update(pushType);
			if(res>0){ //成功
				return pushTypeDao.querySingle(pushType);
			}
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return null;
	}

	/**
	 * 删除推送类型
	 */
	public PushType deletePushType(PushType pushType) throws KBaException {
		try {
			int res=pushTypeDao.delete(pushType);
			if(res>0){
				return pushType;
			}
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return null;
	}

	/**
	 * 通过类型名称查询推送类型是否存在
	 * @param anchorLevel
	 * @return
	 */
	public boolean checkPushTypeByName(PushType pushType) throws KBaException{
		try {
			pushType=this.pushTypeDao.querySingleByName(pushType);
			return pushType!=null?true:false;
		} catch (SQLException e) {
			throw new KBaException(e);
		}
	}

}
