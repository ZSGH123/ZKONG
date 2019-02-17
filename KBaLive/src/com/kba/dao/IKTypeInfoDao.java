package com.kba.dao;

import java.sql.SQLException;
import java.util.List;

import com.kba.entity.KType;
/**
 * k币类型dao接口
 * @author 钟强
 * 修改时间：
 * 创建时间：2019-1-15
 */
public interface IKTypeInfoDao extends IBaseDao<KType> {
	List<KType> queryAll(KType entity)throws SQLException;
}
