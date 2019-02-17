package com.kba.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.kba.dao.ILiveTypeDao;
import com.kba.dao.util.ISqlCommand;
import com.kba.dao.util.NameSpace;
import com.kba.dao.util.ResultSetHandler;
import com.kba.entity.LiveType;

/**
 * 直播类型dao
 * @author 钟强
 * 修改时间：
 * 创建时间：2019-1-15
 */
public class LiveTypeDao  extends AbstractBaseDao implements ILiveTypeDao,ResultSetHandler<List<LiveType>>{

	private static LiveTypeDao liveTypeDao;
	
	private LiveTypeDao(){
		
	}
	
	public synchronized static LiveTypeDao getInstance(){
		if(liveTypeDao==null){
			liveTypeDao=new LiveTypeDao();
		}
		return liveTypeDao;
	}
	/**
	 * 查询所有直播类型
	 */
	@Override
	public List<LiveType> queryAll(LiveType entity) throws SQLException {
		List<LiveType> liveTypes=null;
		String sql=this.parseSqlStatement.getSql(NameSpace.LIVETYPE, ISqlCommand.SELECT_ALL);
		try {
			liveTypes=this.queryRunner.query(sql, this);
		} catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.info("查询异常");
		}
		return liveTypes;
	}

	/**
	 * 查询某个直播类型
	 */
	@Override
	public LiveType querySingle(LiveType entity) throws SQLException {
		String sql=null;
		Object[] params=null;
		
		if(entity==null)return null;
		
		sql=this.parseSqlStatement.getSql(NameSpace.LIVETYPE,ISqlCommand.SELECT_BY_ID);
		
		params=new Object[]{entity.getLiveTypeId()};
		
		try {
			List<LiveType> liveTypes=this.queryRunner.query(sql, this, params);
			return liveTypes != null && liveTypes.size() > 0 ? liveTypes.get(0) : null;
		}catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.error("error",e);
		}
		return null;
	}

	/**
	 * 新增直播类型
	 */
	@Override
	public int insert(LiveType entity) throws SQLException {
		String sql =this.parseSqlStatement.getSql(NameSpace.LIVETYPE, ISqlCommand.INSERT);
	    Object[] args={entity.getLiveTypeName(),entity.getLiveTypeRemark()};
	    int res=this.queryRunner.update(sql, args);
	    this.logger.info("插入直播类型["+entity.getLiveTypeName()+"]成功");
	    return res;
	}
	
    /**
     * 修改直播类型
     */
	@Override
	public int update(LiveType entity) throws SQLException {
		String sql =this.parseSqlStatement.getSql(NameSpace.LIVETYPE, ISqlCommand.UPDATE);
	    Object[] args={entity.getLiveTypeName(),entity.getLiveTypeRemark(),entity.getLiveTypeId()};
	    int res=this.queryRunner.update(sql, args);
	    this.logger.info("更新直播类型["+entity.getLiveTypeId()+"]成功");
	    return res;
	}

	/**
	 * 删除直播类型
	 */
	@Override
	public int delete(LiveType entity) throws SQLException {
		String sql=this.parseSqlStatement.getSql(NameSpace.LIVETYPE, ISqlCommand.DELETE);
		Object[]  args={entity.getLiveTypeId()};
		int res=this.queryRunner.update(sql, args);
		this.logger.info("删除直播类型["+entity.getLiveTypeName()+"]成功");
		return res;	
	}

	/**
	 * 直播类型结果集封装
	 */
	@Override
	public List<LiveType> handle(ResultSet rs) throws SQLException {
		List<LiveType> liveTypes=new Vector<LiveType>();
		LiveType liveType=null;
		if(rs==null){
			throw new SQLException("结果集中没有数据");
		}
		while(rs.next()){
			liveType=new LiveType();
			liveType.setLiveTypeId(rs.getString("LIVE_TYPE_ID"));
			liveType.setLiveTypeName(rs.getString("LIVE_TYPE_NAME"));
			liveType.setLiveTypeRemark(rs.getString("LIVE_TYPE_REMARK"));
			liveTypes.add(liveType);
		}
		return liveTypes;
	}

}
