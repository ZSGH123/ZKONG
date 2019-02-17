package com.kda.dao.util;

import java.sql.SQLException;
import java.util.List;

import javax.mail.internet.NewsAddress;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.kba.dao.impl.BackStageManagerInfoDao;
import com.kba.dao.impl.LiveRoomDetatilDao;
import com.kba.dao.impl.UserDao;
import com.kba.dao.util.DataSourceFactory;
import com.kba.entity.BackStageManagerInfo;
import com.kba.entity.LiveType;
import com.kba.entity.UserInfo;
import com.kba.entity.UserWeiboInfo;
import com.kba.service.impl.IndexService;
import com.kba.service.impl.UserService;
import com.kba.util.KBaException;
import com.kba.vo.LiveRoomDetailInfo;
import com.lu.jsn.JRandomNameTool;

public class TestDataSourceFactory {

	@Test
	public void testDataSourceFactory() {
		// try {
		// System.out.println(DataSourceFactory.getDataSource().getConnection());
		// List<BackStageManagerInfo>
		// users=BackStageManagerInfoDao.getInstance().queryAll(null);
		// //UserDao.getInstance().delete(users.get(0));
		// BackStageManagerInfoDao.getInstance().delete(users.get(0));
		// for (BackStageManagerInfo userInfo : users) {
		// System.out.println( userInfo);
		//
		// }
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println(DataSourceFactory.getDsByTomcat());

//		 UserWeiboInfo weiboInfo=new UserWeiboInfo();
//		 weiboInfo.setUserWeiboId("1000000008");
//		 weiboInfo.setUserWeiboIcon("http://wx4.sinaimg.cn/thumbnail/005AYZqbgy1fyursx2zohj3046046746.jpg");
//		 weiboInfo.setUserWeiboName("王道五");
//		 weiboInfo.setUserWeiboRemark("fsdgsgsfgs");
//		 try {
//		 new UserService().weiBoLogin(weiboInfo, "男");
//		
//		 } catch (KBaException e) {
//		 // TODO Auto-generated catch block
//		 e.printStackTrace();
//		 }
//		try {
//			for (int i = 0; i < 50; i++) {
//				System.out.println(new UserService().generateUserName()+"[i="+i);
//			}
//		} catch (KBaException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		LiveType liveType=new LiveType();
		liveType.setLiveTypeId("1");
		List<LiveRoomDetailInfo> liveRoomDetailInfos;
		try {
			liveRoomDetailInfos = new IndexService().selectAllByLiveTypeID(liveType);
			String json=JSONArray.toJSONString(liveRoomDetailInfos);
			json="{\"liveRoomDetailInfos\":"+json+"}";
			System.out.println(json);
			
		} catch (KBaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
