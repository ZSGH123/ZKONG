package AgentDesignMode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

public class ListHandler implements InvocationHandler {

	private List list;

	public ListHandler(List list){
		this.list=list;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(new Date());
		Object result=method.invoke(list, args);
		return result;
	}

}
