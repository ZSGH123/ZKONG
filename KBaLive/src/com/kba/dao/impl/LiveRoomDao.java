package com.kba.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.kba.dao.ILiveRoomDao;
import com.kba.dao.util.ISqlCommand;
import com.kba.dao.util.NameSpace;
import com.kba.dao.util.ResultSetHandler;
import com.kba.entity.LiveRoom;

/**
 * 直播房间dao
 * @author 钟强
 * 修改时间：
 * 创建时间：2019-1-15
 */
public class LiveRoomDao  extends AbstractBaseDao implements ILiveRoomDao,ResultSetHandler<List<LiveRoom>>{

	private static LiveRoomDao liveRoomDao;
	
	private LiveRoomDao(){
		
	}
	
	public synchronized static LiveRoomDao getInstance(){
		if(liveRoomDao==null){
			liveRoomDao=new LiveRoomDao();
			
		}
		return liveRoomDao;
	}
	
	/**
	 * 查询所有直播间信息
	 */
	@Override
	public List<LiveRoom> queryAll(LiveRoom entity) throws SQLException {
		List<LiveRoom> liveRooms=null;
		String sql=this.parseSqlStatement.getSql(NameSpace.LIVEROOM, ISqlCommand.SELECT_ALL);
		try {
			liveRooms=this.queryRunner.query(sql, this);
		} catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.info("查询异常");
		}
		return liveRooms;
	}

	/**
	 * 查询某个直播间信息
	 */
	@Override
	public LiveRoom querySingle(LiveRoom entity) throws SQLException {
		String sql=null;
		Object[] params=null;
		
		if(entity==null)return null;
		
		sql=this.parseSqlStatement.getSql(NameSpace.LIVEROOM,ISqlCommand.SELECT_BY_ID);
		
		params=new Object[]{entity.getLiveRoomId()};
		
		try {
			List<LiveRoom> liveRooms=this.queryRunner.query(sql, this, params);
			return liveRooms != null && liveRooms.size() > 0 ? liveRooms.get(0) : null;
		}catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.error("error",e);
		}
		return null;
	}

	/**
	 * 新增直播间
	 */
	@Override
	public int insert(LiveRoom entity) throws SQLException {
		String sql =this.parseSqlStatement.getSql(NameSpace.LIVEROOM, ISqlCommand.INSERT);
	    Object[] args={entity.getAnchorId(),entity.getLivePushAddress(),entity.getLiveContentId(),
	    		 entity.getLivePushCode(),entity.getLiveRoomAnnouncement(),entity.getLiveRoomTilie(),
	    		 entity.getLiveRoomScore(),entity.getSyncToWeibo(),entity.getLiveRoomRemark()};
	    int res=this.queryRunner.update(sql, args);
	    this.logger.info("新增直播房间["+entity.getLiveRoomId()+"]成功");
	    return res;
	}
	
    /**
     *  更新直播间信息
     */
	@Override
	public int update(LiveRoom entity) throws SQLException {
		String sql =this.parseSqlStatement.getSql(NameSpace.LIVEROOM, ISqlCommand.UPDATE);
	    Object[] args={entity.getAnchorId(),entity.getLivePushAddress(),entity.getLiveContentId(),
	    		 entity.getLivePushCode(),entity.getLiveRoomAnnouncement(),entity.getLiveRoomTilie(),
	    		 entity.getLiveRoomScore(),entity.getSyncToWeibo(),entity.getLiveRoomRemark(),
	    		 entity.getLiveRoomId()};
	    int res=this.queryRunner.update(sql, args);
	    this.logger.info("更新直播房间["+entity.getLiveRoomId()+"]成功");
	    return res;
	}

	/**
	 * 删除直播间
	 */
	@Override
	public int delete(LiveRoom entity) throws SQLException {
		String sql=this.parseSqlStatement.getSql(NameSpace.LIVEROOM, ISqlCommand.DELETE);
		Object[]  args={entity.getLiveRoomId()};
		int res=this.queryRunner.update(sql, args);
		this.logger.info("删除直播房间["+entity.getLiveRoomId()+"]成功");
		return res;	
	}

	/**
	 * 直播间结果集封装
	 */
	@Override
	public List<LiveRoom> handle(ResultSet rs) throws SQLException {
		List<LiveRoom> liveRooms=new Vector<LiveRoom>();
		LiveRoom liveRoom=null;
		if(rs==null){
			throw new SQLException("结果集中没有数据");
		}
		while(rs.next()){
			liveRoom=new LiveRoom();
			liveRoom.setLiveRoomId(rs.getString("LIVE_ROOM_ID"));
			liveRoom.setAnchorId(rs.getString("ANCHOR_ID"));
			liveRoom.setLivePushAddress(rs.getString("LIVE_PUSH_ADDRESS"));
			liveRoom.setLiveContentId(rs.getString("LIVE_CONTENT_ID"));
			liveRoom.setLivePushCode(rs.getString("LIVE_PUSH_CODE"));
			liveRoom.setLiveRoomAnnouncement(rs.getString("LIVE_ROOM_ANNOUNCEMENT"));
			liveRoom.setLiveRoomTilie(rs.getString("LIVE_ROOM_TITLE"));
			liveRoom.setLiveRoomScore(rs.getInt("LIVE_ROOM_SCORE"));
			liveRoom.setSyncToWeibo(rs.getString("SYNC_TO_WEIBO"));
			liveRoom.setLiveRoomRemark(rs.getString("LIVE_ROOM_REMARK"));
			liveRooms.add(liveRoom);
		}
		return liveRooms;
	}

	@Override
	public LiveRoom querySingleByAnchorId(LiveRoom entity) throws SQLException {
		String sql=null;
		Object[] params=null;
		
		if(entity==null)return null;
		
		sql=this.parseSqlStatement.getSql(NameSpace.LIVEROOM,"selectByAnchorId");
		
		params=new Object[]{entity.getAnchorId()};
		
		try {
			List<LiveRoom> liveRooms=this.queryRunner.query(sql, this, params);
			return liveRooms != null && liveRooms.size() > 0 ? liveRooms.get(0) : null;
		}catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.error("error",e);
		}
		return null;
	}

	@Override
	public List<LiveRoom> queryByLiveContentID(LiveRoom entity) throws SQLException {
		String sql=null;
		Object[] params=null;
		
		if(entity==null)return null;
		
		sql=this.parseSqlStatement.getSql(NameSpace.LIVEROOM,"selectByLiveContentID");
		
		params=new Object[]{entity.getLiveContentId()};
		
		try {
			List<LiveRoom> liveRooms=this.queryRunner.query(sql, this, params);
			return liveRooms;
		}catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.error("error",e);
		}
		return null;
	}

	@Override
	public List<LiveRoom> queryByLiveRoomTitle(LiveRoom entity) throws SQLException {
		String sql=null;
		Object[] params=null;
		
		if(entity==null)return null;
		
		sql=this.parseSqlStatement.getSql(NameSpace.LIVEROOM,"selectByLiveRoomTitle");
		params=new Object[]{entity.getLiveRoomTilie()};
		try {
			List<LiveRoom> liveRooms=this.queryRunner.query(sql, this, params);
			return liveRooms;
		}catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.error("error",e);
		}
		return null;
	}

	@Override
	public List<LiveRoom> queryAllSorded(LiveRoom entity) throws SQLException {
		List<LiveRoom> liveRooms=null;
		String sql=this.parseSqlStatement.getSql(NameSpace.LIVEROOM, "selectAllSorted");
		try {
			liveRooms=this.queryRunner.query(sql, this);
		} catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.info("查询异常");
		}
		return liveRooms;
	}

}