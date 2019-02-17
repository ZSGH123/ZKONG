package com.kba.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.kba.dao.IKTypeInfoDao;
import com.kba.dao.util.ISqlCommand;
import com.kba.dao.util.NameSpace;
import com.kba.dao.util.ResultSetHandler;
import com.kba.entity.AnchorLevel;
import com.kba.entity.KType;


/**
 * k币类型dao
 * @author 钟强
 * 修改时间：
 * 创建时间：2019-1-15
 */
public class KTypeInfoDao extends AbstractBaseDao implements IKTypeInfoDao,ResultSetHandler<List<KType>>{
     
	private static KTypeInfoDao kTypeInfoDao;
	
	private KTypeInfoDao(){
		
	}
	
	public synchronized static KTypeInfoDao getInstance(){
		if(kTypeInfoDao==null){
			kTypeInfoDao=new KTypeInfoDao();
		}
		return kTypeInfoDao;
	}
	/**
	 * 查询所有k币类型
	 */
	@Override
	public List<KType> queryAll(KType entity) throws SQLException {
		List<KType> kTypes=null;
		String sql=this.parseSqlStatement.getSql(NameSpace.KTYPE, ISqlCommand.SELECT_ALL);
		try {
			kTypes=this.queryRunner.query(sql, this);
		} catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.info("查询异常");
		}
		return kTypes;
	}

	/**
	 * 根据id查询单个k币类型
	 */
	@Override
	public KType querySingle(KType entity) throws SQLException {
		String sql=null;
		Object[] params=null;
		
		if(entity==null)return null;
		
		sql=this.parseSqlStatement.getSql(NameSpace.KTYPE,ISqlCommand.SELECT_BY_ID);
		
		params=new Object[]{entity.getkTypeId()};
		
		try {
			List<KType> kTypes=this.queryRunner.query(sql, this, params);
			return kTypes != null && kTypes.size() > 0 ? kTypes.get(0) : null;
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
	public KType querySingleByName(KType entity) throws SQLException {
		String sql=null;
		Object[] params=null;
		
		if(entity==null)return null;
		
		sql=this.parseSqlStatement.getSql(NameSpace.KTYPE,ISqlCommand.SELECT_BY_NAME);
		
		params=new Object[]{entity.getkTypeName()};
		
		try {
			List<KType> kTypes=this.queryRunner.query(sql, this, params);
			return kTypes != null && kTypes.size() > 0 ? kTypes.get(0) : null;
		}catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.error("error",e);
		}
		return null;
		
	}

	/**
	 * 新增k币类型
	 */
	@Override
	public int insert(KType entity) throws SQLException {
		String sql =this.parseSqlStatement.getSql(NameSpace.KTYPE, ISqlCommand.INSERT);
	     Object[] args={entity.getkTypeName(),entity.getkExchangeRate(),entity.getkWithdrawRate(),
	    		 entity.getkRemark()};
	     int res=this.queryRunner.update(sql, args);
	     this.logger.info("插入k币类型["+entity.getkTypeName()+"]成功");
	     return res;
	}
	
    /**
     * 更新k币类型
     */
	@Override
	public int update(KType entity) throws SQLException {
		 String sql =this.parseSqlStatement.getSql(NameSpace.KTYPE, ISqlCommand.UPDATE);
	     Object[] args={entity.getkTypeName(),entity.getkExchangeRate(),entity.getkWithdrawRate(),
	    		 entity.getkRemark(),entity.getkTypeId()};
	     int res=this.queryRunner.update(sql, args);
	     this.logger.info("更新k币类型["+entity.getkTypeName()+"]成功");
	     return res;
	}

	/**
	 * 删除k币类型
	 */
	@Override
	public int delete(KType entity) throws SQLException {
		String sql=this.parseSqlStatement.getSql(NameSpace.KTYPE, ISqlCommand.DELETE);
		Object[]  args={entity.getkTypeId()};
		int res=this.queryRunner.update(sql, args);
		this.logger.info("删除k币类型["+entity.getkTypeName()+"]成功");
		return res;	
	}

	/**
	 * k币类型结果集处理
	 */
	@Override
	public List<KType> handle(ResultSet rs) throws SQLException {
		List<KType> kTypes=new Vector<KType>();
		KType kType=null;
		if(rs==null){
			throw new SQLException("结果集中没有数据");
		}
		while(rs.next()){
			kType=new KType();
			kType.setkTypeId(rs.getString("K_TYPE_ID"));
			kType.setkTypeName(rs.getString("K_TYPE_NAME"));
			kType.setkExchangeRate(Double.parseDouble(rs.getString("K_EXCHANGE_RATE")));
			kType.setkWithdrawRate(Double.parseDouble(rs.getString("K_WITHDRAW_RATE")));
			kType.setkRemark(rs.getString("K_REMARK"));
			kTypes.add(kType);
		}
		return kTypes;
	}

}
