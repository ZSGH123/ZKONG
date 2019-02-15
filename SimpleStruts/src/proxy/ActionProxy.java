package proxy;

import java.lang.reflect.Proxy;

import Action.IAction;
import util.ActionMapping;

/**
 * 工厂
 * 动态生成action代理对象
 * @author 钟强
 *
 */
public class ActionProxy {
   /**
    * 根据解析出来的actionmapping对象动态生成action代理对象
    * @return
    */
	public IAction createActionProxy(ActionMapping map){
		
		//代理对象
		IAction actionProxy=null;
		//真实的action对象
		IAction realAction=null;
		
		try {
			String actionClassName=map.getActionClassName();
			Class actionClz=Class.forName(actionClassName);
			realAction=(IAction) actionClz.newInstance();
			//由真实对象动态生成代理对象
			actionProxy= (IAction) Proxy.newProxyInstance(actionClz.getClassLoader(), new Class[]{IAction.class},new ActionInvocation(realAction));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actionProxy;	
	}
	
}
