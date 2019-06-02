package cn.kgc.tangcco.test.conn;

import java.sql.Connection;

import org.junit.Test;

import cn.kgc.tangcco.commons.datasource.JDBCUtils;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class TestConn {

	private Connection conn;
	
	@Test
	public void testConn() {
		conn = JDBCUtils.getConnection();
		log.info("===>"+conn);
	}
}
