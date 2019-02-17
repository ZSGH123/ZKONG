package com.kba.action.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
/**
 * 装饰原生的request(解决get请求后面带参数，解析参数值时的乱码问题)
 * @author 钟强
 * 创建时间：2019-01-13
 * 修改时间：
 */
public class DecorateRequest extends HttpServletRequestWrapper{

     private String encode;
	
	public DecorateRequest(HttpServletRequest request) {
		super(request);
	}
	
	public DecorateRequest(HttpServletRequest request,String encode) {
		this(request);
		this.encode=encode;
	}
    /**
     * 重写getParameter
     */
	@Override
	public String getParameter(String name) {
		String data=super.getParameter(name);
		if(data!=null){
			try {
				byte[] bs=data.getBytes("ISO-8859-1");
				new String(bs,this.encode);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
 		}
		return data;
	}

}
