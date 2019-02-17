package com.kba.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.kba.dao.IGiftInfoDao;
import com.kba.dao.util.ISqlCommand;
import com.kba.dao.util.NameSpace;
import com.kba.dao.util.ResultSetHandler;
import com.kba.entity.GiftInfo;

import oracle.net.aso.g;

/**
 * 礼物信息dao
 * @author 赵科
 * 创建时间：2019-1-15
 * 修改时间：
 */
public class GiftInfoDao extends AbstractBaseDao implements IGiftInfoDao,ResultSetHandler<List<GiftInfo>>{
 
	private static GiftInfoDao  giftInfoDao;
	
	private GiftInfoDao(){
		
	}
	
	public synchronized static GiftInfoDao getInstance(){
		if(giftInfoDao==null){
			giftInfoDao=new GiftInfoDao();
		}
		return giftInfoDao;
	}
	/**
	 * 查询所有礼物信息
	 */
	@Override
	public List<GiftInfo> queryAll(GiftInfo entity) throws SQLException {
		List<GiftInfo> giftInfos=null;
		String sql=this.parseSqlStatement.getSql(NameSpace.GIFTINFO, ISqlCommand.SELECT_ALL);
		try {
			giftInfos=this.queryRunner.query(sql, this);
		} catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.info("查询异常");
		}
		return giftInfos;
	}

	/**
	 * 查询单个礼物信息
	 */
	@Override
	public GiftInfo querySingle(GiftInfo entity) throws SQLException {
		String sql=null;
		Object[] params=null;
		
		if(entity==null)return null;
		
		sql=this.parseSqlStatement.getSql(NameSpace.GIFTINFO,ISqlCommand.SELECT_BY_ID);
		
		params=new Object[]{entity.getGiftId()};
		
		try {
			List<GiftInfo> giftInfos=this.queryRunner.query(sql, this, params);
			return giftInfos != null && giftInfos.size() > 0 ? giftInfos.get(0) : null;
		}catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.error("error",e);
		}
		return null;
	}

	/**
	 * 新增礼物信息
	 */
	@Override
	public int insert(GiftInfo entity) throws SQLException {
		String sql =this.parseSqlStatement.getSql(NameSpace.GIFTINFO, ISqlCommand.INSERT);
	    Object[] args={entity.getGiftName(),entity.getGiftPrice(),entity.getkTypeId(),
	    		entity.getGiftIconAddress(),entity.getGiftAcctionAddress(),
	    		entity.getGiftInfoRemark()};
	    int res=this.queryRunner.update(sql, args);
	    this.logger.info("插入礼物信息["+entity.getGiftName()+"]成功");
	    return res;
	}

	/**
	 * 修改礼物信息
	 */
	@Override
	public int update(GiftInfo entity) throws SQLException {
		String sql =this.parseSqlStatement.getSql(NameSpace.GIFTINFO, ISqlCommand.UPDATE);
	    Object[] args={entity.getGiftName(),entity.getGiftPrice(),entity.getkTypeId(),
	    		entity.getGiftIconAddress(),entity.getGiftAcctionAddress(),
	    		entity.getGiftInfoRemark(),entity.getGiftId()};
	    int res=this.queryRunner.update(sql, args);
	    this.logger.info("更新礼物信息["+entity.getGiftName()+"]成功");
	    return res;
	}
   
	
	/**
	 * 删除礼物信息
	 */
	@Override
	public int delete(GiftInfo entity) throws SQLException {
		String sql=this.parseSqlStatement.getSql(NameSpace.GIFTINFO, ISqlCommand.DELETE);
		Object[]  args={entity.getGiftId()};
		int res=this.queryRunner.update(sql, args);
		this.logger.info("删除礼物信息["+entity.getGiftName()+"]成功");
		return res;	
	}


	/**
	 * 礼物信息结果集封装
	 */
	@Override
	public List<GiftInfo> handle(ResultSet rs) throws SQLException {
		List<GiftInfo> giftInfos=new Vector<GiftInfo>();
		GiftInfo giftInfo=null;
		if(rs==null){
			throw new SQLException("结果集中没有数据");
		}
		while(rs.next()){
			giftInfo=new GiftInfo();
			giftInfo.setGiftId(rs.getString("GIFT_ID"));
			giftInfo.setGiftName(rs.getString("GIFT_NAME"));
			giftInfo.setGiftPrice(Integer.parseInt(rs.getString("GIFT_PRICE")));
			giftInfo.setkTypeId(rs.getString("K_TYPE_ID"));
			giftInfo.setGiftIconAddress(rs.getString("GIFT_ICON_ADDRESS"));
			giftInfo.setGiftAcctionAddress(rs.getString("GIFT_ACCTION_ADDRESS"));
			giftInfo.setGiftInfoRemark(rs.getString("GIFT_INFO_REMARK"));
			giftInfos.add(giftInfo);
		}
		return giftInfos;
	}

	/**
	 * 通过礼物名称查询礼物
	 */
	public GiftInfo querySingleByName(GiftInfo entity) throws SQLException {
		String sql=null;
		Object[] params=null;
		
		if(entity==null)return null;
		
		sql=this.parseSqlStatement.getSql(NameSpace.GIFTINFO,ISqlCommand.SELECT_BY_NAME);
		
		params=new Object[]{entity.getGiftName()};
		
		try {
			List<GiftInfo> giftInfos=this.queryRunner.query(sql, this, params);
			return giftInfos != null && giftInfos.size() > 0 ? giftInfos.get(0) : null;
		}catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.error("error",e);
		}
		return null;
	}

	

}
