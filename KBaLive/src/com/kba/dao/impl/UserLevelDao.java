package com.kba.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.kba.dao.IUserLevelDao;
import com.kba.dao.util.ISqlCommand;
import com.kba.dao.util.NameSpace;
import com.kba.dao.util.ResultSetHandler;
import com.kba.entity.UserLevel;

/**
 * 用户等级dao
 * @author 赵科
 * 创建时间：2019-1-15
 * 修改时间：
 */
public class UserLevelDao extends AbstractBaseDao implements IUserLevelDao,ResultSetHandler<List<UserLevel>>{

	private static UserLevelDao userLevelDao;
	
	private UserLevelDao(){
		
	}
	
	public synchronized static UserLevelDao getInstance(){
		if(userLevelDao== null){
			userLevelDao=new UserLevelDao();
		}
		return userLevelDao;
	}
	/**
	 * 查询所有用户等级
	 */
	@Override
	public List<UserLevel> queryAll(UserLevel entity) throws SQLException {
		List<UserLevel> userLevels=null;
		String sql=this.parseSqlStatement.getSql(NameSpace.USERLEVEL, ISqlCommand.SELECT_ALL);
		try {
			userLevels=this.queryRunner.query(sql, this);
		} catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.info("查询异常");
		}
		return userLevels;
	}

	/**
	 * 通过等级名称查询
	 * @param entity
	 * @return
	 * @throws SQLException
	 */
	public UserLevel querySingleByName(UserLevel entity)throws SQLException{
		String sql=null;
		Object[] params=null;
		
		if(entity==null)return null;
		
		sql=this.parseSqlStatement.getSql(NameSpace.USERLEVEL,ISqlCommand.SELECT_BY_NAME);
		
		params=new Object[]{entity.getUserLevelName()};
		
		try {
			List<UserLevel> userLevels=this.queryRunner.query(sql, this, params);
			return userLevels != null && userLevels.size() > 0 ? userLevels.get(0) : null;
		}catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.error("error",e);
		}
		return null;
	}
	/**
	 * 查询某种用户等级
	 */
	@Override
	public UserLevel querySingle(UserLevel entity) throws SQLException {
		String sql=null;
		Object[] params=null;
		
		if(entity==null)return null;
		
		sql=this.parseSqlStatement.getSql(NameSpace.USERLEVEL,ISqlCommand.SELECT_BY_ID);
		
		params=new Object[]{entity.getUserLevelId()};
		
		try {
			List<UserLevel> userLevels=this.queryRunner.query(sql, this, params);
			return userLevels != null && userLevels.size() > 0 ? userLevels.get(0) : null;
		}catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.error("error",e);
		}
		return null;
	}

	/**
	 * 新增用户等级
	 */
	@Override
	public int insert(UserLevel entity) throws SQLException {
		String sql =this.parseSqlStatement.getSql(NameSpace.USERLEVEL, ISqlCommand.INSERT);
	    Object[] args={entity.getUserLevelName(),entity.getUserLowInvest(),entity.getUserHighInvest(),
	    		entity.getUserLevelRemark()};
	    int res=this.queryRunner.update(sql, args);
	    this.logger.info("插入用户等级["+entity.getUserLevelName()+"]成功");
	    return res;
	}

	/**
	 * 修改用户等级信息
	 */
	@Override
	public int update(UserLevel entity) throws SQLException {
		String sql =this.parseSqlStatement.getSql(NameSpace.USERLEVEL, ISqlCommand.UPDATE);
	    Object[] args={entity.getUserLevelName(),entity.getUserLowInvest(),entity.getUserHighInvest(),
	    		entity.getUserLevelRemark(),entity.getUserLevelId()};
	    int res=this.queryRunner.update(sql, args);
	    this.logger.info("更新用户等级["+entity.getUserLevelName()+"]成功");
	    return res;
	}

	/**
	 * 删除用户等级信息
	 */
	@Override
	public int delete(UserLevel entity) throws SQLException {
		String sql=this.parseSqlStatement.getSql(NameSpace.USERLEVEL, ISqlCommand.DELETE);
		Object[]  args={entity.getUserLevelId()};
		int res=this.queryRunner.update(sql, args);
		this.logger.info("删除用户等级["+entity.getUserLevelName()+"]成功");
		return res;	
	}

	/**
	 * 用户等级结果集处理
	 */
	@Override
	public List<UserLevel> handle(ResultSet rs) throws SQLException {
		List<UserLevel> userLevels=new Vector<UserLevel>();
		UserLevel userLevel=null;
		if(rs==null){
			throw new SQLException("结果集中没有数据");
		}
		while(rs.next()){
			userLevel=new UserLevel();
			userLevel.setUserLevelId(rs.getString("USER_LEVEL_ID"));
			userLevel.setUserLevelName(rs.getString("USER_LEVEL_NAME"));
			userLevel.setUserLowInvest(Integer.parseInt(rs.getString("USER_LOW_INVEST")));
			userLevel.setUserHighInvest(Integer.parseInt(rs.getString("USER_HIGH_INVEST")));
			userLevel.setUserLevelRemark(rs.getString("USER_LEVEL_REMARK"));
			userLevels.add(userLevel);
		}
		return userLevels;
	}

}
