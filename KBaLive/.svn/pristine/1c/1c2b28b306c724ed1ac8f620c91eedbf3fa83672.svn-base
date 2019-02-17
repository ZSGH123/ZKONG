package com.kba.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kba.entity.UserInfo;
import com.kba.entity.UserQQInfo;
import com.kba.service.IUserService;
import com.kba.service.impl.UserService;
import com.kba.util.KBaException;
import com.kba.util.Log;
import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.oauth.Oauth;

/**
 * qq登陆servlet
 * 
 * @author 钟强 创建时间：2019-01-18 修改时间：
 */
public class QQLoginServlet extends KBaBaseServlet {

	private static final long serialVersionUID = 1L;
	// 业务对象
	private IUserService userService;

	public QQLoginServlet() {
		this.userService = new UserService();
	}

	@Override
	protected void index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operateCode = (String) getSession().getAttribute("operatecode");
		if (operateCode == null) {
			return;
		}
		if (operateCode.equals("qqlogin")) {// QQ登陆
			afterLogin(request, response);
		}

	}

	@Override
	protected void service_(String command, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * qq登陆回调
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void afterLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserQQInfo qqInfo = null;
		UserInfo user = null;
		try {
			qqInfo = wrapQQInfo(request);
			String sex = (String) request.getAttribute("sex");
			 user = userService.qqLogin(qqInfo, sex);
			 if (user != null) {
				getSession().setAttribute("loginUser", user);
				getSession().setAttribute("loginIp", request.getRemoteAddr());//保存登陆ip
				response.sendRedirect("indexAction.do");
			 Log.logInfo("账户:" + user.getUserId() + " 绑定qq" +
			 qqInfo.getUserQQName()+ "成功");
			 }
		}
		 catch (KBaException e) {
		 this.toError(e, response);
		 }
		catch (QQConnectException e) {
			this.toError(e, response);
		}

	}

	/**
	 * 生成qq用户对象
	 * 
	 * @param req
	 * @return
	 * @throws QQConnectException
	 */
	private UserQQInfo wrapQQInfo(HttpServletRequest request) throws QQConnectException {
		UserQQInfo qqInfo = new UserQQInfo();
		try {
			AccessToken accessTokenObj = (new Oauth()).getAccessTokenByRequest(request);
			String accessToken = null, openID = null;
			long tokenExpireIn = 0L;
			if (accessTokenObj.getAccessToken().equals("")) {
				System.out.print("没有获取到响应参数");
			} else {
				accessToken = accessTokenObj.getAccessToken();
				tokenExpireIn = accessTokenObj.getExpireIn();
				getSession().setAttribute("demo_access_token", accessToken);
				getSession().setAttribute("demo_token_expirein", String.valueOf(tokenExpireIn));
				// 利用获取到的accessToken 去获取当前用的openid -------- start
				OpenID openIDObj = new OpenID(accessToken);
				openID = openIDObj.getUserOpenID();

				System.out.println("欢迎你，代号为 " + openID + " 的用户!");
				getSession().setAttribute("demo_openid", openID);
				// 利用获取到的accessToken 去获取当前用户的openid --------- end
				com.qq.connect.api.qzone.UserInfo qzoneUserInfo = new com.qq.connect.api.qzone.UserInfo(accessToken,
						openID);
				qqInfo.setUserQQId(openID);
				UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
				if (userInfoBean.getRet() == 0) {
					qqInfo.setUserQQName(userInfoBean.getNickname());
					request.setAttribute("sex", userInfoBean.getGender());
					qqInfo.setUserQQIcon(userInfoBean.getAvatar().getAvatarURL30());
				} else {
					System.out.println("很抱歉，我们没能正确获取到您的信息，原因是： " + userInfoBean.getMsg());
				}
			}
		} catch (QQConnectException e) {
			e.printStackTrace();
			throw e;
		}
		System.out.println(qqInfo);
		return qqInfo;
	}

}
