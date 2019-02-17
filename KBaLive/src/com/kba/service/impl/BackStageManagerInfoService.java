package com.kba.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.kba.dao.IBackStageManagerInfoDao;
import com.kba.dao.impl.BackStageManagerInfoDao;
import com.kba.entity.BackStageManagerInfo;
import com.kba.service.IBackStageManagerInfoService;
import com.kba.util.KBaException;

public class BackStageManagerInfoService implements IBackStageManagerInfoService{
	
     private IBackStageManagerInfoDao managerInfoDao;
     
     public BackStageManagerInfoService(){
    	 this.managerInfoDao=BackStageManagerInfoDao.getInstance();
     }

     /**
      * 后台管理员登录验证
      */
	@Override
	public BackStageManagerInfo invalidManager(BackStageManagerInfo manager) throws KBaException {
		try {
			//请求数据层对象
			BackStageManagerInfo managerd = managerInfoDao.querySingle(manager);
			if (managerd != null) {//用户存在
				if (manager.getBackStageManagerPassword().equals(managerd.getBackStageManagerPassword())) {
					return managerd;
				}else {//密码不匹配
					//置空用户所输密码
					manager.setBackStageManagerPassword("");
					return manager;
				}
			}
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return null;
	}

	/**
	 * 查询所有管理员信息
	 */
	@Override
	public List<BackStageManagerInfo> selectAllManager(BackStageManagerInfo manager) throws KBaException {
		List<BackStageManagerInfo> managers=null;
		try {
			managers=managerInfoDao.queryAll(manager);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return managers;
	}

	/**
	 * 通过名称查询后台管理员信息
	 */
	@Override
	public BackStageManagerInfo selectManagerByName(BackStageManagerInfo manager) throws KBaException {
		try {
			return managerInfoDao.querySingleByName(manager);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
	}

	/**
	 * 通过id查询后台管理员信息
	 */
	@Override
	public BackStageManagerInfo selectManagerByManagerID(BackStageManagerInfo manager) throws KBaException {
		try {
			return managerInfoDao.querySingle(manager);
		} catch (SQLException e) {
			throw new KBaException(e);
		}
	}

	/**
	 * 新增后台管理员
	 */
	@Override
	public BackStageManagerInfo insertManager(BackStageManagerInfo manager) throws KBaException {
		try {
			// 检查
			BackStageManagerInfo managerd=managerInfoDao.querySingle(manager);
			if (managerd == null) {// 没有，则保存
				int res = managerInfoDao.insert(manager);
				if (res > 0) {// 成功
					return managerInfoDao.querySingleByName(manager);
				}
			}
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return null;
	}

	/**
	 * 修改后台管理员
	 */
	@Override
	public BackStageManagerInfo updateManager(BackStageManagerInfo manager) throws KBaException {
		try {
			//更新
			int res=managerInfoDao.update(manager);
			if(res>0){ //成功
				return managerInfoDao.querySingle(manager);
			}
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return null;
	}
	
	/**
	 * 通过用户名查询是否存在
	 * @param manager
	 * @return
	 * @throws KBaException
	 */
	public boolean checkManagerByName(BackStageManagerInfo manager) throws KBaException{
		try {
			manager=this.managerInfoDao.querySingleByName(manager);
			return manager!=null?true:false;
		} catch (SQLException e) {
			throw new KBaException(e);
		}
	}
 
	/**
	 * 删除后台管理员
	 */
	@Override
	public BackStageManagerInfo deleteManager(BackStageManagerInfo manager) throws KBaException {
		try {
			int res=managerInfoDao.delete(manager);
			if(res>0){
				return manager;
			}
		} catch (SQLException e) {
			throw new KBaException(e);
		}
		return null;
	}
     
     
}