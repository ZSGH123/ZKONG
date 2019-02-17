package com.kba.service;

import java.util.List;

import com.kba.entity.InvestRecord;
import com.kba.entity.ReportMessage;
import com.kba.entity.UserInfo;
import com.kba.entity.UserLevel;
import com.kba.entity.UserProperty;
import com.kba.entity.UserQQInfo;
import com.kba.entity.UserWeiboInfo;
import com.kba.util.KBaException;
import com.kba.vo.PurchaseHistory;
import com.kba.vo.UserLike;
import com.kba.vo.UserManager;


/**
 * 用户业务层接口
 * @author 钟强
 * 创建时间：2019-01-13
 * 修改时间：
 */
public interface IUserService {
	/**
	 * 用户登陆业务
	 * @param user
	 * @return
	 * @throws MyException
	 */
	public UserInfo invalidUser(UserInfo user)throws KBaException;
	
	/**
	 * 用户注册业务
	 * @param user
	 * @return
	 * @throws MyException
	 */
	public UserInfo userRegister(UserInfo user)throws KBaException;
	
	/**
	 * 查询单个用户通过用户名
	 * @param user
	 * @return
	 * @throws MyException
	 */
	public UserInfo selectUserByName(UserInfo user)throws KBaException;
	/**
	 * 查询单个用户通过用户名ID
	 * @param user
	 * @return
	 * @throws MyException
	 */
	public UserInfo selectUserByUserID(UserInfo user)throws KBaException;
	/**
	 * 查询单个用户通过手机号
	 * @param user
	 * @return
	 * @throws MyException
	 */
	public UserInfo selectUserByPhone(UserInfo user)throws KBaException;
	/**
	 * 查询所有用户业务
	 * @param user
	 * @return
	 * @throws MyException
	 */
	public List<UserInfo> selectAllUser(UserInfo user)throws KBaException;
	
	/**
	 * 更新用户业务
	 * @param user
	 * @return
	 * @throws MyException
	 */
	public UserInfo updateUser(UserInfo user)throws KBaException;
	
	/**
	 * 用户微博登陆业务
	 * @param weiboInfo
	 * @return
	 * @throws KBaException
	 */
	public UserInfo weiBoLogin(UserWeiboInfo weiboInfo,String sex)throws KBaException;
	/**
	 * qq登陆业务
	 * @param weiboInfo
	 * @return
	 * @throws KBaException
	 */
	public UserInfo qqLogin(UserQQInfo userQQInfo,String sex)throws KBaException;
	/**
	 * qq解绑
	 * @param weiboInfo
	 * @return
	 * @throws KBaException
	 */
	public UserInfo qqUnbundle(UserInfo user)throws KBaException;
	/**
	 * qq绑定账号
	 * @param weiboInfo
	 * @return
	 * @throws KBaException
	 */
	public UserInfo qqBundle(UserInfo user,UserQQInfo userQQInfo)throws KBaException;
	/**
	 * weibo解绑
	 * @param weiboInfo
	 * @return
	 * @throws KBaException
	 */
	public UserInfo weiBoUnbundle(UserInfo user)throws KBaException;
	/**
	 * weibo绑定账号
	 * @param weiboInfo
	 * @return
	 * @throws KBaException
	 */
	public UserInfo weiBoBundle(UserInfo user,UserWeiboInfo weiboInfo)throws KBaException;
	
	/**
	 * 修改用户密码
	 * @param UserInfo
	 * @return
	 * @throws KBaException
	 */
	public UserInfo modifyUserPassword(UserInfo user)throws KBaException;
	
	/**
	 * 绑定手机号
	 * @param  phone
	 * @return
	 * @throws KBaException
	 */
	public UserInfo phoneBundle(UserInfo user,String phone)throws KBaException;
	
	/**
	 * 解除绑定手机号
	 * @param  phone
	 * @return
	 * @throws KBaException
	 */
	public UserInfo phoneUnBundle(UserInfo user)throws KBaException;
	

	/**
	 * 查询用户钱包信息
	 */
	public List<UserProperty> searchUP(UserInfo user)throws KBaException;

	/**
	 * 查询用户赠礼记录
	 * @param user
	 * @return
	 * @throws KBaException
	 */
	public List<PurchaseHistory> searchUGR(UserInfo user) throws KBaException;

	/**
	 * 查询用户订阅信息
	 * @param user
	 * @return
	 * @throws KBaException
	 */
	public List<UserLike> userlike(UserInfo user) throws KBaException;

	/**
	 * 查询用户管理的直播间
	 * @param user
	 * @return
	 * @throws KBaException
	 */
	public List<UserManager> manager(UserInfo user) throws KBaException;

	/**
	 *查询用户的所有举报信息 
	 */
	public List<ReportMessage> reportMessage(UserInfo user)throws KBaException;

	/**
	 * 查询用户的所有充值记录
	 * @param user
	 * @return
	 * @throws KBaException
	 */
	public List<InvestRecord> investRecord(UserInfo user) throws KBaException;

	/**
	 * 查询用户的等级
	 * @param user
	 * @return
	 * @throws KBaException
	 */
	public List<UserLevel> userLevel(UserInfo user) throws KBaException;

}