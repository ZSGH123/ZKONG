package com.kba.util.weibo;

public class OauthTool {
	/**
	 * //https://api.weibo.com/oauth2/authorize?client_id="+clientId+
	 * "&response_type=code&redirect_uri="+redirectUri+"&forcelogin=true
	 * 根据类型获取授权url
	 * @param response_type
	 * @return
	 */
	public static String authorize(String response_type){
		return WeiboConfig.getValue("authorizeURL").trim() +
				"?client_id="+ WeiboConfig.getValue("client_ID").trim()+ 
				"&response_type=" + response_type
				+"&redirect_uri="+ WeiboConfig.getValue("redirect_URI").trim()
				+"&forcelogin=true";
	}
	
	public static void main(String[] str){
		System.out.print(OauthTool.authorize("code"));
		//https://api.weibo.com/oauth2/authorize?client_id=3820979028&response_type=code&redirect_uri=http://192.168.1.100:70/Shop/weibo.html&forcelogin=true
	}
}
