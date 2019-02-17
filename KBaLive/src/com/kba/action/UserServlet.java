package com.kba.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.w3c.dom.Attr;

import com.kba.dao.impl.AnchorInfoDao;
import com.kba.dao.impl.InvestRecordDao;
import com.kba.dao.impl.LiveContentDao;
import com.kba.dao.impl.LiveRecordDao;
import com.kba.dao.impl.LiveRoomDao;
import com.kba.dao.impl.LiveTypeDao;
import com.kba.dao.impl.ReportMessageDao;
import com.kba.dao.impl.UserBookDao;
import com.kba.dao.impl.UserDao;
import com.kba.dao.impl.UserLevelDao;
import com.kba.entity.AnchorInfo;
import com.kba.entity.BarrageInfo;
import com.kba.entity.InvestRecord;
import com.kba.entity.LiveContent;
import com.kba.entity.LiveRecord;
import com.kba.entity.LiveRoom;
import com.kba.entity.LiveType;
import com.kba.entity.ReportMessage;
import com.kba.entity.UserBook;
import com.kba.entity.UserInfo;
import com.kba.entity.UserLevel;
import com.kba.entity.UserProperty;
import com.kba.entity.UserWeiboInfo;
import com.kba.service.IUserService;
import com.kba.service.impl.UserService;
import com.kba.util.KBaException;
import com.kba.util.Log;
import com.kba.util.SendMessageCode;
import com.kba.util.weibo.OauthTool;

import com.kba.vo.LiveHomeMessages;
import com.kba.vo.PurchaseHistory;
import com.kba.vo.QinChuThread;
import com.kba.vo.UserLike;
import com.kba.vo.UserManager;
import com.qq.connect.QQConnectException;
import com.qq.connect.oauth.Oauth;
import weibo4j.Account;
import weibo4j.Users;
import weibo4j.model.User;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONException;

/**
 * 响应用户功能有关的操作请求 作者：赵科 时间：2019-1-16 修改：2019-1-17
 */
public class UserServlet extends KBaBaseServlet {

	private static final long serialVersionUID = 1L;
	// 业务对象
	private IUserService userService;
	
	//上下文集合
	List<BarrageInfo> barrageInfos=new ArrayList();

	public UserServlet() {
		this.userService = new UserService();
	}

	@Override
	protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void service_(String command, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	}
	
	/**
	 * 个人中心信息获取
	 * @param req
	 * @param resp
	 * @throws KBaException 
	 */
	public void persional(HttpServletRequest req, HttpServletResponse resp) throws KBaException{
		    HttpSession session=this.getSession();
		    UserInfo user=new UserInfo();
			user=(UserInfo) session.getAttribute("loginUser");
			System.out.println(user);
			//用户钱包信息
			List<UserProperty> userpropertys=this.userService.searchUP(user);
			session.setAttribute("userpropertys", userpropertys);
			//用户赠送礼物记录
			List<PurchaseHistory> purchaseHistorys=this.userService.searchUGR(user);
			session.setAttribute("purchaseHistorys", purchaseHistorys);
			//用户订阅
			List<UserLike> userlikes=this.userService.userlike(user);
			session.setAttribute("userlikes", userlikes);
			//用户所管理的直播间
			List<UserManager> userManagers=this.userService.manager(user);
			session.setAttribute("userManagers", userManagers);
			
			//举报消息
			List<ReportMessage> reportMessages=this.userService.reportMessage(user);
			session.setAttribute("reportMessages", reportMessages);
		
			//充值记录
		    List<InvestRecord> investRecords = this.userService.investRecord(user);
		    session.setAttribute("investRecords", investRecords);
			
			
			//用户等级
			List<UserLevel> userLevels=this.userService.userLevel(user);
			session.setAttribute("userLevels", userLevels);	
			
			try {
				resp.sendRedirect("user-page.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		
			
	}

	/**
	 * 实名认证
	 */
	public void updateRealName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
	    HttpSession session=this.getSession();
	    UserInfo user=new UserInfo();
		user=(UserInfo) session.getAttribute("loginUser");
		if(user==null){
			resp.sendRedirect("login.jsp");
			return;
		}
		//修改数据
		try {
			user=userService.selectUserByUserID(user);
			if(user==null)	return;
			user.setUserRealName(req.getParameter("realName"));
			user.setUserIdCard(req.getParameter("idCard"));
			user=this.userService.updateUser(user);
			if(user==null)	return;
			session.setAttribute("loginUser", user);
			resp.sendRedirect("userAction.do?command=persional");	
		} catch (KBaException e) {
			this.toError(e, resp);
		}
	
     }
	/**
	 * 绑定手机
	 */
	public void toSetPhone(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
	    HttpSession session=this.getSession();
	    UserInfo user=new UserInfo();
		user=(UserInfo) session.getAttribute("loginUser");
		if(user==null){
			resp.sendRedirect("login.jsp");
			return;
		}
		try {
			//修改数据
			user=userService.selectUserByUserID(user);
			if(user==null) return ;
			user.setUserPhoneNumber(req.getParameter("userPhoneNumber"));
			user=this.userService.updateUser(user);
			if(user==null) return ;
			session.setAttribute("loginUser", user);
			resp.sendRedirect("userAction.do?command=persional");
			System.out.println("绑定新的手机号成功");
		} catch (KBaException e) {
			this.toError(e, resp);
		}
}

	
	/**
	 * 绑定银行卡
	 */
	public void updateBankcard(HttpServletRequest req, HttpServletResponse resp) throws KBaException{
	    HttpSession session=this.getSession();
	    UserInfo user=new UserInfo();
		user=(UserInfo) session.getAttribute("loginUser");
		user.setUserBankCard(req.getParameter("bankcard"));
		//修改数据
		user=this.userService.updateUser(user);
		session.setAttribute("loginUser", user);
		try {
			resp.sendRedirect("userAction.do?command=persional");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	/**
	 * 通过用户名检查用户是否存在
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void checkUserByName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserInfo user = this.wrap(request);
		PrintWriter out = response.getWriter();
		try {
			user = userService.selectUserByName(user);
			if (user != null) {
				out.print(true);
				System.out.println("用户已存在");
			} else {
				out.print("用户不存在");
				System.out.println("用户不存在");
			}
		} catch (KBaException e) {
			this.toError(e, response);
		} finally {
			out.flush();
			out.close();
		}

	}

	/**
	 * 通过用户手机号检查用户是否存在
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void checkUserByPhone(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserInfo user = this.wrap(request);
		PrintWriter out = response.getWriter();
		try {
			user = userService.selectUserByPhone(user);
			if (user != null) {
				out.print(true);
				System.out.println("用户已存在");
			} else {
				out.print("该手机号还未注册");
				System.out.println("该手机号还未注册");
			}
		} catch (KBaException e) {
			this.toError(e, response);
		} finally {
			out.close();
			out.flush();
		}

	}
	
	
	/**
	 * 安全验证
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void safetyCheck(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserInfo user = this.wrap(request);
		PrintWriter out = response.getWriter();
		UserInfo loginUser=new UserInfo();
		loginUser=(UserInfo) getSession().getAttribute("loginUser");
		 if(loginUser==null) {
			 out.print("请重新登陆");
			 return;
		 }
		 if(!loginUser.getUserPhoneNumber().equals(user.getUserPhoneNumber())){
			 out.print("你输入的手机号错误");
			 return;
		 }		
		out.print(true);
	}
	
	/**
	 * 绑定新手机的验证
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void bundleNewPhone(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserInfo user = this.wrap(request);
		PrintWriter out = response.getWriter();
		try {
			user = userService.selectUserByPhone(user);
			if (user != null) {
				out.print("该手机号已被绑定");
				System.out.println("该手机号已被绑定");
			} else {
				out.print(true);
				System.out.println("该手机号还未被绑定");
			}
		} catch (KBaException e) {
			this.toError(e, response);
		} finally {
			out.close();
			out.flush();
		}

	}

	/**
	 * 检测手机号是否有效
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void checkValidByPhone(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserInfo user = this.wrap(request);
		PrintWriter out = response.getWriter();
		try {
			user = userService.selectUserByPhone(user);
			if (user != null) {
				out.print(false);
				System.out.println("用户已存在");
			} else {
				out.print(true);
				System.out.println("该手机号还未注册");
			}
		} catch (KBaException e) {
			this.toError(e, response);
		} finally {
			out.close();
			out.flush();
		}

	}

	/**
	 * 普通登陆（手机号/用户名+密码）
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void generalLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = this.getSession();
		PrintWriter out = response.getWriter();
		// 1.获取并封装表单数据
		UserInfo user = this.wrap(request);
		// 2.获取登陆方式（0手机，1用户名）
		String method = request.getParameter("method");
		if (method == null)
			return;
		int code = Integer.parseInt(method);
		// 3.重新设置用户的值
		if (code == 1) {
			user.setUserName(user.getUserPhoneNumber());
			user.setUserPhoneNumber(null);
		}
		String isRemenber = request.getParameter("remeberPassword");
		// System.out.println(user+" "+method);
		// 4.请求业务对象
		try {
			user = userService.invalidUser(user);
			if (user != null) {
				if (user.getUserPassword() != null) {// 成功
					session.setAttribute("loginUser", user);//保存用户信息
					session.setAttribute("loginIp", request.getRemoteAddr());//保存登陆ip
					if ("on".equals(isRemenber)) {// 记住密码
						Cookie userNameCookie = new Cookie("userName", request.getParameter("userPhoneNumber"));
						Cookie pwdCookie = new Cookie("userPassword", user.getUserPassword());
						response.addCookie(userNameCookie);
						response.addCookie(pwdCookie);
					}
					String previouspage = (String) session.getAttribute("previouspage");
					if (previouspage != null) {
						System.out.println(previouspage);
						// 重定向到上一个页面
						response.sendRedirect(previouspage);
						session.removeAttribute("previouspage");
					} else {
						// 回到系统首页
						out.print("indexAction.do");
					}
				} else {// 密码不一致
					out.print("密码错误");
					System.out.println("密码错误");
				}
			} else {// 用户不存在
				out.print("用户不存在");
				System.out.println("用户不存在");
			}
		} catch (KBaException e) {
			this.toError(e, response);
		} finally {
			out.flush();
			out.close();
		}
	}


	/**
	 * 微博登陆回调
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void afterWeiBoLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserWeiboInfo weiboInfo = wrapWeiBoInfo(request);
		String sex = (String) request.getAttribute("sex");
		System.out.println(sex);
		UserInfo user = null;
		try {
			user = userService.weiBoLogin(weiboInfo, sex);
			if (user != null) {
				getSession().setAttribute("loginUser", user);
				getSession().setAttribute("loginIp", request.getRemoteAddr());//保存登陆ip
				response.sendRedirect("index.jsp");
				Log.logInfo("账户:" + user.getUserId() + " 绑定weibo" + weiboInfo.getUserWeiboName() + "成功");
			}
		} catch (KBaException e) {
			this.toError(e, response);
		}
	}

	/**
	 * 去qq登陆 转发：保护资源路径 可以为页面提供预加载数据
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void toQQLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = null;
		try {
			url = new Oauth().getAuthorizeURL(request);
			getSession().setAttribute("operatecode", "qqlogin");
			response.sendRedirect(url);
			System.out.println("授权地址" + url);
		} catch (QQConnectException e) {
			// this.toError(e, response);
			e.printStackTrace();
		}
	}

	/**
	 * 去微博登陆 转发：保护资源路径 可以为页面提供预加载数据
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void toWeiLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getSession().setAttribute("operatecode", "weibologin");
		response.sendRedirect(OauthTool.authorize("code"));
	}

	/**
	 * 去注册 转发：保护资源路径 可以为页面提供预加载数据
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void toRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	
	/**
	 * 去绑定新手机
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void toResetphone(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.sendRedirect("reset-phone.jsp");	
	}
	/**
	 * 去重置用户密码页面 转发：保护资源路径 可以为页面提供预加载数据
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void toResetPassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserInfo user = this.wrap(request);
		try {
			user = userService.selectUserByPhone(user);
			if (user != null) {
				getSession().setAttribute("resetPasswordUser", user);
				// 前往重置密码界面
				// request.getRequestDispatcher("reset-password.jsp").forward(request,
				// response);
				response.sendRedirect("reset-password.jsp");
				return;
			}
			request.getRequestDispatcher("error.jsp").forward(request, response);
		} catch (KBaException e) {
			this.toError(e, response);
		}
	}
	/**
	 * 修改用户密码
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void modifyUserPassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserInfo user = this.wrap(request);
		try {
			user = userService.modifyUserPassword(user);
			if (user != null) {//修改成功
				response.sendRedirect("login.jsp");
				return;
			}
			request.getRequestDispatcher("error.jsp").forward(request, response);
		} catch (KBaException e) {
			this.toError(e, response);
		}
	}
	
	/**
	 * 普通注册（通过手机号注册）
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void generalRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = this.getSession();
		PrintWriter out = response.getWriter();
		try {
			// 封装用户注册数据
			UserInfo user = this.wrap(request);
			// 请求业务对象
			UserInfo userd = userService.userRegister(user);
			if (userd != null) {
				session.setAttribute("loginUser", user);
				out.print("indexAction.do");
			} else {
				out.print("userAction.do?command=toRegister");
			}
		} catch (KBaException e) {
			this.toError(e, response);
		} finally {
			out.flush();
			out.close();
		}
	}

	/**
	 * 查询所有用户
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void selectAllUserOfUserManage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserInfo user = null;
		try {
			// 请求业务对象
			List<UserInfo> users = userService.selectAllUser(user);
			if (users != null) {
				request.setAttribute("users", users);
			}
		} catch (KBaException e) {
			this.toError(e, response);
		}
	}

	/**
	 * 
	 * 发送短信验证码
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void sendCode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// 获取手机号码
		String phoneNumber = request.getParameter("phoneNumber");
		if (phoneNumber == null) {
			out.print("发送异常，请重试");
			out.flush();
			out.close();
			return;
		}
		String code = SendMessageCode.sendSm(phoneNumber.trim());
		// 保存验证码到会话对象
		this.getSession().setAttribute("code", code);
		out.print(code);
		out.flush();
		out.close();
	}

	/**
	 * 生成用户对象
	 * 
	 * @param req
	 * @return
	 */
	private UserInfo wrap(HttpServletRequest req) {
		UserInfo user = new UserInfo();
		String uidStr = req.getParameter("userId");
		String upn = req.getParameter("userPhoneNumber");
		String name = req.getParameter("userName");
		String pwd = req.getParameter("userPassword");
		String rname = req.getParameter("userRealName");
		String sex = req.getParameter("userSex");
		String idcard = req.getParameter("userIdCard");
		String weibo = req.getParameter("userWeiboId");
		String qq = req.getParameter("userQQId");
		String icon = req.getParameter("userIcon");
		String alipay = req.getParameter("userAliPay");
		String bank = req.getParameter("userBankCard");
		String remark = req.getParameter("userReamrk");

		user.setUserId(uidStr);
		user.setUserPhoneNumber(upn);
		user.setUserName(name);
		user.setUserPassword(pwd);
		user.setUserRealName(rname);
		user.setUserSex(sex);
		user.setUserIdCard(idcard);
		user.setUserWeiboId(weibo);
		user.setUserQQId(qq);
		user.setUserIcon(icon);
		user.setUserAliPay(alipay);
		user.setUserBankCard(bank);
		user.setUserRemark(remark);
		System.out.println(user);
		return user;
	}

	/**
	 * 生成weibo用户对象
	 * 
	 * @param req
	 * @return
	 */
	private UserWeiboInfo wrapWeiBoInfo(HttpServletRequest req) {
		UserWeiboInfo weiboInfo = new UserWeiboInfo();
		String code = req.getParameter("code");
		System.out.println(code);
		weibo4j.Oauth oauth = new weibo4j.Oauth();
		String access_token = null;// "2.00L7zyaF0h7ji6bfe72a83c71uVtUE";
		Account am = null;
		String uid = null;
		try {
			access_token = oauth.getAccessTokenByCode(code).getAccessToken();
			am = new Account(access_token);
			uid = am.getUid().getString("uid");
			Users um = new Users(access_token);
			User user = um.showUserById(uid);
			weiboInfo.setUserWeiboId(uid);
			weiboInfo.setUserWeiboIcon(user.getProfileImageUrl());
			weiboInfo.setUserWeiboName(user.getScreenName());
			weiboInfo.setUserWeiboRemark(user.getDescription());
			String sex = user.getGender();
			if (sex.equals("m")) {
				sex = "男";
			} else if (sex.equals("f")) {
				sex = "女";
			} else {
				sex = "n";// 未知
			}
			req.setAttribute("sex", sex);
			Log.logInfo(user.toString());
		} catch (WeiboException e1) {
			e1.printStackTrace();
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		System.out.println(weiboInfo);
		return weiboInfo;
	}
    
	
	/**
	 * 转发直播间
	 * @throws SQLException 
	 */
	protected void toLiveHome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		//获得房间号
        String liveRoomId=request.getParameter("liveRoomId");
   
        //通过房间号获得一系列信息,并封装到LiveHomeMessages类中
        LiveHomeMessages liveHomeMessages= getLiveHomeMessages(liveRoomId);
        
        //转发
        request.setAttribute("liveHost", liveHomeMessages);
        request.getRequestDispatcher("ShowRoom.jsp").forward(request, response);
	}
	
	
	/**
	 * 获得直播间相关的所有信息
	 * @throws SQLException 
	 */
	private LiveHomeMessages getLiveHomeMessages(String liveRoomId) throws SQLException{
		LiveHomeMessages liveHomeMessages=new LiveHomeMessages();
		liveHomeMessages.setLiveRoomId(liveRoomId);
		//通过直播间liveRoomId查询所有直播间信息
		LiveRoomDao liveRoomDao=LiveRoomDao.getInstance();
		LiveRoom liveRoom=new LiveRoom();
		liveRoom.setLiveRoomId(liveRoomId);
	    liveRoom=liveRoomDao.querySingle(liveRoom);
	    //赋值到liveHomeMessages类中
		liveHomeMessages.setLiveRoomTilie(liveRoom.getLiveRoomTilie());  //直播间标题
		liveHomeMessages.setLiveRoomAnnouncement(liveRoom.getLiveRoomAnnouncement()); //直播间公告
		liveHomeMessages.setLivePushCode(liveRoom.getLivePushCode());    //直播推流码
		
		
		//主播id查到用户编号,主播信息备注（即官方认证）
		AnchorInfoDao anchorInfoDao=AnchorInfoDao.getInstance();
		AnchorInfo anchorInfo=new AnchorInfo();
		anchorInfo.setAnchorId(liveRoom.getAnchorId());
		anchorInfo=anchorInfoDao.querySingle(anchorInfo);
		liveHomeMessages.setAnchorInfoRemark(anchorInfo.getAnchorInfoRemark());  //主播备注(即官方认证)
		
		//通过用户编号查找主播这个用户的名字，头像
		UserDao userDao=UserDao.getInstance();
		UserInfo userInfo=new UserInfo(anchorInfo.getUserId());
		userInfo=userDao.querySingle(userInfo);
		liveHomeMessages.setUserName(userInfo.getUserName());            //主播名字
		liveHomeMessages.setUserIcon(userInfo.getUserIcon());            //主播头像
		
		//通过直播间的内容编号查找直播具体内容（同时查到板块id）
		LiveContentDao liveContentDao=LiveContentDao.getInstance();
		LiveContent liveContent=new LiveContent();
		liveContent.setLiveContentId(liveRoom.getLiveContentId());
		liveContent=liveContentDao.querySingle(liveContent);
		liveHomeMessages.setLiveContextName(liveContent.getLiveContentName()); //直播具体类容
		
		//通过板id查到板块具体内容
		LiveTypeDao liveTypeDao=LiveTypeDao.getInstance();
		LiveType liveType=new LiveType();
		liveType.setLiveTypeId(liveContent.getLiveTypeId());
		liveType=liveTypeDao.querySingle(liveType);
		liveHomeMessages.setLiveTypeName(liveType.getLiveTypeName());    //直播板块名
		
		//通过主播编号查找所有用户，得到关注数
		UserBookDao userBookDao=UserBookDao.getInstance();
		UserBook userBook=new UserBook();
		userBook.setAnchorId(liveRoom.getAnchorId());
		List<UserBook> userBooks=null;
		userBooks=userBookDao.queryAll(userBook);
		int num=0; //设置计数器
		for (int i = 0; i < userBooks.size(); i++) {
			if(userBooks.get(i).getAnchorId().equals(liveRoom.getAnchorId())){
				num++;
			}
		}
		liveHomeMessages.setAnchorBookedNumber(num+"");      //主播关注数
		
		//通过主播id查询所有直播记录
		LiveRecordDao liveRecordDao=LiveRecordDao.getInstance();
        LiveRecord liveRecord=new LiveRecord();
        List<LiveRecord> liveRecords=null;
        liveRecords=liveRecordDao.queryAll(liveRecord);
        int allLivetime=0;  //设置总时间
        for (int i = 0; i < liveRecords.size(); i++) {
			if(liveRecords.get(i).getUserId().equals(userInfo.getUserId())){
				//得到开始事件与结束事件
				Date onTime=liveRecords.get(i).getOnLiveTime();
				Date offTime=liveRecords.get(i).getOffLiveTime();
				//得到时间差
				allLivetime+=(offTime.getHours()-onTime.getHours());
			}
		}
        liveHomeMessages.setAnchorLevelId(allLivetime+"");   //主播等级（一小时一级）

		System.out.println(liveHomeMessages);
		
		return liveHomeMessages;
	}
	
	/**
	 * 弹幕发送
	 */
	protected void sendDanmu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("loginUserName");
		name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
		String context = request.getParameter("context");
		context = new String(context.getBytes("ISO-8859-1"), "UTF-8");
		String roomId = request.getParameter("roomId");
		roomId = new String(roomId.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("进来了");
		System.out.println(roomId);
		System.out.println(name);
		System.out.println(context);
		// 封装到对象中
		BarrageInfo barrageInfo = new BarrageInfo();
		barrageInfo.setUserId(name);
		barrageInfo.setBarrageContent(context);
		barrageInfo.setBarrageId(roomId);
		barrageInfo.setVideoId(gettime());// 放时间
		// 保存到集合中
		this.barrageInfos = addList(barrageInfo);
	}

	/**
	 * ajax轮询
	 */
	protected void toajax(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		// 将对象转为json
		StringBuffer strBuffer = new StringBuffer("{\"barrageInfo\":[");
		for (BarrageInfo barrageInfo : barrageInfos) {

			strBuffer.append("{");
			strBuffer.append("\"barrageId\":").append("\"" + barrageInfo.getBarrageId() + "\"").append(",");
			strBuffer.append("\"userId\":").append("\"" + barrageInfo.getUserId() + "\"").append(",");
			strBuffer.append("\"barrageContent\":").append("\"" + barrageInfo.getBarrageContent() + "\"").append(",");
			strBuffer.append("\"time\":").append("\"" + barrageInfo.getVideoId() + "\"");
			strBuffer.append("}");
			strBuffer.append(",");
		}
		strBuffer.deleteCharAt(strBuffer.length() - 1);
		strBuffer.append("]}");

		out.print(strBuffer.toString());
		out.close();
	}

	// 获得当前时间
	private String gettime() {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		String time = format.format(date);
		return time;
	}

	// 加入集合
	private List<BarrageInfo> addList(BarrageInfo barrageInfo) {
		// 限制集合大小十
		if (barrageInfos.size() < 20) {
			this.barrageInfos.add(barrageInfo);
		} else {
			this.barrageInfos.remove(0);
			this.barrageInfos.add(barrageInfo);
		}
		return barrageInfos;
	}
	
	//转入主播中心
	protected void toAnchorCenter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		UserInfo userInfo=(UserInfo) this.getSession().getAttribute("loginUser");
		//通过用户id查主播信息表中的直播间编号
		AnchorInfoDao anchorInfoDao=AnchorInfoDao.getInstance();
		AnchorInfo anchorInfo=new AnchorInfo();
		anchorInfo.setUserId(userInfo.getUserId());
		anchorInfo=anchorInfoDao.querySingleByUserId(anchorInfo);
		//如果不是主播
        if(anchorInfo==null){
        	request.getRequestDispatcher("anchor-authentication.jsp").forward(request, response);
        }else{
        	//通过直播间编号，查找直播间信息表的直播间编号，直播推流地址，直播推流码，直播间公告
        	LiveRoomDao liveRoomDao=LiveRoomDao.getInstance();
    		LiveRoom liveRoom=new LiveRoom();
    		liveRoom.setLiveRoomId(anchorInfo.getLiveRoomId());
    		liveRoom=liveRoomDao.querySingle(liveRoom);
    		System.out.println(liveRoom);
    		//转发消息
    		request.setAttribute("myLiveRoom", liveRoom);
        	request.getRequestDispatcher("anchorSet.jsp").forward(request, response);
        }
	}
	
	//转入主播中心
		protected void fromAnchorAuthenticationToAnchorCenter(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException, SQLException {
			UserInfo userInfo=(UserInfo) this.getSession().getAttribute("loginUser");
			//通过用户id查主播信息表中的直播间编号
			AnchorInfoDao anchorInfoDao=AnchorInfoDao.getInstance();
			AnchorInfo anchorInfo=new AnchorInfo();
			anchorInfo.setUserId(userInfo.getUserId());
			anchorInfo=anchorInfoDao.querySingleByUserId(anchorInfo);
			//如果不是主播
	        if(anchorInfo==null){
	        	
	        	//通过直播间编号，查找直播间信息表的直播间编号，直播推流地址，直播推流码，直播间公告
	        	LiveRoomDao liveRoomDao=LiveRoomDao.getInstance();
	    		LiveRoom liveRoom=new LiveRoom();
	    		liveRoom.setLiveRoomId(anchorInfo.getLiveRoomId());
	    		liveRoom=liveRoomDao.querySingle(liveRoom);
	    		System.out.println(liveRoom);
	    		//转发消息
	    		request.setAttribute("myLiveRoom", liveRoom);
	        	request.getRequestDispatcher("anchorSet.jsp").forward(request, response);
	        }
		}
		
	//修该公告
	protected void changGonggao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String gonggao=request.getParameter("gongGao");
		gonggao = new String(gonggao.getBytes("ISO-8859-1"), "UTF-8");
		String roomId=request.getParameter("roomId");
		LiveRoomDao liveRoomDao=LiveRoomDao.getInstance();
		LiveRoom liveRoom=new LiveRoom();
		liveRoom.setLiveRoomId(roomId);
		//查找房间
		liveRoom=liveRoomDao.querySingle(liveRoom);
		//更新公告
		liveRoom.setLiveRoomAnnouncement(gonggao);
		//更新信息
		liveRoomDao.update(liveRoom);
	}
	
	//修改标题
	protected void changTitle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String title=request.getParameter("roomTitle");
		title = new String(title.getBytes("ISO-8859-1"), "UTF-8");
		String roomId=request.getParameter("roomId");
		LiveRoomDao liveRoomDao=LiveRoomDao.getInstance();
		LiveRoom liveRoom=new LiveRoom();
		liveRoom.setLiveRoomId(roomId);
		//查找房间
		liveRoom=liveRoomDao.querySingle(liveRoom);
		//更新标题
		liveRoom.setLiveRoomTilie(title);
		//更新信息
		liveRoomDao.update(liveRoom);
	}
	
	//关注
	protected void toBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		System.out.println(request.getParameter("roomId"));
	}

}
