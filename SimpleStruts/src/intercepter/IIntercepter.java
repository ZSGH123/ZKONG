package intercepter;

import java.lang.reflect.Method;

import proxy.ActionInvocation;

/**
 * �������ӿ�
 * @author ��ǿ
 *
 */
public interface IIntercepter {
 void init();
 void destory();
 void intercepter(ActionInvocation actionInvocation, Object proxy, Method method, Object[] args);
}
