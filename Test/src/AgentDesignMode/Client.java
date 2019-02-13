package AgentDesignMode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * �ͻ�
 * @author ��ǿ
 *
 */
public class Client {

	public static void main(String[] strs) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//��̬����
//		List listAgent=new Proxy(new ArrayList());
//		listAgent.add("12233");
		//��̬����
		List list=new ArrayList();
		ClassLoader cLoader=List.class.getClassLoader();
	    Class<?> clz=Proxy.getProxyClass(cLoader,new Class[]{List.class});
	    List listAgent=(List) clz.getConstructor(new Class[]{InvocationHandler.class})//ͨ�������ҵ���Ӧ���췽��
		.newInstance(new Object[]{new ListHandler(list)});//ͨ����Ӧ���췽��ʵ������
		listAgent.add("a");
		
	}
}
