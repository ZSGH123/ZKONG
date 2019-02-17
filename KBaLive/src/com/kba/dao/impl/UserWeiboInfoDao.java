package com.kba.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.kba.dao.IUserWeiboInfoDao;
import com.kba.dao.util.ISqlCommand;
import com.kba.dao.util.NameSpace;
import com.kba.dao.util.ResultSetHandler;
import com.kba.entity.UserWeiboInfo;

/**
 * 微博用户dao
 * @author 赵科
 * 创建时间：2019-1-15
 * 修改时间：
 */
public class UserWeiboInfoDao extends AbstractBaseDao implements IUserWeiboInfoDao,ResultSetHandler<List<UserWeiboInfo>>{
private static UserWeiboInfoDao weiboInfoDao;
	
	private UserWeiboInfoDao(){
		
	}
	
	public synchronized static UserWeiboInfoDao getInstance(){
		if(weiboInfoDao==null){
			weiboInfoDao=new UserWeiboInfoDao();
		}
		return weiboInfoDao;
	}
	/**
	 * 查询所有微博用户
	 */
	@Override
	public List<UserWeiboInfo> queryAll(UserWeiboInfo entity) throws SQLException {
		List<UserWeiboInfo> userWeiboInfos=null;
		String sql=this.parseSqlStatement.getSql(NameSpace.USERWEIBOINFO, ISqlCommand.SELECT_ALL);
		try {
			userWeiboInfos=this.queryRunner.query(sql, this);
		} catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.info("查询异常");
		}
		return userWeiboInfos;
	}

	/**
	 * 查询单个微博用户信息
	 */
	@Override
	public UserWeiboInfo querySingle(UserWeiboInfo entity) throws SQLException {
		String sql=null;
		Object[] params=null;
		
		if(entity==null)return null;
		
		sql=this.parseSqlStatement.getSql(NameSpace.USERWEIBOINFO,ISqlCommand.SELECT_BY_ID);
		
		params=new Object[]{entity.getUserWeiboId()};
		
		try {
			List<UserWeiboInfo> uerWeiboInfos=this.queryRunner.query(sql, this, params);
			return uerWeiboInfos != null && uerWeiboInfos.size() > 0 ? uerWeiboInfos.get(0) : null;
		}catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.error("error",e);
		}
		return null;
	}

	/**
	 * 新增微博用户
	 */
	@Override
	public int insert(UserWeiboInfo entity) throws SQLException {
		String sql =this.parseSqlStatement.getSql(NameSpace.USERWEIBOINFO, ISqlCommand.INSERT);
	    Object[] args={entity.getUserWeiboId(),entity.getUserWeiboName(),entity.getUserWeiboIcon(),entity.getUserId(),
	    		entity.getUserWeiboRemark()};
	    int res=this.queryRunner.update(sql, args);
	    this.logger.info("插入微博用户["+entity.getUserWeiboName()+"]成功");
	    return res;
	}

	/**
	 * 修改微博用户
	 */
	@Override
	public int update(UserWeiboInfo entity) throws SQLException {
		String sql =this.parseSqlStatement.getSql(NameSpace.USERWEIBOINFO, ISqlCommand.UPDATE);
	    Object[] args={entity.getUserWeiboName(),entity.getUserWeiboIcon(),entity.getUserId(),
	    		entity.getUserWeiboRemark(),entity.getUserWeiboId()};
	    int res=this.queryRunner.update(sql, args);
	    this.logger.info("更新微博用户["+entity.getUserWeiboName()+"]成功");
	    return res;
	}

	/**
	 * 删除微博用户
	 */
	@Override
	public int delete(UserWeiboInfo entity) throws SQLException {
		String sql=this.parseSqlStatement.getSql(NameSpace.USERWEIBOINFO, ISqlCommand.DELETE);
		Object[]  args={entity.getUserWeiboId()};
		int res=this.queryRunner.update(sql, args);
		this.logger.info("删除微博用户["+entity.getUserWeiboName()+"]成功");
		return res;
	}

	/**
	 * 微博用户结果集处理
	 */
	@Override
	public List<UserWeiboInfo> handle(ResultSet rs) throws SQLException {
		List<UserWeiboInfo> userWeiboInfos=new Vector<UserWeiboInfo>();
		UserWeiboInfo userWeiboInfo=null;
		if(rs==null){
			throw new SQLException("结果集中没有数据");
		}
		while(rs.next()){
			userWeiboInfo=new UserWeiboInfo();
			userWeiboInfo.setUserWeiboId(rs.getString("USER_WEIBO_ID"));
			userWeiboInfo.setUserWeiboName(rs.getString("USER_WEIBO_NAME"));
			userWeiboInfo.setUserWeiboIcon(rs.getString("USER_WEIBO_ICON"));
			userWeiboInfo.setUserId(rs.getString("USER_ID"));
			userWeiboInfo.setUserWeiboRemark(rs.getString("USER_WEIBO_REMARK"));
			userWeiboInfos.add(userWeiboInfo);
		}
		return userWeiboInfos;
	}

}
