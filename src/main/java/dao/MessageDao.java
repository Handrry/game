package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Message;
import util.DBUtil;

public class MessageDao implements Serializable {
	
	/**
	 * ����IDɾ��һ������
	 */
	public void deleteMsg(Integer id){
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "delete from message where message_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("�Ҳ���������",e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("ɾ��ʧ��",e);
		} finally {
			DBUtil.colseConnection();
		}
	}
	 
	
	/** 
	 * �����û��ǳ��޸�������Ϣ
	 * */
	public void updateWords(String name,String newname){
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "update message set email=? where email=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newname);
			ps.setString(2, name);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("�����Ҳ���",e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("����ʧ��",e);
		} finally {
			DBUtil.colseConnection();
		}
	}
	
	
	/** 
	 * �����û����޸�ͼƬ
	 * */
	public void updateImg(String name,String path){
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "update message set path=? where email=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, path);
			ps.setString(2, name);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("�����Ҳ���",e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("����ʧ��",e);
		} finally {
			DBUtil.colseConnection();
		}
	}
	
	
	/**
	 * ��һ��message�������԰�
	 */
	public void save(Message m){
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "INSERT INTO message (email,saytime,words,path)VALUES"
					+ "(?,now(),?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, m.getNickName());
			ps.setString(2, m.getWords());
			ps.setString(3, m.getPath());
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("�Ҳ���������",e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("����ʧ��!",e);
		} finally {
			DBUtil.colseConnection();
		}
		
	}
	
	/**
	 * ��ѯ��������
	 */
	public List<Message> findAll(){
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "SELECT * FROM message";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(sql);
			List<Message> list = new ArrayList<Message>();
			while(rs.next()){
				Message m = new Message();
				m.setId(rs.getInt(1));
				m.setNickName(rs.getString(2));
				m.setSayTime(rs.getTimestamp(3));
				m.setWords(rs.getString(4));
				m.setPath(rs.getString(5));
				list.add(m);
			}
			return list;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("�Ҳ���������",e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯʧ��",e);
		} finally {
			DBUtil.colseConnection();
		}
	}
	
	// ����ҳ����ҳ���ѯ
	public List<Message> findByPage(int page,int size){
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "select * from message ORDER BY saytime desc limit ?,?";
			PreparedStatement ps = 
					conn.prepareStatement(sql);
			//System.out.println((page-1)*size+","+page*size);
				ps.setInt(1, (page-1)*size);
				ps.setInt(2, size);
				ResultSet rs = ps.executeQuery();
				List<Message> list = new ArrayList<Message>();
				while(rs.next()) {
					Message c = createMess(rs);
					list.add(c);
				}
				return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.colseConnection();
		}
		
		return null;
	}
	
	// ��һ��������Ž�Message��
	private Message createMess(ResultSet rs) throws SQLException{
		Message m = new Message();
		m.setId(rs.getInt(1));
		m.setNickName(rs.getString(2));
		m.setSayTime(rs.getTimestamp(3));
		m.setWords(rs.getString(4));
		m.setPath(rs.getString(5));
		return m;
	}
	
	// ��ѯ��ҳ��
	public int findRow(){
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "select count(*) from message";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.colseConnection();
		}
		return 0;
	}
	
	
	public static void main(String[] args) {
		MessageDao dao = new MessageDao();
		List<Message> list = dao.findAll();
		if(list!=null){
			for(Message m : list){
				System.out.println(m.getNickName()+":"+m.getSayTime());
			}
		}
	}
	
}
