package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Admin;
import util.DBUtil;

public class AdminDao implements Serializable {
	
	
	/**
	 * 根据ID删除一个管理员
	 * */
	public void deleteAdmin(Integer id){
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "DELETE FROM admin WHERE admin_id=?";
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
	 * 添加一个管理员
	 * */
	public void addAdmin(Admin a){
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "INSERT INTO admin(admin_name,PASSWORD,adminTime,apower)"
					+ "values(?,?,now(),?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getAdmin_name());
			ps.setString(2, a.getAdmin_password());
			ps.setString(3, a.getPower());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("加载驱动失败");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加失败");
		} finally {
			DBUtil.colseConnection();
		}
		
	}
	
	/**
	 * 查询所有管理员
	 * @param name
	 * @return
	 */
	public List<Admin> findAll(){
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "select * from admin";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			List<Admin> list = new ArrayList<Admin>();
			while(rs.next()){
				Admin a = new Admin();
				a.setAdmin_id(rs.getInt(1));
				a.setAdmin_name(rs.getString(2));
				a.setAdmin_password(rs.getString(3));
				a.setTime(rs.getTimestamp(4));
				a.setPower(rs.getString(5));
				list.add(a);
			}
			return list;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("找不到驱动类",e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败",e);
		}
	}
	
	// 查询管理员
	public Admin findAdmin(String name){
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "select * from admin where admin_name=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				Admin a = new Admin();
				a.setAdmin_id(rs.getInt(1));
				a.setAdmin_name(rs.getString(2));
				a.setAdmin_password(rs.getString(3));
				a.setTime(rs.getTimestamp(4));
				a.setPower(rs.getString(5));
				return a;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("找不到驱动类",e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("找不到管理员",e);
		}
		return null;
	}
	
	public static void main(String[] args) {
		AdminDao dao = new AdminDao();
		Admin a = dao.findAdmin("cao");
		System.out.println(a.getAdmin_name());
		System.out.println(a.getAdmin_password());
	}
}
