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
	 * ���ݷ�װ
	 * 1.����������
	 * 2.javaBeanģ��������
	 * 3.ģ������,ʵ��ModelDriven�ӿڣ��Զ���model���������������������Ӧ������
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
		System.out.println("��½"+user.getUname()+";"+user.getUpass());
		return "show";
	}
	
	public String register(){
		System.out.println("ע��"+user.getUname()+";"+user.getUpass());
		return "register";
	}
	
	public String execute(){
		//1.������������ݣ��Զ�����
		
		//2.����ҵ�����
		
		//3.1��ת��Я�����ݣ����������򣬻Ự������Ӧ�ó���������
		ActionContext actionContext=ActionContext.getContext();//action������
		actionContext.put("ruser", this.user);
	    Map<String, Object> as=actionContext.getSession();
		as.put("suser", this.user);
	    actionContext.getApplication().put("auser", this.user);
	    //3.2	
        //HttpServletRequest request= ServletActionContext.getRequest();
        //ServletContext application=ServletActionContext.getServletContext();
	    //3.3ʵ��requestAware��servletrequestAware�Ƚӿڻ�ȡrequest��response��application��session
	    
	    
	    
		System.out.println(user.getUname()+";"+user.getUpass());
		return "success";
	}
    /**
     * �Ѷ���ѹ��valueStack��
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
