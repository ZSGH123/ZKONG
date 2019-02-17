package com.kba.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.kba.dao.ILiveContentDao;
import com.kba.dao.ILiveRoomDetailDao;
import com.kba.dao.ILiveTypeDao;
import com.kba.dao.IPushTypeDao;
import com.kba.dao.impl.LiveContentDao;
import com.kba.dao.impl.LiveRoomDetatilDao;
import com.kba.dao.impl.LiveTypeDao;
import com.kba.dao.impl.PushTypeDao;
import com.kba.entity.AnchorInfo;
import com.kba.entity.LiveContent;
import com.kba.entity.LiveRoom;
import com.kba.entity.LiveType;
import com.kba.entity.PushType;
import com.kba.entity.UserInfo;
import com.kba.service.IIndexService;
import com.kba.util.KBaException;
import com.kba.vo.LiveContentInfo;
import com.kba.vo.LiveRoomDetailInfo;
import com.kba.vo.LiveRoomsInfo;
/**
 * 首页服务层
 * @author 钟强
 * 时间：2019-1-26
 */
public class IndexService implements IIndexService {
   
	private ILiveContentDao liveContentDao;
	
	private ILiveTypeDao liveTypeDao;
	
	private IPushTypeDao pushTypeDao;
	
	private ILiveRoomDetailDao liveRoomDetailDao;
	
	public IndexService(){
		liveContentDao=LiveContentDao.getInstance();
		liveTypeDao=LiveTypeDao.getInstance();
		pushTypeDao=PushTypeDao.getInstance();
		liveRoomDetailDao=LiveRoomDetatilDao.getInstance();
	}
	
	/**
	 * 根据直播类型查询相应直播内容
	 */
	@Override
	public List<LiveContent> selectByLiveType(LiveContent liveContent) throws KBaException {
		List<LiveContent> liveContents=null;
		try {
			liveContents=liveContentDao.querySingleByLiveTypeId(liveContent);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return liveContents;
	}
	
    /**
     * 查询所有直播类型
     */
	@Override
	public List<LiveType> selectAllLiveType(LiveType liveType) throws KBaException {
		List<LiveType> liveTypes=null;
		try {
			liveTypes=liveTypeDao.queryAll(liveType);	
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return liveTypes;
	}
    
	 /**
     * 查询所有直播内容
     */
	@Override
	public List<LiveContent> selectAllLiveContent(LiveContent liveContent) throws KBaException {
		List<LiveContent> liveContents=null;
		try {
			liveContents=liveContentDao.queryAll(liveContent);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return liveContents;
	}
	 /**
     * 查询所有推送类型
     */
	@Override
	public List<PushType> queryAllPushType(PushType entity) throws KBaException {
		List<PushType> pushTypes=null;
		try {
			pushTypes=pushTypeDao.queryAll(entity);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return pushTypes;
	}

	@Override
	public List<LiveRoomDetailInfo> queryAllLiveRoomDetailInfo() throws KBaException {
		
		List<LiveRoomDetailInfo> liveRoomDetailInfos=null;
		try {
			liveRoomDetailInfos=liveRoomDetailDao.queryAllLiveRoomDetailInfo();
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return liveRoomDetailInfos;
	}

	@Override
	public List<LiveRoomDetailInfo> selectAllByPushTypeId(PushType entity) throws KBaException {
		List<LiveRoomDetailInfo> liveRoomDetailInfos=null;
		try {
			liveRoomDetailInfos=liveRoomDetailDao.selectAllByPushTypeId(entity);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return liveRoomDetailInfos;
	}

	@Override
	public List<LiveRoomDetailInfo> selectAllByLiveCotentName(LiveContent entity) throws KBaException {
		List<LiveRoomDetailInfo> liveRoomDetailInfos=null;
		try {
			liveRoomDetailInfos=liveRoomDetailDao.selectAllByLiveCotentName(entity);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return liveRoomDetailInfos;
	}

	@Override
	public List<LiveRoomDetailInfo> selectAllByLiveTypeName(LiveType entity) throws KBaException {
		List<LiveRoomDetailInfo> liveRoomDetailInfos=null;
		try {
			liveRoomDetailInfos=liveRoomDetailDao.selectAllByLiveTypeName(entity);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return liveRoomDetailInfos;
	}

	@Override
	public LiveRoomsInfo selectLiveRoomsInfoByPushType(PushType pushType) throws KBaException {
		List<LiveRoomDetailInfo> pushliveRoomDetailInfos=new Vector<LiveRoomDetailInfo>();//保存所有正在推送列表中的所有房间信息
		List<LiveRoomDetailInfo> liveRoomDetailInfos=new Vector<LiveRoomDetailInfo>();//保存所有与该推送内容相关的所有房间信息
		List<LiveRoomDetailInfo> liveRoomDetailInfosByContent=new Vector<LiveRoomDetailInfo>();
		List<LiveRoomDetailInfo> extraliveRoomDetailInfos=new Vector<LiveRoomDetailInfo>();
		LiveRoomsInfo liveRoomsInfo=new LiveRoomsInfo();
		//1.查询正在推送的所有房间
		pushliveRoomDetailInfos=selectLiveRoomDetailInfoByNum(this.selectAllByPushTypeId(pushType),4);
		//保存发钱推送的直播间
	    liveRoomsInfo.setPushType(pushType);
	    liveRoomsInfo.setPushliveRoomDetailInfos(pushliveRoomDetailInfos);
		if(pushliveRoomDetailInfos.size()<4){//位置不满
			//2.查询与该推送内容相关的所有房间
			liveRoomDetailInfosByContent=this.selectAllByLiveCotentName(spwan(pushType));
			liveRoomDetailInfosByContent.addAll(this.selectAllByLiveTypeName(this.spwanLiveType(pushType)));
			//3.删除正在推送的房间
			liveRoomDetailInfos=this.delLiveRoomDetailInfo(liveRoomDetailInfosByContent);
			//4.找出剩余的需推送的房间,按照直播分数高低
			liveRoomDetailInfos=this.selectLiveRoomDetailInfoByNum(liveRoomDetailInfos,4-pushliveRoomDetailInfos.size());
			//5.保存不是花钱推送的直播间
			liveRoomsInfo.setLiveRoomDetailInfos(liveRoomDetailInfos);
		}
		if(pushliveRoomDetailInfos.size()+liveRoomDetailInfos.size()>=4){//位置满了
			//剔除已经在推送的房间
			extraliveRoomDetailInfos=this.delLiveRoomDetailInfo(liveRoomDetailInfosByContent);
			extraliveRoomDetailInfos=this.selectLiveRoomDetailInfoByNum(extraliveRoomDetailInfos,4-pushliveRoomDetailInfos.size(),4);
			liveRoomsInfo.setExtraliveRoomDetailInfos(extraliveRoomDetailInfos);
		}
		return liveRoomsInfo;
	}
	
	@Override
	public List<LiveRoomDetailInfo> selectAllByLiveTypeID(LiveType entity) throws KBaException {
		List<LiveRoomDetailInfo> liveRoomDetailInfos=null;
		try {
			liveRoomDetailInfos=liveRoomDetailDao.selectAllByLiveTypeID(entity);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return liveRoomDetailInfos;
	}

	@Override
	public LiveRoomDetailInfo selectByLiveRoomId(LiveRoom entity) throws KBaException {
		LiveRoomDetailInfo liveRoomDetailInfo=null;
		try {
			liveRoomDetailInfo=liveRoomDetailDao.selectByLiveRoomId(entity);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return liveRoomDetailInfo;
	}

	@Override
	public LiveRoomDetailInfo selectByAnchorId(AnchorInfo entity) throws KBaException {
		LiveRoomDetailInfo liveRoomDetailInfo=null;
		try {
			liveRoomDetailInfo=liveRoomDetailDao.selectByAnchorId(entity);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return liveRoomDetailInfo;
	}

	@Override
	public LiveRoomDetailInfo selectByUserName(UserInfo entity) throws KBaException {
		LiveRoomDetailInfo liveRoomDetailInfo=null;
		try {
			liveRoomDetailInfo=liveRoomDetailDao.selectByUserName(entity);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return liveRoomDetailInfo;
	}

	@Override
	public List<LiveRoomDetailInfo> selectAllByAnnouncment(LiveRoom entity) throws KBaException {
		List<LiveRoomDetailInfo> liveRoomDetailInfos=null;
		try {
			liveRoomDetailInfos=liveRoomDetailDao.selectAllByAnnouncment(entity);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return liveRoomDetailInfos;
	}

	@Override
	public List<LiveRoomDetailInfo> selectAllByTitle(LiveRoom entity) throws KBaException {
		List<LiveRoomDetailInfo> liveRoomDetailInfos=null;
		try {
			liveRoomDetailInfos=liveRoomDetailDao.selectAllByTitle(entity);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return liveRoomDetailInfos;
	}

	@Override
	public List<LiveRoomDetailInfo> selectAllAllPushRoom(PushType entity) throws KBaException {
		List<LiveRoomDetailInfo> liveRoomDetailInfos=null;
		try {
			liveRoomDetailInfos=liveRoomDetailDao.selectALLPushRoom(entity);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return liveRoomDetailInfos;
	}

	@Override
	public List<LiveContentInfo> selectLiveContentInfoByLiveType(LiveType liveType) throws KBaException {
		List<LiveContentInfo> liveContentInfos=new Vector<LiveContentInfo>();
		List<LiveType> liveTypes=this.selectAllLiveType(liveType);
		List<LiveContent> liveContents=null;
		for (LiveType liveType2 : liveTypes) {
			LiveContentInfo liveContentInfo=new LiveContentInfo();
			liveContentInfo.setLiveType(liveType2);
			liveContents=this.selectByLiveType(spwan(liveType2));
			liveContentInfo.setLiveContentList(liveContents);
			liveContentInfos.add(liveContentInfo);
		}
		return liveContentInfos;
	}
	
	@Override
	public List<LiveRoomDetailInfo> selectAllByLiveCotentId(LiveContent entity) throws KBaException {
		List<LiveRoomDetailInfo> liveRoomDetailInfos=null;
		try {
			liveRoomDetailInfos=liveRoomDetailDao.selectAllByLiveCotentId(entity);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return liveRoomDetailInfos;
	}
	
	@Override
	public LiveContent selectSingleLiveContent(LiveContent liveContent) throws KBaException {
		LiveContent liveContentdb=null;
		try {
			liveContentdb=liveContentDao.querySingle(liveContent);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return liveContentdb;
	}
	
	@Override
	public LiveType selectSingleLiveType(LiveType liveType) throws KBaException {
		LiveType liveTypeDb=null;
		try {
			liveTypeDb=liveTypeDao.querySingle(liveType);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return liveTypeDb;
	}
	
	
	/**
	 *查询指定数量的直播详细信息
	 */
	public List<LiveRoomDetailInfo> selectLiveRoomDetailInfoByNum(List<LiveRoomDetailInfo> list,int num){
		return selectLiveRoomDetailInfoByNum(list, 0,num);
	}
	
	/**
	 *查询从指定位置开始，指定数量的直播详细信息
	 */
	public List<LiveRoomDetailInfo> selectLiveRoomDetailInfoByNum(List<LiveRoomDetailInfo> list,int start,int num) {
		if(start<0||list==null) return null;
		int length=list.size();
		if(start>length) return null;
		if(num<=0) return null;
		if(start+num>list.size()){
			return list.subList(start, length);
		}else {
			return list.subList(start, num);
		}
	}
	/**
	 *剔除正在推送的直播详细信息
	 */
	public List<LiveRoomDetailInfo> delLiveRoomDetailInfo(List<LiveRoomDetailInfo> list){
		List<LiveRoomDetailInfo> listRoomDetailInfos=new Vector<LiveRoomDetailInfo>();
		for (LiveRoomDetailInfo liveRoomDetailInfo : list) {
			if(liveRoomDetailInfo.getPushList().getLiveRoomId()==null){
				listRoomDetailInfos.add(liveRoomDetailInfo);
			}
		}
		return listRoomDetailInfos;
	}
	
	private LiveContent spwan(LiveType liveType2) {
		LiveContent liveContent=new LiveContent();
		liveContent.setLiveTypeId(liveType2.getLiveTypeId());
		return liveContent;
	}
	private LiveContent spwan(PushType pushType){
		LiveContent liveContent=new LiveContent();
		liveContent.setLiveContentName(pushType.getPushName());
		return liveContent;
	}
	
	private LiveType spwanLiveType(PushType pushType){
		LiveType liveType=new LiveType();
		liveType.setLiveTypeName(pushType.getPushName());
		return liveType;
	}

	@Override
	public List<LiveRoomDetailInfo> selectAllMoHu(String content) throws KBaException {
		List<LiveRoomDetailInfo> liveRoomDetailInfos=null;
		try {
			liveRoomDetailInfos=liveRoomDetailDao.selectAllMoHu(content);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return liveRoomDetailInfos;
	}

}
