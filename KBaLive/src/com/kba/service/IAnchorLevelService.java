package com.kba.service;

import java.util.List;

import com.kba.entity.AnchorLevel;
import com.kba.util.KBaException;

/**
 * 主播等级业务
 * @author 赵科
 * 创建时间：2019-1-22
 * 修改时间：
 */
public interface IAnchorLevelService {

	/**
	 * 查询所有主播等级业务
	 * @param manager
	 * @return
	 * @throws KBaException
	 */
	public List<AnchorLevel> selectAllAnchorLevel(AnchorLevel anchorLevel)throws KBaException;
	
	/**
	 * 查询单个主播等级通过主播等级名
	 * @param manager
	 * @return
	 * @throws KBaException
	 */
	public AnchorLevel selectAnchorLevelByName(AnchorLevel anchorLevel)throws KBaException;
	
	/**
	 * 查询单个主播等级通过主播等级ID
	 * @param manager
	 * @return
	 * @throws KBaException
	 */
	public AnchorLevel selectAnchorLevelByID(AnchorLevel anchorLevel)throws KBaException;
	
	/**
	 * 插入主播等级业务
	 * @param manager
	 * @return
	 * @throws KBaException
	 */
	public AnchorLevel insertAnchorLevel(AnchorLevel anchorLevel)throws KBaException;
	
	/**
	 * 更新主播等级业务
	 * @param manager
	 * @return
	 * @throws KBaException
	 */
	public AnchorLevel updateAnchorLevel(AnchorLevel anchorLevel)throws KBaException;
	
	/**
	 * 删除主播等级业务
	 * @param manager
	 * @return
	 * @throws KBaException
	 */
	public AnchorLevel deleteAnchorLevel(AnchorLevel anchorLevel)throws KBaException;
}
