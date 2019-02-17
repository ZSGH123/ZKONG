package com.kba.service;

import java.util.List;

import com.kba.entity.BackStageManagerInfo;
import com.kba.util.KBaException;

/**
 * 后台管理员业务层接口
 * @author Administrator
 * 创建时间：2019-1-16
 * 修改时间：
 */
public interface IBackStageManagerInfoService {

	/**
	 * 后台管理员登陆业务
	 * @param manager
	 * @return
	 * @throws KBaException
	 */
	public BackStageManagerInfo invalidManager(BackStageManagerInfo manager)throws KBaException;
	
	
	/**
	 * 查询所有后台管理员业务
	 * @param manager
	 * @return
	 * @throws KBaException
	 */
	public List<BackStageManagerInfo> selectAllManager(BackStageManagerInfo manager)throws KBaException;
	
	/**
	 * 查询单个后台管理员通过后台管理员名
	 * @param manager
	 * @return
	 * @throws KBaException
	 */
	public BackStageManagerInfo selectManagerByName(BackStageManagerInfo manager)throws KBaException;
	
	/**
	 * 查询单个后台管理员通过后台管理员ID
	 * @param manager
	 * @return
	 * @throws KBaException
	 */
	public BackStageManagerInfo selectManagerByManagerID(BackStageManagerInfo manager)throws KBaException;
	
	/**
	 * 插入后台管理员业务
	 * @param manager
	 * @return
	 * @throws KBaException
	 */
	public BackStageManagerInfo insertManager(BackStageManagerInfo manager)throws KBaException;
	
	/**
	 * 更新后台管理员业务
	 * @param manager
	 * @return
	 * @throws KBaException
	 */
	public BackStageManagerInfo updateManager(BackStageManagerInfo manager)throws KBaException;
	
	/**
	 * 删除后台管理员业务
	 * @param manager
	 * @return
	 * @throws KBaException
	 */
	public BackStageManagerInfo deleteManager(BackStageManagerInfo manager)throws KBaException;
}
