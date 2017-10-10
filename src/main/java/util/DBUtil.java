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
	// �̰߳�
	private static ThreadLocal<Connection> tl;
	// ���ӳؼ���
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
			// ���ӳ�����
			dataSource.setDriverClassName(drivername);
			// ���ݿ��ַ������
			dataSource.setUrl(host);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
//			String initialSize = prop.getProperty("initialSize");
//			String minIdle = prop.getProperty("minIdle");
//			String maxIdle = prop.getProperty("maxIdle");
			String maxWait = prop.getProperty("maxWait");
			String maxActive = prop.getProperty("maxActive");
//			System.out.println(initialSize);
			// ��ʼ��������
//			if (initialSize != null)
//				dataSource.setInitialSize(Integer.parseInt(initialSize));

			// ��С��������
//			if (minIdle != null)
//				dataSource.setMinIdle(Integer.parseInt(minIdle));

			// ����������
//			if (maxIdle != null)
//				dataSource.setMaxIdle(Integer.parseInt(maxIdle));

			// ��ʱ����ʱ��(�Ժ���Ϊ��λ)
			if (maxWait != null)
				dataSource.setMaxWait(Long.parseLong(maxWait));

			// ���������
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
	 * ����һ������
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
	 * �ر�����
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
	 * �ر������Զ��ύ
	 * @throws SQLException
	 */
	public static void closeCommit() throws SQLException{
		Connection conn = tl.get();
		conn.setAutoCommit(false);
	}
	/**
	 * ���������ύ
	 * @throws SQLException
	 */
	public static void startCommit() throws SQLException{
		Connection conn = tl.get();
		conn.setAutoCommit(true);
	}
	/**
	 * �ύ����
	 * @throws SQLException
	 */
	public static void commit() throws SQLException{
		Connection conn = tl.get();
		conn.commit();
	}
	/**
	 * �ع�����
	 * @throws SQLException
	 */
	public static void rollback() throws SQLException{
		Connection conn = tl.get();
		conn.rollback();
	}
}
