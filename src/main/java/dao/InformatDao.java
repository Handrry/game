package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import entity.Informat;
import util.DBUtil;

public class InformatDao implements Serializable {
	
	/**
	 * 根据ID删除一条资讯信息
	 * */
	public void deleteInfo(Integer id){
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "delete from informat where informat_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("找不到驱动类",e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除失败",e);
		} finally {
			DBUtil.colseConnection();
		}
	}
	
	/**
	 * 添加一条资讯
	 * */
	public void addInform(Informat i){
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "Insert into informat(name,inform,uptime,img) "
					+ "values(?,?,now(),?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, i.getName());
			ps.setString(2, i.getInform());
			ps.setString(3, i.getImg());
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
	 * 查找所有的游戏咨询返回一个集合
	 * @return
	 */
	public List<Informat> findAll(){
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "select * from informat order by uptime desc";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			List<Informat> list = new ArrayList<Informat>();
			while(rs.next()){
				Informat im = new Informat();
				im.setInformatId(rs.getInt(1));
				im.setName(rs.getString(2));
				im.setInform(rs.getString(3));
				im.setUpTime(rs.getTimestamp(4));
				im.setImg(rs.getString(5));
				im.setBigImg(rs.getString(6));
				list.add(im);
			}
			return list;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("找不到驱动类",e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败",e);
		} finally {
			DBUtil.colseConnection();
		}
	}
	
	
	
	
}
