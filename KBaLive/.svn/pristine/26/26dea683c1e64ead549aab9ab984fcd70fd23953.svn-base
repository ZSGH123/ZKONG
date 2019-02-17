package com.kba.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.kba.dao.ILiveRoomReceiveDao;
import com.kba.dao.util.ISqlCommand;
import com.kba.dao.util.NameSpace;
import com.kba.dao.util.ResultSetHandler;
import com.kba.vo.LiveReceiveCount;

public class LiveRoomReceiveDao extends AbstractBaseDao implements ILiveRoomReceiveDao,ResultSetHandler<List<LiveReceiveCount>>{

	/**
	 * 查询所有直播间收益
	 */
	public List<LiveReceiveCount> queryAll(LiveReceiveCount entity) throws SQLException {
		List<LiveReceiveCount> liveReceiveCounts=null;
		String sql=this.parseSqlStatement.getSql(NameSpace.LIVEROOMRECEIVE, ISqlCommand.SELECT_ALL);
		try {
			liveReceiveCounts=this.queryRunner.query(sql, this);
		} catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.info("查询异常");
		}
		return liveReceiveCounts;
	}

	@Override
	public LiveReceiveCount querySingle(LiveReceiveCount entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(LiveReceiveCount entity) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(LiveReceiveCount entity) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(LiveReceiveCount entity) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<LiveReceiveCount> handle(ResultSet rs) throws SQLException {
		List<LiveReceiveCount> liveReceiveCounts=new Vector<LiveReceiveCount>();
		LiveReceiveCount liveReceiveCount=null;
		if(rs==null){
			throw new SQLException("结果集中没有数据");
		}
		while(rs.next()){
			liveReceiveCount=new LiveReceiveCount();
			liveReceiveCount.setLiveRoomId(rs.getString(1));
			liveReceiveCount.setLiveRoomReceive(Double.parseDouble(rs.getString(2)));
			liveReceiveCounts.add(liveReceiveCount);
		}
		return liveReceiveCounts;
	}

}
