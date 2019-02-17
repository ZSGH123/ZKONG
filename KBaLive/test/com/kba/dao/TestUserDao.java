package com.kba.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.kba.dao.impl.LiveRoomDao;
import com.kba.dao.impl.UserDao;
import com.kba.dao.impl.UserlikeDao;
import com.kba.entity.LiveRoom;
import com.kba.entity.UserInfo;
import com.kba.vo.UserLike;

public class TestUserDao {

	@Test
	public void testQuerySingle(){
		IUserDao userDao=UserDao.getInstance();
		UserInfo user=new UserInfo();
		user.setUserPhoneNumber("18873269672");
		try {
			user=userDao.querySingle(user);
			System.out.println(userDao.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	@Test
	public void test(){
		IUserlikeDao userlikeDao=UserlikeDao.getInstance();
		UserLike userLike=new UserLike();
		userLike.setUserId("1000000003");
		try {
			List<UserLike> uu=userlikeDao.queryAll(userLike);
			System.out.println(uu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testName() throws Exception {
		LiveRoomDao liveRoomDao=LiveRoomDao.getInstance();
		LiveRoom liveRoom=new LiveRoom();
		liveRoom.setLiveRoomId("70002");
		liveRoom=liveRoomDao.querySingle(liveRoom);
		System.out.println(liveRoom);
		liveRoom.setLiveRoomTilie("吃鸡恶霸蓝战非！");
		liveRoomDao.update(liveRoom);
	
		
	}
	
}
