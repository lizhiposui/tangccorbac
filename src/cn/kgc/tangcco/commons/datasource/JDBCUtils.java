package cn.kgc.tangcco.commons.datasource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import cn.kgc.tangcco.commons.properties.util.PropertiesUtils;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class JDBCUtils {

	private static ThreadLocal<Connection> tl = new ThreadLocal<>();
	private static DataSource dataSource;

	static {
		Properties properties =PropertiesUtils.getInstance("").getPropertiesDruid();
		try {
			dataSource = DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			log.error("Druid数据库连接池初始化失败");
		}
	}
	/*
	 * static { Properties properties =
	 * PropertiesUtils.getInstance("db.properties").getProperties(); try {
	 * dataSource = new DruidDataSource(); String driver =
	 * properties.getProperty("driverClassName"); String url =
	 * properties.getProperty("url"); String username =
	 * properties.getProperty("username"); String password =
	 * properties.getProperty("password"); dataSource.setDriverClassName(driver);
	 * dataSource.setUrl(url); dataSource.setUsername(username);
	 * dataSource.setPassword(password);
	 * dataSource.setInitialSize(Integer.parseInt(properties.getProperty(
	 * "initialSize")));
	 * dataSource.setMaxActive(Integer.parseInt(properties.getProperty("maxActive"))
	 * );
	 * 
	 * 
	 * try { dataSource.setFilters("config,log4j"); } catch (SQLException e) {
	 * log.error("打印SQL语句初始化失败"); } } catch (Exception e) {
	 * log.error("Druid数据库连接池初始化失败"); } }
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}
	public static Connection getConnection() {
		Connection conn = tl.get();
		if(conn==null) {
			try {
				conn = dataSource.getConnection();
				tl.set(conn);
			} catch (SQLException e) {
				log.error("数据库连接对象初始化失败");
			}
		}
		return conn;
	}
	
	//开启事务
	public static void starTransaction() throws SQLException {
		Connection conn = getConnection();
		conn.setAutoCommit(false);
		conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
	}
	//提交事务
	public static void commit() throws SQLException {
		Connection  conn = getConnection();
		if (conn != null) {
			conn.commit();
		}
	}
	//回滚事务
	public static void rollBack() throws SQLException {
		Connection conn = getConnection();
		if (conn != null) {
			conn.rollback();
		}
	}
}
