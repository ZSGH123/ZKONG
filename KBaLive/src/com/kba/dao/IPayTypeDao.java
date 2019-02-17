package com.kba.dao;

import java.sql.SQLException;
import java.util.List;

import com.kba.entity.PayType;

/**
 * 支付类型dao
 * @author 赵科
 * 创建时间：2019-1-15
 * 修改时间：
 */
public interface IPayTypeDao extends IBaseDao<PayType>{
	List<PayType> queryAll(PayType entity)throws SQLException;
	}
