package Action;

import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport {

	
	private static final long serialVersionUID = 1L;

	public String index(){
		System.out.println("index");
		return "success";
	}
	
}
