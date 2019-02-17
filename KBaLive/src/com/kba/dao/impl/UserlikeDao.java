package com.kba.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.kba.dao.IPayTypeDao;
import com.kba.dao.IUserlikeDao;
import com.kba.dao.util.ISqlCommand;
import com.kba.dao.util.NameSpace;
import com.kba.dao.util.ResultSetHandler;
import com.kba.entity.PayType;
import com.kba.vo.UserLike;

/**
 * 用户订阅查询
 * @author 墨迹
 *
 */
public class UserlikeDao extends AbstractBaseDao implements IUserlikeDao,ResultSetHandler<List<UserLike>>{

	private static UserlikeDao userlikeDao;
	
	private UserlikeDao(){
		
	}
	
	public synchronized static UserlikeDao getInstance(){
		if(userlikeDao==null){
			userlikeDao=new UserlikeDao();
		}
		return userlikeDao;
	}
	

	/**
	 * 查询某个用户的所有关注
	 */
	@Override
	public List<UserLike> queryAll(UserLike entity) throws SQLException {
		List<UserLike> userLikes=null;
		String sql=this.parseSqlStatement.getSql(NameSpace.USERLIKE, ISqlCommand.SELECT_ALL);
		Object[] args = new Object[] { entity.getUserId()};
		try {
			userLikes=this.queryRunner.query(sql, this,args);
		} catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.info("查询异常");
		}
		return userLikes;
	}
	

	@Override
	public UserLike querySingle(UserLike entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(UserLike entity) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UserLike entity) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(UserLike entity) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserLike> handle(ResultSet rs) throws SQLException {
		List<UserLike> userLikes = new Vector<UserLike>();
		UserLike userLike = null;
		if (rs == null) {
			throw new SQLException("结果集中没有数据");
		}
		while (rs.next()) {
			userLike = new UserLike();
			// xml
			userLike.setUserId(rs.getString("user_id"));
			userLike.setLiveRoomId(rs.getString("live_room_id"));
			userLike.setLive_room_title(rs.getString("live_room_title"));
			userLike.setLive_room_remark(rs.getString("live_room_remark"));
			userLike.setUser_name(rs.getString("user_name"));
			userLikes.add(userLike);
		}
		return userLikes;
	}

	

	

}
