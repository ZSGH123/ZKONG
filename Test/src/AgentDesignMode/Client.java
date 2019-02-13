package AgentDesignMode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * 客户
 * @author 钟强
 *
 */
public class Client {

	public static void main(String[] strs) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//静态代理
//		List listAgent=new Proxy(new ArrayList());
//		listAgent.add("12233");
		//动态代理
		List list=new ArrayList();
		ClassLoader cLoader=List.class.getClassLoader();
	    Class<?> clz=Proxy.getProxyClass(cLoader,new Class[]{List.class});
	    List listAgent=(List) clz.getConstructor(new Class[]{InvocationHandler.class})//通过参数找到相应构造方法
		.newInstance(new Object[]{new ListHandler(list)});//通过相应构造方法实例对象
		listAgent.add("a");
		
	}
}
