package com.kda.dao.util;

import java.sql.SQLException;

import org.junit.Test;

import com.kba.dao.util.DbConnector;

public class TestDataSource {
	
	@Test
	public void testDataSource() throws SQLException{
		DbConnector d = new DbConnector();
		d.getConnection();
	}

}
