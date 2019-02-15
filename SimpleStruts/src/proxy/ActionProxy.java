package proxy;

import java.lang.reflect.Proxy;

import Action.IAction;
import util.ActionMapping;

/**
 * ����
 * ��̬����action�������
 * @author ��ǿ
 *
 */
public class ActionProxy {
   /**
    * ���ݽ���������actionmapping����̬����action�������
    * @return
    */
	public IAction createActionProxy(ActionMapping map){
		
		//�������
		IAction actionProxy=null;
		//��ʵ��action����
		IAction realAction=null;
		
		try {
			String actionClassName=map.getActionClassName();
			Class actionClz=Class.forName(actionClassName);
			realAction=(IAction) actionClz.newInstance();
			//����ʵ����̬���ɴ������
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
