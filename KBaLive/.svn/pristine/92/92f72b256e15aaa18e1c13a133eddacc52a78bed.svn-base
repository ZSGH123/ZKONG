package com.kba.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.kba.dao.IUserBookDao;
import com.kba.dao.util.ISqlCommand;
import com.kba.dao.util.NameSpace;
import com.kba.dao.util.ResultSetHandler;
import com.kba.entity.UserBook;

/**
 * 用户订阅dao
 * @author 赵科
 * 创建时间：2019-1-15
 * 修改时间：
 */
public class UserBookDao extends AbstractBaseDao implements IUserBookDao,ResultSetHandler<List<UserBook>>{

	private static UserBookDao userBookDao;
   
	private UserBookDao(){
		
	}
	
	public synchronized static UserBookDao getInstance(){
		if(userBookDao==null){
			userBookDao=new UserBookDao();
		}
		return userBookDao;
	}
	/**
     * 查询所有订阅信息
     */
	@Override
	public List<UserBook> queryAll(UserBook entity) throws SQLException {
		List<UserBook> userBooks=null;
		String sql=this.parseSqlStatement.getSql(NameSpace.USERBOOK, ISqlCommand.SELECT_ALL);
		try {
			userBooks=this.queryRunner.query(sql, this);
		} catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.info("查询异常");
		}
		return userBooks;
	}

	/**
	 * 查询单条订阅信息
	 */
	@Override
	public UserBook querySingle(UserBook entity) throws SQLException {
		String sql=null;
		Object[] params=null;
		
		if(entity==null)return null;
		
		sql=this.parseSqlStatement.getSql(NameSpace.USERBOOK,ISqlCommand.SELECT_BY_ID);
		
		params=new Object[]{entity.getUserBookId()};
		
		try {
			List<UserBook> userBooks=this.queryRunner.query(sql, this, params);
			return userBooks != null && userBooks.size() > 0 ? userBooks.get(0) : null;
		}catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.error("error",e);
		}
		return null;
	}

	/**
	 * 新增订阅信息
	 */
	@Override
	public int insert(UserBook entity) throws SQLException {
		String sql =this.parseSqlStatement.getSql(NameSpace.USERBOOK, ISqlCommand.INSERT);
	    Object[] args={entity.getAnchorId(),entity.getUserId(),entity.getUserBookTime(),
	    		entity.getUserTakeOffTime(),entity.getUserBookRemark()};
	    int res=this.queryRunner.update(sql, args);
	    this.logger.info("插入用户订阅["+entity.getUserBookId()+"]成功");
	    return res;
	}

	/**
	 * 修改订阅信息
	 */
	@Override
	public int update(UserBook entity) throws SQLException {
		String sql =this.parseSqlStatement.getSql(NameSpace.USERBOOK, ISqlCommand.UPDATE);
	    Object[] args={entity.getAnchorId(),entity.getUserId(),entity.getUserBookTime(),
	    		entity.getUserTakeOffTime(),entity.getUserBookRemark(),entity.getUserBookId()};
	    int res=this.queryRunner.update(sql, args);
	    this.logger.info("更新用户订阅["+entity.getUserBookId()+"]成功");
	    return res;
	}

	/**
	 * 删除订阅信息
	 */
	@Override
	public int delete(UserBook entity) throws SQLException {
		String sql=this.parseSqlStatement.getSql(NameSpace.USERBOOK, ISqlCommand.DELETE);
		Object[]  args={entity.getUserBookId()};
		int res=this.queryRunner.update(sql, args);
		this.logger.info("删除用户订阅["+entity.getUserBookId()+"]成功");
		return res;	
	}

	/**
	 * 订阅信息结果处理
	 */
	@Override
	public List<UserBook> handle(ResultSet rs) throws SQLException {
		List<UserBook> userBooks=new Vector<UserBook>();
		UserBook userBook=null;
		if(rs==null){
			throw new SQLException("结果集中没有数据");
		}
		while(rs.next()){
			userBook=new UserBook();
			userBook.setUserBookId(rs.getString("USER_BOOK_ID"));
			userBook.setAnchorId(rs.getString("ANCHOR_ID"));
			userBook.setUserId(rs.getString("USER_ID"));
			userBook.setUserBookTime(rs.getTimestamp("USER_BOOK_TIME"));
			userBook.setUserTakeOffTime(rs.getTimestamp("USER_TAKE_OFF_TIME"));
			userBook.setUserBookRemark(rs.getString("USER_BOOK_REMARK"));
			userBooks.add(userBook);
		}
		return userBooks;
	}
	/**
	 * 按用户id查询订阅
	 * 作者：单杰
	 */
	@Override
	public List<UserBook> queryByUserId(UserBook entity) throws SQLException {
		List<UserBook> userBooks=null;
		String sql=this.parseSqlStatement.getSql(NameSpace.USERBOOK, ISqlCommand.SELECT_BY_USERID);
		try {
			userBooks=this.queryRunner.query(sql, this);
		} catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.info("查询异常");
		}
		return userBooks;
	}

}
