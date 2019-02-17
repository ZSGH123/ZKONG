package com.kba.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.kba.dao.IPayTypeDao;
import com.kba.dao.util.ISqlCommand;
import com.kba.dao.util.NameSpace;
import com.kba.dao.util.ResultSetHandler;
import com.kba.entity.AnchorLevel;
import com.kba.entity.PayType;

/**
 * 支付类型dao
 * @author 赵科
 * 创建时间：2019-1-15
 * 修改时间：
 */
public class PayTypeDao extends AbstractBaseDao implements IPayTypeDao,ResultSetHandler<List<PayType>>{

	private static PayTypeDao payTypeDao;
	
	private PayTypeDao(){
		
	}
	
	public synchronized static PayTypeDao getInstance(){
		if(payTypeDao==null){
			payTypeDao=new PayTypeDao();
		}
		return payTypeDao;
	}
	/**
	 * 查询所有支付类型
	 */
	@Override
	public List<PayType> queryAll(PayType entity) throws SQLException {
		List<PayType> payTypes=null;
		String sql=this.parseSqlStatement.getSql(NameSpace.PAYTYPE, ISqlCommand.SELECT_ALL);
		try {
			payTypes=this.queryRunner.query(sql, this);
		} catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.info("查询异常");
		}
		return payTypes;
	}

	/**
	 * 查询某种支付方式
	 */
	@Override
	public PayType querySingle(PayType entity) throws SQLException {
		String sql=null;
		Object[] params=null;
		if(entity==null)return null;
		
		sql=this.parseSqlStatement.getSql(NameSpace.PAYTYPE,ISqlCommand.SELECT_BY_ID);
		
		params=new Object[]{entity.getPayTypeId()};
		
		try {
			List<PayType> payTypes=this.queryRunner.query(sql, this, params);
			return payTypes != null && payTypes.size() > 0 ? payTypes.get(0) : null;
		}catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.error("error",e);
		}
		return null;
	}

	/**
	 * 新增支付类型
	 */
	@Override
	public int insert(PayType entity) throws SQLException {
		String sql =this.parseSqlStatement.getSql(NameSpace.PAYTYPE, ISqlCommand.INSERT);
	    Object[] args={entity.getPayTypeName(),entity.getPayTypeRemark()};
	    int res=this.queryRunner.update(sql, args);
	    this.logger.info("插入支付类型["+entity.getPayTypeName()+"]成功");
	    return res;
	}

	/**
	 * 修改支付类型
	 */
	@Override
	public int update(PayType entity) throws SQLException {
		String sql =this.parseSqlStatement.getSql(NameSpace.PAYTYPE, ISqlCommand.UPDATE);
	    Object[] args={entity.getPayTypeName(),entity.getPayTypeRemark(),entity.getPayTypeId()};
	    int res=this.queryRunner.update(sql, args);
	    this.logger.info("更新支付类型["+entity.getPayTypeName()+"]成功");
	    return res;
	}

	/**
	 * 删除支付类型
	 */
	@Override
	public int delete(PayType entity) throws SQLException {
		String sql=this.parseSqlStatement.getSql(NameSpace.PAYTYPE, ISqlCommand.DELETE);
		Object[]  args={entity.getPayTypeId()};
		int res=this.queryRunner.update(sql, args);
		this.logger.info("删除支付类型["+entity.getPayTypeName()+"]成功");
		return res;	
	}

	/**
	 * 支付类型结果集封装
	 */
	@Override
	public List<PayType> handle(ResultSet rs) throws SQLException {
		List<PayType> payTypes=new Vector<PayType>();
		PayType payType=null;
		if(rs==null){
			throw new SQLException("结果集中没有数据");
		}
		while(rs.next()){
			payType=new PayType();
			payType.setPayTypeId(rs.getString("PAY_TYPE_ID"));
			payType.setPayTypeName(rs.getString("PAY_TYPE_NAME"));
			payType.setPayTypeRemark(rs.getString("PAY_TYPE_REMARK"));
			payTypes.add(payType);
		}
		return payTypes;
	}

	/**
	 * 通过支付类型名称查询支付类型
	 * @param payType
	 * @return
	 * @throws SQLException 
	 */
	public PayType querySingleByName(PayType entity) throws SQLException {
		String sql=null;
		Object[] params=null;
		
		if(entity==null)return null;
		
		sql=this.parseSqlStatement.getSql(NameSpace.PAYTYPE,ISqlCommand.SELECT_BY_NAME);
		
		params=new Object[]{entity.getPayTypeName()};
		
		try {
			List<PayType> payTypes=this.queryRunner.query(sql, this, params);
			return payTypes != null && payTypes.size() > 0 ? payTypes.get(0) : null;
		}catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.error("error",e);
		}
		return null;
	}

}
