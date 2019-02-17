package com.kba.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.kba.dao.ITransformRecordDao;
import com.kba.dao.util.ISqlCommand;
import com.kba.dao.util.NameSpace;
import com.kba.dao.util.ResultSetHandler;
import com.kba.entity.GagInfo;
import com.kba.entity.TransformRecord;

/**
 * 礼物转K币记录dao
 * @author 赵科
 * 创建时间：2019-1-15
 * 修改时间：
 */
public class TransformRecordDao extends AbstractBaseDao implements ITransformRecordDao,ResultSetHandler<List<TransformRecord>>{

	private static TransformRecordDao transformRecordDao;
	
	private TransformRecordDao(){
		
	}
	
	public synchronized static TransformRecordDao getInstance(){
		if(transformRecordDao==null){
			transformRecordDao=new TransformRecordDao();
		}
		return transformRecordDao;
	}
	/**
	 * 查询所有礼物转K币记录
	 */
	@Override
	public List<TransformRecord> queryAll(TransformRecord entity) throws SQLException {
		List<TransformRecord> transformRecords=null;
		String sql=this.parseSqlStatement.getSql(NameSpace.TRANSFORMRECORD, ISqlCommand.SELECT_ALL);
		try {
			transformRecords=this.queryRunner.query(sql, this);
		} catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.info("查询异常");
		}
		return transformRecords;
	}

	/**
	 * 查询某条礼物转K币记录
	 */
	@Override
	public TransformRecord querySingle(TransformRecord entity) throws SQLException {
		String sql=null;
		Object[] params=null;
		
		if(entity==null)return null;
		
		sql=this.parseSqlStatement.getSql(NameSpace.TRANSFORMRECORD,ISqlCommand.SELECT_BY_ID);
		
		params=new Object[]{entity.getTransformRecordId()};
		
		try {
			List<TransformRecord> transformRecords=this.queryRunner.query(sql, this, params);
			return transformRecords != null && transformRecords.size() > 0 ? transformRecords.get(0) : null;
		}catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.error("error",e);
		}
		return null;
	}

	/**
	 * 新增礼物转K币记录
	 */
	@Override
	public int insert(TransformRecord entity) throws SQLException {
		String sql =this.parseSqlStatement.getSql(NameSpace.TRANSFORMRECORD, ISqlCommand.INSERT);
	    Object[] args={entity.getAnchorId(),entity.getGiftId(),entity.getGiftNum(),
	    		entity.getkTypeId(),entity.getkNum(),entity.getTransformTime(),
	    		entity.getTransformRecordRemark()};
	    int res=this.queryRunner.update(sql, args);
	    this.logger.info("插入礼物转K币记录["+entity.getTransformRecordId()+"]成功");
	    return res;
	}

	/**
	 * 修改礼物转K币记录
	 */
	@Override
	public int update(TransformRecord entity) throws SQLException {
		String sql =this.parseSqlStatement.getSql(NameSpace.TRANSFORMRECORD, ISqlCommand.UPDATE);
	    Object[] args={entity.getAnchorId(),entity.getGiftId(),entity.getGiftNum(),
	    		entity.getkTypeId(),entity.getkNum(),entity.getTransformTime(),
	    		entity.getTransformRecordRemark(),entity.getTransformRecordId()};
	    int res=this.queryRunner.update(sql, args);
	    this.logger.info("更新礼物转K币记录["+entity.getTransformRecordId()+"]成功");
	    return res;
	}

	/**
	 * 删除礼物转K币记录
	 */
	@Override
	public int delete(TransformRecord entity) throws SQLException {
		String sql=this.parseSqlStatement.getSql(NameSpace.TRANSFORMRECORD, ISqlCommand.DELETE);
		Object[]  args={entity.getTransformRecordId()};
		int res=this.queryRunner.update(sql, args);
		this.logger.info("删除礼物转K币记录["+entity.getTransformRecordId()+"]成功");
		return res;	
	}

	/**
	 * 礼物转K币记录结果集处理
	 */
	@Override
	public List<TransformRecord> handle(ResultSet rs) throws SQLException {
		List<TransformRecord> transformRecords=new Vector<TransformRecord>();
		TransformRecord transformRecord=null;
		if(rs==null){
			throw new SQLException("结果集中没有数据");
		}
		while(rs.next()){
			transformRecord=new TransformRecord();
			transformRecord.setTransformRecordId(rs.getString("TRANSFORM_RECORD_ID"));
			transformRecord.setAnchorId(rs.getString("ANCHOR_ID"));
			transformRecord.setGiftId(rs.getString("GIFT_ID"));
			transformRecord.setGiftNum(Integer.parseInt(rs.getString("GIFT_NUM")));
			transformRecord.setkTypeId(rs.getString("K_TYPE_ID"));
			transformRecord.setkNum(Integer.parseInt(rs.getString("K_NUM")));
			transformRecord.setTransformTime(rs.getTimestamp("TRANSFORM_TIME"));
			transformRecord.setTransformRecordRemark(rs.getString("TRANSFORM_RECORD_REMARK"));
			transformRecords.add(transformRecord);
		}
		return transformRecords;
	}


}
