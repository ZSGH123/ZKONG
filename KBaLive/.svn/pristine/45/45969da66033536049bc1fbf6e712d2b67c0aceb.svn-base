package com.kba.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.kba.dao.IPurchaseHistory;
import com.kba.dao.util.ISqlCommand;
import com.kba.dao.util.NameSpace;
import com.kba.dao.util.ResultSetHandler;
import com.kba.vo.PurchaseHistory;

/**
 * 用户消费历史
 * @author 墨迹
 *
 */
public class PurchaseHistoryDao extends AbstractBaseDao implements IPurchaseHistory,ResultSetHandler<List<PurchaseHistory>>{

	private static PurchaseHistoryDao purchaseHistoryDao;
	
	private PurchaseHistoryDao(){
		
	}
	
	public synchronized static PurchaseHistoryDao getInstance(){
		if(purchaseHistoryDao==null){
			purchaseHistoryDao=new PurchaseHistoryDao();
		}
		return purchaseHistoryDao;
	}
	

	/**
	 * 查询某个用户的所有关注
	 */
	@Override
	public List<PurchaseHistory> queryAll(PurchaseHistory entity) throws SQLException {
		List<PurchaseHistory> purchaseHistorys=null;
		String sql=this.parseSqlStatement.getSql(NameSpace.PURCHASEHISTORY, ISqlCommand.SELECT_ALL);
		Object[] args = new Object[] { entity.getUser_id()};
		try {
			purchaseHistorys=this.queryRunner.query(sql, this,args);
		} catch (SQLException e) {
			throw e;
		}catch (Exception e) {
			logger.info("查询异常");
		}
		return purchaseHistorys;
	}
	


	@Override
	public List<PurchaseHistory> handle(ResultSet rs) throws SQLException {
		List<PurchaseHistory> purchaseHistorys = new Vector<PurchaseHistory>();
		PurchaseHistory purchaseHistory = null;
		if (rs == null) {
			throw new SQLException("结果集中没有数据");
		}
		while (rs.next()) {
			purchaseHistory = new PurchaseHistory();
			// xml
			purchaseHistory.setUser_id(rs.getString("user_id"));
			purchaseHistory.setUser_name(rs.getString("user_name"));
			purchaseHistory.setGift_name(rs.getString("gift_name"));
			purchaseHistory.setGift_number(rs.getInt("gift_number"));
			purchaseHistory.setGift_price(rs.getDouble("gift_price"));
			purchaseHistory.setGift_time(rs.getString("gift_time"));
			purchaseHistory.setK_type_id(rs.getString("k_type_id"));
			purchaseHistory.setK_type_name(rs.getString("k_type_name"));
			purchaseHistorys.add(purchaseHistory);
		}
		return purchaseHistorys;
	}

	@Override
	public PurchaseHistory querySingle(PurchaseHistory entity) throws SQLException {
	
		return null;
	}

	@Override
	public int insert(PurchaseHistory entity) throws SQLException {

		return 0;
	}

	@Override
	public int update(PurchaseHistory entity) throws SQLException {

		return 0;
	}

	@Override
	public int delete(PurchaseHistory entity) throws SQLException {

		return 0;
	}

	

	

}
