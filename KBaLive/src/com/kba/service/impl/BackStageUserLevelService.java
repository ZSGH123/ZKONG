package com.kba.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.kba.dao.impl.UserLevelDao;
import com.kba.entity.AnchorLevel;
import com.kba.entity.UserLevel;
import com.kba.service.IUserLevelService;
import com.kba.util.KBaException;

/**
 * 后台用户等级service
 * @author 赵科
 * 创建时间：2019-01-22
 * 修改时间：
 */
public class BackStageUserLevelService implements IUserLevelService{

	private UserLevelDao userLevelDao;
	
    public BackStageUserLevelService() {
		this.userLevelDao=UserLevelDao.getInstance();
	}
	
    /**
     * 查询所有用户等级
     */
	@Override
	public List<UserLevel> selectAllUserLevel(UserLevel userLevel) throws KBaException {
		List<UserLevel> userLevels=null;
		try {
			userLevels=userLevelDao.queryAll(userLevel);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return userLevels;
	}
    
	/**
	 * 通过等级名称查询
	 */
	@Override
	public UserLevel selectUserLevelByName(UserLevel userLevel) throws KBaException {
		try {
			return userLevelDao.querySingleByName(userLevel);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
	}

	/**
	 * 通过等级编号查询用户等级
	 */
	@Override
	public UserLevel selectUserLevelByUserLevelID(UserLevel userLevel) throws KBaException {
		try {
			return userLevelDao.querySingle(userLevel);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
	}

	/**
	 * 新增等级
	 */
	@Override
	public UserLevel insertUserLevel(UserLevel userLevel) throws KBaException {
		try {
			// 检查
			UserLevel userLeveld=userLevelDao.querySingle(userLevel);
			if (userLeveld == null) {// 没有，则保存
				int res = userLevelDao.insert(userLevel);
				if (res > 0) {// 成功
					return userLevelDao.querySingleByName(userLevel);
				}
			}
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return null;
	}

	/**
	 * 修改等级信息
	 */
	@Override
	public UserLevel updateUserLevel(UserLevel userLevel) throws KBaException {
		try {
			//更新
			int res=userLevelDao.update(userLevel);
			if(res>0){ //成功
				return userLevelDao.querySingle(userLevel);
			}
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return null;
	}

	/**
	 * 删除等级信息
	 */
	@Override
	public UserLevel deleteUserLevel(UserLevel userLevel) throws KBaException {
		try {
			int res=userLevelDao.delete(userLevel);
			if(res>0){
				return userLevel;
			}
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return null;
	}

	/**
	 * 通过等级名称查询用户等级是否存在
	 * @param anchorLevel
	 * @return
	 */
	public boolean checkUserLevelByName(UserLevel userLevel) throws KBaException{
		try {
			userLevel=this.userLevelDao.querySingleByName(userLevel);
			return userLevel!=null?true:false;
		} catch (SQLException e) {
			throw new KBaException(e);
		}
	}

}
