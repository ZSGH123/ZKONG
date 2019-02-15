package intercepter;

import java.lang.reflect.Method;

import proxy.ActionInvocation;

/**
 * À¹½ØÆ÷½Ó¿Ú
 * @author ÖÓÇ¿
 *
 */
public interface IIntercepter {
 void init();
 void destory();
 void intercepter(ActionInvocation actionInvocation, Object proxy, Method method, Object[] args);
}
