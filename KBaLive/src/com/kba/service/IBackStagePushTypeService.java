package com.kba.service;

import java.util.List;

import com.kba.entity.PushType;
import com.kba.util.KBaException;
/**
 * 后台推送类型业务
 * @author 单杰
 * 时间：2019-1-25
 */
public interface IBackStagePushTypeService {
	/**
	 * 查询所有推送类型业务
	 * @param manager
	 * @return
	 * @throws KBaException
	 */
	public List<PushType> selectAllPushType(PushType pushType)throws KBaException;
	
	/**
	 * 查询单个推送类型通过推送名
	 * @param manager
	 * @return
	 * @throws KBaException
	 */
	public PushType selectPushTypeByName(PushType pushType)throws KBaException;
	
	/**
	 * 查询单个推送类型通过推送ID
	 * @param manager
	 * @return
	 * @throws KBaException
	 */
	public PushType selectPushTypeByID(PushType pushType)throws KBaException;
	
	/**
	 * 插入推送类型业务
	 * @param manager
	 * @return
	 * @throws KBaException
	 */
	public PushType insertPushType(PushType pushType)throws KBaException;
	
	/**
	 * 更新推送类型业务
	 * @param manager
	 * @return
	 * @throws KBaException
	 */
	public PushType updatePushType(PushType pushType)throws KBaException;
	
	/**
	 * 删除推送类型业务
	 * @param manager
	 * @return
	 * @throws KBaException
	 */
	public PushType deletePushType(PushType pushType)throws KBaException;
}
