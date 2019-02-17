package com.kba.dao.util;

public interface ISqlCommand {
	String INSERT = "insert";
	String UPDATE = "update";
	String DELETE = "delete";
	String SELECT_ALL = "selectAll";
	String SELECT_SINGLE = "selectSingle";
	String SELECT_BY_ID = "selectById";
	String SELECT_BY_NAME = "selectByName";
	String SELECT_BY_PHONENUMBER="selectByPhoneNumber";
	String SELECT_BY_USERID="selectByUserId";
	String SELECT_LIVEROOMDETAIL_BY_VIEW="selectAllByView";
	String SELECT_BY_ANCHOR_ID="selectByAnchorId";
}