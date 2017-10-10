package util;

import java.io.FileInputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil implements Serializable {
	private static String drivername;
	private static String host;
	private static String username;
	private static String password;
	// 线程绑定
	private static ThreadLocal<Connection> tl;
	// 连接池技术
	private static BasicDataSource dataSource;
	static {
		try {
			Properties prop= new Properties();
			// prop.load(new FileInputStream("config.properties"));
			prop.load(DBUtil.class.getClassLoader().getResourceAsStream("config.properties"));
			drivername = prop.getProperty("driver");
			host = prop.getProperty("host1");
			username = prop.getProperty("name");
			password = prop.getProperty("pass");
			// System.out.println(host);
			// System.out.println(drivername);
			dataSource = new BasicDataSource();
			// 连接池驱动
			dataSource.setDriverClassName(drivername);
			// 数据库地址和密码
			dataSource.setUrl(host);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
//			String initialSize = prop.getProperty("initialSize");
//			String minIdle = prop.getProperty("minIdle");
//			String maxIdle = prop.getProperty("maxIdle");
			String maxWait = prop.getProperty("maxWait");
			String maxActive = prop.getProperty("maxActive");
//			System.out.println(initialSize);
			// 初始化连接数
//			if (initialSize != null)
//				dataSource.setInitialSize(Integer.parseInt(initialSize));

			// 最小空闲连接
//			if (minIdle != null)
//				dataSource.setMinIdle(Integer.parseInt(minIdle));

			// 最大空闲连接
//			if (maxIdle != null)
//				dataSource.setMaxIdle(Integer.parseInt(maxIdle));

			// 超时回收时间(以毫秒为单位)
			if (maxWait != null)
				dataSource.setMaxWait(Long.parseLong(maxWait));

			// 最大连接数
			if (maxActive != null) { 
				if (!maxActive.trim().equals("0"))
					dataSource.setMaxActive(Integer.parseInt(maxActive));
			}
			tl = new ThreadLocal<Connection>();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 返回一个连接
	 * @return Connection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		/*
		if (dataSource == null) {
			init();
		}*/
		Connection conn = null;
		if (dataSource != null) {
			conn = dataSource.getConnection();
		}
		tl.set(conn);
		return conn;
	}
	/**
	 * 关闭链接
	 */
	public static void colseConnection(){
		try {
			Connection conn = tl.get();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		System.out.println(conn);
		colseConnection();
	}
	/**
	 * 关闭事务自动提交
	 * @throws SQLException
	 */
	public static void closeCommit() throws SQLException{
		Connection conn = tl.get();
		conn.setAutoCommit(false);
	}
	/**
	 * 开启事务提交
	 * @throws SQLException
	 */
	public static void startCommit() throws SQLException{
		Connection conn = tl.get();
		conn.setAutoCommit(true);
	}
	/**
	 * 提交事务
	 * @throws SQLException
	 */
	public static void commit() throws SQLException{
		Connection conn = tl.get();
		conn.commit();
	}
	/**
	 * 回滚事务
	 * @throws SQLException
	 */
	public static void rollback() throws SQLException{
		Connection conn = tl.get();
		conn.rollback();
	}
}
