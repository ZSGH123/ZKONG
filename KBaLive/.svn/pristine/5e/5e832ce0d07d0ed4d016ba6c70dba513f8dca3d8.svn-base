package com.kba.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Vector;

import com.kba.dao.ILiveRecordDao;
import com.kba.dao.util.ISqlCommand;
import com.kba.dao.util.NameSpace;
import com.kba.dao.util.ResultSetHandler;
import com.kba.entity.LiveRecord;

/**
 * 直播记录dao
 * @author 钟强
 * 修改时间：
 * 创建时间：2019-1-15
 */
public class LiveRecordDao  extends AbstractBaseDao implements ILiveRecordDao,ResultSetHandler<List<LiveRecord>>{

	private static LiveRecordDao liveRecordDao;
	
	private LiveRecordDao(){
		
	}
	
	public synchronized static LiveRecordDao getInstance(){
		if(liveRecordDao==null){
			liveRecordDao=new LiveRecordDao();
		}
		return liveRecordDao;
	}
	/**
	 * 查询所有的直播记录
	 */
	@Override
	public List<LiveRecord> queryAll(LiveRecord entity) throws SQLException {
		List<LiveRecord> liveRecords=null;
		String sql=this.parseSqlStatement.getSql(NameSpace.LIVERECORD, ISqlCommand.SELECT_ALL);
		try {
			liveRecords=this.queryRunner.query(sql, this);
		} catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.info("查询异常");
		}
		return liveRecords;
	}

	/**
	 * 根据编号查询直播记录
	 */
	@Override
	public LiveRecord querySingle(LiveRecord entity) throws SQLException {
		String sql=null;
		Object[] params=null;
		
		if(entity==null)return null;
		
		sql=this.parseSqlStatement.getSql(NameSpace.LIVERECORD,ISqlCommand.SELECT_BY_ID);
		
		params=new Object[]{entity.getLiveRecordId()};
		
		try {
			List<LiveRecord> liveRecords=this.queryRunner.query(sql, this, params);
			return liveRecords != null && liveRecords.size() > 0 ? liveRecords.get(0) : null;
		}catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.error("error",e);
		}
		return null;
	}

	/**
	 * 插入直播记录
	 */
	@Override
	public int insert(LiveRecord entity) throws SQLException {
		 String sql =this.parseSqlStatement.getSql(NameSpace.LIVERECORD, ISqlCommand.INSERT);
	     Object[] args={entity.getUserId(),entity.getOnLiveTime()!=null?new Timestamp(entity.getOnLiveTime().getTime()):null,
	    		 entity.getOffLiveTime()!=null?new Timestamp(entity.getOffLiveTime().getTime()):null,
	    		 entity.getLiveRecordRemark()};
	     int res=this.queryRunner.update(sql, args);
	     this.logger.info("插入直播记录["+entity.getUserId()+"]成功");
	     return res;
	}
	
    /**
     *  更新直播记录
     */
	@Override
	public int update(LiveRecord entity) throws SQLException {
		 String sql =this.parseSqlStatement.getSql(NameSpace.LIVERECORD, ISqlCommand.UPDATE);
	     Object[] args={entity.getUserId(),entity.getOnLiveTime()!=null?new Timestamp(entity.getOnLiveTime().getTime()):null,
	    		 entity.getOffLiveTime()!=null?new Timestamp(entity.getOffLiveTime().getTime()):null,
	    		 entity.getLiveRecordRemark(),entity.getLiveRecordId()};
	     int res=this.queryRunner.update(sql, args);
	     this.logger.info("更新直播记录["+entity.getLiveRecordId()+"]成功");
	     return res;
	}

	/**
	 * 删除直播记录
	 */
	@Override
	public int delete(LiveRecord entity) throws SQLException {
		String sql=this.parseSqlStatement.getSql(NameSpace.LIVERECORD, ISqlCommand.DELETE);
		Object[]  args={entity.getLiveRecordId()};
		int res=this.queryRunner.update(sql, args);
		this.logger.info("删除直播记录["+entity.getLiveRecordId()+"]成功");
		return res;	
	}

	/**
	 * 直播记录结果集处理
	 */
	@Override
	public List<LiveRecord> handle(ResultSet rs) throws SQLException {
		List<LiveRecord> liveRecords=new Vector<LiveRecord>();
		LiveRecord liveRecord=null;
		if(rs==null){
			throw new SQLException("结果集中没有数据");
		}
		while(rs.next()){
			liveRecord=new LiveRecord();
			liveRecord.setLiveRecordId(rs.getString("LIVE_RECORD_ID"));
			liveRecord.setUserId(rs.getString("USER_ID"));
			liveRecord.setOnLiveTime(rs.getTimestamp("ON_LIVE_TIME"));
			liveRecord.setOffLiveTime(rs.getTimestamp("OFF_LIVE_TIME"));
			liveRecord.setLiveRecordRemark(rs.getString("LIVE_RECORD_REMARK"));
			liveRecords.add(liveRecord);
		}
		return liveRecords;
	}

	/**
	 * 通过用户id查询直播记录
	 * 作者：单杰
	 * 时间：2019-1-23
	 */
	public List<LiveRecord> queryByUserId(LiveRecord entity) throws SQLException {
		List<LiveRecord> liveRecords=null;
		String sql=this.parseSqlStatement.getSql(NameSpace.LIVERECORD, ISqlCommand.SELECT_BY_USERID);
		try {
			liveRecords=this.queryRunner.query(sql, this);
		} catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.info("查询异常");
		}
		return liveRecords;
	}

}
