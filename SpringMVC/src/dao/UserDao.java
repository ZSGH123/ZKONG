package dao;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import domain.UserInfo;

public class UserDao extends SqlMapClientDaoSupport{


	//ʹ��sqlMapClient,�����̰߳�ȫ�����Կ��Զ���ɾ�̬��
	private static SqlMapClientTemplate sqlMaper=new SqlMapClientTemplate();
		
		

     public List<UserInfo> getAllUserInfo(){
    	 return null;
     }
     
     public UserInfo getUserInfoByUserId(String userid){
    	 return null;
     }
     public int addUser(UserInfo user){
 		return (int) sqlMaper.insert("addUsers",user);//��SqlMap������û���Ϣ������Ӧ
 		
 	}
  
 /**
  * ͨ��map��ʽ������û���Ϣ
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
