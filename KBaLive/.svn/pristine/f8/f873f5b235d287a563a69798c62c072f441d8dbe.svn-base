package com.kba.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.kba.dao.IPayTypeDao;
import com.kba.dao.IUserManagerDao;
import com.kba.dao.IUserlikeDao;
import com.kba.dao.util.ISqlCommand;
import com.kba.dao.util.NameSpace;
import com.kba.dao.util.ResultSetHandler;
import com.kba.entity.PayType;
import com.kba.vo.UserLike;
import com.kba.vo.UserManager;

/**
 * 用户管理
 * @author 墨迹
 *
 */
public class UserManagerDao extends AbstractBaseDao implements IUserManagerDao,ResultSetHandler<List<UserManager>>{

	private static UserManagerDao userlikeDao;
	
	private UserManagerDao(){
		
	}
	
	public synchronized static UserManagerDao getInstance(){
		if(userlikeDao==null){
			userlikeDao=new UserManagerDao();
		}
		return userlikeDao;
	}
	

	/**
	 * 查询某个用户的所有关注
	 */
	@Override
	public List<UserManager> queryAll(UserManager entity) throws SQLException {
		List<UserManager> userManagers=null;
		String sql=this.parseSqlStatement.getSql(NameSpace.USERMANAGER, ISqlCommand.SELECT_ALL);
		Object[] args = new Object[] { entity.getUser_id()};
		try {
			userManagers=this.queryRunner.query(sql, this,args);
		} catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.info("查询异常");
		}
		return userManagers;
	}
	

	@Override
	public UserManager querySingle(UserManager entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(UserManager entity) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UserManager entity) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(UserManager entity) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserManager> handle(ResultSet rs) throws SQLException {
		List<UserManager> userManagers = new Vector<UserManager>();
		UserManager userManager = null;
		if (rs == null) {
			throw new SQLException("结果集中没有数据");
		}
		while (rs.next()) {
			userManager = new UserManager();
			// xml
			userManager.setUser_id(rs.getString("user_id"));
			userManager.setLive_room_id(rs.getString("live_room_id"));
			userManager.setPush_start_time(rs.getString("push_start_time"));
			userManager.setUser_name(rs.getString("user_name"));
			userManagers.add(userManager);
		}
		return userManagers;
	}

	

	

}
