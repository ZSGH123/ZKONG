package entity;

import java.lang.reflect.Field;
import java.text.MessageFormat;

import annotation.entity;
import annotation.field;

@entity(tableName="kk_user")
public class User {
	@field(fieldname="userName")
    private String uname;
	@field(fieldname="userPassword")
    private String upass;
  
	public User() {
		super();
	}
	
	public User(String uname, String upass) {
		super();
		this.uname = uname;
		this.upass = upass;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
    /**
     * 通过反射和注解动态生成sql
     * @param strs
     */
	public static void main(String[] strs){
		User user=new User();
		Class clz= user.getClass();
		StringBuffer sql=new StringBuffer("select {0} from {1}");
		entity table=(entity)clz.getAnnotation(entity.class);
		String tableName=table!=null?table.tableName():clz.getName();
		StringBuffer filedNames=new StringBuffer();
		Field[] fields=clz.getDeclaredFields();
		for (Field f : fields) {
			field fieldnamea=f.getAnnotation(field.class);
			String fieldname=fieldnamea!=null?fieldnamea.fieldname():f.getName();
			filedNames.append(fieldname).append(",");
		}
		filedNames.deleteCharAt(filedNames.length()-1);
		System.out.println(MessageFormat.format(sql.toString(), new Object[]{filedNames,tableName}));
		 
		
	}
    
}
