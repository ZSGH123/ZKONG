package interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class TestInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object user;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		ActionContext actionContext=ActionContext.getContext();//action上下文
		
		System.out.println("拦截器测试,访问值栈里的action对象中的属性"+actionContext.getValueStack().findValue("uname"));
		arg0.invoke();
		return null;
	}

}
