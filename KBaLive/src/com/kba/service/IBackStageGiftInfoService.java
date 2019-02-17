package com.kba.service;

import java.util.List;

import com.kba.entity.GiftInfo;
import com.kba.util.KBaException;
/**
 * 礼物信息业务
 * @author 单杰
 * 时间：2019-1-24
 */
public interface IBackStageGiftInfoService {

	/**
	 * 查询所有礼物信息
	 * @param manager
	 * @return
	 * @throws KBaException
	 */
	public List<GiftInfo> selectAllGiftInfo(GiftInfo giftInfo)throws KBaException;
	/**
	 * 通过礼物名称查询礼物
	 * @param giftInfo
	 * @return
	 * @throws KBaException
	 */
	public GiftInfo selectGiftInfoByName(GiftInfo giftInfo)throws KBaException;
	/**
	 * 插入礼物信息业务
	 * @param manager
	 * @return
	 * @throws KBaException
	 */
	public GiftInfo insertGiftInfo(GiftInfo giftInfo)throws KBaException;
	
	/**
	 * 更新礼物信息业务
	 * @param manager
	 * @return
	 * @throws KBaException
	 */
	public GiftInfo updateGiftInfo(GiftInfo giftInfo)throws KBaException;
	
	/**
	 * 删除礼物信息业务
	 * @param manager
	 * @return
	 * @throws KBaException
	 */
	public GiftInfo deleteGiftInfo(GiftInfo giftInfo)throws KBaException;
}
