package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import Action.IAction;
import intercepter.FirsterIntercepter;
import intercepter.IIntercepter;
import intercepter.SecondIntercepter;
import intercepter.ThreeIntercepter;
/**
 * 责任链设计模式
 * 处理调用代理action中的方法的回调
 * @author 钟强
 *
 */
public class ActionInvocation implements InvocationHandler {
	/**
	 * 存储所有解析所得所有拦截器
	 */
    private List<IIntercepter> list;
	
	private IAction action;
	
	private int index=0;
	
	private ActionInvocation(){
		list=new ArrayList<IIntercepter>();
		list.add(new FirsterIntercepter());
		list.add(new SecondIntercepter());
		list.add(new ThreeIntercepter());
	}
	
	/**
	 * 用于动态生成代理对象时使用
	 * @param action
	 */
	public ActionInvocation(IAction action){
		this();
		this.action=action;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result=null;
		int index=this.index++;
		if(index<list.size()){
			this.list.get(index).intercepter(this,proxy,method,args);
		}else {
			result=method.invoke(action, args);
		}
		return result;
	}

}
