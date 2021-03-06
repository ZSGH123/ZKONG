package com.kba.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.kba.dao.IGagInfoDao;
import com.kba.dao.util.ISqlCommand;
import com.kba.dao.util.NameSpace;
import com.kba.dao.util.ResultSetHandler;
import com.kba.entity.GagInfo;

/**
 * 禁言信息dao
 * @author 赵科
 * 创建时间：2019-1-15
 * 修改时间：
 */
public class GagInfoDao extends AbstractBaseDao implements IGagInfoDao,ResultSetHandler<List<GagInfo>>{

	private static GagInfoDao gagInfoDao;
	
	private GagInfoDao(){
		
	}
	
	public synchronized static GagInfoDao getInstance(){
		if(gagInfoDao==null){
			gagInfoDao=new GagInfoDao();
		}
		return gagInfoDao;
	}
	/**
	 * 查询所有的禁言信息
	 */
	@Override
	public List<GagInfo> queryAll(GagInfo entity) throws SQLException {
		List<GagInfo> gagInfos=null;
		String sql=this.parseSqlStatement.getSql(NameSpace.GAGINFO, ISqlCommand.SELECT_ALL);
		try {
			gagInfos=this.queryRunner.query(sql, this);
		} catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.info("查询异常");
		}
		return gagInfos;
	}

	/**
	 * 查询单个禁言信息
	 */
	@Override
	public GagInfo querySingle(GagInfo entity) throws SQLException {
		String sql=null;
		Object[] params=null;
		
		if(entity==null)return null;
		
		sql=this.parseSqlStatement.getSql(NameSpace.GAGINFO,ISqlCommand.SELECT_BY_ID);
		
		params=new Object[]{entity.getGagId()};
		
		try {
			List<GagInfo> gagInfos=this.queryRunner.query(sql, this, params);
			return gagInfos != null && gagInfos.size() > 0 ? gagInfos.get(0) : null;
		}catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.error("error",e);
		}
		return null;
	}

	/**
	 * 插入禁言信息
	 */
	@Override
	public int insert(GagInfo entity) throws SQLException {
		String sql =this.parseSqlStatement.getSql(NameSpace.LIVETYPE, ISqlCommand.INSERT);
	    Object[] args={entity.getUserId(),entity.getRoomManagerId(),entity.getLiveRoomId(),
	    		entity.getAnchorId(),entity.getGagTime(),entity.getGagStartTime(),
	    		entity.getGagInfoRemark()};
	    int res=this.queryRunner.update(sql, args);
	    this.logger.info("插入禁言信息["+entity.getUserId()+"]成功");
	    return res;
	}

	/**
	 * 修改禁言信息
	 */
	@Override
	public int update(GagInfo entity) throws SQLException {
		String sql =this.parseSqlStatement.getSql(NameSpace.LIVETYPE, ISqlCommand.UPDATE);
	    Object[] args={entity.getUserId(),entity.getRoomManagerId(),entity.getLiveRoomId(),
	    		entity.getAnchorId(),entity.getGagTime(),entity.getGagStartTime(),
	    		entity.getGagInfoRemark(),entity.getGagId()};
	    int res=this.queryRunner.update(sql, args);
	    this.logger.info("更新禁言信息["+entity.getUserId()+"]成功");
	    return res;
	}

	/**
	 * 删除禁言信息
	 */
	@Override
	public int delete(GagInfo entity) throws SQLException {
		String sql=this.parseSqlStatement.getSql(NameSpace.LIVETYPE, ISqlCommand.DELETE);
		Object[]  args={entity.getGagId()};
		int res=this.queryRunner.update(sql, args);
		this.logger.info("删除禁言信息["+entity.getUserId()+"]成功");
		return res;	
	}

	/**
	 * 禁言信息结果集封装
	 */
	@Override
	public List<GagInfo> handle(ResultSet rs) throws SQLException {
		List<GagInfo> gagInfos=new Vector<GagInfo>();
		GagInfo gagInfo=null;
		if(rs==null){
			throw new SQLException("结果集中没有数据");
		}
		while(rs.next()){
			gagInfo=new GagInfo();
			gagInfo.setGagId(rs.getString("GAG_ID"));
			gagInfo.setUserId(rs.getString("USER_ID"));
			gagInfo.setRoomManagerId(rs.getString("ROOM_MANAGER_ID"));
			gagInfo.setLiveRoomId(rs.getString("LIVE_ROOM_ID"));
			gagInfo.setAnchorId(rs.getString("ANCHOR_ID"));
			gagInfo.setGagTime(Integer.parseInt(rs.getString("GAG_TIME")));
			gagInfo.setGagStartTime(rs.getTimestamp("GAG_START_TIME"));
			gagInfo.setGagInfoRemark(rs.getString("GAG_INFO_REMARK"));
			gagInfos.add(gagInfo);
		}
		return gagInfos;
	}
/**
 * 通过主播id查询禁言信息
 * 作者：单杰
 */
	@Override
	public List<GagInfo> queryByAnchorId(GagInfo entity) throws SQLException {
		List<GagInfo> gagInfos=null;
		String sql=this.parseSqlStatement.getSql(NameSpace.GAGINFO, ISqlCommand.SELECT_BY_ANCHOR_ID);
		try {
			gagInfos=this.queryRunner.query(sql, this);
		} catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.info("查询异常");
		}
		return gagInfos;
	}	
}
