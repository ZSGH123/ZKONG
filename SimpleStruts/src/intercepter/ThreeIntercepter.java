package intercepter;

import java.lang.reflect.Method;

import proxy.ActionInvocation;

public class ThreeIntercepter implements IIntercepter {

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void destory() {
		// TODO Auto-generated method stub

	}

	@Override
	public void intercepter(ActionInvocation actionInvocation, Object proxy, Method method, Object[] args) {
		try {
			System.out.println("������������ǰ");
			actionInvocation.invoke(proxy, method, args);
			System.out.println("��������������");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
