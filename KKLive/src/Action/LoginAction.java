package Action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.User;

public class LoginAction extends ActionSupport implements ModelDriven<User>,RequestAware{

	private static final long serialVersionUID = 1L;
	
	private  Map<String, Object> rMap;
	/**
	 * 数据封装
	 * 1.属性驱动，
	 * 2.javaBean模型驱动，
	 * 3.模型驱动,实现ModelDriven接口，自动在model里搜素与请求里属性相对应的属性
	 */
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LoginAction(){
		this.user=new User();
	}
	
	@Action(value="userloginAction",results={@Result(name="success",location="/show.jsp")})
	public String login(){
		System.out.println("登陆"+user.getUname()+";"+user.getUpass());
		return "show";
	}
	
	public String register(){
		System.out.println("注册"+user.getUname()+";"+user.getUpass());
		return "register";
	}
	
	public String execute(){
		//1.解析请求包数据，自动请求
		
		//2.调用业务对象
		
		//3.1跳转：携带数据，请求作用域，会话作用域，应用陈述作用于
		ActionContext actionContext=ActionContext.getContext();//action上下文
		actionContext.put("ruser", this.user);
	    Map<String, Object> as=actionContext.getSession();
		as.put("suser", this.user);
	    actionContext.getApplication().put("auser", this.user);
	    //3.2	
        //HttpServletRequest request= ServletActionContext.getRequest();
        //ServletContext application=ServletActionContext.getServletContext();
	    //3.3实现requestAware，servletrequestAware等接口获取request，response，application，session
	    
	    
	    
		System.out.println(user.getUname()+";"+user.getUpass());
		return "success";
	}
    /**
     * 把对象压入valueStack顶
     */
	@Override
	public User getModel() {
		return this.user;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.rMap=arg0;
	}	
	
}
