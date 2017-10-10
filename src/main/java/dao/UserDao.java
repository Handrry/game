package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import util.DBUtil;

public class UserDao implements Serializable {
	
	/**
	 * 保存一个用户
	 */
	public void save(User u){
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "INSERT INTO USER(email,PASSWORD,nickname) VALUES"
					+ "(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getNickName());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("找不到驱动类",e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("保存失败",e);
		} finally {
			DBUtil.colseConnection();
		}
	} 
	
	/**
	 * 根据email判断邮箱是否被注册 返回true就是被注册了
	 */
	public boolean check(String email){
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "select * from user where email=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				if(rs!=null){
					return true;
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("加载驱动类失败",e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败",e);
		} finally {
			DBUtil.colseConnection();
		}
		return false;
	}
	
	/**
	 * 根据ID删除一个用户
	 * */
	public void deleteUser(Integer id){
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "delete from user where user_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.colseConnection();
		}
	}
	
	/**
	 * 增加一个用户信息
	 * */
	public void addUser(User u){
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "INSERT INTO USER(email,password,nickname,games) VALUES"
					+ "(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getNickName());
			ps.setString(4, u.getGames());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("找不到驱动类",e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加失败",e);
		} finally {
			DBUtil.colseConnection();
		}
		
	}
	
	/**
	 * 查询所有的用户信息
	 * */
	public List<User> findAll(){
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "select * from user";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			List<User> list = new ArrayList<User>();
			while(rs.next()){
				User u = new User();
				u.setUserId(rs.getInt(1));
				u.setEmail(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setNickName(rs.getString(4));
				u.setGames(rs.getString(5));
				u.setWords(rs.getString(6));
				u.setPhoto(rs.getString(7));
				list.add(u);
			}
			return list;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("找不到驱动",e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败",e);
		} finally {
			DBUtil.colseConnection();
		}
	}
	
	/**
	 * 修改用户的信息
	 */
	public void update(User u){
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "update user set password=?,nickname=?,"
					+ "games=?,photo=? where user_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getPassword());
			ps.setString(2, u.getNickName());
			ps.setString(3, u.getGames());
			ps.setString(4, u.getPhoto());
			ps.setInt(5, u.getUserId());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("驱动类找不到!",e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("修改失败!",e);
		} finally {
			DBUtil.colseConnection();
		}
	}
	
	
	/**
	 * 根据用户邮箱查询一条用户信息
	 */
	public User findUser(String email){
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "select * from user where email=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				User u = new User();
				u.setUserId(rs.getInt(1));
				u.setEmail(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setNickName(rs.getString(4));
				u.setGames(rs.getString(5));
				u.setWords(rs.getString(6));
				u.setPhoto(rs.getString(7));
				return u;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("找不到驱动类",e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败",e);
		} finally {
			DBUtil.colseConnection();
		}
		return null;
	}
	
	public static void main(String[] args) {
		UserDao dao = new UserDao();
		User u = dao.findUser("123@qq.com");
		System.out.println(u.getNickName());
	}
	
}
