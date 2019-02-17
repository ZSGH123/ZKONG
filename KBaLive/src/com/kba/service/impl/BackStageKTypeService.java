package com.kba.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.kba.dao.impl.KTypeInfoDao;
import com.kba.entity.KType;
import com.kba.service.IBackStageKTypeService;
import com.kba.util.KBaException;

public class BackStageKTypeService implements IBackStageKTypeService {
	private KTypeInfoDao kTypeDao;
	
    public BackStageKTypeService() {
		this.kTypeDao=kTypeDao.getInstance();
	}
    /**
     * 查询所有类型
     */
    public List<KType> selectAllKType(KType kType) throws KBaException {
		List<KType> kTypes=null;
		try {
			kTypes=kTypeDao.queryAll(kType);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return kTypes;
	}

    /**
     * 按照类型编号查询k币
     */
    public KType selectKTypeById(KType kType) throws KBaException {
		try {
			return kTypeDao.querySingle(kType);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
	}

	/**
	 * 新增K币类型
	 */
	public KType insertKType(KType kType) throws KBaException {
		try {
			// 检查
			KType kTypeo=kTypeDao.querySingle(kType);
			if (kTypeo == null) {// 没有，则保存
				int res = kTypeDao.insert(kType);
				if (res > 0) {// 成功
					return kTypeDao.querySingle(kType);
				}
			}
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return null;
	}

	/**
	 * 修改k币类型
	 */
	public KType updateKType(KType kType) throws KBaException {
		try {
			//更新
			int res=kTypeDao.update(kType);
			if(res>0){ //成功
				return kTypeDao.querySingle(kType);
			}
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return null;
	}

	/**
	 * 删除K币类型
	 */
	public KType deleteKType(KType kType) throws KBaException {
		try {
			int res=kTypeDao.delete(kType);
			if(res>0){
				return kType;
			}
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return null;
	}
	
	/**
	 * 通过k币名称查询k币类型是否存在
	 * @param anchorLevel
	 * @return
	 */
	public boolean checkKTypeByName(KType kType)  throws KBaException{
		try {
			kType=this.kTypeDao.querySingleByName(kType);
			return kType!=null?true:false;
		} catch (SQLException e) {
			throw new KBaException(e);
		}
	}
	
}
