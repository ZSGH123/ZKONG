package com.kba.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.kba.dao.impl.PayTypeDao;
import com.kba.entity.PayType;
import com.kba.service.IBackStagePayTypeService;
import com.kba.util.KBaException;

/**
 * 后台支付类型业务
 * @author 单杰
 * 创建时间：2019-1-25
 * 修改时间:
 */

public class BackStagePayTypeService implements IBackStagePayTypeService{
	private PayTypeDao payTypeDao;
	
    public BackStagePayTypeService() {
		this.payTypeDao=PayTypeDao.getInstance();
	}
	/**
	 * 查询所有支付类型
	 */
	public List<PayType> selectAllPayType(PayType payType) throws KBaException {
		List<PayType> payTypes=null;
		try {
			payTypes=payTypeDao.queryAll(payType);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return payTypes;
	}

	/**
	 * 通过支付类型id查询支付类型
	 */
	public PayType selectPayTypeById(PayType payType) throws KBaException {
		try {
			return payTypeDao.querySingle(payType);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
	}

	/**
	 * 新增支付类型
	 */
	public PayType insertPayType(PayType payType) throws KBaException {
		try {
			// 检查
			PayType payTypeo=payTypeDao.querySingle(payType);
			if (payTypeo == null) {// 没有，则保存
				int res = payTypeDao.insert(payType);
				if (res > 0) {// 成功
					return payTypeDao.querySingle(payType);
				}
			}
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return null;

	}

	/**
	 * 修改支付类型
	 */
	public PayType updatePayType(PayType payType) throws KBaException {
		try {
			//更新
			int res=payTypeDao.update(payType);
			if(res>0){ //成功
				return payTypeDao.querySingle(payType);
			}
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return null;
	}

	/**
	 * 删除支付类型
	 */
	public PayType deletePayType(PayType payType) throws KBaException {
		try {
			int res=payTypeDao.delete(payType);
			if(res>0){
				return payType;
			}
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return null;
	}
	/**
	 * 通过名称检查支付类型是否存在
	 * @param payType
	 * @return
	 * @throws KBaException 
	 */
	public boolean checkPayTypeByName(PayType payType) throws KBaException {
		try {
			payType=this.payTypeDao.querySingleByName(payType);
			return payType!=null?true:false;
		} catch (SQLException e) {
			throw new KBaException(e);
		}
	}
	

}
