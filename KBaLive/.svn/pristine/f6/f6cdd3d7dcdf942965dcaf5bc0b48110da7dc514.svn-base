package com.kba.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.kba.dao.IVideoTypeDao;
import com.kba.dao.util.ISqlCommand;
import com.kba.dao.util.NameSpace;
import com.kba.dao.util.ResultSetHandler;
import com.kba.entity.VideoType;

/**
 * 视频类型dao
 * @author 赵科
 * 创建时间：2019-1-15
 * 修改时间：
 */
public class VideoTypeDao extends AbstractBaseDao implements IVideoTypeDao,ResultSetHandler<List<VideoType>>{

	private static VideoTypeDao videoTypeDao;
	
	private VideoTypeDao(){
		
	}
	
	public synchronized static VideoTypeDao getInstance(){
		if(videoTypeDao==null){
			videoTypeDao=new VideoTypeDao();
		}
		return videoTypeDao;
	}
	/**
	 * 查询所有视频类型
	 */
	@Override
	public List<VideoType> queryAll(VideoType entity) throws SQLException {
		List<VideoType> videoTypes=null;
		String sql=this.parseSqlStatement.getSql(NameSpace.VIDEOTYPE, ISqlCommand.SELECT_ALL);
		try {
			videoTypes=this.queryRunner.query(sql, this);
		} catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.info("查询异常");
		}
		return videoTypes;
	}

	/**
	 * 查询某个视频类型
	 */
	@Override
	public VideoType querySingle(VideoType entity) throws SQLException {
		String sql=null;
		Object[] params=null;
		
		if(entity==null)return null;
		
		sql=this.parseSqlStatement.getSql(NameSpace.VIDEOTYPE,ISqlCommand.SELECT_BY_ID);
		
		params=new Object[]{entity.getVideoTypeId()};
		
		try {
			List<VideoType> videoTypes=this.queryRunner.query(sql, this, params);
			return videoTypes != null && videoTypes.size() > 0 ? videoTypes.get(0) : null;
		}catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.error("error",e);
		}
		return null;
	}

	/**
	 * 新增视频类型
	 */
	@Override
	public int insert(VideoType entity) throws SQLException {
		String sql =this.parseSqlStatement.getSql(NameSpace.VIDEOTYPE, ISqlCommand.INSERT);
	    Object[] args={entity.getVideoTypeName(),entity.getVideoTypeRemark()};
	    int res=this.queryRunner.update(sql, args);
	    this.logger.info("插入视频类型["+entity.getVideoTypeName()+"]成功");
	    return res;
	}

	/**
	 * 修改视频类型
	 */
	@Override
	public int update(VideoType entity) throws SQLException {
		String sql =this.parseSqlStatement.getSql(NameSpace.VIDEOTYPE, ISqlCommand.UPDATE);
	    Object[] args={entity.getVideoTypeName(),entity.getVideoTypeRemark(),entity.getVideoTypeId()};
	    int res=this.queryRunner.update(sql, args);
	    this.logger.info("更新视频类型["+entity.getVideoTypeName()+"]成功");
	    return res;
	}

	/**
	 * 删除视频类型
	 */
	@Override
	public int delete(VideoType entity) throws SQLException {
		String sql=this.parseSqlStatement.getSql(NameSpace.VIDEOTYPE, ISqlCommand.DELETE);
		Object[]  args={entity.getVideoTypeId()};
		int res=this.queryRunner.update(sql, args);
		this.logger.info("删除视频类型["+entity.getVideoTypeName()+"]成功");
		return res;
	}

	/**
	 * 视频类型结果集处理
	 */
	@Override
	public List<VideoType> handle(ResultSet rs) throws SQLException {
		List<VideoType> videoTypes=new Vector<VideoType>();
		VideoType videoType=null;
		if(rs==null){
			throw new SQLException("结果集中没有数据");
		}
		while(rs.next()){
			videoType=new VideoType();
			videoType.setVideoTypeId(rs.getString("VIDEO_TYPE_ID"));
			videoType.setVideoTypeName(rs.getString("VIDEO_TYPE_NAME"));
			videoType.setVideoTypeRemark(rs.getString("VIDEO_TYPE_REMARK"));
			videoTypes.add(videoType);
		}
		return videoTypes;
	}

}
