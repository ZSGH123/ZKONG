package com.kba.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.kba.dao.IAnchorLevelDao;
import com.kba.dao.util.ISqlCommand;
import com.kba.dao.util.NameSpace;
import com.kba.dao.util.ResultSetHandler;
import com.kba.entity.AnchorLevel;
import com.kba.entity.BackStageManagerInfo;

/**
 * 主播等级dao
 * @author 赵科
 * 创建时间：2019-1-15
 * 修改时间：
 */
public class AnchorLevelDao extends AbstractBaseDao implements IAnchorLevelDao,ResultSetHandler<List<AnchorLevel>>{
 
	private static AnchorLevelDao anchorLevelDao;
	
	private  AnchorLevelDao(){
		
	}
	
	public synchronized static AnchorLevelDao getInstance(){
		if(anchorLevelDao==null){
			anchorLevelDao=new AnchorLevelDao();
		}
		return anchorLevelDao;
	}
	/**
	 * 查询所有主播等级
	 */
	@Override
	public List<AnchorLevel> queryAll(AnchorLevel entity) throws SQLException {
		List<AnchorLevel> anchorLevels=null;
		String sql=this.parseSqlStatement.getSql(NameSpace.ANCHORLEVEL, ISqlCommand.SELECT_ALL);
		try {
			anchorLevels=this.queryRunner.query(sql, this);
		} catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.info("查询异常");
		}
		return anchorLevels;
	}

	/**
	 * 查询单个主播等级
	 */
	@Override
	public AnchorLevel querySingle(AnchorLevel entity) throws SQLException {
		String sql=null;
		Object[] params=null;
		
		if(entity==null)return null;
		
		sql=this.parseSqlStatement.getSql(NameSpace.ANCHORLEVEL,ISqlCommand.SELECT_BY_ID);
		
		params=new Object[]{entity.getAnchorLevelId()};
		
		try {
			List<AnchorLevel> anchorLevels=this.queryRunner.query(sql, this, params);
			return anchorLevels != null && anchorLevels.size() > 0 ? anchorLevels.get(0) : null;
		}catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.error("error",e);
		}
		return null;
	}
	
	/**
	 * 通过等级名称查询等级
	 * @param entity
	 * @return
	 * @throws SQLException
	 */
	public AnchorLevel querySingleByName(AnchorLevel entity) throws SQLException {
		String sql=null;
		Object[] params=null;
		
		if(entity==null)return null;
		
		sql=this.parseSqlStatement.getSql(NameSpace.ANCHORLEVEL,ISqlCommand.SELECT_BY_NAME);
		
		params=new Object[]{entity.getAnchorLevelName()};
		
		try {
			List<AnchorLevel> anchorLevels=this.queryRunner.query(sql, this, params);
			return anchorLevels != null && anchorLevels.size() > 0 ? anchorLevels.get(0) : null;
		}catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.error("error",e);
		}
		return null;
		
	}

	/**
	 * 新增主播等级
	 */
	@Override
	public int insert(AnchorLevel entity) throws SQLException {
		String sql =this.parseSqlStatement.getSql(NameSpace.ANCHORLEVEL, ISqlCommand.INSERT);
	    Object[] args={entity.getAnchorLevelName(),entity.getLiveMinTotalTime(),
	    		entity.getLiveMaxTotalTime(),entity.getAnchorLevelRemark()};
	    int res=this.queryRunner.update(sql, args);
	    this.logger.info("插入主播等级["+entity.getAnchorLevelName()+"]成功");
	    return res;
	}

	/**
	 * 修改主播等级
	 */
	@Override
	public int update(AnchorLevel entity) throws SQLException {
		String sql =this.parseSqlStatement.getSql(NameSpace.ANCHORLEVEL, ISqlCommand.UPDATE);
	    Object[] args={entity.getAnchorLevelName(),entity.getLiveMinTotalTime(),
	    		entity.getLiveMaxTotalTime(),entity.getAnchorLevelRemark(),entity.getAnchorLevelId()};
	    int res=this.queryRunner.update(sql, args);
	    this.logger.info("更新主播等级["+entity.getAnchorLevelName()+"]成功");
	    return res;
	}

	/**
	 * 删除主播等级
	 */
	@Override
	public int delete(AnchorLevel entity) throws SQLException {
		String sql=this.parseSqlStatement.getSql(NameSpace.ANCHORLEVEL, ISqlCommand.DELETE);
		Object[]  args={entity.getAnchorLevelId()};
		int res=this.queryRunner.update(sql, args);
		this.logger.info("删除主播等级["+entity.getAnchorLevelName()+"]成功");
		return res;
	}

	/**
	 * 主播等级结果集封装
	 */
	@Override
	public List<AnchorLevel> handle(ResultSet rs) throws SQLException {
		List<AnchorLevel> anchorLevels=new Vector<AnchorLevel>();
		AnchorLevel anchorLevel=null;
		if(rs==null){
			throw new SQLException("结果集中没有数据");
		}
		while(rs.next()){
			anchorLevel=new AnchorLevel();
			anchorLevel.setAnchorLevelId(rs.getString("ANCHOR_LEVEL_ID"));
			anchorLevel.setAnchorLevelName(rs.getString("ANCHOR_LEVEL_NAME"));
			anchorLevel.setLiveMinTotalTime(Integer.parseInt(rs.getString("LIVE_MINTOTAL_TIME")));
			anchorLevel.setLiveMaxTotalTime(Integer.parseInt(rs.getString("LIVE_MAXTOTAL_TIME")));
			anchorLevel.setAnchorLevelRemark(rs.getString("ANCHOR_LEVEL_REMARK"));
			anchorLevels.add(anchorLevel);
		}
		return anchorLevels;
	}

}
