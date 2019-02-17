package com.kba.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.kba.dao.IUserQQInfoDao;
import com.kba.dao.util.ISqlCommand;
import com.kba.dao.util.NameSpace;
import com.kba.dao.util.ResultSetHandler;
import com.kba.entity.UserQQInfo;

/**
 * QQ用户dao
 * @author 赵科
 * 创建时间：2019-1-15
 * 修改时间：
 */
public class UserQQInfoDao extends AbstractBaseDao implements IUserQQInfoDao,ResultSetHandler<List<UserQQInfo>>{
	private static UserQQInfoDao qqInfoDao;
	
	private UserQQInfoDao(){
		
	}
	
	public synchronized static UserQQInfoDao getInstance(){
		if(qqInfoDao==null){
			qqInfoDao=new UserQQInfoDao();
		}
		return qqInfoDao;
	}
	/**
	 * 查询所有QQ用户
	 */
	@Override
	public List<UserQQInfo> queryAll(UserQQInfo entity) throws SQLException {
		List<UserQQInfo> userQQInfos=null;
		String sql=this.parseSqlStatement.getSql(NameSpace.USERQQINFO, ISqlCommand.SELECT_ALL);
		try {
			userQQInfos=this.queryRunner.query(sql, this);
		} catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.info("查询异常");
		}
		return userQQInfos;
	}

	/**
	 * 查询某个QQ用户信息
	 */
	@Override
	public UserQQInfo querySingle(UserQQInfo entity) throws SQLException {
		String sql=null;
		Object[] params=null;
		
		if(entity==null)return null;
		
		sql=this.parseSqlStatement.getSql(NameSpace.USERQQINFO,ISqlCommand.SELECT_BY_ID);
		
		params=new Object[]{entity.getUserQQId()};
		
		try {
			List<UserQQInfo> userQQInfos=this.queryRunner.query(sql, this, params);
			return userQQInfos != null && userQQInfos.size() > 0 ? userQQInfos.get(0) : null;
		}catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.error("error",e);
		}
		return null;
	}

	/**
	 * 新增QQ用户
	 */
	@Override
	public int insert(UserQQInfo entity) throws SQLException {
		String sql =this.parseSqlStatement.getSql(NameSpace.USERQQINFO, ISqlCommand.INSERT);
	    Object[] args={entity.getUserQQId(),entity.getUserQQName(),entity.getUserQQIcon(),
	    		entity.getUserId(),entity.getUserQQRemark()};
	    int res=this.queryRunner.update(sql, args);
	    this.logger.info("插入QQ用户["+entity.getUserQQName()+"]成功");
	    return res;
	}

	/**
	 * 修改QQ用户信息
	 */
	@Override
	public int update(UserQQInfo entity) throws SQLException {
		String sql =this.parseSqlStatement.getSql(NameSpace.USERQQINFO, ISqlCommand.UPDATE);
	    Object[] args={entity.getUserQQName(),entity.getUserQQIcon(),
	    		entity.getUserId(),entity.getUserQQRemark(),entity.getUserQQId()};
	    int res=this.queryRunner.update(sql, args);
	    this.logger.info("更新QQ用户["+entity.getUserQQName()+"]成功");
	    return res;
	}

	/**
	 * 删除QQ用户
	 */
	@Override
	public int delete(UserQQInfo entity) throws SQLException {
		String sql=this.parseSqlStatement.getSql(NameSpace.USERQQINFO, ISqlCommand.DELETE);
		Object[]  args={entity.getUserQQId()};
		int res=this.queryRunner.update(sql, args);
		this.logger.info("删除QQ用户["+entity.getUserQQName()+"]成功");
		return res;	
	}

	/**
	 * QQ用户结果集处理
	 */
	@Override
	public List<UserQQInfo> handle(ResultSet rs) throws SQLException {
		List<UserQQInfo> userQQInfos=new Vector<UserQQInfo>();
		UserQQInfo userQQInfo=null;
		if(rs==null){
			throw new SQLException("结果集中没有数据");
		}
		while(rs.next()){
			userQQInfo=new UserQQInfo();
			userQQInfo.setUserQQId(rs.getString("USER_QQ_ID"));
			userQQInfo.setUserQQName(rs.getString("USER_QQ_NAME"));
			userQQInfo.setUserQQIcon(rs.getString("USER_QQ_ICON"));
			userQQInfo.setUserId(rs.getString("USER_ID"));
			userQQInfo.setUserQQRemark(rs.getString("USER_QQ_remark"));
			userQQInfos.add(userQQInfo);
		}
		return userQQInfos;
	}

}
