package dao;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import domain.UserInfo;

public class UserDao extends SqlMapClientDaoSupport{


	//使用sqlMapClient,此类线程安全，所以可以定义成静态的
	private static SqlMapClientTemplate sqlMaper=new SqlMapClientTemplate();
		
		

     public List<UserInfo> getAllUserInfo(){
    	 return null;
     }
     
     public UserInfo getUserInfoByUserId(String userid){
    	 return null;
     }
     public int addUser(UserInfo user){
 		return (int) sqlMaper.insert("addUsers",user);//与SqlMap中添加用户信息方法对应
 		
 	}
  
 /**
  * 通过map方式，添加用户信息
  * @param userMap
  * @throws SQLException
  */
    public int  addUserByMap(Map userMap) {
    	this.getSqlMapClientTemplate();
      return 0;
    }
    
    public int updateUserInfoByID(UserInfo userInfo){
    	sqlMaper.update("updateUserInfoByID", userInfo);
    	 return 0;
    }
    
    public int deleteById(Integer id ){
    	sqlMaper.delete("deleteById", id);
    	 return 0;
    }
    
     public int deleteByIds(List<Integer> id ){
    	 sqlMaper.delete("deleteByIds", id);
    	 return 0;
    }
    
}
