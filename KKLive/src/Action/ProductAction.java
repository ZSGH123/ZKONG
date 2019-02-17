package Action;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.opensymphony.xwork2.ActionSupport;

import entity.User;

public class ProductAction extends ActionSupport {

	
	private static final long serialVersionUID = 1L;
     
	private String[] strings=new String[10];
	
	private List<String> lists;
	
	private Map<String, String> map;
	
	private User user;
	
	
	
	public String[] getStrings() {
		return strings;
	}

	public void setStrings(String[] strings) {
		this.strings = strings;
	}

	public List<String> getLists() {
		return lists;
	}

	public void setLists(List<String> lists) {
		this.lists = lists;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String index(){
		System.out.println("index");
		return "success";
	}
	
	public String test(){
		System.out.println("test");
		System.out.println("----------strings---------");
		for (String string : strings) {
			System.out.println(string);
		}
		System.out.println("----------lists---------");
		for (String string : lists) {
			System.out.println(string);
		}
		System.out.println("----------map---------");
		for (Entry<String, String> string : map.entrySet()) {
			System.out.println(string);
		}
		return "success";
	}
	
}
