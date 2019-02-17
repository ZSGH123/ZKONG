package com.kba.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.kba.dao.IUserBookDao;
import com.kba.dao.impl.UserBookDao;
import com.kba.entity.UserBook;
import com.kba.service.IBackStageUserBookService;
import com.kba.util.KBaException;
/**
 * 后台查询订阅记录
 * @author 单杰
 * 时间：2019-1-23
 */
public class BackStageUserBookService implements IBackStageUserBookService {
	private IUserBookDao userBookDao;
	public BackStageUserBookService() {
		userBookDao=UserBookDao.getInstance();
	}
/**
 * 查询所有记录
 */
	@Override
	public List<UserBook> selectAllBook(UserBook record) throws KBaException {
		List<UserBook> userBook = null;
		try {
			userBook = userBookDao.queryAll(record);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return userBook;
	}
/**
 * 通过id查询
 */

	@Override
	public List<UserBook> selectByUserId(UserBook record) throws KBaException {
		List<UserBook> userBook = null;
		try {
			userBook = userBookDao.queryByUserId(record);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return userBook;
	}

}
