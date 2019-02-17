package com.kba.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.kba.dao.ILiveContentDao;
import com.kba.dao.util.ISqlCommand;
import com.kba.dao.util.NameSpace;
import com.kba.dao.util.ResultSetHandler;
import com.kba.entity.LiveContent;

/**
 * 直播内容dao
 * @author 钟强
 * 修改时间：
 * 创建时间：2019-1-15
 */
public class LiveContentDao  extends AbstractBaseDao implements ILiveContentDao,ResultSetHandler<List<LiveContent>>{

	private static LiveContentDao liveContentDao;
	
	private LiveContentDao(){
		
	}
	
	public synchronized static LiveContentDao getInstance(){
		if(liveContentDao==null){
			liveContentDao=new LiveContentDao();
		}
		return liveContentDao;
	}
	/**
	 * 查询所有种类的直播内容
	 */
	@Override
	public List<LiveContent> queryAll(LiveContent entity) throws SQLException {
		List<LiveContent> liveContents=null;
		String sql=this.parseSqlStatement.getSql(NameSpace.LIVECONTENT, ISqlCommand.SELECT_ALL);
		try {
			liveContents=this.queryRunner.query(sql, this);
		} catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.info("查询异常");
		}
		return liveContents;
	}

	/**
	 * 根据编号查询单个直播内容
	 */
	@Override
	public LiveContent querySingle(LiveContent entity) throws SQLException {
		String sql=null;
		Object[] params=null;
		
		if(entity==null)return null;
		
		sql=this.parseSqlStatement.getSql(NameSpace.LIVECONTENT,ISqlCommand.SELECT_BY_ID);
		
		params=new Object[]{entity.getLiveContentId()};
		
		try {
			List<LiveContent> liveContents=this.queryRunner.query(sql, this, params);
			return liveContents != null && liveContents.size() > 0 ? liveContents.get(0) : null;
		}catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.error("error",e);
		}
		return null;
	}

	/**
	 * 新增直播内容种类
	 */
	@Override
	public int insert(LiveContent entity) throws SQLException {
		String sql =this.parseSqlStatement.getSql(NameSpace.LIVECONTENT, ISqlCommand.INSERT);
	     Object[] args={entity.getLiveContentName(),entity.getLiveTypeId(),entity.getLiveContentRemark(),
	    		 entity.getLiveContentImgURL()};
	     int res=this.queryRunner.update(sql, args);
	     this.logger.info("插入直播内容["+entity.getLiveContentName()+"]成功");
	     return res;
	}
	
    /**
     * 更新直播内容
     */
	@Override
	public int update(LiveContent entity) throws SQLException {
		 String sql =this.parseSqlStatement.getSql(NameSpace.LIVECONTENT, ISqlCommand.UPDATE);
	     Object[] args={entity.getLiveContentName(),entity.getLiveTypeId(),entity.getLiveContentRemark(),
	    		 entity.getLiveContentImgURL(),entity.getLiveContentId()};
	     int res=this.queryRunner.update(sql, args);
	     this.logger.info("更新直播内容["+entity.getLiveContentId()+"]成功");
	     return res;
	}

	/**
	 * 删除直播内容
	 */
	@Override
	public int delete(LiveContent entity) throws SQLException {
		String sql=this.parseSqlStatement.getSql(NameSpace.LIVECONTENT, ISqlCommand.DELETE);
		Object[]  args={entity.getLiveContentId()};
		int res=this.queryRunner.update(sql, args);
		this.logger.info("删除直播内容["+entity.getLiveContentName()+"]成功");
		return res;	
	}

	/**
	 * 直播内容结果集处理
	 */
	@Override
	public List<LiveContent> handle(ResultSet rs) throws SQLException {
		List<LiveContent> liveContents=new Vector<LiveContent>();
		LiveContent liveContent=null;
		if(rs==null){
			throw new SQLException("结果集中没有数据");
		}
		while(rs.next()){
			liveContent=new LiveContent();
			liveContent.setLiveContentId(rs.getString("LIVE_CONTENT_ID"));
			liveContent.setLiveContentName(rs.getString("LIVE_CONTENT_NAME"));
			liveContent.setLiveTypeId(rs.getString("LIVE_TYPE_ID"));
			liveContent.setLiveContentRemark(rs.getString("LIVE_CONTENT_REMARK"));
			liveContent.setLiveContentImgURL(rs.getString("LIVE_CONTENT_IMGURL"));
			liveContents.add(liveContent);
		}
		return liveContents;
	}

	@Override
	public List<LiveContent> querySingleByLiveTypeId(LiveContent entity) throws SQLException {
		String sql=null;
		Object[] params=null;
		
		if(entity==null)return null;
		
		sql=this.parseSqlStatement.getSql(NameSpace.LIVECONTENT,"selectByLiveTypeId");
		
		params=new Object[]{entity.getLiveTypeId()};
		
		try {
			return this.queryRunner.query(sql, this, params);
		}catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.error("error",e);
		}
		return null;
	}

}
